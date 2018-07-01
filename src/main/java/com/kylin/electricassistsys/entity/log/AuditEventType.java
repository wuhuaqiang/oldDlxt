package com.kylin.electricassistsys.entity.log;

/**
 * Created by Threecolors on 2018/3/5.
 */
public enum AuditEventType
{
    NONE("NONE",0),
    SYS_EVENT("系统事件",1),
    BUSINESS_EVENT("业务事件",2);


    private String name;
    private int index;

    AuditEventType(String name, int index)
    {
        this.name = name;
        this.index = index;
    }

    public static String getName(int index)
    {
        for (AuditEventType c : AuditEventType.values())
        {
            if (c.getIndex() == index)
            {
                return c.name;
            }
        }
        return AuditEventType.getName(0);
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
