package com.kylin.electricassistsys.entity.log;

import com.kylin.electricassistsys.entity.BaseEntity;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Table;
import java.math.BigInteger;

/**
 * Created by Threecolors on 2018/3/5.
 */
@NameStyle(Style.normal)
@Table(name="SysAuditSetting")
public class SysAuditSetting extends BaseEntity
{

    /**
     * 邮箱列表
     */
    private String emailList;

    /**
     * 审计日志保存时长
     */
    private int logValidDurationTime = 90;

    /**
     * 审计日志预警条数
     */
    private long logMaxCount = Long.MAX_VALUE;

    public String getEmailList()
    {
        return emailList;
    }

    public void setEmailList(String emailList)
    {
        this.emailList = emailList;
    }

    public int getLogValidDurationTime()
    {
        return logValidDurationTime;
    }

    public void setLogValidDurationTime(int logValidDurationTime)
    {
        this.logValidDurationTime = logValidDurationTime;
    }

    public long getLogMaxCount()
    {
        return logMaxCount;
    }

    public void setLogMaxCount(long logMaxCount)
    {
        this.logMaxCount = logMaxCount;
    }
}
