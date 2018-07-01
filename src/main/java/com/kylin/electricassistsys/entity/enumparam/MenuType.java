package com.kylin.electricassistsys.entity.enumparam;

/**
 * 菜单类型
 */
public enum MenuType
{
    /**
     * 主菜单
     */
    MAIN("主菜单", 0),


    /**
     * 子菜单
     */
    SUB("子菜单", 1),

    /**
     * 内部菜单
     */
    INNER("内部菜单", 2),


    /**
     * 其他
     */
    OTHER("其他菜单", 3);

    private String name;
    private int index;

    MenuType(String name, int index)
    {
        this.name = name;
        this.index = index;
    }

    public static String getName(int index)
    {
        for (MenuType c : MenuType.values())
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
