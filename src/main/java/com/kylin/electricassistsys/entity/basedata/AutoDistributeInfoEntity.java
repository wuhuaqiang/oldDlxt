package com.kylin.electricassistsys.entity.basedata;

import com.kylin.electricassistsys.entity.BaseEntity;
import com.kylin.electricassistsys.entity.enumparam.KeyValueType;
import com.kylin.electricassistsys.utility.FieldMeta;
import com.kylin.electricassistsys.utility.TagType;
import org.hibernate.validator.constraints.NotBlank;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Table;

/**
 * Created by Threecolors on 2017/11/17.
 * 配电自动化信息实体
 */
@NameStyle(Style.normal)
@Table(name="AutoDistributeInfo")
public class AutoDistributeInfoEntity extends BaseEntity
{
    @NotBlank(message = "必填项")
    @FieldMeta(description = "供电类型", index = 1, queryField = true, editTagType = TagType.SELECT, keyValueType = KeyValueType.SUPPLY_ZONE_TYPE)
    private  String supplyZoneType ="";

    @NotBlank(message = "必填项")
    @FieldMeta(description = "电压等级", index = 2, queryField = true,  editTagType = TagType.SELECT, keyValueType = KeyValueType.VOLTAGE)
    private  String voltage ="";

    @FieldMeta(description = "自动化覆盖率(%)",index =3)
    private  float coverageRate;

    @FieldMeta(description = "配电终端一遥比例(%)",index =4)
    private  float pdzdyybl;

    @FieldMeta(description = "配电终端二遥比例(%)",index =5)
    private  float pdzdeybl;

    @FieldMeta(description = "配电终端三遥比例(%)",index =6)
    private  float pdzdsybl;

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

    public float getCoverageRate()
    {
        return coverageRate;
    }

    public void setCoverageRate(float coverageRate)
    {
        this.coverageRate = coverageRate;
    }

    public float getPdzdyybl()
    {
        return pdzdyybl;
    }

    public void setPdzdyybl(float pdzdyybl)
    {
        this.pdzdyybl = pdzdyybl;
    }

    public float getPdzdeybl()
    {
        return pdzdeybl;
    }

    public void setPdzdeybl(float pdzdeybl)
    {
        this.pdzdeybl = pdzdeybl;
    }

    public float getPdzdsybl()
    {
        return pdzdsybl;
    }

    public void setPdzdsybl(float pdzdsybl)
    {
        this.pdzdsybl = pdzdsybl;
    }
}
