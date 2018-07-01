package com.kylin.electricassistsys.entity.basedata;


import com.kylin.electricassistsys.entity.BaseEntity;
import com.kylin.electricassistsys.entity.enumparam.KeyValueType;
import com.kylin.electricassistsys.utility.FieldMeta;
import com.kylin.electricassistsys.utility.TagType;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 中压配网运行指标信息
 */
@NameStyle(Style.normal)
@Table(name="Zypwyxzb")
public class ZypwyxzbEntity extends BaseEntity
{
    @FieldMeta(description = "所属区域", queryField = true,index = 1, show = false, editTagType = TagType.SELECT, keyValueType = KeyValueType.QY)
    private String qyId;

    @Transient
    @FieldMeta(description = "所属区域",index =1, editTagType = TagType.NONE)
    private String qyName;

    @FieldMeta(description = "供区类型", queryField = true,index = 2, show = false, editTagType = TagType.SELECT, keyValueType = KeyValueType.SUPPLY_ZONE_TYPE)
    private String gqlx;

    @Transient
    @FieldMeta(description = "供区类型",index = 2, editTagType = TagType.NONE)
    private String gqlxName;

    @FieldMeta(description = "城农网", queryField = true,index = 3, show = false, editTagType = TagType.SELECT, keyValueType = KeyValueType.CNW)
    private String cnw;

    @Transient
    @FieldMeta(description = "城农网",index =3, editTagType = TagType.NONE)
    private String cnwName;

    @FieldMeta(description = "数据年月",index = 4)
    private String year;

    @FieldMeta(description = "供电可靠性RS1(%)",index = 5)
    private float gdkkxrs1;

    @FieldMeta(description = "供电可靠性RS3(%)",index = 6)
    private float gdkkxrs3;

    @FieldMeta(description = "110kV及以下线损率(%)",index = 7)
    private float xsl110;

    @FieldMeta(description = "10kV及以下线损率(%)",index = 8)
    private float xsl10;

    @FieldMeta(description = "综合电压合格率(%)",index = 9)
    private float zhdyhgl;

    @FieldMeta(description = "居民端电压合格率(%)",index = 10)
    private float jmddyhgl;

    public String getQyId()
    {
        return qyId;
    }

    public void setQyId(String qyId)
    {
        this.qyId = qyId;
    }

    public String getQyName()
    {
        return qyName;
    }

    public void setQyName(String qyName)
    {
        this.qyName = qyName;
    }

    public String getGqlx()
    {
        return gqlx;
    }

    public void setGqlx(String gqlx)
    {
        this.gqlx = gqlx;
    }

    public String getGqlxName()
    {
        return gqlxName;
    }

    public void setGqlxName(String gqlxName)
    {
        this.gqlxName = gqlxName;
    }

    public String getCnw()
    {
        return cnw;
    }

    public void setCnw(String cnw)
    {
        this.cnw = cnw;
    }

    public String getCnwName()
    {
        return cnwName;
    }

    public void setCnwName(String cnwName)
    {
        this.cnwName = cnwName;
    }

    public String getYear()
    {
        return year;
    }

    public void setYear(String year)
    {
        this.year = year;
    }

    public float getGdkkxrs1()
    {
        return gdkkxrs1;
    }

    public void setGdkkxrs1(float gdkkxrs1)
    {
        this.gdkkxrs1 = gdkkxrs1;
    }

    public float getGdkkxrs3()
    {
        return gdkkxrs3;
    }

    public void setGdkkxrs3(float gdkkxrs3)
    {
        this.gdkkxrs3 = gdkkxrs3;
    }

    public float getXsl110()
    {
        return xsl110;
    }

    public void setXsl110(float xsl110)
    {
        this.xsl110 = xsl110;
    }

    public float getXsl10()
    {
        return xsl10;
    }

    public void setXsl10(float xsl10)
    {
        this.xsl10 = xsl10;
    }

    public float getZhdyhgl()
    {
        return zhdyhgl;
    }

    public void setZhdyhgl(float zhdyhgl)
    {
        this.zhdyhgl = zhdyhgl;
    }

    public float getJmddyhgl()
    {
        return jmddyhgl;
    }

    public void setJmddyhgl(float jmddyhgl)
    {
        this.jmddyhgl = jmddyhgl;
    }
}
