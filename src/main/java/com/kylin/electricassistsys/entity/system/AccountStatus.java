package com.kylin.electricassistsys.entity.system;

import com.kylin.electricassistsys.utility.AuthorityType;

/**
 * Created by Threecolors on 2018/2/25.
 */
public enum AccountStatus
{
    NONE("NONE",0),
    STANDING_AVAILABLE ("长期可用",1),
    TEMPORARY_AVAILABLE("临时可用",2),
    RESTING("休眠",3);

    private String name;
    private int index;

    AccountStatus(String name, int index)
    {
        this.name = name;
        this.index = index;
    }

    public static String getName(int index)
    {
        for (AccountStatus c : AccountStatus.values())
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
