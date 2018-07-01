package com.kylin.electricassistsys.entity.system;

import com.kylin.electricassistsys.entity.BaseEntity;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Table;
import java.util.Date;

/**
 * Created by Threecolors on 2018/1/22.
 */
@NameStyle(Style.normal)
@Table(name="LoginRecords")
public class LoginRecords extends BaseEntity
{

    /**
     * 本次登录ip
     */
    private String loginIp="";


    /**
     * 本地时间
     */
    private Date loginTime;


    /**
     * 上次登录ip
     */
    private String lastLoginIp="";


    /**
     * 上次登录时间
     */
    private Date lastLoginTime;


    /**
     * 登录次数
     */
    private Integer loginCount;


    /**
     * 登录账号
     */
    private String account="";


    public String getLastLoginIp()
    {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp)
    {
        this.lastLoginIp = lastLoginIp;
    }

    public Date getLastLoginTime()
    {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime)
    {
        this.lastLoginTime = lastLoginTime;
    }

    public Integer getLoginCount()
    {
        return loginCount;
    }

    public void setLoginCount(Integer loginCount)
    {
        this.loginCount = loginCount;
    }

    public String getLoginIp()
    {
        return loginIp;
    }

    public void setLoginIp(String loginIp)
    {
        this.loginIp = loginIp;
    }

    public Date getLoginTime()
    {
        return loginTime;
    }

    public void setLoginTime(Date loginTime)
    {
        this.loginTime = loginTime;
    }

    public String getAccount()
    {
        return account;
    }

    public void setAccount(String account)
    {
        this.account = account;
    }
}
