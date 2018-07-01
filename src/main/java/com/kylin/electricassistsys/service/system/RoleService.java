package com.kylin.electricassistsys.service.system;

import com.kylin.electricassistsys.entity.CommonEntity;
import com.kylin.electricassistsys.entity.enumparam.Status;
import com.kylin.electricassistsys.entity.system.*;
import com.kylin.electricassistsys.mapper.system.RoleAuthorityMapper;
import com.kylin.electricassistsys.mapper.system.RoleMapper;
import com.kylin.electricassistsys.mapper.system.UserRoleMapper;
import com.kylin.electricassistsys.service.BaseService;
import com.kylin.electricassistsys.service.system.CustomSecurity.CustomGrantedAuthority;
import com.kylin.electricassistsys.service.system.CustomSecurity.CustomUserDetailsService;
import com.kylin.electricassistsys.utility.AuthorityType;
import com.kylin.electricassistsys.utility.CustomField;
import com.kylin.electricassistsys.utility.OperateButtonScript;
import com.kylin.electricassistsys.utility.StringHelper;
import org.apache.calcite.linq4j.Linq4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.*;

/**
 * Created by Threecolors on 2017/11/15.
 */
@Service
public class RoleService extends BaseService<RoleEntity>
{
    @Autowired
    private RoleMapper mapper;

    @Autowired
    private SessionRegistry sessionRegistry;

    @Autowired
    public void setRoleMapper(RoleMapper mapper)
    {
        this.mapper = mapper;
        setBaseMapper(mapper);
    }

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private RoleAuthorityMapper roleAuthorityMapper;

    public boolean saveRoleAuthority(String roleId, String ckNavi, String ckButtonQx)
    {
        String[] menuIds = ckNavi.split(",");
        if (menuIds.length == 0)
        {
            return true;
        }

        deleteRoleAuthorityByRoleId(roleId);
        for (String menuId : menuIds)
        {
            List<String> methodsValues = new ArrayList();
            for (String method : ckButtonQx.split(","))
            {
                if (method.split("\\|")[0].equals(menuId))
                {
                    methodsValues.add(method.split("\\|")[1]);
                }
            }

            int methods = 0;
            for (String value : methodsValues)
            {
                methods |= Integer.parseInt(value);
            }

            RoleAuthorityEntity roleAuthorityEntity = new RoleAuthorityEntity();
            roleAuthorityEntity.setMethods(methods);
            roleAuthorityEntity.setRoleId(roleId);
            roleAuthorityEntity.setMenuId(menuId);
            roleAuthorityEntity.setId(UUID.randomUUID().toString());
            roleAuthorityEntity.setUpdateTime(new Date());
            roleAuthorityMapper.insert(roleAuthorityEntity);
        }

        return true;
    }

    public boolean deleteRoleAuthorityByRoleId(String roleId)
    {
        Example example = new Example(RoleAuthorityEntity.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("roleId", roleId);
        return roleAuthorityMapper.deleteByExample(example) > 0;
    }

    public List<RoleEntity> getAllEnable()
    {

        Example example = new Example(RoleEntity.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("status", Status.VALID.getName());
        return mapper.selectByExample(example);
    }

    /**
     * 获取所有
     *
     * @return 所有实体集合
     */
    public List<UserSetRoleEntity> getUserSetRoleEntity(String userId)
    {
        List<RoleEntity> entities = getAllEnable();
        List<String> roleIds = mapper.getRoleByIdUserId(userId);
        List<UserSetRoleEntity> userSetRoleEntities = new ArrayList<>();
        UserSetRoleEntity userSetRoleEntity;
        for (RoleEntity entity : entities)
        {
            userSetRoleEntity = new UserSetRoleEntity();
            userSetRoleEntity.setRoleName(entity.getName());
            userSetRoleEntity.setRoleId(entity.getId());
            userSetRoleEntity.setChecked(roleIds.contains(entity.getId()));
            userSetRoleEntities.add(userSetRoleEntity);
        }
        return userSetRoleEntities;
    }

    public boolean saveUserSetRole(UserRoleEntity userRoleEntity)
    {
        Example example = new Example(UserRoleEntity.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userId", userRoleEntity.getUserId());
        userRoleMapper.deleteByExample(example);

        UserRoleEntity entity = new UserRoleEntity();

        entity.setUserId(userRoleEntity.getUserId());
        for (String roleId : userRoleEntity.getRoleId().split(","))
        {
            entity.setId(UUID.randomUUID().toString());
            entity.setUpdateTime(new Date());
            entity.setRoleId(roleId);
            userRoleMapper.insert(entity);
        }

        return true;
    }

    /**
     * 根据名称获取
     *
     * @return 所有实体集合
     */
    public List<RoleEntity> getEntitiesByCondition(RoleEntity conditionEntity)
    {
        Example example = new Example(RoleEntity.class);
        Example.Criteria criteria = example.createCriteria();
        if (!StringHelper.isNullOrWhiteSpace(conditionEntity.getName()))
        {
            criteria.andLike("name", "%" + conditionEntity.getName() + "%");
        }
        example.orderBy("updateTime").desc();

        return mapper.selectByExample(example);
    }

    public List<RoleEntity> getEntitiesByConditionForJGrid(RoleEntity conditionEntity, int buttonAuthority)
    {
        List<RoleEntity> entities = this.getEntitiesByCondition(conditionEntity);

        String operStr = StringUtils.EMPTY;
        if ((AuthorityType.DELETE.getIndex() & buttonAuthority) > 0)
        {
            operStr += OperateButtonScript.DELETE_BUTTON;
        }
        if ((AuthorityType.MODIFY.getIndex() & buttonAuthority) > 0)
        {
            operStr += OperateButtonScript.EIDIT_BUTTON;
        }

        operStr += OperateButtonScript.AUTHORITY_SETTING;

        if (!StringUtils.isEmpty(operStr))
        {
            for (RoleEntity entity : entities)
            {
                entity.setOperate(String.format(operStr, entity.getId(), entity.getId(), entity.getId()));
            }
        }

        return entities;
    }

    //修改用户权限有要设置Session过期
    private void invalidateSession(User user){
        List<Object> o= sessionRegistry.getAllPrincipals();
        for (Object principal : o) {
            if (principal instanceof User) {
                final User loggedUser = (User) principal;
                if (user.getUsername().equals(loggedUser.getUsername())) {
                    List<SessionInformation> sessionsInfo = sessionRegistry.getAllSessions(principal, false);
                    if (null != sessionsInfo && sessionsInfo.size() > 0) {
                        for (SessionInformation sessionInformation : sessionsInfo) {
                            sessionInformation.expireNow();
                        }
                    }
                }
            }
        }
    }
}
