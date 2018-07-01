package com.kylin.electricassistsys.entity.log;

/**
 * Created by Threecolors on 2018/2/22.
 */
public enum AuditEventName
{
    NONE("NONE",0),
    ADD("添加",1),
    DELETE("删除",2),
    MODIFY("修改",3),
    QUERY("查询",4),
    IMPORT("导入",5),
    EXPORT("导出",6),
    UNAUTHORIZED("越权访问",7),
    IP_ABNORMAL("访问IP异常",8);


    private String name;
    private int index;

    AuditEventName(String name, int index)
    {
        this.name = name;
        this.index = index;
    }

    public static String getName(int index)
    {
        for (AuditEventName c : AuditEventName.values())
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
