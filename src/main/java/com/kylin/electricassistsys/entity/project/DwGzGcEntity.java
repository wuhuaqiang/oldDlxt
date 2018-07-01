package com.kylin.electricassistsys.entity.project;


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

@NameStyle(Style.normal)
@Table(name="Xmqc")
public class DwGzGcEntity extends BaseEntity
{
    @NotBlank(message ="必填项" )
    @Length(max = 20,message = "20位以内字符")
    @FieldMeta(description = "项目名称", index = 1,queryField = true, editTagType = TagType.INPUT_TEXT)
    private String xmmc = "";

    @NotBlank(message ="必填项" )
    @FieldMeta(description = "运维单位", index = 2, show = false, isExport = false,editTagType = TagType.SELECT, keyValueType = KeyValueType.GDGS)
    private String ywdwId = "";

    @Transient
    @FieldMeta(description = "运维单位", index = 2, editTagType = TagType.NONE,isImport = false)
    private String ywdwName = "";

    @NotBlank(message ="必填项" )
    @FieldMeta(description = "所属区域", index = 3, show = false, isExport = false, editTagType = TagType.SELECT, keyValueType = KeyValueType.QY)
    private String qyId = "";

    @Transient
    @FieldMeta(description = "所属区域", index = 3, editTagType = TagType.NONE,isImport = false)
    private String qyName = "";

    @NotBlank(message ="必填项" )
    @FieldMeta(description = "规划年份", index = 4)
    private String ghnf = "";

    @NotBlank(message ="必填项" )
    @FieldMeta(description = "供区类型", index = 5,queryField = true,  editTagType = TagType.SELECT,keyValueType = KeyValueType.SUPPLY_ZONE_TYPE)
    private String gqlx = "";

    @NotBlank(message ="必填项" )
    @FieldMeta(description = "电压等级", index = 6, queryField = true, editTagType = TagType.SELECT, keyValueType = KeyValueType.VOLTAGE)
    private String voltage = "";

    @NotBlank(message ="必填项" )
    @FieldMeta(description = "城农网", index = 7, editTagType = TagType.SELECT, keyValueType = KeyValueType.CNW)
    private String cnw = "";

    @FieldMeta(description = "资产属性", index = 8)
    private String zcsx= "";

    @FieldMeta(description = "总投资(万元)", index = 9)
    private float xmtz;

    @FieldMeta(description = "农网建设性质1", index = 10)
    private String nwjsxz1= "";

    @FieldMeta(description = "农网建设性质2", index = 11)
    private String nwjsxz2= "";

    @FieldMeta(description = "农网建设性质3", index = 12)
    private String nwjsxz3= "";

    @FieldMeta(description = "工程性质", index = 13)
    private String gcxz = "";

    @FieldMeta(description = "改造总台数(台)", index = 14)
    private int gzzts;

    @FieldMeta(description = "改造前总容量(KVar)", index = 15)
    private float gzqzrl;

    @FieldMeta(description = "改造后总容量(KVar)", index = 16)
    private float gzhzrl;

    @FieldMeta(description = "其中:改造高损台数(台)", index = 17)
    private int gzgsts;

    @FieldMeta(description = "其中:改造高损容量(KVar)", index = 18)
    private float gzgsrl;

    @FieldMeta(description = "配变投资(万元)", index = 19)
    private float pbtz;

    @FieldMeta(description = "其中:更换非晶台数(台)", index = 20)
    private int fjts;

    @FieldMeta(description = "其中:更换非晶容量(KVar)", index = 21)
    private float fjrl;

    @FieldMeta(description = "无功补偿-组数(组)", index = 22)
    private int wgzs;

    @FieldMeta(description = "无功补偿-总容量(KVar)", index = 23)
    private float wgzrl;

    @FieldMeta(description = "无功补偿-投资(万元)", index = 24)
    private float wgtz;

    @FieldMeta(description = "断路器(台)", index = 25)
    private int dlq;

    @FieldMeta(description = "负荷开关(台)", index = 26)
    private int fhkg;

    @FieldMeta(description = "环网柜(座)", index = 27)
    private int hwg;

    @FieldMeta(description = "电缆分支箱(座)", index = 28)
    private int dlfzx;

    @FieldMeta(description = "开关投资(万元)", index = 29)
    private float kgtz;

    @FieldMeta(description = "架空线路条数(条)", index = 30)
    private int jkxlts;

    @FieldMeta(description = "架空线路长度(km)", index = 31)
    private float jkxlcd;

    @FieldMeta(description = "绝缘导线长度(km)", index = 32)
    private float jydxcd;

    @FieldMeta(description = "架空线路投资(万元)", index = 33)
    private float jkxltz;

    @FieldMeta(description = "电缆条数(条)", index = 34)
    private int dlts;

    @FieldMeta(description = "电缆线路长度(km)", index = 35)
    private float dlxlcd;

    @FieldMeta(description = "沟道长度(km)", index = 36)
    private float gdcd;

    @FieldMeta(description = "电缆投资(万元)", index = 37)
    private float dlxltz;

    @FieldMeta(description = "户表(户)", index = 38)
    private int hb;

    @FieldMeta(description = "接户线(km)", index = 39)
    private float jhx;

    @FieldMeta(description = "户表投资(万元)", index = 40)
    private float hbtz;


    @FieldMeta(description = "中央计划(%)", index = 41)
    private float zyjh;

    @FieldMeta(description = "公司自筹(%)", index = 42)
    private float gszc;

    @FieldMeta(description = "县级供电企业自筹(%)", index = 43)
    private float xjgdqyzc;

    @FieldMeta(description = "用户投资(%)", index = 44)
    private float yhtz;

    @FieldMeta(description = "小区配套费(%)", index = 45)
    private float xqptf;

    @FieldMeta(description = "政府垫资(%)", index = 46)
    private float zfdz;

    @FieldMeta(description = "其他投资(%)", index = 47)
    private float qttz;

    @FieldMeta(description = "類型",show =false,index = 48,isExport = false, isImport = false)
    private int type;

    public int getType()
    {
        return type;
    }

    public void setType(int type)
    {
        this.type = type;
    }

    public String getXmmc()
    {
        return xmmc;
    }

    public void setXmmc(String xmmc)
    {
        this.xmmc = xmmc;
    }

    public String getYwdwId()
    {
        return ywdwId;
    }

    public void setYwdwId(String ywdwId)
    {
        this.ywdwId = ywdwId;
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

    public String getGhnf()
    {
        return ghnf;
    }

    public void setGhnf(String ghnf)
    {
        this.ghnf = ghnf;
    }

    public String getGqlx()
    {
        return gqlx;
    }

    public void setGqlx(String gqlx)
    {
        this.gqlx = gqlx;
    }

    public String getVoltage()
    {
        return voltage;
    }

    public void setVoltage(String voltage)
    {
        this.voltage = voltage;
    }

    public String getCnw()
    {
        return cnw;
    }

    public void setCnw(String cnw)
    {
        this.cnw = cnw;
    }

    public String getZcsx()
    {
        return zcsx;
    }

    public void setZcsx(String zcsx)
    {
        this.zcsx = zcsx;
    }

    public float getXmtz()
    {
        return xmtz;
    }

    public void setXmtz(float xmtz)
    {
        this.xmtz = xmtz;
    }

    public String getNwjsxz1()
    {
        return nwjsxz1;
    }

    public void setNwjsxz1(String nwjsxz1)
    {
        this.nwjsxz1 = nwjsxz1;
    }

    public String getNwjsxz2()
    {
        return nwjsxz2;
    }

    public void setNwjsxz2(String nwjsxz2)
    {
        this.nwjsxz2 = nwjsxz2;
    }

    public String getNwjsxz3()
    {
        return nwjsxz3;
    }

    public void setNwjsxz3(String nwjsxz3)
    {
        this.nwjsxz3 = nwjsxz3;
    }

    public String getGcxz()
    {
        return gcxz;
    }

    public void setGcxz(String gcxz)
    {
        this.gcxz = gcxz;
    }

    public int getGzzts()
    {
        return gzzts;
    }

    public void setGzzts(int gzzts)
    {
        this.gzzts = gzzts;
    }

    public float getGzqzrl()
    {
        return gzqzrl;
    }

    public void setGzqzrl(float gzqzrl)
    {
        this.gzqzrl = gzqzrl;
    }

    public float getGzhzrl()
    {
        return gzhzrl;
    }

    public void setGzhzrl(float gzhzrl)
    {
        this.gzhzrl = gzhzrl;
    }

    public int getGzgsts()
    {
        return gzgsts;
    }

    public void setGzgsts(int gzgsts)
    {
        this.gzgsts = gzgsts;
    }

    public float getGzgsrl()
    {
        return gzgsrl;
    }

    public void setGzgsrl(float gzgsrl)
    {
        this.gzgsrl = gzgsrl;
    }

    public float getPbtz()
    {
        return pbtz;
    }

    public void setPbtz(float pbtz)
    {
        this.pbtz = pbtz;
    }

    public int getFjts()
    {
        return fjts;
    }

    public void setFjts(int fjts)
    {
        this.fjts = fjts;
    }

    public float getFjrl()
    {
        return fjrl;
    }

    public void setFjrl(float fjrl)
    {
        this.fjrl = fjrl;
    }

    public int getWgzs()
    {
        return wgzs;
    }

    public void setWgzs(int wgzs)
    {
        this.wgzs = wgzs;
    }

    public float getWgzrl()
    {
        return wgzrl;
    }

    public void setWgzrl(float wgzrl)
    {
        this.wgzrl = wgzrl;
    }

    public float getWgtz()
    {
        return wgtz;
    }

    public void setWgtz(float wgtz)
    {
        this.wgtz = wgtz;
    }

    public int getDlq()
    {
        return dlq;
    }

    public void setDlq(int dlq)
    {
        this.dlq = dlq;
    }

    public int getFhkg()
    {
        return fhkg;
    }

    public void setFhkg(int fhkg)
    {
        this.fhkg = fhkg;
    }

    public int getHwg()
    {
        return hwg;
    }

    public void setHwg(int hwg)
    {
        this.hwg = hwg;
    }

    public int getDlfzx()
    {
        return dlfzx;
    }

    public void setDlfzx(int dlfzx)
    {
        this.dlfzx = dlfzx;
    }

    public float getKgtz()
    {
        return kgtz;
    }

    public void setKgtz(float kgtz)
    {
        this.kgtz = kgtz;
    }

    public int getJkxlts()
    {
        return jkxlts;
    }

    public void setJkxlts(int jkxlts)
    {
        this.jkxlts = jkxlts;
    }

    public float getJkxlcd()
    {
        return jkxlcd;
    }

    public void setJkxlcd(float jkxlcd)
    {
        this.jkxlcd = jkxlcd;
    }

    public float getJydxcd()
    {
        return jydxcd;
    }

    public void setJydxcd(float jydxcd)
    {
        this.jydxcd = jydxcd;
    }

    public float getJkxltz()
    {
        return jkxltz;
    }

    public void setJkxltz(float jkxltz)
    {
        this.jkxltz = jkxltz;
    }

    public int getDlts()
    {
        return dlts;
    }

    public void setDlts(int dlts)
    {
        this.dlts = dlts;
    }

    public float getDlxlcd()
    {
        return dlxlcd;
    }

    public void setDlxlcd(float dlxlcd)
    {
        this.dlxlcd = dlxlcd;
    }

    public float getGdcd()
    {
        return gdcd;
    }

    public void setGdcd(float gdcd)
    {
        this.gdcd = gdcd;
    }

    public float getDlxltz()
    {
        return dlxltz;
    }

    public void setDlxltz(float dlxltz)
    {
        this.dlxltz = dlxltz;
    }

    public int getHb()
    {
        return hb;
    }

    public void setHb(int hb)
    {
        this.hb = hb;
    }

    public float getJhx()
    {
        return jhx;
    }

    public void setJhx(float jhx)
    {
        this.jhx = jhx;
    }

    public float getHbtz()
    {
        return hbtz;
    }

    public void setHbtz(float hbtz)
    {
        this.hbtz = hbtz;
    }

    public float getZyjh()
    {
        return zyjh;
    }

    public void setZyjh(float zyjh)
    {
        this.zyjh = zyjh;
    }

    public float getGszc()
    {
        return gszc;
    }

    public void setGszc(float gszc)
    {
        this.gszc = gszc;
    }

    public float getXjgdqyzc()
    {
        return xjgdqyzc;
    }

    public void setXjgdqyzc(float xjgdqyzc)
    {
        this.xjgdqyzc = xjgdqyzc;
    }

    public float getYhtz()
    {
        return yhtz;
    }

    public void setYhtz(float yhtz)
    {
        this.yhtz = yhtz;
    }

    public float getXqptf()
    {
        return xqptf;
    }

    public void setXqptf(float xqptf)
    {
        this.xqptf = xqptf;
    }

    public float getZfdz()
    {
        return zfdz;
    }

    public void setZfdz(float zfdz)
    {
        this.zfdz = zfdz;
    }

    public float getQttz()
    {
        return qttz;
    }

    public void setQttz(float qttz)
    {
        this.qttz = qttz;
    }
}
