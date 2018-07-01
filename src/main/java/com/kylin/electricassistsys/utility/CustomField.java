package com.kylin.electricassistsys.utility;

import com.alibaba.fastjson.annotation.JSONField;
import com.kylin.electricassistsys.entity.enumparam.KeyValueType;

import java.lang.reflect.Field;

/**
 * Created by Threecolors on 2017/11/30.
 */
public class CustomField
{
    public CustomField(FieldMeta meta, Field field)
    {
        this.rank = meta.index();
        this.show = meta.show();
        this.queryField = meta.queryField();
        this.editTagType = meta.editTagType();
        this.keyValueType = meta.keyValueType();
        this.colName = meta.description();
        this.width = meta.width();
        this.sortable = meta.sortable();
        this.align = meta.align();
        this.search = meta.search();
        this.required = meta.required();
        this.name = field.getName();
        this.field = field;
        this.hidden = !this.show;
        this.hidedlg = this.colName.equals("操作");
        this.meta = meta;
    }
    @JSONField(serialize = false)
    private  boolean isExport;
    @JSONField(serialize = false)
    private  boolean isImport;
    @JSONField(serialize = false)
    private  FieldMeta meta;

    @JSONField(serialize = false)
    private Field field;

    /**
     * 排序
     */
    @JSONField(serialize = false)
    private int rank;

    /**
     * 是否在列表显示
     */
    @JSONField(serialize = false)
    private boolean show;
    /**
     * 是否查询字段
     */
    @JSONField(serialize = false)
    private boolean queryField;

    /**
     * 是否查询标签类型
     */
    @JSONField(serialize = false)
    private TagType editTagType;

    /**
     * 是否必须填写
     */
    @JSONField(serialize = false)
    private boolean required;

    /**
     * TagType.SELECT 数据源类型
     */
    @JSONField(serialize = false)
    private KeyValueType keyValueType;

    /**
     * 表头
     */
    @JSONField(serialize = false)
    private String colName;

    @JSONField(serialize = false)
    private Object fieldValue;


    private String name;

    //private String index;

    /**
     * 表头宽度
     */
    private int width;

    /**
     * 是否可以排序
     */
    private boolean sortable;

    /**
     * 排序类型
     */
    private String sorttype;

    /**
     * 是否隐藏
     */
    private boolean hidden;

    private boolean hidedlg;

    /**
     * 是否居中
     */
    private String align;

    /**
     * 是否可以搜索
     */
    private boolean search;

    public boolean isShow()
    {
        return show;
    }

    public void setShow(boolean show)
    {
        this.show = show;
    }

    public boolean isQueryField()
    {
        return queryField;
    }

    public void setQueryField(boolean queryField)
    {
        this.queryField = queryField;
    }

    public TagType getEditTagType()
    {
        return editTagType;
    }

    public void setEditTagType(TagType editTagType)
    {
        this.editTagType = editTagType;
    }

    public KeyValueType getKeyValueType()
    {
        return keyValueType;
    }

    public void setKeyValueType(KeyValueType keyValueType)
    {
        this.keyValueType = keyValueType;
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
        switch (this.field.getType().getName())
        {
            case "int":
                return "int";
            case "float":
            case "double":
                return "number";
            case "Date":
                return "date";
            default:
                return "string";
        }
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

    public Field getField()
    {
        return field;
    }

    public void setField(Field field)
    {
        this.field = field;
    }

    public Object getFieldValue()
    {
        return fieldValue;
    }

    public void setFieldValue(Object fieldValue)
    {
        this.fieldValue = fieldValue;
    }

    public boolean isRequired()
    {
        return required;
    }

    public void setRequired(boolean required)
    {
        this.required = required;
    }

    public boolean isHidden()
    {
        return hidden;
    }

    public void setHidden(boolean hidden)
    {
        this.hidden = hidden;
    }

    public void setSorttype(String sorttype)
    {
        this.sorttype = sorttype;
    }

    public boolean isHidedlg()
    {
        return hidedlg;
    }

    public void setHidedlg(boolean hidedlg)
    {
        this.hidedlg = hidedlg;
    }

    public int getRank()
    {
        return rank;
    }

    public void setRank(int rank)
    {
        this.rank = rank;
    }

    public boolean isExport()
    {
        return isExport;
    }

    public void setExport(boolean export)
    {
        isExport = export;
    }

    public boolean isImport()
    {
        return isImport;
    }

    public void setImport(boolean anImport)
    {
        isImport = anImport;
    }

    public FieldMeta getMeta()
    {
        return meta;
    }

    public void setMeta(FieldMeta meta)
    {
        this.meta = meta;
    }
}
