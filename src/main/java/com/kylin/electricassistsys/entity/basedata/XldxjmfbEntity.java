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
 * 导线截面分布
 */
@NameStyle(Style.normal)
@Table(name="Xldxjmfb")
public class XldxjmfbEntity extends BaseEntity
{
    @NotBlank(message ="必填项" )
    @FieldMeta(description = "供电类型", index = 1, queryField = true, editTagType = TagType.SELECT, keyValueType = KeyValueType.SUPPLY_ZONE_TYPE)
    private  String supplyZoneType ="";

    @NotBlank(message ="必填项" )
    @FieldMeta(description = "电压等级", index = 2, queryField = true,  editTagType = TagType.SELECT, keyValueType = KeyValueType.VOLTAGE)
    private  String voltage ="";

    @Digits(integer = 6, fraction = 2,message = "8位有效数字的小数")
    @FieldMeta(description = "架空线路长度240(km)",index =3,width = 80)
    private double jkxlcd240;

    @Digits(integer = 6, fraction = 2,message = "8位有效数字的小数")
    @FieldMeta(description = "架空线路长度185(km)",index =4,width = 80)
    private double jkxlcd185;

    @Digits(integer = 6, fraction = 2,message = "8位有效数字的小数")
    @FieldMeta(description = "架空线路长度150(km)",index =5,width = 80)
    private double jkxlcd150;

    @Digits(integer = 6, fraction = 2,message = "8位有效数字的小数")
    @FieldMeta(description = "架空线路长度120(km)",index =6,width = 80)
    private double jkxlcd120;

    @Digits(integer = 6, fraction = 2,message = "8位有效数字的小数")
    @FieldMeta(description = "架空线路长度95(km)",index =7,width = 80)
    private double jkxlcd95;

    @Digits(integer = 6, fraction = 2,message = "8位有效数字的小数")
    @FieldMeta(description = "架空线路长度70(km)",index =8,width = 80)
    private double jkxlcd70;

    @Digits(integer = 6, fraction = 2,message = "8位有效数字的小数")
    @FieldMeta(description = "电缆线路长度(km)",index =9,width = 80)
    private double dlxlcd400;

    @Digits(integer = 6, fraction = 2,message = "8位有效数字的小数")
    @FieldMeta(description = "电缆线路长度300(km)",index =10,width = 80)
    private double dlxlcd300;

    @Digits(integer = 6, fraction = 2,message = "8位有效数字的小数")
    @FieldMeta(description = "电缆线路长度240(km)",index =11,width = 80)
    private double dlxlcd240;

    @Digits(integer = 6, fraction = 2,message = "8位有效数字的小数")
    @FieldMeta(description = "电缆线路长度185(km)",index =12,width = 80)
    private double dlxlcd185;

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

    public double getJkxlcd240()
    {
        return jkxlcd240;
    }

    public void setJkxlcd240(double jkxlcd240)
    {
        this.jkxlcd240 = jkxlcd240;
    }

    public double getJkxlcd185()
    {
        return jkxlcd185;
    }

    public void setJkxlcd185(double jkxlcd185)
    {
        this.jkxlcd185 = jkxlcd185;
    }

    public double getJkxlcd150()
    {
        return jkxlcd150;
    }

    public void setJkxlcd150(double jkxlcd150)
    {
        this.jkxlcd150 = jkxlcd150;
    }

    public double getJkxlcd120()
    {
        return jkxlcd120;
    }

    public void setJkxlcd120(double jkxlcd120)
    {
        this.jkxlcd120 = jkxlcd120;
    }

    public double getJkxlcd95()
    {
        return jkxlcd95;
    }

    public void setJkxlcd95(double jkxlcd95)
    {
        this.jkxlcd95 = jkxlcd95;
    }

    public double getJkxlcd70()
    {
        return jkxlcd70;
    }

    public void setJkxlcd70(double jkxlcd70)
    {
        this.jkxlcd70 = jkxlcd70;
    }

    public double getDlxlcd400()
    {
        return dlxlcd400;
    }

    public void setDlxlcd400(double dlxlcd400)
    {
        this.dlxlcd400 = dlxlcd400;
    }

    public double getDlxlcd300()
    {
        return dlxlcd300;
    }

    public void setDlxlcd300(double dlxlcd300)
    {
        this.dlxlcd300 = dlxlcd300;
    }

    public double getDlxlcd240()
    {
        return dlxlcd240;
    }

    public void setDlxlcd240(double dlxlcd240)
    {
        this.dlxlcd240 = dlxlcd240;
    }

    public double getDlxlcd185()
    {
        return dlxlcd185;
    }

    public void setDlxlcd185(double dlxlcd185)
    {
        this.dlxlcd185 = dlxlcd185;
    }
}
