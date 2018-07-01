package com.kylin.electricassistsys.service.system;

import com.kylin.electricassistsys.common.SendEmailHelper;
import com.kylin.electricassistsys.entity.enumparam.KeyValueType;
import com.kylin.electricassistsys.entity.system.AccountStatus;
import com.kylin.electricassistsys.entity.system.LoginRecords;
import com.kylin.electricassistsys.entity.system.User;
import com.kylin.electricassistsys.entity.system.UserInfoEntity;
import com.kylin.electricassistsys.exception.AppException;
import com.kylin.electricassistsys.mapper.system.UserInfoMapper;
import com.kylin.electricassistsys.service.BaseService;
import com.kylin.electricassistsys.service.KeyValueService;
import com.kylin.electricassistsys.utility.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.*;

/**
 * Created by Threecolors on 2017/11/16.
 */
@Service
public class UserInfoService extends BaseService<UserInfoEntity>
{
    @Autowired
    private LoginRecordsService loginRecordsService;

    @Autowired
    private UserInfoMapper mapper;

    @Autowired
    private UserService userService;

    @Autowired
    private KeyValueService keyValueService;

    @Autowired
    private SysSettingService sysSettingService;

    @Autowired
    private SendEmailHelper sendEmailHelper;

    @Autowired
    public void setMapper(UserInfoMapper mapper)
    {
        this.mapper = mapper;
        setBaseMapper(mapper);
    }

    public int deleteByIds(String[] ids)
    {
        Example example = new Example(UserInfoEntity.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("id", java.util.Arrays.asList(ids));
        int deleteCount = mapper.deleteByExample(example);
        if (deleteCount > 0)
        {
            userService.deleteByIds(ids);
        }

        return deleteCount;
    }

    public UserInfoEntity getEntityById(String id)
    {
        UserInfoEntity userInfoEntity = mapper.getEntityById(id);
        try
        {
            userInfoEntity.setPassword(DESCryptography.decodeValue(userInfoEntity.getPassword()));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return userInfoEntity;
    }

    public boolean insertSelective(UserInfoEntity entity)
    {
        //保存用户信息
        if (mapper.insertSelective(entity) > 0)
        {
            String randomPwd = RandomPassword.getRandomPassword(8);
            entity.setPassword(randomPwd);

            //保存账号密码
            User user = new User();
            user.setUsername(entity.getUsername());
            user.setPassword(DESCryptography.encode(entity.getPassword()));
            user.setId(entity.getId());
            user.setCredentialsNonExpired(true);
            user.setAccountNonLocked(true);
            user.setAccountNonExpired(true);
            user.setEnabled(true);
            user.setAccountStatus(entity.getAccountStatus());

            if (userService.insertSelective(user))
            {
                //添加成功异步发邮件
                if(!StringUtils.isEmpty(entity.getEmail()))
                {
                    String sendTo = entity.getEmail();
                    String subject = "主题：账号初始化";
                    Map<String, Object> map = new HashMap<>();
                    map.put("name", entity.getName());
                    map.put("pwd", randomPwd);
                    map.put("account", entity.getUsername());
                    sendEmailHelper.SendEmailForUserPwd(new String[]{sendTo}, subject, map, "initialAccount.ftl");
                }
                return true;
            }
        }

        return false;
    }

    public  boolean resetAccount(String id)
    {
        UserInfoEntity userInfoEntity =  mapper.getEntityById(id);
        if(userInfoEntity==null)
        {
            return  false;
        }

        User user = new User();
        user.setId(userInfoEntity.getId());
        user.setUsername(userInfoEntity.getUsername());
        String randomPwd = RandomPassword.getRandomPassword(8);
        user.setPassword(DESCryptography.encode(randomPwd));
        user.setCredentialsNonExpired(true);
        user.setAccountNonLocked(true);
        user.setAccountNonExpired(true);
        user.setEnabled(true);
        if(userService.updateByPrimaryKeySelective(user))
        {
            if(!StringUtils.isEmpty(userInfoEntity.getEmail()))
            {
                //添加成功异步发邮件
                String sendTo = userInfoEntity.getEmail();
                String subject = "主题：账号重置";
                Map<String, Object> map = new HashMap<>();
                map.put("name", userInfoEntity.getName());
                map.put("pwd", randomPwd);
                map.put("account", userInfoEntity.getUsername());
                sendEmailHelper.SendEmailForUserPwd(new String[]{sendTo}, subject, map, "initialAccount.ftl");
            }
            return  true;
        }
        return  false;
    }

    public boolean updateByPrimaryKeySelective(UserInfoEntity entity)
    {
        //保存用户信息
        if (mapper.updateByPrimaryKeySelective(entity) > 0)
        {
            User user = userService.selectByKyId(entity.getId());
            boolean isAccountStatusResting = user.getAccountStatus().equals(entity.getAccountStatus());
            user.setAccountStatus(entity.getAccountStatus());

            if (userService.updateByPrimaryKeySelective(user))
            {
                LoginRecords loginRecords = loginRecordsService.getEntityById(user.getId());
                //由休眠改为其他，更新登录记录，保证可用登录
                if (loginRecords != null && isAccountStatusResting && !user.getAccountStatus().equals(
                        AccountStatus.RESTING.getName()))
                {
                    loginRecords.setLoginTime(new Date());
                    loginRecordsService.updateByPrimaryKeySelective(loginRecords);
                }
            }

            return true;
        }

        return false;
    }

    public boolean updateUserInfo(UserInfoEntity entity)
    {
        return mapper.updateByPrimaryKey(entity) > 0;
    }

    /**
     * 根据名称获取
     *
     * @return 所有实体集合
     */
    public List<UserInfoEntity> getEntitiesByCondition(UserInfoEntity conditionEntity)
    {
        return mapper.getEntitiesByCondition(conditionEntity);
    }

    public List<UserInfoEntity> getEntitiesByConditionForJGrid(UserInfoEntity conditionEntity,
                                                               int buttonAuthority)
    {
        List<UserInfoEntity> entities = this.getEntitiesByCondition(conditionEntity);

        String operStr = StringUtils.EMPTY;
        if ((AuthorityType.DELETE.getIndex() & buttonAuthority) > 0)
        {
            operStr += OperateButtonScript.DELETE_BUTTON;
        }
        if ((AuthorityType.MODIFY.getIndex() & buttonAuthority) > 0)
        {
            operStr += OperateButtonScript.EIDIT_BUTTON;
        }

        operStr += OperateButtonScript.ROLE_SETTING +OperateButtonScript.RESET_PWD ;



        if (!StringUtils.isEmpty(operStr))
        {
            for (UserInfoEntity entity : entities)
            {
                entity.setOperate(String.format(operStr, entity.getId(), entity.getId(), entity.getId(),entity.getId()));

                //解锁按钮
                if (!entity.isUnlock())
                {
                    entity.setOperate(entity.getOperate() + String.format(OperateButtonScript.UNLOCK, entity.getId()));
                }
            }
        }

        return entities;
    }

    /**
     * 特殊处理，转化字段展示和数据库存储不一致的情况
     *
     * @param entity
     */
    protected void specialProcessForField(UserInfoEntity entity,
                                          String type)
    {
        Map<String, String> map = keyValueService.getKeyValueMap(KeyValueType.GDGS);
        Set<String> kset = map.keySet();
        String tempValue = entity.getUnitId();
        entity.setUnitId("");
        for (String ks : kset)
        {
            String value = map.get(ks);
            if (tempValue.equals(value))
            {
                entity.setUnitId(ks);
                break;
            }
        }
    }

    public UserInfoEntity getUserInfoByAccount(String account)
    {
        return mapper.getUserInfoByUsername(account);
    }

}
