package com.kylin.electricassistsys.entity.enumparam;

/**
 * Created by Threecolors on 2017/11/14.
 * 行政级别
 */
public enum AdministrativeLevel
{
    NATIONALITY("国家级",0),PROVINCE("省级",1),CITY("市级",2), COUNTY("县级",3),TOWN("镇级",4);

    private String name;
    private int index;

    AdministrativeLevel(String name, int index)
    {
        this.name = name;
        this.index = index;
    }

    public static String getName(int index)
    {
        for (AdministrativeLevel c : AdministrativeLevel.values())
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
