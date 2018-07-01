package com.kylin.electricassistsys.service.system;

import com.kylin.electricassistsys.entity.system.User;
import com.kylin.electricassistsys.mapper.system.UserMapper;
import com.kylin.electricassistsys.service.BaseService;
import com.kylin.electricassistsys.utility.DESCryptography;
import com.kylin.electricassistsys.utility.RandomPassword;
import com.kylin.electricassistsys.utility.StringHelper;
import org.apache.commons.lang3.time.DateUtils;
import org.jsoup.helper.DataUtil;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by Threecolors on 2017/11/16.
 */
@Service
public class UserService extends BaseService<User>
{
    private UserMapper mapper;

    @Autowired
    public void setMapper(UserMapper mapper)
    {
        this.mapper = mapper;
        setBaseMapper(mapper);
    }

    @Autowired
    private RoleAuthorityService roleAuthorityService;

    /**
     * 添加
     *
     * @param entity 实体
     * @return 影响条数
     */
    public boolean insert(User entity)
    {
        return mapper.insert(entity) > 0;
    }

    public User selectByKyId(String keyId)
    {
        return  mapper.selectByPrimaryKey(keyId);
    }


    public int deleteByIds(String[] ids)
    {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("id", java.util.Arrays.asList(ids));
        return mapper.deleteByExample(example);
    }

    public  boolean unlockAccount(String id)
    {
        User user = this.selectByKyId(id);
        if(user==null)
        {
            return  false;
        }
        user.setLockTime(new Date(0));
        user.setAccountNonLocked(true);
       return   mapper.updateByPrimaryKeySelective(user)>0;
    }

    /**
     * 根据id获取实体
     *
     * @param account
     * @return 实体
     */
    public User getEntityByAccount(String account)
    {
        User loginEntity = mapper.getEntityByUsername(account);
        loginEntity.setPassword(DESCryptography.decodeValue(loginEntity.getPassword()));

        return  loginEntity;
    }

    public User getUserByUsername(String username)
    {
        return mapper.getEntityByUsername(username);
    }

    public boolean isUsernameExsist(String username)
    {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username", username);
        return mapper.selectCountByExample(example)>0;
    }
}
