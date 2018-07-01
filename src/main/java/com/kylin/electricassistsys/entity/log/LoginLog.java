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
 * Created by Threecolors on 2018/2/1.
 */
@NameStyle(Style.normal)
@Table(name = "LoginLog")
public class LoginLog extends BaseEntity {
    /**
     * 登录账号
     */
    @FieldMeta(description = "用户账号", index = 1, queryField = true)
    private String account = "";

    /**
     * 登录ip
     */
    @FieldMeta(description = "用户IP", index = 2)
    private String loginIp = "";
    /**
     * 登录时间
     */
    @FieldMeta(description = "时间", index = 3, show = false, isExport = false)
    private Date loginTime;

    @Transient
    @FieldMeta(description = "时间", index = 3, isImport = false)
    private String loginTimeTxt;

    @FieldMeta(description = "类型", index = 4, isImport = false)
    private String logType;

    @FieldMeta(description = "是否成功", index = 5, show = false, isExport = false)
    private String isSuccess;

    @Transient
    @FieldMeta(description = "是否成功", index = 5, isImport = false)
    private String isSuccessTxt;

    @FieldMeta(description = "错误消息", index = 6)
    private String errorMsg = "";

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;


    }

    public String getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(String isSuccess) {
        this.isSuccess = isSuccess;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public String getIsSuccessTxt() {
        return "1".equals(isSuccess) ? "成功" : "失败";
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getLoginTimeTxt() {
        SimpleDateFormat dateFm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFm.format(this.loginTime);
    }

    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType;
    }
}
