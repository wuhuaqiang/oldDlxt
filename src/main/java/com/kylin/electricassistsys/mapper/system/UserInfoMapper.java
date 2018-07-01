package com.kylin.electricassistsys.mapper.system;

import com.kylin.electricassistsys.commonmapper.BaseMapper;
import com.kylin.electricassistsys.entity.system.UserInfoEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Threecolors on 2017/11/16.
 */
@Mapper
@Component(value="UserInfoMapper")
public interface UserInfoMapper extends BaseMapper<UserInfoEntity>
{
    UserInfoEntity getUserInfoByUsername(String username);
}
