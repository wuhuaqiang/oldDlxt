package com.kylin.electricassistsys.entity.basedata;

import com.kylin.electricassistsys.entity.BaseEntity;
import com.kylin.electricassistsys.entity.enumparam.KeyValueType;
import com.kylin.electricassistsys.utility.FieldMeta;
import com.kylin.electricassistsys.utility.TagType;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Table;

/**
 * Created by Threecolors on 2017/12/14.
 */
@NameStyle(Style.normal)
@Table(name="MaintainGroup")
public class MaintainGroupEntity extends BaseEntity
{
    @FieldMeta(description = "班组名称", index = 1, queryField = true)
    private String name ="";

    @FieldMeta(description = "排序",index = 2)
    private int rank;

    @FieldMeta(description = "备注",index = 3,editTagType =TagType.TEXTAREA, required = false)
    private String remark="";

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getRank()
    {
        return rank;
    }

    public void setRank(int rank)
    {
        this.rank = rank;
    }

    public String getRemark()
    {
        return remark;
    }

    public void setRemark(String remark)
    {
        this.remark = remark;
    }
}
