package com.kylin.electricassistsys.mapper.system;

import com.kylin.electricassistsys.commonmapper.BaseMapper;
import com.kylin.electricassistsys.entity.system.MenuEntity;
import com.kylin.electricassistsys.entity.system.MenuTreeGridEntity;
import com.kylin.electricassistsys.entity.system.MenuTreeGridRoleAuthorityEntity;
import jdk.nashorn.internal.runtime.ListAdapter;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value="MenuMapper")
public interface MenuMapper extends BaseMapper<MenuEntity>
{
    /**获取所有菜单
     * @return 所有菜单实体集合
     */
    List<MenuTreeGridEntity> getAllMenus();

    List<MenuTreeGridRoleAuthorityEntity> getAllMenuTreeGridRoleAuthority();


    /**根据菜单id获取菜单
     * @param id
     * @return 菜单实体
     */
    MenuEntity getMenuById(String id);

    void setSort(@Param("ysId") String id,@Param("isUpOrDown") String type);
}
