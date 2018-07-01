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
 * 高压线路信息
 */
@NameStyle(Style.normal)
@Table(name="Gyxlxx")
public class GyxlxxEntity extends BaseEntity
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
    @FieldMeta(description = "使用方式", index = 8,editTagType = TagType.SELECT, keyValueType = KeyValueType.SYFS)
    private String syfs="";

    @NotBlank(message ="必填项" )
    @FieldMeta(description = "城农网", index = 9)
    private String cnw="";

    @NotBlank(message ="必填项" )
    @FieldMeta(description = "CT变比", index = 9)
    private String ctbb="";


    @Transient
    @FieldMeta(description = "供电区属性", index = 5,show = false,isExport = false,isImport = false)
    private String gdqsx="";

    @Transient
    @FieldMeta(description = "供电性质", index = 6,show = false,isExport = false,isImport = false)
    private String gdxz="";

    @NotBlank(message ="必填项" )
    @FieldMeta(description = "电网结构链接", index = 7)
    private String dwjg="";

    @NotBlank(message ="必填项" )
    @FieldMeta(description = "敷设方式", index = 8,editTagType = TagType.SELECT, keyValueType = KeyValueType.FSFS)
    private String fsfs="";

    @NotBlank(message ="必填项" )
    @FieldMeta(description = "满足N-1", index = 7)
    private String n_1="";

    @FieldMeta(description = "电阻", index = 9)
    private float dz;

    @FieldMeta(description = "电抗", index = 9)
    private float dk;


    @NotBlank(message ="必填项" )
    @FieldMeta(description = "起点类型", index = 7)
    private String qdlx="";

    @NotBlank(message ="必填项" )
    @FieldMeta(description = "终点类型", index = 7)
    private String zdlx="";

    @NotBlank(message ="必填项" )
    @FieldMeta(description = "(实际)起点",show=false, index = 9,isExport = false)
    private String sjqd="";

    @NotBlank(message ="必填项" )
    @FieldMeta(description = "(实际)终点", show = false,index = 9,isExport = false)
    private String sjzd="";

    @Transient
    @FieldMeta(description = "(实际)起点", index = 9,isImport = false)
    private String sjqdName="";

    @Transient
    @FieldMeta(description = "(实际)终点",  index = 9,isImport = false)
    private String sjzdName="";

    @FieldMeta(description = "开关编号首", index = 9)
    private String kgbhs="";

    @FieldMeta(description = "开关编号末", index = 9)
    private String kgbhm="";

    @NotBlank(message ="必填项" )
    @FieldMeta(description = "投运时间", index = 9)
    private String tysj="";

    @FieldMeta(description = "退役时间", index = 9)
    private String tuiyisj="";

    @FieldMeta(description = "备注", index = 7)
    private String remark="";

    @Transient
    @FieldMeta(description = "起始杆号", index = 9,show = false)
    private String qsgh="";

    @FieldMeta(description = "架空导线（全线）", index = 9)
    private float qxjk;

    @FieldMeta(description = "电缆(全线)", index = 9)
    private float qxdl;

    @FieldMeta(description = "总长(全线)", index = 9)
    private float qxzc;

    @FieldMeta(description = "其中同塔双回", index = 9)
    private float qzttsh;

    @FieldMeta(description = "电缆型号", index = 8,show =false,isExport = false,editTagType = TagType.SELECT, keyValueType = KeyValueType.DXCS)
    private String dlxh="";

    @Transient
    @FieldMeta(description = "电缆型号", index = 8,isImport = false,editTagType = TagType.SELECT, keyValueType = KeyValueType.DXCS)
    private String dlxhName="";

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

    @FieldMeta(description = "最小截面导线", index = 9)
    private float zxjmdx;

    @FieldMeta(description = "最大允许电流", index = 9)
    private float zdyxdl;

    @FieldMeta(description = "是否CT影响", index = 9)
    private String sfyxct="";

    @FieldMeta(description = "分段数", index = 7)
    private int fds;

    @FieldMeta(description = "分段长度", index = 7)
    private float fdcd;

    @FieldMeta(description = "运行状态", index = 9)
    private String status = "";

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

    public String getCtbb()
    {
        return ctbb;
    }

    public void setCtbb(String ctbb)
    {
        this.ctbb = ctbb;
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

    public String getDwjg()
    {
        return dwjg;
    }

    public void setDwjg(String dwjg)
    {
        this.dwjg = dwjg;
    }

    public String getFsfs()
    {
        return fsfs;
    }

    public void setFsfs(String fsfs)
    {
        this.fsfs = fsfs;
    }

    public String getN_1()
    {
        return n_1;
    }

    public void setN_1(String n_1)
    {
        this.n_1 = n_1;
    }

    public float getDz()
    {
        return dz;
    }

    public void setDz(float dz)
    {
        this.dz = dz;
    }

    public float getDk()
    {
        return dk;
    }

    public void setDk(float dk)
    {
        this.dk = dk;
    }

    public String getQdlx()
    {
        return qdlx;
    }

    public void setQdlx(String qdlx)
    {
        this.qdlx = qdlx;
    }

    public String getZdlx()
    {
        return zdlx;
    }

    public void setZdlx(String zdlx)
    {
        this.zdlx = zdlx;
    }

    public String getSjqd()
    {
        return sjqd;
    }

    public void setSjqd(String sjqd)
    {
        this.sjqd = sjqd;
    }

    public String getSjzd()
    {
        return sjzd;
    }

    public void setSjzd(String sjzd)
    {
        this.sjzd = sjzd;
    }

    public String getKgbhs()
    {
        return kgbhs;
    }

    public void setKgbhs(String kgbhs)
    {
        this.kgbhs = kgbhs;
    }

    public String getKgbhm()
    {
        return kgbhm;
    }

    public void setKgbhm(String kgbhm)
    {
        this.kgbhm = kgbhm;
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

    public String getRemark()
    {
        return remark;
    }

    public void setRemark(String remark)
    {
        this.remark = remark;
    }

    public String getQsgh()
    {
        return qsgh;
    }

    public void setQsgh(String qsgh)
    {
        this.qsgh = qsgh;
    }

    public float getQxjk()
    {
        return qxjk;
    }

    public void setQxjk(float qxjk)
    {
        this.qxjk = qxjk;
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

    public float getQzttsh()
    {
        return qzttsh;
    }

    public void setQzttsh(float qzttsh)
    {
        this.qzttsh = qzttsh;
    }

    public String getDlxh()
    {
        return dlxh;
    }

    public void setDlxh(String dlxh)
    {
        this.dlxh = dlxh;
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

    public float getZxjmdx()
    {
        return zxjmdx;
    }

    public void setZxjmdx(float zxjmdx)
    {
        this.zxjmdx = zxjmdx;
    }

    public float getZdyxdl()
    {
        return zdyxdl;
    }

    public void setZdyxdl(float zdyxdl)
    {
        this.zdyxdl = zdyxdl;
    }

    public String getSfyxct()
    {
        return sfyxct;
    }

    public void setSfyxct(String sfyxct)
    {
        this.sfyxct = sfyxct;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
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

    public String getSjqdName()
    {
        return sjqdName;
    }

    public void setSjqdName(String sjqdName)
    {
        this.sjqdName = sjqdName;
    }

    public String getSjzdName()
    {
        return sjzdName;
    }

    public void setSjzdName(String sjzdName)
    {
        this.sjzdName = sjzdName;
    }

    public String getDlxhName()
    {
        return dlxhName;
    }

    public void setDlxhName(String dlxhName)
    {
        this.dlxhName = dlxhName;
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
