package com.kylin.electricassistsys.utility;

import com.kylin.electricassistsys.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * Created by Threecolors on 2017/11/13.
 */
public class HierarchicalEntity extends BaseEntity
{
    private String preId ="";

    private String name ="";

    private int rank;

    @Transient
    private String remark = "";

    public String getPreId()
    {
        return preId;
    }

    public void setPreId(String preId)
    {
        this.preId = preId;
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

    public int getRank()
    {
        return rank;
    }

    public void setRank(int rank)
    {
        this.rank = rank;
    }
}
