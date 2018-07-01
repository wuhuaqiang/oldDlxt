package com.kylin.electricassistsys.entity.enumparam;

/**
 * Created by Threecolors on 2017/12/12.
 */
public enum FunctionType
{

    NONE("无", 0),

    VIEW("查看", 1),

    ADD("添加", 2),

    DELETE("删除", 4),

    MODIFY("修改", 8),

    QUERY("查询", 16),

    IMPORT("导入", 32),

    EXPORT("导出", 64);

    private String name;
    private int index;

    FunctionType(String name, int index)
    {
        this.name = name;
        this.index = index;
    }

    public static String getName(int index)
    {
        for (FunctionType c : FunctionType.values())
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
