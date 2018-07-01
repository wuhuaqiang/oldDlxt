package com.kylin.electricassistsys.entity.system;

import java.util.ArrayList;
import java.util.List;

/**
 * ThreeGrid实体
 */
public class TreeGridEntity
{
    private int total;

    private List<MenuTreeGridEntity> rows = new ArrayList<MenuTreeGridEntity>();

    public int getTotal()
    {
        return rows.size();
    }

    public List<MenuTreeGridEntity> getRows()
    {
        return rows;
    }

    public void setRows(List<MenuTreeGridEntity> rows)
    {
        this.rows = rows;
    }
}
