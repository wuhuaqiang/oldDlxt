package com.kylin.electricassistsys.entity.basedata;


import com.kylin.electricassistsys.entity.BaseEntity;
import com.kylin.electricassistsys.entity.enumparam.KeyValueType;
import com.kylin.electricassistsys.utility.FieldMeta;
import com.kylin.electricassistsys.utility.TagType;
import org.hibernate.validator.constraints.LuhnCheck;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.NumberFormat;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

/**
 * 电网配变设备
 */
@NameStyle(Style.normal)
@Table(name="Dwpbsb")
public class DwpbsbEntity extends BaseEntity
{
    @NotBlank(message ="必填项" )
    @FieldMeta(description = "供电类型", index = 1, queryField = true, editTagType = TagType.SELECT, keyValueType = KeyValueType.SUPPLY_ZONE_TYPE)
    private  String supplyZoneType ="";

    @NotBlank(message ="必填项" )
    @FieldMeta(description = "电压等级", index = 2, queryField = true,  editTagType = TagType.SELECT, keyValueType = KeyValueType.VOLTAGE)
    private  String voltage ="";

    @Digits(integer = 8, fraction = 0,message = "8位以内整数")
    @FieldMeta(description = "配电室数(座)",index =3)
    private int pdszs;

    @Digits(integer = 6, fraction = 2,message = "8位有效数字的小数")
    @FieldMeta(description = "配电室容量(MVA)",index =4)
    private float pdsrl;

    @Digits(integer = 8, fraction = 0,message = "8位以内整数")
    @FieldMeta(description = "箱变数(座)",index =5)
    private int xbzs;

    @Digits(integer = 6, fraction = 2,message = "8位有效数字的小数")
    @FieldMeta(description = "箱变容量(MVA)",index =6)
    private float xbrl;

    @Digits(integer = 8, fraction = 0,message = "8位以内整数")
    @FieldMeta(description = "公用配变数(台)",index =7)
    private int gypbts;

    @Digits(integer = 6, fraction = 2,message = "8位有效数字的小数")
    @FieldMeta(description = "公用配变容量(MVA)",index =8)
    private float gypbrl;

    @Digits(integer = 8, fraction = 0,message = "8位以内整数")
    @FieldMeta(description = "柱上变数(台)",index =9)
    private int zsbts;

    @Digits(integer = 6, fraction = 2,message = "8位有效数字的小数")
    @FieldMeta(description = "柱上变容量(MVA)",index =10)
    private float zsbrl;

    @Digits(integer = 8, fraction = 0,message = "8位以内整数")
    @FieldMeta(description = "公用配变非晶合金配变数(台)",index =11)
    private int gypbfjhjpbts;

    @Digits(integer = 6, fraction = 2,message = "8位有效数字的小数")
    @FieldMeta(description = "公用配变非晶合金配变容量(MVA)",index =12)
    private float gypbfjhjpbrl;

    @Digits(integer = 8, fraction = 0,message = "8位以内整数")
    @FieldMeta(description = "专用配变数(台)",index =13)
    private int zypbts;

    @Digits(integer = 6, fraction = 2,message = "8位有效数字的小数")
    @FieldMeta(description = "专用配变容量(MVA)",index =14)
    private float zypbrl;

    @Digits(integer = 8, fraction = 0,message = "8位以内整数")
    @FieldMeta(description = "公用配变高损配变数(台)",index =15)
    private int gypbgspbts;

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

    public int getPdszs()
    {
        return pdszs;
    }

    public void setPdszs(int pdszs)
    {
        this.pdszs = pdszs;
    }

    public float getPdsrl()
    {
        return pdsrl;
    }

    public void setPdsrl(float pdsrl)
    {
        this.pdsrl = pdsrl;
    }

    public int getXbzs()
    {
        return xbzs;
    }

    public void setXbzs(int xbzs)
    {
        this.xbzs = xbzs;
    }

    public float getXbrl()
    {
        return xbrl;
    }

    public void setXbrl(float xbrl)
    {
        this.xbrl = xbrl;
    }

    public int getGypbts()
    {
        return gypbts;
    }

    public void setGypbts(int gypbts)
    {
        this.gypbts = gypbts;
    }

    public float getGypbrl()
    {
        return gypbrl;
    }

    public void setGypbrl(float gypbrl)
    {
        this.gypbrl = gypbrl;
    }

    public int getZsbts()
    {
        return zsbts;
    }

    public void setZsbts(int zsbts)
    {
        this.zsbts = zsbts;
    }

    public float getZsbrl()
    {
        return zsbrl;
    }

    public void setZsbrl(float zsbrl)
    {
        this.zsbrl = zsbrl;
    }

    public int getGypbfjhjpbts()
    {
        return gypbfjhjpbts;
    }

    public void setGypbfjhjpbts(int gypbfjhjpbts)
    {
        this.gypbfjhjpbts = gypbfjhjpbts;
    }

    public float getGypbfjhjpbrl()
    {
        return gypbfjhjpbrl;
    }

    public void setGypbfjhjpbrl(float gypbfjhjpbrl)
    {
        this.gypbfjhjpbrl = gypbfjhjpbrl;
    }

    public int getZypbts()
    {
        return zypbts;
    }

    public void setZypbts(int zypbts)
    {
        this.zypbts = zypbts;
    }

    public float getZypbrl()
    {
        return zypbrl;
    }

    public void setZypbrl(float zypbrl)
    {
        this.zypbrl = zypbrl;
    }

    public int getGypbgspbts()
    {
        return gypbgspbts;
    }

    public void setGypbgspbts(int gypbgspbts)
    {
        this.gypbgspbts = gypbgspbts;
    }
}
