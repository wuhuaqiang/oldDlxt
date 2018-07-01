package com.kylin.electricassistsys.entity.basedata;

import com.kylin.electricassistsys.entity.BaseEntity;
import com.kylin.electricassistsys.entity.enumparam.KeyValueType;
import com.kylin.electricassistsys.utility.FieldMeta;
import com.kylin.electricassistsys.utility.TagType;
import org.hibernate.validator.constraints.NotBlank;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Table;
import javax.validation.constraints.Digits;

/**
 * Created by Threecolors on 2017/11/18.
 * 导线截面
 */
@NameStyle(Style.normal)
@Table(name="Xldxjm")
public class XldxjmEntity extends BaseEntity
{
    @NotBlank(message ="必填项" )
    @FieldMeta(description = "供电类型", index = 1, queryField = true, editTagType = TagType.SELECT, keyValueType = KeyValueType.SUPPLY_ZONE_TYPE)
    private  String supplyZoneType ="";

    @FieldMeta(description = "低压线路类型",index =2)
    private String dyxllx = "";

    @FieldMeta(description = "导线截面1",index =3)
    private String dxjm1 = "";

    @Digits(integer = 6, fraction = 2,message = "8位有效数字的小数")
    @FieldMeta(description = "导线截面1长度",index =4)
    private double dxjmcd1;

    @FieldMeta(description = "导线截面2",index =5)
    private String dxjm2 = "";

    @Digits(integer = 6, fraction = 2,message = "8位有效数字的小数")
    @FieldMeta(description = "导线截面2长度",index =6)
    private double dxjmcd2;

    @FieldMeta(description = "导线截面3",index =7)
    private String dxjm3 = "";

    @Digits(integer = 6, fraction = 2,message = "8位有效数字的小数")
    @FieldMeta(description = "导线截面3长度",index =8)
    private double dxjmcd3;

    public String getSupplyZoneType()
    {
        return supplyZoneType;
    }

    public void setSupplyZoneType(String supplyZoneType)
    {
        this.supplyZoneType = supplyZoneType;
    }

    public String getDyxllx()
    {
        return dyxllx;
    }

    public void setDyxllx(String dyxllx)
    {
        this.dyxllx = dyxllx;
    }

    public String getDxjm1()
    {
        return dxjm1;
    }

    public void setDxjm1(String dxjm1)
    {
        this.dxjm1 = dxjm1;
    }

    public double getDxjmcd1()
    {
        return dxjmcd1;
    }

    public void setDxjmcd1(double dxjmcd1)
    {
        this.dxjmcd1 = dxjmcd1;
    }

    public String getDxjm2()
    {
        return dxjm2;
    }

    public void setDxjm2(String dxjm2)
    {
        this.dxjm2 = dxjm2;
    }

    public double getDxjmcd2()
    {
        return dxjmcd2;
    }

    public void setDxjmcd2(double dxjmcd2)
    {
        this.dxjmcd2 = dxjmcd2;
    }

    public String getDxjm3()
    {
        return dxjm3;
    }

    public void setDxjm3(String dxjm3)
    {
        this.dxjm3 = dxjm3;
    }

    public double getDxjmcd3()
    {
        return dxjmcd3;
    }

    public void setDxjmcd3(double dxjmcd3)
    {
        this.dxjmcd3 = dxjmcd3;
    }
}
