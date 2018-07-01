package com.kylin.electricassistsys.entity.system;

/**
 * Created by Threecolors on 2017/12/7.
 */
public class UserSetRoleEntity
{
    /**
     * 角色id
     */
    private String roleId;

    /**
     角色名字
     */
    private String roleName;

    private boolean checked;

    public String getRoleId()
    {
        return roleId;
    }

    public void setRoleId(String roleId)
    {
        this.roleId = roleId;
    }

    public String getRoleName()
    {
        return roleName;
    }

    public void setRoleName(String roleName)
    {
        this.roleName = roleName;
    }

    public boolean isChecked()
    {
        return checked;
    }

    public void setChecked(boolean checked)
    {
        this.checked = checked;
    }
}
