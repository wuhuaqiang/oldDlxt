package com.kylin.electricassistsys.mapper.system;

import com.kylin.electricassistsys.commonmapper.BaseMapper;
import com.kylin.electricassistsys.entity.CommonEntity;
import com.kylin.electricassistsys.entity.system.RoleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Threecolors on 2017/11/15.
 */
@Mapper
@Component(value="RoleMapper")
public interface RoleMapper extends BaseMapper<RoleEntity>
{
    /**根据用户id获取对于角色id
     * @param userId
     * @return
     */
     List<String> getRoleByIdUserId(String userId);
}
