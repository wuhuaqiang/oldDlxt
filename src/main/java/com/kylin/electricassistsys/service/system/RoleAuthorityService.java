package com.kylin.electricassistsys.service.system;

import com.kylin.electricassistsys.entity.system.RoleAuthorityEntity;
import com.kylin.electricassistsys.mapper.system.RoleAuthorityMapper;
import com.kylin.electricassistsys.service.BaseService;
import com.kylin.electricassistsys.utility.AuthorityType;
import com.kylin.electricassistsys.utility.CustomField;
import com.kylin.electricassistsys.utility.StringHelper;
import org.apache.calcite.linq4j.Linq4j;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Threecolors on 2017/12/4.
 */
@Service
public class RoleAuthorityService extends BaseService<RoleAuthorityEntity>
{
    protected final Log logger = LogFactory.getLog(this.getClass());

    private RoleAuthorityMapper mapper;

    @Autowired
    public void setRoleAuthorityMapper(RoleAuthorityMapper mapper)
    {
        this.mapper = mapper;
        setBaseMapper(mapper);
    }

    /**
     * 根据登录账号获取权限关联信息
     *
     * @param username
     * @return
     */
    public HashMap<String, Integer> getRoleAuthorityByAccount(String username)
    {
        List<RoleAuthorityEntity> roleAuthorityEntities = this.mapper.getRoleAuthorityByUsername(username);
        //处理一个用户多个角色的情况
        HashMap<String, Integer> authorityMap = new LinkedHashMap<>();

        Linq4j.asEnumerable(roleAuthorityEntities).forEach(roleAuthorityEntity ->
                                                           {
                                                               if (roleAuthorityEntity == null)
                                                               {
                                                                   return;
                                                               }

                                                               String key = StringHelper.isNullOrEmpty(
                                                                       roleAuthorityEntity.getUrl()) ? roleAuthorityEntity.getMenuId() : roleAuthorityEntity.getUrl();

                                                               Integer methods = authorityMap.containsKey(
                                                                       key) ? authorityMap.get(
                                                                       key) | roleAuthorityEntity.getMethods() : roleAuthorityEntity.getMethods();
                                                               authorityMap.put(key, methods);
                                                           });

        return authorityMap;
    }

    public List<RoleAuthorityEntity> getRoleAuthorityByRoleId(String roleId)
    {
        Example example = new Example(RoleAuthorityEntity.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("roleId", roleId);
        return this.mapper.selectByExample(example);
    }


    /**
     * 获取上级菜单页面按钮权限
     *
     * @param url 菜单url
     * @return 按钮权限
     */
    public int getPreviousMenuButtonAuthorityByUrl(String url,
                                                   String account)
    {
        try
        {
            return this.mapper.getPreviousMenuButtonAuthorityByUrl(url, account);
        }
        catch (Exception ex)
        {
            logger.error(ex);
        }

        return AuthorityType.VIEW.getIndex();
    }
}
