package com.kylin.electricassistsys.utility;

/**
 * Created by Threecolors on 2018/1/21.
 *  2^0查看，2^1添加，2^2删除，2^3修改，2^4查询，2^5导入，2^6导出
 */
public enum  AuthorityType
{
    NONE("NONE",0),
    VIEW("查看",1),
    ADD("添加",2),
    DELETE("删除",4),
    MODIFY("修改",8),
    QUERY("查询",16),
    IMPORT("导入",32),
    EXPORT("导出",64);


    private String name;
    private int index;

    AuthorityType(String name, int index)
    {
        this.name = name;
        this.index = index;
    }

    public static String getName(int index)
    {
        for (AuthorityType c : AuthorityType.values())
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
