package com.kylin.electricassistsys.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * Created by Threecolors on 2018/1/13.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class LigerGridColumn
{
    private String display = "";

    private String name = "";

    private int minWidth=60;

    private int width=100;

    private boolean frozen = false;

    private List<LigerGridColumn> columns;

    public LigerGridColumn(String display, String name)
    {
        this.display = display;
        this.name = name;
    }

    public String getDisplay()
    {
        return display;
    }

    public void setDisplay(String display)
    {
        this.display = display;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getMinWidth()
    {
        return minWidth;
    }

    public void setMinWidth(int minWidth)
    {
        this.minWidth = minWidth;
    }

    public int getWidth()
    {
        return width;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public boolean isFrozen()
    {
        return frozen;
    }

    public void setFrozen(boolean frozen)
    {
        this.frozen = frozen;
    }

    public List<LigerGridColumn> getColumns()
    {
        return columns;
    }

    public void setColumns(List<LigerGridColumn> columns)
    {
        this.columns = columns;
    }
}
