package com.kylin.electricassistsys.entity.log;

/**
 * Created by Threecolors on 2018/3/5.
 */
public enum AuditEventGrade
{
    NONE("NONE",0),
    INFO("信息",1),
    ERROR("错误",2),
    FAULT("故障",3),
    ABNORMAL("异常",4),
    FATAL_ABNORMAL("致命异常",5);


    private String name;
    private int index;

    AuditEventGrade(String name, int index)
    {
        this.name = name;
        this.index = index;
    }

    public static String getName(int index)
    {
        for (AuditEventGrade c : AuditEventGrade.values())
        {
            if (c.getIndex() == index)
            {
                return c.name;
            }
        }
        return null;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getIndex()
    {
        return index;
    }

    public void setIndex(int index)
    {
        this.index = index;
    }
}
