package com.kylin.electricassistsys.entity.system;

import com.kylin.electricassistsys.entity.BaseEntity;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

/**
 * 角色权限实体
 */
@NameStyle(Style.normal)
@Table(name="RoleAuthority")
public class RoleAuthorityEntity extends BaseEntity
{
    /**
     角色编号
     */
    private String roleId="";

    /**
     菜单编号
     */
    private String menuId="";

    /**
     方法
     2^0查看，2^1添加，2^2删除，2^3修改，2^4查询，2^5导入，2^6导出
     */
    private int methods;

    /**
     * 菜单url
     */
    @Transient
    private String url;

    public String getRoleId()
    {
        return roleId;
    }

    public void setRoleId(String roleId)
    {
        this.roleId = roleId;
    }

    public String getMenuId()
    {
        return menuId;
    }

    public void setMenuId(String menuId)
    {
        this.menuId = menuId;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public int getMethods()
    {
        return methods;
    }

    public void setMethods(int methods)
    {
        this.methods = methods;
    }
}
