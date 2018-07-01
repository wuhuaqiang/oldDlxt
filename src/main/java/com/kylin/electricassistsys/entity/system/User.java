package com.kylin.electricassistsys.entity.system;


import com.kylin.electricassistsys.commonmapper.BaseMapper;
import com.kylin.electricassistsys.entity.BaseEntity;
import com.kylin.electricassistsys.utility.FieldMeta;
import com.kylin.electricassistsys.utility.TagType;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.management.relation.Role;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * 用户登录信息
 */
@NameStyle(Style.normal)
@Table(name="User")
public class User extends BaseEntity implements UserDetails
{
    /**
     登录账户
     */
    @Pattern(regexp="^[a-zA-Z0-9_-]{4,16}$",message="4到16位(字母、数字、下划线、减号)")
    private String username;

    /**
     密码
     */
    @NotBlank(message = "必填项")
    private String password;

    private String accountStatus;

    private boolean isAccountNonExpired;

    private boolean isAccountNonLocked;

    private boolean isCredentialsNonExpired;

    private boolean isEnabled;

    private Date lockTime;

    private Date changePwdTime;

    private Date addTime;


    @Transient
    private List<RoleEntity> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
//        List<GrantedAuthority> auths = new ArrayList<>();
        //        for (RoleEntity role : roles) {
        //            auths.add(new SimpleGrantedAuthority(role.getName()));
        //        }
        //        return auths;

        return null;
    }

    public String getPassword()
    {
        return password;
    }

    @Override
    public String getUsername()
    {
        return username;
    }

    @Override
    public boolean isAccountNonExpired()
    {
        return isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked()
    {
        return isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired()
    {
        return isCredentialsNonExpired;
    }

    @Override
    public boolean isEnabled()
    {
        return isEnabled;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getAccountStatus()
    {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus)
    {
        this.accountStatus = accountStatus;
    }

    public List<RoleEntity> getRoles()
    {
        return roles;
    }

    public void setRoles(List<RoleEntity> roles)
    {
        this.roles = roles;
    }

    public void setAccountNonExpired(boolean accountNonExpired)
    {
        isAccountNonExpired = accountNonExpired;
    }

    public void setAccountNonLocked(boolean accountNonLocked)
    {
        isAccountNonLocked = accountNonLocked;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired)
    {
        isCredentialsNonExpired = credentialsNonExpired;
    }

    public void setEnabled(boolean enabled)
    {
        isEnabled = enabled;
    }

    public Date getLockTime()
    {
        return lockTime;
    }

    public void setLockTime(Date lockTime)
    {
        this.lockTime = lockTime;
    }

    public Date getChangePwdTime()
    {
        return changePwdTime;
    }

    public void setChangePwdTime(Date changePwdTime)
    {
        this.changePwdTime = changePwdTime;
    }

    @Override
    public String toString() {
        return this.username;
    }

    @Override
    public int hashCode() {
        return username.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this.toString().equals(obj.toString());
    }

    public Date getAddTime()
    {
        return addTime;
    }

    public void setAddTime(Date addTime)
    {
        this.addTime = addTime;
    }
}
