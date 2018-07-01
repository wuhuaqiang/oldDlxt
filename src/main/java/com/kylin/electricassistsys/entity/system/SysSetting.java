package com.kylin.electricassistsys.entity.system;

import com.kylin.electricassistsys.entity.BaseEntity;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Table;

/**
 * Created by Threecolors on 2018/1/31.
 */
@NameStyle(Style.normal)
@Table(name = "SysSetting")
public class SysSetting extends BaseEntity {
    /**
     * 登录失败记录时间(分钟)
     */
    private int loginFailedTimeInterval = 30;

    /**
     * 最大登录失败次数
     */
    private int maxLoginFailedTimes = 5;

    /**
     * 登录失败锁定时长(分)
     */
    private int pwdLockDuration = 20;

    /**
     * 登录密码有效时长(天)
     */
    private int pwdValidDurationTime = 60;

    /**
     * 账号有效时间，逾期休眠(天)
     */
    private int accountValidDurationTime = 90;


    /**
     * 临时账号有效期
     */
    private int temporaryAccountDurationTime = 90;

    /**
     * session有效期(分钟)
     */
    private int sessionKeepTime = 5;

    /**
     * 最大在线session数
     */
    private int maxSessionCount = 1000;


    /**
     * 允许访问起始时间
     */
    private String accessBeginTime = "06:00";


    /**
     * 允许访问结束时间
     */
    private String accessEndTime = "20:00";

    private int restrictType = 0;

    private String ipList = "";

    private String mailHost;
    private String mailAccount;
    private String mailPassword;

    public String getMailHost() {
        return mailHost;
    }

    public void setMailHost(String mailHost) {
        this.mailHost = mailHost;
    }

    public String getMailAccount() {
        return mailAccount;
    }

    public void setMailAccount(String mailAccount) {
        this.mailAccount = mailAccount;
    }

    public String getMailPassword() {
        return mailPassword;
    }

    public void setMailPassword(String mailPassword) {
        this.mailPassword = mailPassword;
    }

    public int getLoginFailedTimeInterval() {
        return loginFailedTimeInterval;
    }

    public void setLoginFailedTimeInterval(int loginFailedTimeInterval) {
        this.loginFailedTimeInterval = loginFailedTimeInterval;
    }

    public int getMaxLoginFailedTimes() {
        return maxLoginFailedTimes;
    }

    public void setMaxLoginFailedTimes(int maxLoginFailedTimes) {
        this.maxLoginFailedTimes = maxLoginFailedTimes;
    }

    public int getPwdValidDurationTime() {
        return pwdValidDurationTime;
    }

    public void setPwdValidDurationTime(int pwdValidDurationTime) {
        this.pwdValidDurationTime = pwdValidDurationTime;
    }

    public int getPwdLockDuration() {
        return pwdLockDuration;
    }

    public void setPwdLockDuration(int pwdLockDuration) {
        this.pwdLockDuration = pwdLockDuration;
    }

    public int getAccountValidDurationTime() {
        return accountValidDurationTime;
    }

    public void setAccountValidDurationTime(int accountValidDurationTime) {
        this.accountValidDurationTime = accountValidDurationTime;
    }

    public int getSessionKeepTime() {
        return sessionKeepTime;
    }

    public void setSessionKeepTime(int sessionKeepTime) {
        this.sessionKeepTime = sessionKeepTime;
    }

    public int getMaxSessionCount() {
        return maxSessionCount;
    }

    public void setMaxSessionCount(int maxSessionCount) {
        this.maxSessionCount = maxSessionCount;
    }

    public String getAccessBeginTime() {
        return accessBeginTime;
    }

    public void setAccessBeginTime(String accessBeginTime) {
        this.accessBeginTime = accessBeginTime;
    }

    public String getAccessEndTime() {
        return accessEndTime;
    }

    public void setAccessEndTime(String accessEndTime) {
        this.accessEndTime = accessEndTime;
    }

    public int getRestrictType() {
        return restrictType;
    }

    public void setRestrictType(int restrictType) {
        this.restrictType = restrictType;
    }

    public String getIpList() {
        return ipList;
    }

    public void setIpList(String ipList) {
        this.ipList = ipList;
    }


    public int getTemporaryAccountDurationTime() {
        return temporaryAccountDurationTime;
    }

    public void setTemporaryAccountDurationTime(int temporaryAccountDurationTime) {
        this.temporaryAccountDurationTime = temporaryAccountDurationTime;
    }
}
