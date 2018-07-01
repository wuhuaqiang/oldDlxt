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
public class XlGzGcEntity extends BaseEntity
{
    @NotBlank(message ="必填项" )
    @Length(max = 20,message = "20位以内字符")
    @FieldMeta(description = "项目名称",queryField = true, index = 1, editTagType = TagType.INPUT_TEXT)
    private String xmmc = "";

    @NotBlank(message ="必填项" )
    @FieldMeta(description = "运维单位", index = 2, show = false, isExport = false,editTagType = TagType.SELECT, keyValueType = KeyValueType.GDGS)
    private String ywdwId = "";

    @Transient
    @FieldMeta(description = "运维单位", index = 2,isImport = false,editTagType = TagType.NONE)
    private String ywdwName = "";

    @NotBlank(message ="必填项" )
    @FieldMeta(description = "所属区域", index = 3, show = false, isExport = false,editTagType = TagType.SELECT, keyValueType = KeyValueType.QY)
    private String qyId = "";

    @Transient
    @FieldMeta(description = "所属区域", index = 3,isImport = false,editTagType = TagType.NONE)
    private String qyName = "";

    @NotBlank(message ="必填项" )
    @FieldMeta(description = "规划年份", index = 4)
    private String ghnf = "";

    @NotBlank(message ="必填项" )
    @FieldMeta(description = "供区类型",queryField = true, index = 5, editTagType = TagType.SELECT, keyValueType = KeyValueType.SUPPLY_ZONE_TYPE)
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

    @FieldMeta(description = "架空线长度(千米)", index = 14)
    private float jkxlcd;

    @FieldMeta(description = "其中:耐热导线(千米)", index = 15)
    private float jydxcd;

    @FieldMeta(description = "架空线路投资(万元)", index = 16)
    private float jkxltz;

    @FieldMeta(description = "电缆线路长度(千米)", index = 17)
    private float dlxlcd;

    @FieldMeta(description = "沟道长度(千米)", index = 18)
    private float gdcd;

    @FieldMeta(description = "电缆投资(万元)", index = 19)
    private float dlxltz;

    @FieldMeta(description = "其他项", index = 20)
    private String qtx="";

    @FieldMeta(description = "其它项投资(万元)", index = 21)
    private float qtxtz;

    @FieldMeta(description = "电源送出类型", index = 22)
    private String dysclx="";

    @FieldMeta(description = "中央计划(%)", index = 23)
    private float zyjh;

    @FieldMeta(description = "公司自筹(%)", index = 24)
    private float gszc;

    @FieldMeta(description = "县级供电企业自筹(%)", index = 25)
    private float xjgdqyzc;

    @FieldMeta(description = "用户投资(%)", index = 26)
    private float yhtz;

    @FieldMeta(description = "小区配套费(%)", index = 27)
    private float xqptf;

    @FieldMeta(description = "政府垫资(%)", index = 28)
    private float zfdz;

    @FieldMeta(description = "其他投资(%)", index = 29)
    private float qttz;

    @FieldMeta(description = "類型",show =false,index = 30,isExport =  false,isImport = false)
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

    public String getQtx()
    {
        return qtx;
    }

    public void setQtx(String qtx)
    {
        this.qtx = qtx;
    }

    public float getQtxtz()
    {
        return qtxtz;
    }

    public void setQtxtz(float qtxtz)
    {
        this.qtxtz = qtxtz;
    }

    public String getDysclx()
    {
        return dysclx;
    }

    public void setDysclx(String dysclx)
    {
        this.dysclx = dysclx;
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
