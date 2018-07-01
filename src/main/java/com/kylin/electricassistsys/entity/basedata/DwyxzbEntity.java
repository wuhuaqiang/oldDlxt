package com.kylin.electricassistsys.entity.basedata;


import com.kylin.electricassistsys.entity.BaseEntity;
import com.kylin.electricassistsys.entity.enumparam.KeyValueType;
import com.kylin.electricassistsys.utility.FieldMeta;
import com.kylin.electricassistsys.utility.TagType;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Table;

/**
 * 电网运行指标实体
 */
@NameStyle(Style.normal)
@Table(name="Dwyxzb")
public class DwyxzbEntity extends BaseEntity
{
    @FieldMeta(description = "供电类型", index = 1, queryField = true, editTagType = TagType.SELECT, keyValueType = KeyValueType.SUPPLY_ZONE_TYPE)
    private  String supplyZoneType ="";

    @FieldMeta(description = "电压等级", index = 2, queryField = true,  editTagType = TagType.SELECT, keyValueType = KeyValueType.VOLTAGE)
    private  String voltage ="";

    @FieldMeta(description = "容载比",index =3)
    private float rzb;

    @FieldMeta(description = "单线或单变站座数",index =4)
    private int dzs;

    @FieldMeta(description = "单线或单变站比例",index =5)
    private float dzbl;

    @FieldMeta(description = "满足N-1主变台数",index =6)
    private int zbts;

    @FieldMeta(description = "满足N-1主变比例",index =7)
    private float zbbl;

    @FieldMeta(description = "满足N-1线路条数",index =8)
    private int xlts;

    @FieldMeta(description = "满足N-1线路比例",index =9)
    private float xlbl;

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

    public float getRzb()
    {
        return rzb;
    }

    public void setRzb(float rzb)
    {
        this.rzb = rzb;
    }

    public int getDzs()
    {
        return dzs;
    }

    public void setDzs(int dzs)
    {
        this.dzs = dzs;
    }

    public float getDzbl()
    {
        return dzbl;
    }

    public void setDzbl(float dzbl)
    {
        this.dzbl = dzbl;
    }

    public int getZbts()
    {
        return zbts;
    }

    public void setZbts(int zbts)
    {
        this.zbts = zbts;
    }

    public float getZbbl()
    {
        return zbbl;
    }

    public void setZbbl(float zbbl)
    {
        this.zbbl = zbbl;
    }

    public int getXlts()
    {
        return xlts;
    }

    public void setXlts(int xlts)
    {
        this.xlts = xlts;
    }

    public float getXlbl()
    {
        return xlbl;
    }

    public void setXlbl(float xlbl)
    {
        this.xlbl = xlbl;
    }
}
