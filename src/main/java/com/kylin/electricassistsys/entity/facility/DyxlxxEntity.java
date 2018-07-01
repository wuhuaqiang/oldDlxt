package com.kylin.electricassistsys.entity.facility;


import com.kylin.electricassistsys.entity.BaseEntity;
import com.kylin.electricassistsys.entity.enumparam.KeyValueType;
import com.kylin.electricassistsys.utility.FieldMeta;
import com.kylin.electricassistsys.utility.TagType;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 低压线路信息列表
 */
@NameStyle(Style.normal)
@Table(name="Dyxlxx")
public class DyxlxxEntity extends BaseEntity
{
    @Transient
    @FieldMeta(description = "线路名称", index = 1, show = false, isImport = false,isExport = false)
    private String xlmc="";

    @Transient
    @FieldMeta(description = "线路编号", index = 2, show = false, isImport = false,isExport = false)
    private String xlbh="";

    @NotBlank(message ="必填项" )
    @FieldMeta(description = "年份",index =3)
    private String nf="";

    @NotBlank(message ="必填项" )
    @FieldMeta(description = "运维单位", queryField = true,index = 4,show=false, isExport = false,editTagType = TagType.SELECT, keyValueType = KeyValueType.GDGS)
    private String ywdw="";

    @Transient
    @FieldMeta(description = "运维单位", index =4,isImport = false)
    private String ywdwName="";

    @NotBlank(message ="必填项" )
    @FieldMeta(description = "所属区域", queryField = true,index = 5, isExport = false,  show = false, editTagType = TagType.SELECT, keyValueType = KeyValueType.QY)
    private String qyId="";

    @Transient
    @FieldMeta(description = "所属区域",index =5, editTagType = TagType.NONE,isImport = false)
    private String qyName="";

    @NotBlank(message ="必填项" )
    @FieldMeta(description = "供区类型", queryField = true,index = 6,editTagType = TagType.SELECT, keyValueType = KeyValueType.SUPPLY_ZONE_TYPE)
    private String gqlx="";

    @NotBlank(message ="必填项" )
    @FieldMeta(description = "敷设方式", index = 7,editTagType = TagType.SELECT, keyValueType = KeyValueType.FSFS)
    private String fsfs="";

    @Transient
    @FieldMeta(description = "城农网", index = 8,show = false,isExport = false,isImport = false)
    private String cnw="";

    @Transient
    @FieldMeta(description = "电缆型号",index = 9,isImport = false)
    private String dlxhname="";

    @NotBlank(message ="必填项" )
    @FieldMeta(description = "电缆型号",show=false, index = 9, isExport = false)
    private String dlxh="";

    @FieldMeta(description = "裸导线条数", index = 10)
    private int ldxts;

    @FieldMeta(description = "绝缘线条数", index = 11)
    private int jyxts;

    @Transient
    @FieldMeta(description = "线路总条数", index = 12)
    private int xlts;

    @FieldMeta(description = "裸导线长度", index = 13)
    private float ldxcd;

    @FieldMeta(description = "绝缘线长度", index = 14)
    private float jyxcd;

    @Transient
    @FieldMeta(description = "线路总长度", index = 15)
    private float xlcd;

    @FieldMeta(description = "分段数", index = 16)
    private int fds;

    @FieldMeta(description = "分段长度", index = 17)
    private float fdcd;

    @FieldMeta(description = "备注", index = 18)
    private String remark;

    public String getXlmc()
    {
        return xlmc;
    }

    public void setXlmc(String xlmc)
    {
        this.xlmc = xlmc;
    }

    public String getXlbh()
    {
        return xlbh;
    }

    public void setXlbh(String xlbh)
    {
        this.xlbh = xlbh;
    }

    public String getCnw()
    {
        return cnw;
    }

    public void setCnw(String cnw)
    {
        this.cnw = cnw;
    }

    public String getNf()
    {
        return nf;
    }

    public void setNf(String nf)
    {
        this.nf = nf;
    }

    public String getYwdw()
    {
        return ywdw;
    }

    public void setYwdw(String ywdw)
    {
        this.ywdw = ywdw;
    }

    public String getYwdwName()
    {
        return ywdwName;
    }

    public void setYwdwName(String ywdwName)
    {
        this.ywdwName = ywdwName;
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

    public String getFsfs()
    {
        return fsfs;
    }

    public void setFsfs(String fsfs)
    {
        this.fsfs = fsfs;
    }

    public int getLdxts()
    {
        return ldxts;
    }

    public void setLdxts(int ldxts)
    {
        this.ldxts = ldxts;
    }

    public int getJyxts()
    {
        return jyxts;
    }

    public void setJyxts(int jyxts)
    {
        this.jyxts = jyxts;
    }

    public int getXlts()
    {
        return ldxts+jyxts;
    }

    public void setXlts(int xlts)
    {
        this.xlts = xlts;
    }

    public float getLdxcd()
    {
        return ldxcd;
    }

    public void setLdxcd(float ldxcd)
    {
        this.ldxcd = ldxcd;
    }

    public float getJyxcd()
    {
        return jyxcd;
    }

    public void setJyxcd(float jyxcd)
    {
        this.jyxcd = jyxcd;
    }

    public float getXlcd()
    {
        return ldxcd + jyxcd;
    }

    public void setXlcd(float xlcd)
    {
        this.xlcd = xlcd;
    }

    public int getFds()
    {
        return fds;
    }

    public void setFds(int fds)
    {
        this.fds = fds;
    }

    public float getFdcd()
    {
        return fdcd;
    }

    public void setFdcd(float fdcd)
    {
        this.fdcd = fdcd;
    }

    public String getDlxhname()
    {
        return dlxhname;
    }

    public void setDlxhname(String dlxhname)
    {
        this.dlxhname = dlxhname;
    }

    public String getDlxh()
    {
        return dlxh;
    }

    public void setDlxh(String dlxh)
    {
        this.dlxh = dlxh;
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
