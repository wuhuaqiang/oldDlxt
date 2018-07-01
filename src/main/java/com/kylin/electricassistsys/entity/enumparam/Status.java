package com.kylin.electricassistsys.entity.enumparam;


/**
 * 状态枚举
 */
public enum  Status
{
    INVALID("无效", 0), VALID("有效",1);

    private String name;
    private int index;

    Status(String name, int index)
    {
        this.name = name;
        this.index = index;
    }

    public static String getName(int index)
    {
        for (Status c : Status.values())
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
