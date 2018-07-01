package com.kylin.electricassistsys.entity.log;

import com.kylin.electricassistsys.entity.BaseEntity;
import com.kylin.electricassistsys.utility.FieldMeta;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Table;
import javax.persistence.Transient;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Threecolors on 2018/2/22.
 */
@NameStyle(Style.normal)
@Table(name="SysAuditLog")
public class SysAuditLog extends BaseEntity
{
    /**
     * 用户账号
     */
    @FieldMeta(description = "用户账号",index = 1, queryField = true)
    private String account="";

    /**
     * 用户ip
     */
    @FieldMeta(description = "用户IP",index = 2)
    private String userIp="";

    /**
     * 审计事件名称
     */
    @FieldMeta(description = "事件",index = 3, queryField = true)
    private String auditEventName="";

    @FieldMeta(description = "事件类型",index = 4)
    private String type;

    @FieldMeta(description = "事件等级",index = 5, queryField = true)
    private String auditEventGrade;

    /**
     * 记录时间
     */
    @FieldMeta(description = "时间",index = 6,show = false,isExport = false)
    private Date currentTime;

    @Transient
    @FieldMeta(description = "时间",index = 6,isImport = false)
    private String currentTimeTxt;

    /**
     * 模块名称
     */
    @FieldMeta(description = "模块",index =7, queryField = true)
    private String moduleName="";

    /**
     * 消息
     */
    @FieldMeta(description = "消息",index = 8)
    private String message="";

    public String getAccount()
    {
        return account;
    }

    public void setAccount(String account)
    {
        this.account = account;
    }

    public String getUserIp()
    {
        return userIp;
    }

    public void setUserIp(String userIp)
    {
        this.userIp = userIp;
    }

    public Date getCurrentTime()
    {
        return currentTime;
    }

    public void setCurrentTime(Date currentTime)
    {
        this.currentTime = currentTime;
    }

    public String getModuleName()
    {
        return moduleName;
    }

    public void setModuleName(String moduleName)
    {
        this.moduleName = moduleName;
    }

    public String getAuditEventName()
    {
        return auditEventName;
    }

    public void setAuditEventName(String auditEventName)
    {
        this.auditEventName = auditEventName;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public String getCurrentTimeTxt()
    {
        SimpleDateFormat dateFm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFm.format(this.currentTime);
    }

    public void setCurrentTimeTxt(String currentTimeTxt)
    {
        this.currentTimeTxt = currentTimeTxt;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getAuditEventGrade()
    {
        return auditEventGrade;
    }

    public void setAuditEventGrade(String auditEventGrade)
    {
        this.auditEventGrade = auditEventGrade;
    }
}
