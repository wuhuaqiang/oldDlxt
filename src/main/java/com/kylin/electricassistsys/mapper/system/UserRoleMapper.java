package com.kylin.electricassistsys.mapper.system;

import com.kylin.electricassistsys.commonmapper.BaseMapper;
import com.kylin.electricassistsys.entity.system.UserRoleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * Created by Threecolors on 2017/12/10.
 */
@Mapper
@Component(value="UserRoleMapper")
public interface UserRoleMapper extends BaseMapper<UserRoleEntity>
{
}
