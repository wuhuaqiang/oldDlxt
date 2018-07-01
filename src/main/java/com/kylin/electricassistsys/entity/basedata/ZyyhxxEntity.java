package com.kylin.electricassistsys.entity.basedata;


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
import javax.validation.constraints.Digits;

/**
 * 重要用户信息
 */
@NameStyle(Style.normal)
@Table(name="Zyyhxx")
public class ZyyhxxEntity extends BaseEntity
{
    @NotBlank(message ="必填项" )
    @Length(max = 20,message = "20位以内字符")
    @FieldMeta(description = "用户名称",index = 1)
    private String yhmc="";

    @NotBlank(message ="必填项" )
    @Length(max = 20,message = "20位以内字符")
    @FieldMeta(description = "项目名称",queryField = true,index = 2)
    private String xmmc="";

    @NotBlank(message ="必填项" )
    @FieldMeta(description = "所属区域", index = 3, show = false, editTagType = TagType.SELECT, keyValueType = KeyValueType.QY,isExport = false)
    private String qyId="";

    @Transient
    @FieldMeta(description = "所属区域",index =3, editTagType = TagType.NONE, isImport = false)
    private String qyName="";

    @NotBlank(message ="必填项" )
    @FieldMeta(description = "电压等级", index = 4, editTagType = TagType.SELECT, keyValueType = KeyValueType.VOLTAGE)
    private String dydj="";

    @NotBlank(message ="必填项" )
    @FieldMeta(description = "项目性质", index = 5, editTagType = TagType.SELECT, keyValueType = KeyValueType.XMXZ)
    private String xmxz="";

    @NotBlank(message ="必填项" )
    @FieldMeta(description = "所属变电站",index = 6, show = false, editTagType = TagType.SELECT, keyValueType = KeyValueType.BDZ,isExport = false)
    private String bdz="";

    @Transient
    @FieldMeta(description = "所属变电站",index = 6, editTagType = TagType.NONE, isImport = false)
    private String bdzName="";

    @Digits(integer = 6, fraction = 2,message = "8位有效数字的小数")
    @FieldMeta(description = "占地面积",index = 7)
    private float zdmj;

    @Digits(integer = 6, fraction = 2,message = "8位有效数字的小数")
    @FieldMeta(description = "建筑面积",index = 8)
    private float jzmj;

    @Digits(integer = 8, fraction = 0,message = "8位以内整数")
    @FieldMeta(description = "户数",index = 9)
    private int hs;

    @Digits(integer = 6, fraction = 2,message = "8位有效数字的小数")
    @FieldMeta(description = "年最大负荷",index = 10)
    private float zdfh;

    @Digits(integer = 6, fraction = 2,message = "8位有效数字的小数")
    @FieldMeta(description = "年用电量",index = 11)
    private float nydl;

    @FieldMeta(description = "申请用电时间",index = 12)
    private String sqydsj="";

    @FieldMeta(description = "通电时间",index = 12)
    private String tdsj="";

    @FieldMeta(description = "退运时间",index = 14)
    private String tysj="";

    @FieldMeta(description = "主供线路",index = 15)
    private String zgxl="";

    @Digits(integer = 6, fraction = 2,message = "8位有效数字的小数")
    @FieldMeta(description = "主供容量",index = 16)
    private float zgrl;

    @FieldMeta(description = "备用线路",index = 17)
    private String byxl="";

    @Digits(integer = 6, fraction = 2,message = "8位有效数字的小数")
    @FieldMeta(description = "备用容量",index = 18)
    private float byrl;

    @Digits(integer = 6, fraction = 2,message = "8位有效数字的小数")
    @FieldMeta(description = "保安容量",index = 19)
    private float barl;

    @FieldMeta(description = "配电室",index = 20)
    private String pds="";

    @FieldMeta(description = "开关站/环网柜",index = 21)
    private String hwg="";

    @FieldMeta(description = "项目地址",index = 22)
    private String xmdz="";

    @FieldMeta(description = "备注",index = 23, editTagType = TagType.TEXTAREA)
    private String remark="";

    public String getYhmc()
    {
        return yhmc;
    }

    public void setYhmc(String yhmc)
    {
        this.yhmc = yhmc;
    }

    public String getXmmc()
    {
        return xmmc;
    }

    public void setXmmc(String xmmc)
    {
        this.xmmc = xmmc;
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

    public String getDydj()
    {
        return dydj;
    }

    public void setDydj(String dydj)
    {
        this.dydj = dydj;
    }

    public String getXmxz()
    {
        return xmxz;
    }

    public void setXmxz(String xmxz)
    {
        this.xmxz = xmxz;
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

    public float getZdmj()
    {
        return zdmj;
    }

    public void setZdmj(float zdmj)
    {
        this.zdmj = zdmj;
    }

    public float getJzmj()
    {
        return jzmj;
    }

    public void setJzmj(float jzmj)
    {
        this.jzmj = jzmj;
    }

    public int getHs()
    {
        return hs;
    }

    public void setHs(int hs)
    {
        this.hs = hs;
    }

    public float getZdfh()
    {
        return zdfh;
    }

    public void setZdfh(float zdfh)
    {
        this.zdfh = zdfh;
    }

    public float getNydl()
    {
        return nydl;
    }

    public void setNydl(float nydl)
    {
        this.nydl = nydl;
    }

    public String getSqydsj()
    {
        return sqydsj;
    }

    public void setSqydsj(String sqydsj)
    {
        this.sqydsj = sqydsj;
    }

    public String getTdsj()
    {
        return tdsj;
    }

    public void setTdsj(String tdsj)
    {
        this.tdsj = tdsj;
    }

    public String getTysj()
    {
        return tysj;
    }

    public void setTysj(String tysj)
    {
        this.tysj = tysj;
    }

    public String getZgxl()
    {
        return zgxl;
    }

    public void setZgxl(String zgxl)
    {
        this.zgxl = zgxl;
    }

    public float getZgrl()
    {
        return zgrl;
    }

    public void setZgrl(float zgrl)
    {
        this.zgrl = zgrl;
    }

    public String getByxl()
    {
        return byxl;
    }

    public void setByxl(String byxl)
    {
        this.byxl = byxl;
    }

    public float getByrl()
    {
        return byrl;
    }

    public void setByrl(float byrl)
    {
        this.byrl = byrl;
    }

    public float getBarl()
    {
        return barl;
    }

    public void setBarl(float barl)
    {
        this.barl = barl;
    }

    public String getPds()
    {
        return pds;
    }

    public void setPds(String pds)
    {
        this.pds = pds;
    }

    public String getHwg()
    {
        return hwg;
    }

    public void setHwg(String hwg)
    {
        this.hwg = hwg;
    }

    public String getXmdz()
    {
        return xmdz;
    }

    public void setXmdz(String xmdz)
    {
        this.xmdz = xmdz;
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
