package com.kylin.electricassistsys.entity;

import com.kylin.electricassistsys.entity.enumparam.Status;

/**
 * Created by hhq on 2017/11/14.
 * 一般实体类型
 */
public class CommonEntity
{
    /**
     * 主键
     */
    private String id  ="";

    /**
     * 名称
     */
    private String name="";

    /**
     * 排序
     */
    private int index;

    /**
     * 备注
     */
    private String remark="";

    /**
     * 状态
     */
    private int status =1;

    private String operate = "";

    public int getIndex()
    {
        return index;
    }

    public void setIndex(int index)
    {
        this.index = index;
    }

    public int getStatus()
    {
        return this.status;
    }

    public String getStatusTxt()
    {
        return  Status.getName(this.status);
    }

    public void setStatus(int status)
    {
        this.status = status;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getRemark()
    {
        return remark;
    }

    public void setRemark(String remark)
    {
        this.remark = remark;
    }

    public String getOperate()
    {
        return operate;
    }

    public void setOperate(String operate)
    {
        this.operate = operate;
    }
}
