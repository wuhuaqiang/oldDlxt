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
import java.util.Date;

/**
 * 中压线路信息
 */
@NameStyle(Style.normal)
@Table(name="Zyxlxx")
public class ZyxlxxEntity extends BaseEntity
{
    @NotBlank(message ="必填项" )
    @Length(max = 20,message = "20位以内字符")
    @FieldMeta(description = "线路名称", index = 6)
    private String xlmc="";

    @NotBlank(message ="必填项" )
    @Length(max = 20,message = "20位以内字符")
    @FieldMeta(description = "线路编号", index = 6)
    private String xlbh="";

    @NotBlank(message ="必填项" )
    @FieldMeta(description = "变电站", index = 2, queryField = true, show = false, isExport = false,editTagType = TagType.SELECT, keyValueType = KeyValueType.BDZ)
    private String bdz="";

    @Transient
    @FieldMeta(description = "变电站", index = 1,isImport =  false)
    private String bdzName="";

    @NotBlank(message ="必填项" )
    @FieldMeta(description = "电压等级", index = 2, queryField = true,  editTagType = TagType.SELECT,keyValueType = KeyValueType.VOLTAGE)
    private String dydj="";

    @NotBlank(message ="必填项" )
    @FieldMeta(description = "所属区域", queryField = true,index = 4, show = false, isExport = false,editTagType = TagType.SELECT, keyValueType = KeyValueType.QY)
    private String qyId="";

    @Transient
    @FieldMeta(description = "所属区域",index =4, editTagType = TagType.NONE,isImport = false)
    private String qyName="";

    @NotBlank(message ="必填项" )
    @FieldMeta(description = "供区类型", queryField = true,index = 3,editTagType = TagType.SELECT, keyValueType = KeyValueType.SUPPLY_ZONE_TYPE)
    private String gqlx="";

    @NotBlank(message ="必填项" )
    @FieldMeta(description = "运维单位", index = 7,show=false,isExport = false)
    private String ywdw="";

    @Transient
    @FieldMeta(description = "运维单位", index = 7,isImport = false)
    private String ywdwName="";

    @NotBlank(message ="必填项" )
    @FieldMeta(description = "城农网", index = 9)
    private String cnw="";

    @NotBlank(message ="必填项" )
    @FieldMeta(description = "使用方式", index = 8,editTagType = TagType.SELECT, keyValueType = KeyValueType.SYFS)
    private String syfs="";

    @NotBlank(message ="必填项" )
    @FieldMeta(description = "投运时间", index = 9)
    private String tysj="";

    @FieldMeta(description = "退役时间", index = 9)
    private String tuiyisj="";

    @NotBlank(message ="必填项" )
    @FieldMeta(description = "运行状态", index = 9)
    private String status = "";

    @FieldMeta(description = "备注", index = 7)
    private String remark="";

    @FieldMeta(description = "架空绝缘线（全线）", index = 7)
    private float qxjkjyx;

    @FieldMeta(description = "架空裸导线（全线）", index = 7)
    private float qxjklx;

    @FieldMeta(description = "电缆（全线）", index = 7)
    private float qxdl;

    @FieldMeta(description = "总长（全线）", index = 7)
    private float qxzc;

    @FieldMeta(description = "架空绝缘线(主干线)", index = 7)
    private float zgjkjyx;

    @FieldMeta(description = "架空裸导线(主干线)", index = 7)
    private float zgjklx;

    @FieldMeta(description = "电缆主干线", index = 7)
    private float dlzgx;

    @FieldMeta(description = "总长主干线", index = 7)
    private float zczgx;

    @FieldMeta(description = "导线型号一", index = 7,show = false,isExport = false)
    private String dxxh1="";
    @Transient
    @FieldMeta(description = "导线型号一", index = 7,isImport = false)
    private String dxxh1Name="";

    @FieldMeta(description = "导线型号二", index = 7,show = false,isExport = false)
    private String dxxh2="";
    @Transient
    @FieldMeta(description = "导线型号二", index = 7,isImport = false)
    private String dxxh2Name="";

    @FieldMeta(description = "导线型号三", index = 7,show = false,isExport = false)
    private String dxxh3="";
    @Transient
    @FieldMeta(description = "导线型号三", index = 7,isImport = false)
    private String dxxh3Name="";

    @FieldMeta(description = "公变台数", index = 7)
    private int gbts;

    @FieldMeta(description = "公变容量", index = 7)
    private float gbrl;

    @FieldMeta(description = "专变台数", index = 7)
    private int zbts;

    @FieldMeta(description = "专变容量", index = 7)
    private float zbrl;

    @FieldMeta(description = "总数(公变台数+专变台数)", index = 7)
    private int zts;

    @FieldMeta(description = "总数(公变容量+专变容量)", index = 7)
    private float zrl;

    @FieldMeta(description = "高损配变台数", index = 7)
    private int gspbts;

    @FieldMeta(description = "高损配变容量", index = 7)
    private float gspbrl;

    @FieldMeta(description = "环网柜", index = 7)
    private int hwg;

    @FieldMeta(description = "电缆分支箱", index = 7)
    private int dlfzx;

    @FieldMeta(description = "柱上开关", index = 7)
    private int zskg;

    @FieldMeta(description = "断路器", index = 7)
    private int dlq;

    @FieldMeta(description = "无功补偿台", index = 7)
    private int wgbcd;

    @FieldMeta(description = "无功补偿容量", index = 7)
    private float wgbcrl;

    @Transient
    @FieldMeta(description = "接线模式", index = 7)
    private String jxms="";

    @FieldMeta(description = "联络线数量", index = 7)
    private int llxsl;

    @FieldMeta(description = "主干线最大允许载流量", index = 7)
    private float zgxzdyxzll;

    @FieldMeta(description = "CT变比", index = 7)
    private String ctbb="";

    @FieldMeta(description = "一次侧额定电流", index = 7)
    private float ctyceddl;

    @FieldMeta(description = "其它原因限制最大载流量", index = 7)
    private float qtyyxzzdzll;

    @FieldMeta(description = "安全电流", index = 7)
    private float aqdl;

    @FieldMeta(description = "极限传输容量", index = 7)
    private float jxcsll;

    @FieldMeta(description = "最小截面导线载流量", index = 7)
    private float zxjmdxzll;

    @FieldMeta(description = "专用环网柜", index = 7)
    private int hwgzy;

    @FieldMeta(description = "专用电缆分支箱", index = 7)
    private int dlfzxzy;

    @FieldMeta(description = "专用柱上开关", index = 7)
    private int zskgzy;

    @FieldMeta(description = "专用断路器", index = 7)
    private int dlqzy;

    @FieldMeta(description = "环网柜总数", index = 7)
    private int hwgzs;

    @FieldMeta(description = "电缆分支箱总数", index = 7)
    private int dlfzxzs;

    @FieldMeta(description = "柱上开关总数", index = 7)
    private int zskgzs;

    @FieldMeta(description = "断路器总数", index = 7)
    private int dlqzs;

    @FieldMeta(description = "分段数", index = 7)
    private int fds;

    @FieldMeta(description = "分段长度", index = 7)
    private float fdcd;

    @FieldMeta(description = "敷设方式", index = 8,editTagType = TagType.SELECT, keyValueType = KeyValueType.FSFS)
    private String fsfs="";

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

    public String getDydj()
    {
        return dydj;
    }

    public void setDydj(String dydj)
    {
        this.dydj = dydj;
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

    public String getCnw()
    {
        return cnw;
    }

    public void setCnw(String cnw)
    {
        this.cnw = cnw;
    }

    public String getSyfs()
    {
        return syfs;
    }

    public void setSyfs(String syfs)
    {
        this.syfs = syfs;
    }

    public String getTysj()
    {
        return tysj;
    }

    public void setTysj(String tysj)
    {
        this.tysj = tysj;
    }

    public String getTuiyisj()
    {
        return tuiyisj;
    }

    public void setTuiyisj(String tuiyisj)
    {
        this.tuiyisj = tuiyisj;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getRemark()
    {
        return remark;
    }

    public void setRemark(String remark)
    {
        this.remark = remark;
    }

    public float getQxjkjyx()
    {
        return qxjkjyx;
    }

    public void setQxjkjyx(float qxjkjyx)
    {
        this.qxjkjyx = qxjkjyx;
    }

    public float getQxjklx()
    {
        return qxjklx;
    }

    public void setQxjklx(float qxjklx)
    {
        this.qxjklx = qxjklx;
    }

    public float getQxdl()
    {
        return qxdl;
    }

    public void setQxdl(float qxdl)
    {
        this.qxdl = qxdl;
    }

    public float getQxzc()
    {
        return qxzc;
    }

    public void setQxzc(float qxzc)
    {
        this.qxzc = qxzc;
    }

    public float getZgjkjyx()
    {
        return zgjkjyx;
    }

    public void setZgjkjyx(float zgjkjyx)
    {
        this.zgjkjyx = zgjkjyx;
    }

    public float getZgjklx()
    {
        return zgjklx;
    }

    public void setZgjklx(float zgjklx)
    {
        this.zgjklx = zgjklx;
    }

    public float getDlzgx()
    {
        return dlzgx;
    }

    public void setDlzgx(float dlzgx)
    {
        this.dlzgx = dlzgx;
    }

    public float getZczgx()
    {
        return zczgx;
    }

    public void setZczgx(float zczgx)
    {
        this.zczgx = zczgx;
    }

    public String getDxxh1()
    {
        return dxxh1;
    }

    public void setDxxh1(String dxxh1)
    {
        this.dxxh1 = dxxh1;
    }

    public String getDxxh2()
    {
        return dxxh2;
    }

    public void setDxxh2(String dxxh2)
    {
        this.dxxh2 = dxxh2;
    }

    public String getDxxh3()
    {
        return dxxh3;
    }

    public void setDxxh3(String dxxh3)
    {
        this.dxxh3 = dxxh3;
    }

    public int getGbts()
    {
        return gbts;
    }

    public void setGbts(int gbts)
    {
        this.gbts = gbts;
    }

    public float getGbrl()
    {
        return gbrl;
    }

    public void setGbrl(float gbrl)
    {
        this.gbrl = gbrl;
    }

    public int getZbts()
    {
        return zbts;
    }

    public void setZbts(int zbts)
    {
        this.zbts = zbts;
    }

    public float getZbrl()
    {
        return zbrl;
    }

    public void setZbrl(float zbrl)
    {
        this.zbrl = zbrl;
    }

    public int getZts()
    {
        return zts;
    }

    public void setZts(int zts)
    {
        this.zts = zts;
    }

    public float getZrl()
    {
        return zrl;
    }

    public void setZrl(float zrl)
    {
        this.zrl = zrl;
    }

    public int getGspbts()
    {
        return gspbts;
    }

    public void setGspbts(int gspbts)
    {
        this.gspbts = gspbts;
    }

    public float getGspbrl()
    {
        return gspbrl;
    }

    public void setGspbrl(float gspbrl)
    {
        this.gspbrl = gspbrl;
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

    public int getZskg()
    {
        return zskg;
    }

    public void setZskg(int zskg)
    {
        this.zskg = zskg;
    }

    public int getDlq()
    {
        return dlq;
    }

    public void setDlq(int dlq)
    {
        this.dlq = dlq;
    }

    public int getWgbcd()
    {
        return wgbcd;
    }

    public void setWgbcd(int wgbcd)
    {
        this.wgbcd = wgbcd;
    }

    public float getWgbcrl()
    {
        return wgbcrl;
    }

    public void setWgbcrl(float wgbcrl)
    {
        this.wgbcrl = wgbcrl;
    }

    public String getJxms()
    {
        return jxms;
    }

    public void setJxms(String jxms)
    {
        this.jxms = jxms;
    }

    public int getLlxsl()
    {
        return llxsl;
    }

    public void setLlxsl(int llxsl)
    {
        this.llxsl = llxsl;
    }

    public float getZgxzdyxzll()
    {
        return zgxzdyxzll;
    }

    public void setZgxzdyxzll(float zgxzdyxzll)
    {
        this.zgxzdyxzll = zgxzdyxzll;
    }

    public String getCtbb()
    {
        return ctbb;
    }

    public void setCtbb(String ctbb)
    {
        this.ctbb = ctbb;
    }

    public float getCtyceddl()
    {
        return ctyceddl;
    }

    public void setCtyceddl(float ctyceddl)
    {
        this.ctyceddl = ctyceddl;
    }

    public float getQtyyxzzdzll()
    {
        return qtyyxzzdzll;
    }

    public void setQtyyxzzdzll(float qtyyxzzdzll)
    {
        this.qtyyxzzdzll = qtyyxzzdzll;
    }

    public float getAqdl()
    {
        return aqdl;
    }

    public void setAqdl(float aqdl)
    {
        this.aqdl = aqdl;
    }

    public float getJxcsll()
    {
        return jxcsll;
    }

    public void setJxcsll(float jxcsll)
    {
        this.jxcsll = jxcsll;
    }

    public float getZxjmdxzll()
    {
        return zxjmdxzll;
    }

    public void setZxjmdxzll(float zxjmdxzll)
    {
        this.zxjmdxzll = zxjmdxzll;
    }

    public int getHwgzy()
    {
        return hwgzy;
    }

    public void setHwgzy(int hwgzy)
    {
        this.hwgzy = hwgzy;
    }

    public int getDlfzxzy()
    {
        return dlfzxzy;
    }

    public void setDlfzxzy(int dlfzxzy)
    {
        this.dlfzxzy = dlfzxzy;
    }

    public int getZskgzy()
    {
        return zskgzy;
    }

    public void setZskgzy(int zskgzy)
    {
        this.zskgzy = zskgzy;
    }

    public int getDlqzy()
    {
        return dlqzy;
    }

    public void setDlqzy(int dlqzy)
    {
        this.dlqzy = dlqzy;
    }

    public int getHwgzs()
    {
        return hwgzs;
    }

    public void setHwgzs(int hwgzs)
    {
        this.hwgzs = hwgzs;
    }

    public int getDlfzxzs()
    {
        return dlfzxzs;
    }

    public void setDlfzxzs(int dlfzxzs)
    {
        this.dlfzxzs = dlfzxzs;
    }

    public int getZskgzs()
    {
        return zskgzs;
    }

    public void setZskgzs(int zskgzs)
    {
        this.zskgzs = zskgzs;
    }

    public int getDlqzs()
    {
        return dlqzs;
    }

    public void setDlqzs(int dlqzs)
    {
        this.dlqzs = dlqzs;
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

    public String getFsfs()
    {
        return fsfs;
    }

    public void setFsfs(String fsfs)
    {
        this.fsfs = fsfs;
    }

    public String getDxxh1Name()
    {
        return dxxh1Name;
    }

    public void setDxxh1Name(String dxxh1Name)
    {
        this.dxxh1Name = dxxh1Name;
    }

    public String getDxxh2Name()
    {
        return dxxh2Name;
    }

    public void setDxxh2Name(String dxxh2Name)
    {
        this.dxxh2Name = dxxh2Name;
    }

    public String getDxxh3Name()
    {
        return dxxh3Name;
    }

    public void setDxxh3Name(String dxxh3Name)
    {
        this.dxxh3Name = dxxh3Name;
    }
}
