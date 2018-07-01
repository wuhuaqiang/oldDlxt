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
 * 变压器信息
 */
@NameStyle(Style.normal)
@Table(name="Byqxx")
public class ByqxxEntity extends BaseEntity
{
    @NotBlank(message ="必填项" )
    @Length(max = 20,message = "20位以内字符")
    @FieldMeta(description = "变压器",queryField = true, index = 1)
    private String byqName="";

    @NotBlank(message ="必填项" )
    @FieldMeta(description = "变电站", index = 2, queryField = true, show = false, isExport = false,editTagType = TagType.SELECT, keyValueType = KeyValueType.VOLTAGE)
    private String bdz="";


    @Transient
    @FieldMeta(description = "变电站",index = 2,isImport = false)
    private String bdzName="";

    @Transient
    @FieldMeta(description = "使用方式", index = 3, editTagType = TagType.SELECT, isImport = false,keyValueType = KeyValueType.SYFS)
    private String syfs="";

    @Transient
    @FieldMeta(description = "电压等级", index =4, queryField = true, isImport = false,editTagType = TagType.SELECT, keyValueType = KeyValueType.VOLTAGE)
    private String dydj="";

    @Transient
    @FieldMeta(description = "供区类型",queryField = true,index = 5,isImport = false, editTagType = TagType.SELECT, keyValueType = KeyValueType.SUPPLY_ZONE_TYPE)
    private String gqlx="";

    @Transient
    @FieldMeta(description = "所属区域", queryField = true,index = 6,isExport = false,isImport = false,show = false, editTagType = TagType.SELECT, keyValueType = KeyValueType.QY)
    private String qyId="";

    @Transient
    @FieldMeta(description = "所属区域",index =6, editTagType = TagType.NONE,isImport = false)
    private String qyName="";

    @FieldMeta(description = "变电容量", index = 7)
    private String bdrl="";

    @FieldMeta(description = "额定电压", index = 8)
    private String eddy="";

    @NotBlank(message ="必填项" )
    @FieldMeta(description = "调压方式", index = 9)
    private String tsfs="";

    @NotBlank(message ="必填项" )
    @FieldMeta(description = "铭牌变比", index = 10)
    private String mpbb="";

    @FieldMeta(description = "绕阻形式", index = 11)
    private String rzxs="";

    @NotBlank(message ="必填项" )
    @FieldMeta(description = "铭牌型号", index = 12)
    private String mpxh="";

    @NotBlank(message ="必填项" )
    @FieldMeta(description = "投运时间", index = 13)
    private String btysj="";

    @FieldMeta(description = "退役时间", index = 14)
    private String etysj="";

    @NotBlank(message ="必填项" )
    @FieldMeta(description = "状态", index = 15)
    private String zt="";

    @FieldMeta(description = "备注", index = 16)
    private String remark="";

    @FieldMeta(description = "无功补偿容量", index = 17)
    private float wgbcrl;

    @FieldMeta(description = "无功补偿构成", index = 18)
    private String wgbcgc="";

    @FieldMeta(description = "无功补偿度", index = 19)
    private float wgbcd;

    @FieldMeta(description = "高-中阻抗", index = 20)
    private float gzzk;

    @FieldMeta(description = "中-低阻抗", index = 21)
    private float zdzk;

    @FieldMeta(description = "高-低阻抗", index = 22)
    private float gdzk;

    @FieldMeta(description = "高-中损耗", index = 23)
    private float gzsh;

    @FieldMeta(description = "中-低损耗", index = 24)
    private float zdsh;

    @FieldMeta(description = "高-低损耗", index = 25)
    private float gdsh;

    @FieldMeta(description = "高-中电阻", index = 26)
    private float gzdz;

    @FieldMeta(description = "中-低电阻", index = 27)
    private float zddz;

    @FieldMeta(description = "高-低电阻", index = 28)
    private float gddz;

    @FieldMeta(description = "高-中电抗", index = 29)
    private float gzdk;

    @FieldMeta(description = "中-低电抗", index = 30)
    private float zddk;

    @FieldMeta(description = "高-低电抗", index = 31)
    private float gddk;

    public String getByqName()
    {
        return byqName;
    }

    public void setByqName(String byqName)
    {
        this.byqName = byqName;
    }

    public String getBdz()
    {
        return bdz;
    }

    public void setBdz(String bdz)
    {
        this.bdz = bdz;
    }

    public String getBdzName()
    {
        return bdzName;
    }

    public void setBdzName(String bdzName)
    {
        this.bdzName = bdzName;
    }

    public String getSyfs()
    {
        return syfs;
    }

    public void setSyfs(String syfs)
    {
        this.syfs = syfs;
    }

    public String getDydj()
    {
        return dydj;
    }

    public void setDydj(String dydj)
    {
        this.dydj = dydj;
    }

    public String getGqlx()
    {
        return gqlx;
    }

    public void setGqlx(String gqlx)
    {
        this.gqlx = gqlx;
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

    public String getBdrl()
    {
        return bdrl;
    }

    public void setBdrl(String bdrl)
    {
        this.bdrl = bdrl;
    }

    public String getEddy()
    {
        return eddy;
    }

    public void setEddy(String eddy)
    {
        this.eddy = eddy;
    }

    public String getTsfs()
    {
        return tsfs;
    }

    public void setTsfs(String tsfs)
    {
        this.tsfs = tsfs;
    }

    public String getMpbb()
    {
        return mpbb;
    }

    public void setMpbb(String mpbb)
    {
        this.mpbb = mpbb;
    }

    public String getRzxs()
    {
        return rzxs;
    }

    public void setRzxs(String rzxs)
    {
        this.rzxs = rzxs;
    }

    public String getMpxh()
    {
        return mpxh;
    }

    public void setMpxh(String mpxh)
    {
        this.mpxh = mpxh;
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

    public String getZt()
    {
        return zt;
    }

    public void setZt(String zt)
    {
        this.zt = zt;
    }

    public String getRemark()
    {
        return remark;
    }

    public void setRemark(String remark)
    {
        this.remark = remark;
    }

    public float getWgbcrl()
    {
        return wgbcrl;
    }

    public void setWgbcrl(float wgbcrl)
    {
        this.wgbcrl = wgbcrl;
    }

    public String getWgbcgc()
    {
        return wgbcgc;
    }

    public void setWgbcgc(String wgbcgc)
    {
        this.wgbcgc = wgbcgc;
    }

    public float getWgbcd()
    {
        return wgbcd;
    }

    public void setWgbcd(float wgbcd)
    {
        this.wgbcd = wgbcd;
    }

    public float getGzzk()
    {
        return gzzk;
    }

    public void setGzzk(float gzzk)
    {
        this.gzzk = gzzk;
    }

    public float getZdzk()
    {
        return zdzk;
    }

    public void setZdzk(float zdzk)
    {
        this.zdzk = zdzk;
    }

    public float getGdzk()
    {
        return gdzk;
    }

    public void setGdzk(float gdzk)
    {
        this.gdzk = gdzk;
    }

    public float getGzsh()
    {
        return gzsh;
    }

    public void setGzsh(float gzsh)
    {
        this.gzsh = gzsh;
    }

    public float getZdsh()
    {
        return zdsh;
    }

    public void setZdsh(float zdsh)
    {
        this.zdsh = zdsh;
    }

    public float getGdsh()
    {
        return gdsh;
    }

    public void setGdsh(float gdsh)
    {
        this.gdsh = gdsh;
    }

    public float getGzdz()
    {
        return gzdz;
    }

    public void setGzdz(float gzdz)
    {
        this.gzdz = gzdz;
    }

    public float getZddz()
    {
        return zddz;
    }

    public void setZddz(float zddz)
    {
        this.zddz = zddz;
    }

    public float getGddz()
    {
        return gddz;
    }

    public void setGddz(float gddz)
    {
        this.gddz = gddz;
    }

    public float getGzdk()
    {
        return gzdk;
    }

    public void setGzdk(float gzdk)
    {
        this.gzdk = gzdk;
    }

    public float getZddk()
    {
        return zddk;
    }

    public void setZddk(float zddk)
    {
        this.zddk = zddk;
    }

    public float getGddk()
    {
        return gddk;
    }

    public void setGddk(float gddk)
    {
        this.gddk = gddk;
    }
}
