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
 * 变电站信息
 */
@NameStyle(Style.normal)
@Table(name="Bdzxx")
public class BdzxxEntity extends BaseEntity
{
    @NotBlank(message ="必填项" )
    @Length(max = 20,message = "20位以内字符")
    @FieldMeta(description = "变电站名称",queryField = true, index = 1)
    private String bdzName="";

    @NotBlank(message ="必填项" )
    @FieldMeta(description = "电压等级", index = 2, queryField = true,  editTagType = TagType.SELECT,keyValueType = KeyValueType.VOLTAGE)
    private String dydj="";

    @NotBlank(message ="必填项" )
    @FieldMeta(description = "供区类型", queryField = true,index = 3,editTagType = TagType.SELECT, keyValueType = KeyValueType.SUPPLY_ZONE_TYPE)
    private String gqlx="";

    @NotBlank(message ="必填项" )
    @FieldMeta(description = "所属区域", queryField = true,index = 4, show = false, isExport = false, editTagType = TagType.SELECT, keyValueType = KeyValueType.QY)
    private String qyId="";

    @Transient
    @FieldMeta(description = "所属区域",index =4, editTagType = TagType.NONE, isImport = false)
    private String qyName="";

    @NotBlank(message ="必填项" )
    @FieldMeta(description = "供电区属性", index = 5)
    private String gdqsx="";

    @NotBlank(message ="必填项" )
    @FieldMeta(description = "供电性质", index = 6)
    private String gdxz="";

    @NotBlank(message ="必填项" )
    @FieldMeta(description = "运维单位", index = 7,show=false, isExport = false)
    private String ywdw="";

    @Transient
    @FieldMeta(description = "运维单位", index = 7, isImport = false)
    private String ywdwName="";

    @NotBlank(message ="必填项" )
    @FieldMeta(description = "使用方式", index = 8,editTagType = TagType.SELECT, keyValueType = KeyValueType.SYFS)
    private String syfs="";

    @NotBlank(message ="必填项" )
    @FieldMeta(description = "城农网", index = 9)
    private String cnw="";

    @NotBlank(message ="必填项" )
    @FieldMeta(description = "安装形式", index = 10)
    private String azxs="";

    @NotBlank(message ="必填项" )
    @FieldMeta(description = "高压配电装置类型", index = 11)
    private String gypdzzlx="";

    @FieldMeta(description = "占地面积(公顷)", index = 12)
    private double zdmj;

    @NotBlank(message ="必填项" )
    @FieldMeta(description = "投运时间", index = 13)
    private String btysj="";

    @FieldMeta(description = "退役时间", index = 14)
    private String etysj="";

    @NotBlank(message ="必填项" )
    @FieldMeta(description = "运行状态",index = 15)
    private String yxzt="";

    @FieldMeta(description = "变电站地址", index = 16)
    private String address="";

    @FieldMeta(description = "经度", index = 17)
    private String jd="";

    @FieldMeta(description = "纬度", index = 18)
    private String wd="";

    @FieldMeta(description = "接线图纸",show =  false, isExport = false,isImport = false,index = 19)
    private String jxtz = "";

    @FieldMeta(description = "变压器数量(台)", index = 20)
    private int byqsl;

    @FieldMeta(description = "主变总容量（MVA）", index = 21)
    private double zbzrl;

    @FieldMeta(description = "容量构成", index = 22)
    private String rlgc="";

    @FieldMeta(description = "无功补偿容量",show = false, isImport = false,isExport = false)
    private String wgbcrl="";

    @FieldMeta(description = "无功补偿构成",show = false, isImport = false,isExport = false)
    private String wgbcgc="";

    @FieldMeta(description = "无功补偿度",show = false, isImport = false,isExport = false)
    private String wgbcd="";

    @NotBlank(message ="必填项" )
    @FieldMeta(description = "满足N-1", index = 23)
    private String n_1="";

    @NotBlank(message ="必填项" )
    @FieldMeta(description = "电网结构", index = 24)
    private String dwjg="";

    @FieldMeta(description = "断路器", index = 25)
    private int dlq;

    @FieldMeta(description = "备注", index = 26)
    private String remark="";

    @FieldMeta(description = "高压侧电压等级", index = 27)
    private String gycdydj="";

    @FieldMeta(description = "中压侧电压等级", index = 28)
    private String zycdydj="";

    @FieldMeta(description = "低压侧电压等级", index = 29)
    private String dycdydj="";


    @FieldMeta(description = "1#高压侧主接线", index = 30)
    private String gyczjx1="";

    @FieldMeta(description = "1#中压侧主接线", index = 31)
    private String zyczjx1="";

    @FieldMeta(description = "1#低压侧主接线", index = 32)
    private String dyczjx1="";

    @FieldMeta(description = "2#高压侧主接线", index = 33)
    private String gyczjx2="";

    @FieldMeta(description = "2#中压侧主接线", index = 34)
    private String zyczjx2="";

    @FieldMeta(description = "2#低压侧主接线", index = 35)
    private String dyczjx2="";

    @FieldMeta(description = "3#高压侧主接线", index = 36)
    private String gyczjx3="";

    @FieldMeta(description = "3#中压侧主接线", index = 37)
    private String zyczjx3="";

    @FieldMeta(description = "3#低压侧主接线", index = 38)
    private String dyczjx3="";

    @FieldMeta(description = "220kV出线间隔总数",show=false, isImport = false,isExport = false)
    private String cxjg220kv="";

    @FieldMeta(description = "110kV出线间隔总数",show=false, isImport = false,isExport = false)
    private String cxjg110kv="";

    @FieldMeta(description = "35kV出线间隔总数",show=false, isImport = false,isExport = false)
    private String cxjg35kv="";

    @FieldMeta(description = "10kV出线间隔总数",show=false, isImport = false,isExport = false)
    private String cxjg10kv="";

    @FieldMeta(description = "已用220kV出线间隔总数",show=false, isImport = false,isExport = false)
    private String yy220kv="";

    @FieldMeta(description = "已用110kV出线间隔总数",show=false, isImport = false,isExport = false)
    private String yy110kv="";

    @FieldMeta(description = "已用110kV出线间隔总数",show=false, isImport = false,isExport = false)
    private String yy35kv="";

    @FieldMeta(description = "已用10kV出线间隔总数",show=false, isImport = false,isExport = false)
    private String yy10kv="";

    @FieldMeta(description = "终期间隔个数",show=false, isImport = false,isExport = false)
    private String zqjggs="";

    public String getBdzName()
    {
        return bdzName;
    }

    public void setBdzName(String bdzName)
    {
        this.bdzName = bdzName;
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

    public String getGdqsx()
    {
        return gdqsx;
    }

    public void setGdqsx(String gdqsx)
    {
        this.gdqsx = gdqsx;
    }

    public String getGdxz()
    {
        return gdxz;
    }

    public void setGdxz(String gdxz)
    {
        this.gdxz = gdxz;
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

    public String getSyfs()
    {
        return syfs;
    }

    public void setSyfs(String syfs)
    {
        this.syfs = syfs;
    }

    public String getCnw()
    {
        return cnw;
    }

    public void setCnw(String cnw)
    {
        this.cnw = cnw;
    }

    public String getAzxs()
    {
        return azxs;
    }

    public void setAzxs(String azxs)
    {
        this.azxs = azxs;
    }

    public String getGypdzzlx()
    {
        return gypdzzlx;
    }

    public void setGypdzzlx(String gypdzzlx)
    {
        this.gypdzzlx = gypdzzlx;
    }

    public double getZdmj()
    {
        return zdmj;
    }

    public void setZdmj(double zdmj)
    {
        this.zdmj = zdmj;
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

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getJd()
    {
        return jd;
    }

    public void setJd(String jd)
    {
        this.jd = jd;
    }

    public String getWd()
    {
        return wd;
    }

    public void setWd(String wd)
    {
        this.wd = wd;
    }

    public String getJxtz()
    {
        return jxtz;
    }

    public void setJxtz(String jxtz)
    {
        this.jxtz = jxtz;
    }

    public int getByqsl()
    {
        return byqsl;
    }

    public void setByqsl(int byqsl)
    {
        this.byqsl = byqsl;
    }

    public double getZbzrl()
    {
        return zbzrl;
    }

    public void setZbzrl(double zbzrl)
    {
        this.zbzrl = zbzrl;
    }

    public String getRlgc()
    {
        return rlgc;
    }

    public void setRlgc(String rlgc)
    {
        this.rlgc = rlgc;
    }

    public String getWgbcrl()
    {
        return wgbcrl;
    }

    public void setWgbcrl(String wgbcrl)
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

    public String getWgbcd()
    {
        return wgbcd;
    }

    public void setWgbcd(String wgbcd)
    {
        this.wgbcd = wgbcd;
    }

    public String getN_1()
    {
        return n_1;
    }

    public void setN_1(String n_1)
    {
        this.n_1 = n_1;
    }

    public String getDwjg()
    {
        return dwjg;
    }

    public void setDwjg(String dwjg)
    {
        this.dwjg = dwjg;
    }

    public int getDlq()
    {
        return dlq;
    }

    public void setDlq(int dlq)
    {
        this.dlq = dlq;
    }

    public String getRemark()
    {
        return remark;
    }

    public void setRemark(String remark)
    {
        this.remark = remark;
    }

    public String getGyczjx1()
    {
        return gyczjx1;
    }

    public void setGyczjx1(String gyczjx1)
    {
        this.gyczjx1 = gyczjx1;
    }

    public String getZyczjx1()
    {
        return zyczjx1;
    }

    public void setZyczjx1(String zyczjx1)
    {
        this.zyczjx1 = zyczjx1;
    }

    public String getDyczjx1()
    {
        return dyczjx1;
    }

    public void setDyczjx1(String dyczjx1)
    {
        this.dyczjx1 = dyczjx1;
    }

    public String getGyczjx2()
    {
        return gyczjx2;
    }

    public void setGyczjx2(String gyczjx2)
    {
        this.gyczjx2 = gyczjx2;
    }

    public String getZyczjx2()
    {
        return zyczjx2;
    }

    public void setZyczjx2(String zyczjx2)
    {
        this.zyczjx2 = zyczjx2;
    }

    public String getDyczjx2()
    {
        return dyczjx2;
    }

    public void setDyczjx2(String dyczjx2)
    {
        this.dyczjx2 = dyczjx2;
    }

    public String getGyczjx3()
    {
        return gyczjx3;
    }

    public void setGyczjx3(String gyczjx3)
    {
        this.gyczjx3 = gyczjx3;
    }

    public String getZyczjx3()
    {
        return zyczjx3;
    }

    public void setZyczjx3(String zyczjx3)
    {
        this.zyczjx3 = zyczjx3;
    }

    public String getDyczjx3()
    {
        return dyczjx3;
    }

    public void setDyczjx3(String dyczjx3)
    {
        this.dyczjx3 = dyczjx3;
    }

    public String getCxjg220kv()
    {
        return cxjg220kv;
    }

    public void setCxjg220kv(String cxjg220kv)
    {
        this.cxjg220kv = cxjg220kv;
    }

    public String getCxjg110kv()
    {
        return cxjg110kv;
    }

    public void setCxjg110kv(String cxjg110kv)
    {
        this.cxjg110kv = cxjg110kv;
    }

    public String getCxjg35kv()
    {
        return cxjg35kv;
    }

    public void setCxjg35kv(String cxjg35kv)
    {
        this.cxjg35kv = cxjg35kv;
    }

    public String getCxjg10kv()
    {
        return cxjg10kv;
    }

    public void setCxjg10kv(String cxjg10kv)
    {
        this.cxjg10kv = cxjg10kv;
    }

    public String getYy220kv()
    {
        return yy220kv;
    }

    public void setYy220kv(String yy220kv)
    {
        this.yy220kv = yy220kv;
    }

    public String getYy110kv()
    {
        return yy110kv;
    }

    public void setYy110kv(String yy110kv)
    {
        this.yy110kv = yy110kv;
    }

    public String getYy35kv()
    {
        return yy35kv;
    }

    public void setYy35kv(String yy35kv)
    {
        this.yy35kv = yy35kv;
    }

    public String getYy10kv()
    {
        return yy10kv;
    }

    public void setYy10kv(String yy10kv)
    {
        this.yy10kv = yy10kv;
    }

    public String getGycdydj()
    {
        return gycdydj;
    }

    public void setGycdydj(String gycdydj)
    {
        this.gycdydj = gycdydj;
    }

    public String getZycdydj()
    {
        return zycdydj;
    }

    public void setZycdydj(String zycdydj)
    {
        this.zycdydj = zycdydj;
    }

    public String getDycdydj()
    {
        return dycdydj;
    }

    public void setDycdydj(String dycdydj)
    {
        this.dycdydj = dycdydj;
    }

    public String getZqjggs()
    {
        return zqjggs;
    }

    public void setZqjggs(String zqjggs)
    {
        this.zqjggs = zqjggs;
    }
}
