package com.kylin.electricassistsys.mapper.system;

import com.kylin.electricassistsys.commonmapper.BaseMapper;
import com.kylin.electricassistsys.entity.system.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * Created by Threecolors on 2017/11/16.
 */
@Mapper
@Component(value="UserMapper")
public interface UserMapper extends BaseMapper<User>
{
    /**获取登录实体
     * @param username 账号
     * @return 实体
     */
    User getEntityByUsername(String username);
}
