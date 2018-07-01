package com.kylin.electricassistsys.mapper.system;

import com.kylin.electricassistsys.commonmapper.BaseMapper;
import com.kylin.electricassistsys.entity.system.RoleAuthorityEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Threecolors on 2017/12/4.
 */
@Mapper
@Component(value="RoleAuthorityMapper")
public interface RoleAuthorityMapper extends BaseMapper<RoleAuthorityEntity>
{
    /**根据登录账号获取权限关联信息
     * @param username
     * @return
     */
    List<RoleAuthorityEntity> getRoleAuthorityByUsername(String username);

    /**获取上级父页面的按钮权限
     * @param url
     * @return
     */
    int getPreviousMenuButtonAuthorityByUrl(@Param("url") String url,@Param("username") String username);
}
