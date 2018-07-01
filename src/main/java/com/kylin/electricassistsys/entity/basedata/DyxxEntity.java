package com.kylin.electricassistsys.entity.basedata;


import com.kylin.electricassistsys.entity.BaseEntity;
import com.kylin.electricassistsys.entity.enumparam.KeyValueType;
import com.kylin.electricassistsys.utility.FieldMeta;
import com.kylin.electricassistsys.utility.TagType;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

/**
 * 电源信息
 */
@NameStyle(Style.normal)
@Table(name="Dyxx")
public class DyxxEntity extends BaseEntity
{
    @FieldMeta(description = "电厂名称",index = 1, queryField = true )
    private String dcmc;

    @FieldMeta(description = "电源标记",index = 2, editTagType = TagType.SELECT, keyValueType = KeyValueType.OPERATING_STATE)
    private String dybj;

    @FieldMeta(description = "所属区域", queryField = true,index = 3, show = false, editTagType = TagType.SELECT, keyValueType = KeyValueType.QY)
    private String qyId;

    @Transient
    @FieldMeta(description = "所属区域",index = 3, editTagType = TagType.NONE)
    private String qyName;

    @FieldMeta(description = "供区类型", queryField = true,index = 4, show = false, editTagType = TagType.SELECT, keyValueType = KeyValueType.SUPPLY_ZONE_TYPE)
    private String gqlx;

    @Transient
    @FieldMeta(description = "供区类型",index = 4, editTagType = TagType.NONE)
    private String gqlxName;

    @FieldMeta(description = "电压等级", queryField = true,index = 5, show = false, editTagType = TagType.SELECT, keyValueType = KeyValueType.VOLTAGE)
    private String dydj;

    @Transient
    @FieldMeta(description = "电压等级",index = 5, editTagType = TagType.NONE)
    private int dydjName;

    @FieldMeta(description = "电厂类型", queryField = true,index = 6, show = false, editTagType = TagType.SELECT, keyValueType = KeyValueType.DCLX)
    private String dclx;

    @Transient
    @FieldMeta(description = "电厂类型",index = 6, editTagType = TagType.NONE)
    private String dclxName;

    @FieldMeta(description = "厂用电量(%)",index = 7)
    private float cydl;

    @FieldMeta(description = "投产时间",index = 8)
    private String tcsj;

    @FieldMeta(description = "调试属性",index = 9,show = false)
    private String tssx;

    @FieldMeta(description = "装机规模",index = 10,show = false)
    private String zjmx;

    @FieldMeta(description = "年发电量",index = 11,show = false)
    private float nfdl;

    @FieldMeta(description = "利用小时数",index = 12,show = false)
    private float lyxss;

    @FieldMeta(description = "丰期出力",index = 13,show = false)
    private float fqcl;

    @FieldMeta(description = "枯期出力",index = 14,show = false)
    private float kqcl;

    @FieldMeta(description = "投运时间",index = 15,show = false)
    private String btysj;

    @FieldMeta(description = "退役时间",index = 16,show = false)
    private String etysj;

    @FieldMeta(description = "运行状态",index = 17,show = false)
    private String yxzt;

    @FieldMeta(description = "备注",index = 18,show = false)
    private String remark;

    public String getDcmc()
    {
        return dcmc;
    }

    public void setDcmc(String dcmc)
    {
        this.dcmc = dcmc;
    }

    public String getDybj()
    {
        return dybj;
    }

    public void setDybj(String dybj)
    {
        this.dybj = dybj;
    }

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

    public String getDydj()
    {
        return dydj;
    }

    public void setDydj(String dydj)
    {
        this.dydj = dydj;
    }

    public int getDydjName()
    {
        return dydjName;
    }

    public void setDydjName(int dydjName)
    {
        this.dydjName = dydjName;
    }

    public String getDclx()
    {
        return dclx;
    }

    public void setDclx(String dclx)
    {
        this.dclx = dclx;
    }

    public String getDclxName()
    {
        return dclxName;
    }

    public void setDclxName(String dclxName)
    {
        this.dclxName = dclxName;
    }

    public float getCydl()
    {
        return cydl;
    }

    public void setCydl(float cydl)
    {
        this.cydl = cydl;
    }

    public String getTcsj()
    {
        return tcsj;
    }

    public void setTcsj(String tcsj)
    {
        this.tcsj = tcsj;
    }

    public String getTssx()
    {
        return tssx;
    }

    public void setTssx(String tssx)
    {
        this.tssx = tssx;
    }

    public String getZjmx()
    {
        return zjmx;
    }

    public void setZjmx(String zjmx)
    {
        this.zjmx = zjmx;
    }

    public float getNfdl()
    {
        return nfdl;
    }

    public void setNfdl(float nfdl)
    {
        this.nfdl = nfdl;
    }

    public float getLyxss()
    {
        return lyxss;
    }

    public void setLyxss(float lyxss)
    {
        this.lyxss = lyxss;
    }

    public float getFqcl()
    {
        return fqcl;
    }

    public void setFqcl(float fqcl)
    {
        this.fqcl = fqcl;
    }

    public float getKqcl()
    {
        return kqcl;
    }

    public void setKqcl(float kqcl)
    {
        this.kqcl = kqcl;
    }

    public String getBtysj()
    {
        return btysj;
    }

    public void setBtysj(String btysj)
    {
        this.btysj = btysj;
    }

    public String getEtysj()
    {
        return etysj;
    }

    public void setEtysj(String etysj)
    {
        this.etysj = etysj;
    }

    public String getYxzt()
    {
        return yxzt;
    }

    public void setYxzt(String yxzt)
    {
        this.yxzt = yxzt;
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
