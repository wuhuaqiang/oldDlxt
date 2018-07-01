package com.kylin.electricassistsys.utility;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by hhq on 2017/11/15.
 */
public class JQGridColModel
{
    //private boolean key;

    /**
     * 表头列名
     */
    @JSONField(serialize=false)
    private String colName = "";

    /**
     * 列的字段名称
     */
    private String name = "";

    /**
     * 表头宽度
     */
    private int width = 0;

    /**
     * 是否可以排序
     */
    private boolean sortable = true;

    /**
     * 排序类型
     */
    private String sorttype = "string";

    /**
     * 是否居中
     */
    private String align = "center";

    /**
     * 是否可以搜索
     */
    private boolean search = true;


    /**构造函数
     * @param colName
     * @param name
     * @param width
     * @param sortable
     * @param sorttype
     * @param search
     */
    public JQGridColModel(String colName, String name, int width, boolean sortable, String sorttype, boolean search)
    {
        //this.key = key;
        this.colName = colName;
        this.name = name;
        this.width = width;
        this.sortable = sortable;
        this.sorttype = sorttype;
        this.search = search;
    }

    public String getIndex()
    {
        return this.name;
    }

    public String getColName()
    {
        return colName;
    }

    public void setColName(String colName)
    {
        this.colName = colName;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getWidth()
    {
        return width;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public boolean isSortable()
    {
        return sortable;
    }

    public void setSortable(boolean sortable)
    {
        this.sortable = sortable;
    }

    public String getSorttype()
    {
        return sorttype;
    }

    public void setSorttype(String sorttype)
    {
        this.sorttype = sorttype;
    }

    public String getAlign()
    {
        return align;
    }

    public void setAlign(String align)
    {
        this.align = align;
    }

    public boolean isSearch()
    {
        return search;
    }

    public void setSearch(boolean search)
    {
        this.search = search;
    }
}
