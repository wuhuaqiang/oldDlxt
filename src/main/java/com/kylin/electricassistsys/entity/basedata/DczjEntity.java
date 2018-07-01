package com.kylin.electricassistsys.entity.basedata;


import com.kylin.electricassistsys.entity.BaseEntity;
import com.kylin.electricassistsys.entity.enumparam.KeyValueType;
import com.kylin.electricassistsys.utility.FieldMeta;
import com.kylin.electricassistsys.utility.TagType;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Table;

/**
 * 电厂装机表
 */
@NameStyle(Style.normal)
@Table(name="Dczj")
public class DczjEntity extends BaseEntity
{
    @FieldMeta(description = "类型", index = 1, queryField = true)
    private String lx;

    @FieldMeta(description = "单位", index = 2)
    private String dw;

    @FieldMeta(description = "单位(Kv)", index = 3)
    private String dwt;

    public String getLx()
    {
        return lx;
    }

    public void setLx(String lx)
    {
        this.lx = lx;
    }

    public String getDw()
    {
        return dw;
    }

    public void setDw(String dw)
    {
        this.dw = dw;
    }

    public String getDwt()
    {
        return dwt;
    }

    public void setDwt(String dwt)
    {
        this.dwt = dwt;
    }
}
