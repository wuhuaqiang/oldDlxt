package com.kylin.electricassistsys.entity.system;

import com.kylin.electricassistsys.entity.BaseEntity;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Table;

/**
 * Created by hhq on 2017/11/12.
 * 用户角色关联
 */
@NameStyle(Style.normal)
@Table(name="UserRole")
public class UserRoleEntity extends BaseEntity
{
    /**
     用户编号
     */
    private String userId;

    /**
     角色编号
     */
    private String roleId;

    public String getUserId()
    {
        return userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getRoleId()
    {
        return roleId;
    }

    public void setRoleId(String roleId)
    {
        this.roleId = roleId;
    }
}
