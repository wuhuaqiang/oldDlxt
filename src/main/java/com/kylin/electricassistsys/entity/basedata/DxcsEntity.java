package com.kylin.electricassistsys.entity.basedata;

import com.kylin.electricassistsys.entity.BaseEntity;
import com.kylin.electricassistsys.entity.enumparam.KeyValueType;
import com.kylin.electricassistsys.utility.FieldMeta;
import com.kylin.electricassistsys.utility.TagType;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Table;

/**
 * 导线参数
 */
@NameStyle(Style.normal)
@Table(name ="Dxcs")
public class DxcsEntity extends BaseEntity
{
    @NotBlank(message ="必填项" )
    @Length(max = 20,message = "20位以内字符")
    @FieldMeta(description = "导线名称", index = 1, queryField = true)
    private String name = "";

    @NotBlank(message ="必填项" )
    @FieldMeta(description = "导线类型", index = 2, queryField = true, editTagType = TagType.SELECT, keyValueType = KeyValueType.WIRE_TYPE)
    private String dxlx= "";

    @Length(max = 20,message = "20位以内字符")
    @FieldMeta(description = "导线截面", index = 3)
    private String dxjm= "";

    @FieldMeta(description = "安全电流限值", index = 4)
    private float aqdlxz;

    @FieldMeta(description = "正序电阻", index = 5)
    private float r1;

    @FieldMeta(description = "零序电阻", index = 6)
    private float r0;

    @FieldMeta(description = "正序电抗", index =7)
    private float x1;

    @FieldMeta(description = "零序电抗", index = 8)
    private float x0;

    @FieldMeta(description = "正序电纳", index =9)
    private float b1;

    @FieldMeta(description = "零序电纳", index = 10)
    private float b0;

    @FieldMeta(description = "经济电流密度", index = 11)
    private float jjdlmd;

    @FieldMeta(description = "容量最小值", index = 12)
    private float minimum;

    @FieldMeta(description = "容量最大值", index = 13)
    private float maximum;

    @FieldMeta(description = "备注", index = 14, editTagType = TagType.TEXTAREA)
    private String remark="";

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDxlx()
    {
        return dxlx;
    }

    public void setDxlx(String dxlx)
    {
        this.dxlx = dxlx;
    }

    public String getDxjm()
    {
        return dxjm;
    }

    public void setDxjm(String dxjm)
    {
        this.dxjm = dxjm;
    }

    public float getAqdlxz()
    {
        return aqdlxz;
    }

    public void setAqdlxz(float aqdlxz)
    {
        this.aqdlxz = aqdlxz;
    }

    public float getR1()
    {
        return r1;
    }

    public void setR1(float r1)
    {
        this.r1 = r1;
    }

    public float getR0()
    {
        return r0;
    }

    public void setR0(float r0)
    {
        this.r0 = r0;
    }

    public float getX1()
    {
        return x1;
    }

    public void setX1(float x1)
    {
        this.x1 = x1;
    }

    public float getX0()
    {
        return x0;
    }

    public void setX0(float x0)
    {
        this.x0 = x0;
    }

    public float getB1()
    {
        return b1;
    }

    public void setB1(float b1)
    {
        this.b1 = b1;
    }

    public float getB0()
    {
        return b0;
    }

    public void setB0(float b0)
    {
        this.b0 = b0;
    }

    public float getJjdlmd()
    {
        return jjdlmd;
    }

    public void setJjdlmd(float jjdlmd)
    {
        this.jjdlmd = jjdlmd;
    }

    public float getMinimum()
    {
        return minimum;
    }

    public void setMinimum(float minimum)
    {
        this.minimum = minimum;
    }

    public float getMaximum()
    {
        return maximum;
    }

    public void setMaximum(float maximum)
    {
        this.maximum = maximum;
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
