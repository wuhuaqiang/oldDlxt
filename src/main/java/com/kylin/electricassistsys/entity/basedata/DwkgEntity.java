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
 * 电网开关
 */
@NameStyle(Style.normal)
@Table(name="Dwkg")
public class DwkgEntity extends BaseEntity
{
    @NotBlank(message ="必填项" )
    @FieldMeta(description = "供电类型", index = 1, queryField = true, editTagType = TagType.SELECT, keyValueType = KeyValueType.SUPPLY_ZONE_TYPE)
    private  String supplyZoneType ="";

    @NotBlank(message ="必填项" )
    @FieldMeta(description = "电压等级", index = 2, queryField = true,  editTagType = TagType.SELECT, keyValueType = KeyValueType.VOLTAGE)
    private  String voltage ="";

    @Digits(integer = 8, fraction = 0,message = "8位以内整数")
    @FieldMeta(description = "开关站(设施)",index =3)
    private int kgzss;

    @Digits(integer = 8, fraction = 0,message = "8位以内整数")
    @FieldMeta(description = "环网柜(设施)",index =4)
    private int hwgss;

    @Digits(integer = 8, fraction = 0,message = "8位以内整数")
    @FieldMeta(description = "电缆分支箱(设施)",index =5)
    private int dlfzxss;

    @Digits(integer = 8, fraction = 0,message = "8位以内整数")
    @FieldMeta(description = "柱上开关(设施)",index =6)
    private int zskgss;

    @Digits(integer = 8, fraction = 0,message = "8位以内整数")
    @FieldMeta(description = "开关数(台)",index =7)
    private int kgts;

    @Digits(integer = 8, fraction = 0,message = "8位以内整数")
    @FieldMeta(description = "短路器",index =8)
    private int dlq;

    @Digits(integer = 8, fraction = 0,message = "8位以内整数")
    @FieldMeta(description = "负荷开关",index =9)
    private int fhkg;

    public String getSupplyZoneType()
    {
        return supplyZoneType;
    }

    public void setSupplyZoneType(String supplyZoneType)
    {
        this.supplyZoneType = supplyZoneType;
    }

    public String getVoltage()
    {
        return voltage;
    }

    public void setVoltage(String voltage)
    {
        this.voltage = voltage;
    }

    public int getKgzss()
    {
        return kgzss;
    }

    public void setKgzss(int kgzss)
    {
        this.kgzss = kgzss;
    }

    public int getHwgss()
    {
        return hwgss;
    }

    public void setHwgss(int hwgss)
    {
        this.hwgss = hwgss;
    }

    public int getDlfzxss()
    {
        return dlfzxss;
    }

    public void setDlfzxss(int dlfzxss)
    {
        this.dlfzxss = dlfzxss;
    }

    public int getZskgss()
    {
        return zskgss;
    }

    public void setZskgss(int zskgss)
    {
        this.zskgss = zskgss;
    }

    public int getKgts()
    {
        return kgts;
    }

    public void setKgts(int kgts)
    {
        this.kgts = kgts;
    }

    public int getDlq()
    {
        return dlq;
    }

    public void setDlq(int dlq)
    {
        this.dlq = dlq;
    }

    public int getFhkg()
    {
        return fhkg;
    }

    public void setFhkg(int fhkg)
    {
        this.fhkg = fhkg;
    }
}
