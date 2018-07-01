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
public class DwXjGcEntity extends BaseEntity
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
    @FieldMeta(description = "所属区域", index = 3, show = false, isExport = false,editTagType = TagType.SELECT, keyValueType = KeyValueType.QY)
    private String qyId = "";

    @Transient
    @FieldMeta(description = "所属区域", index = 3, isImport = false,editTagType = TagType.NONE)
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
    private String zcsx="";

    @FieldMeta(description = "总投资(万元)", index = 9)
    private float xmtz;

    @FieldMeta(description = "农网建设性质1", index = 10)
    private String nwjsxz1="";

    @FieldMeta(description = "农网建设性质2", index = 11)
    private String nwjsxz2="";

    @FieldMeta(description = "农网建设性质3", index = 12)
    private String nwjsxz3="";

    @FieldMeta(description = "工程性质", index = 13)
    private String gcxz = "";

    @FieldMeta(description = "中压线路-架空长度(km)", index = 14)
    private float zyxljkcd;

    @FieldMeta(description = "中压线路-电缆长度(km)", index = 15)
    private float zyxldlcd;

    @FieldMeta(description = "中压线路-供电半径(km)", index = 16)
    private float zyxlgdbj;

    @FieldMeta(description = "中压线路-无功补偿容量(KVar)", index = 17)
    private float zyxlwgbcrl;

    @FieldMeta(description = "中压线路-投资(万元)", index = 18)
    private float zyxltz;

    @FieldMeta(description = "中压开关-开闭所(座)", index = 19)
    private int zykgkbs;

    @FieldMeta(description = "中压开关-电缆分支箱(座)", index = 20)
    private int zykgdlfzx;

    @FieldMeta(description = "中压开关-投资", index = 21)
    private float zykgtz;

    @FieldMeta(description = "中压开关-环网柜总数(座)", index = 22)
    private int zykghwgzs;

    @FieldMeta(description = "中压开关-分段环网柜(座)", index = 23)
    private int zykghwgfd;

    @FieldMeta(description = "中压开关-联络环网柜(座)", index = 24)
    private int zykghwgll;

    @FieldMeta(description = "中压开关-柱上开关总数(座)", index = 13)
    private int zykgzskgzs;

    @FieldMeta(description = "中压开关-分段柱上开关(座)", index = 25)
    private int zykgzskgfd;

    @FieldMeta(description = "中压开关-联络柱上开关(座)", index = 26)
    private int zykgzskgll;

    @FieldMeta(description = "中压配变-无功补偿容量(KVar)", index = 27)
    private float zypbwgbcrl;

    @FieldMeta(description = "中压配变-投资(万元)", index = 28)
    private float zypbtz;

    @FieldMeta(description = "中压配变-柱上变台数(台)", index = 29)
    private int zypbzsbts;

    @FieldMeta(description = "中压配变-柱上变容量(KVA)", index = 30)
    private float zypbzsbrl;

    @FieldMeta(description = "中压配变-非晶合金台数(台)", index = 31)
    private int zypbfjhjpbts;

    @FieldMeta(description = "中压配变-非晶合金容量(KVA)", index = 32)
    private float zypbfjhjpbrl;

    @FieldMeta(description = "中压配变-配电室座数(座)", index = 33)
    private int zypbpdszs;

    @FieldMeta(description = "中压配变-配电室台数(台)", index = 34)
    private int zypbpdsts;

    @FieldMeta(description = "中压配变-配电室容量(KVA)", index = 35)
    private float zypbpdsrl;

    @FieldMeta(description = "中压配变-箱变座数(座)", index = 36)
    private int zypbxbzs;

    @FieldMeta(description = "中压配变-箱变台数(台)", index = 37)
    private int zypbxbts;

    @FieldMeta(description = "中压配变-箱变容量(KVA)", index = 38)
    private float zypbxbrl;

    @FieldMeta(description = "低压网配套-架空线路条数(条)", index = 39)
    private int jkxlts;

    @FieldMeta(description = "低压网配套-架空线路长度(km)", index = 40)
    private float jkxlcd;

    @FieldMeta(description = "低压网配套-架空线路投资(万元)", index = 41)
    private float jkxltz;

    @FieldMeta(description = "低压网配套-电缆条数(条)", index = 42)
    private int dlts;

    @FieldMeta(description = "低压网配套-电缆长度(km)", index = 43)
    private float dlcd;

    @FieldMeta(description = "低压网配套-电缆投资(万元)", index = 44)
    private float dltz;

    @FieldMeta(description = "户表(户)", index = 45)
    private int hb;

    @FieldMeta(description = "接户线(km)", index = 46)
    private float jhx;

    @FieldMeta(description = "户表投资(万元)", index = 47)
    private float hbtz;

    @FieldMeta(description = "中央计划(%)", index = 48)
    private float zyjh;

    @FieldMeta(description = "公司自筹(%)", index = 49)
    private float gszc;

    @FieldMeta(description = "县级供电企业自筹(%)", index = 50)
    private float xjgdqyzc;

    @FieldMeta(description = "用户投资(%)", index = 51)
    private float yhtz;

    @FieldMeta(description = "小区配套费(%)", index = 52)
    private float xqptf;

    @FieldMeta(description = "政府垫资(%)", index = 53)
    private float zfdz;

    @FieldMeta(description = "其他投资(%)", index = 54)
    private float qttz;

    @FieldMeta(description = "類型",show =false,index = 55,isExport = false, isImport = false)
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

    public float getZyxljkcd()
    {
        return zyxljkcd;
    }

    public void setZyxljkcd(float zyxljkcd)
    {
        this.zyxljkcd = zyxljkcd;
    }

    public float getZyxldlcd()
    {
        return zyxldlcd;
    }

    public void setZyxldlcd(float zyxldlcd)
    {
        this.zyxldlcd = zyxldlcd;
    }

    public float getZyxlgdbj()
    {
        return zyxlgdbj;
    }

    public void setZyxlgdbj(float zyxlgdbj)
    {
        this.zyxlgdbj = zyxlgdbj;
    }

    public float getZyxlwgbcrl()
    {
        return zyxlwgbcrl;
    }

    public void setZyxlwgbcrl(float zyxlwgbcrl)
    {
        this.zyxlwgbcrl = zyxlwgbcrl;
    }

    public float getZyxltz()
    {
        return zyxltz;
    }

    public void setZyxltz(float zyxltz)
    {
        this.zyxltz = zyxltz;
    }

    public int getZykgkbs()
    {
        return zykgkbs;
    }

    public void setZykgkbs(int zykgkbs)
    {
        this.zykgkbs = zykgkbs;
    }

    public int getZykgdlfzx()
    {
        return zykgdlfzx;
    }

    public void setZykgdlfzx(int zykgdlfzx)
    {
        this.zykgdlfzx = zykgdlfzx;
    }

    public float getZykgtz()
    {
        return zykgtz;
    }

    public void setZykgtz(float zykgtz)
    {
        this.zykgtz = zykgtz;
    }

    public int getZykghwgzs()
    {
        return zykghwgzs;
    }

    public void setZykghwgzs(int zykghwgzs)
    {
        this.zykghwgzs = zykghwgzs;
    }

    public int getZykghwgfd()
    {
        return zykghwgfd;
    }

    public void setZykghwgfd(int zykghwgfd)
    {
        this.zykghwgfd = zykghwgfd;
    }

    public int getZykghwgll()
    {
        return zykghwgll;
    }

    public void setZykghwgll(int zykghwgll)
    {
        this.zykghwgll = zykghwgll;
    }

    public int getZykgzskgzs()
    {
        return zykgzskgzs;
    }

    public void setZykgzskgzs(int zykgzskgzs)
    {
        this.zykgzskgzs = zykgzskgzs;
    }

    public int getZykgzskgfd()
    {
        return zykgzskgfd;
    }

    public void setZykgzskgfd(int zykgzskgfd)
    {
        this.zykgzskgfd = zykgzskgfd;
    }

    public int getZykgzskgll()
    {
        return zykgzskgll;
    }

    public void setZykgzskgll(int zykgzskgll)
    {
        this.zykgzskgll = zykgzskgll;
    }

    public float getZypbwgbcrl()
    {
        return zypbwgbcrl;
    }

    public void setZypbwgbcrl(float zypbwgbcrl)
    {
        this.zypbwgbcrl = zypbwgbcrl;
    }

    public float getZypbtz()
    {
        return zypbtz;
    }

    public void setZypbtz(float zypbtz)
    {
        this.zypbtz = zypbtz;
    }

    public int getZypbzsbts()
    {
        return zypbzsbts;
    }

    public void setZypbzsbts(int zypbzsbts)
    {
        this.zypbzsbts = zypbzsbts;
    }

    public float getZypbzsbrl()
    {
        return zypbzsbrl;
    }

    public void setZypbzsbrl(float zypbzsbrl)
    {
        this.zypbzsbrl = zypbzsbrl;
    }

    public int getZypbfjhjpbts()
    {
        return zypbfjhjpbts;
    }

    public void setZypbfjhjpbts(int zypbfjhjpbts)
    {
        this.zypbfjhjpbts = zypbfjhjpbts;
    }

    public float getZypbfjhjpbrl()
    {
        return zypbfjhjpbrl;
    }

    public void setZypbfjhjpbrl(float zypbfjhjpbrl)
    {
        this.zypbfjhjpbrl = zypbfjhjpbrl;
    }

    public int getZypbpdszs()
    {
        return zypbpdszs;
    }

    public void setZypbpdszs(int zypbpdszs)
    {
        this.zypbpdszs = zypbpdszs;
    }

    public int getZypbpdsts()
    {
        return zypbpdsts;
    }

    public void setZypbpdsts(int zypbpdsts)
    {
        this.zypbpdsts = zypbpdsts;
    }

    public float getZypbpdsrl()
    {
        return zypbpdsrl;
    }

    public void setZypbpdsrl(float zypbpdsrl)
    {
        this.zypbpdsrl = zypbpdsrl;
    }

    public int getZypbxbzs()
    {
        return zypbxbzs;
    }

    public void setZypbxbzs(int zypbxbzs)
    {
        this.zypbxbzs = zypbxbzs;
    }

    public int getZypbxbts()
    {
        return zypbxbts;
    }

    public void setZypbxbts(int zypbxbts)
    {
        this.zypbxbts = zypbxbts;
    }

    public float getZypbxbrl()
    {
        return zypbxbrl;
    }

    public void setZypbxbrl(float zypbxbrl)
    {
        this.zypbxbrl = zypbxbrl;
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

    public float getDlcd()
    {
        return dlcd;
    }

    public void setDlcd(float dlcd)
    {
        this.dlcd = dlcd;
    }

    public float getDltz()
    {
        return dltz;
    }

    public void setDltz(float dltz)
    {
        this.dltz = dltz;
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
