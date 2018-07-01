package com.kylin.electricassistsys.entity.facility;


/**
 * 中亚线路历史
 */
public class ZyxlLsEntity
{
    /**
     * 主键
     */
    private String id;


    /**
     * 供区类型
     */
    private String gqlx;

    /**
     * 供区类型中文
     */
    private String gqlxName;


    /**
     * 所属区域
     */
    private String ssqy;

    /**
     * 所属区域中文
     */
    private String ssqyName;


    /**
     * 变电站编号
     */
    private String ssbdz;

    /**
     * 变电站编号中文
     */
    private String ssbdzName;


    /**
     * 修改时间
     */
    private String updata;

    /**
     * 修改人
     */
    private String upuser;

    /**
     * 修改人中文
     */
    private String upuserName;

    /**
     * 线路编号
     */
    private String xlbh;

    /**
     * 线路名称
     */
    private String xlmc;


    /**
     * 数据年份
     */
    private String sjnf;


    /**
     * 站内联络线一
     */
    private String zlllx1;

    /**
     * 站内联络线二
     */
    private String zlllx2;

    /**
     * 站内联络线三
     */
    private String zlllx3;

    /**
     * 站间联络线一
     */
    private String zjllx1;

    /**
     * 站间联络线二
     */
    private String zjllx2;

    /**
     * 站间联络线三
     */
    private String zjllx3;


    /**
     * 接线模式
     */
    private String jxms;

    /**
     * 联络线数量
     */
    private String llxsl;

    /**
     * 运维单位
     */
    private String ywdw;

    /**
     * 运维单位中文
     */
    private String dwmz;

    /**
     * 城农网
     */
    private String ynw;

    /**
     * 城农网中文
     */
    private String ynwName;

    /**
     * 使用方式
     */
    private String syfs;

    /**
     * 使用方式中文
     */
    private String syfsName;


    /**
     * 投运时间
     */
    private String tysj;

    /**
     * 退役时间
     */
    private String tuiyisj;

    /**
     * 状态
     */
    private String zt;

    /**
     * 架空绝缘线(全线)
     */
    private String qxjkjyx;

    /**
     * 架空裸导线(全线)
     */
    private String qxjklx;

    /**
     * 电缆(全线)
     */
    private String qxdl;

    /**
     * 总长(全线)
     */
    private String qxzc;

    /**
     * 架空绝缘线(主干线)
     */
    private String zgjkjyx;

    /**
     * 架空裸导线(主干线)
     */
    private String zgjklx;

    /**
     * 电缆主干线
     */
    private String dlzgx;

    /**
     * 总长主干线
     */
    private String zczgx;

    /**
     * 导线型号一
     */
    private String dxxh1;

    /**
     * 导线型号二
     */
    private String dxxh2;

    /**
     * 导线型号三
     */
    private String dxxh3;

    /**
     * 公变台数
     */
    private String gbts;

    /**
     * 公变容量
     */
    private String gbrl;

    /**
     * 专变台数
     */
    private String zbts;

    /**
     * 专变容量
     */
    private String zbrl;

    /**
     * 总数（公变台数+专变台数）
     */
    private String zts;

    /**
     * 总数(公变容量+专变容量)
     */
    private String zrl;

    /**
     * 环网柜
     */
    private String hwg;

    /**
     * 电缆分支箱
     */
    private String dlfzx;

    /**
     * 柱上开关
     */
    private String zskg;

    /**
     * 断路器
     */
    private String dlq;

    /**
     * 无功补偿台
     */
    private String wgbcd;


    /**
     * 分段数
     */
    private String fds;


    /**
     * 主干线最大允许载流量
     */
    private String zgxzdyxzll;

    /**
     * CT一次侧额定电流
     */
    private String ctyceddl;

    /**
     * 最小截面导线载流量
     */
    private String zxjmdxzll;

    /**
     * 其它原因限制最大载流量
     */
    private String qtyyxzzdzll;

    /**
     * 安全电流
     */
    private String aqdl;

    /**
     * 极限传输容量
     */
    private String jxcsll;

    /**
     * 高损配变(台数)
     */
    private String gspbts;

    /**
     * 高损配变(容量)
     */
    private String gspbrl;

    /**
     * 无功补偿容量
     */
    private String wgbcrl;

    /**
     * 开关编号
     */
    private String kgbh;


    /**
     * 中压线路ID
     */
    private String zyxlId;


    /**
     * 备注
     */
    private String bz;

    /**
     * 中压线路
     */
    private String zyxl;

    /**
     * 电缆型号
     */
    private String dlxhname;

    private String dlxh;


    /**
     * 分段长度
     */
    private String fdcd;

    /**
     * 敷设方式
     */
    private String fsfs;

    /**
     * 敷设方式中文
     */
    private String name;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
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

    public String getSsqy()
    {
        return ssqy;
    }

    public void setSsqy(String ssqy)
    {
        this.ssqy = ssqy;
    }

    public String getSsqyName()
    {
        return ssqyName;
    }

    public void setSsqyName(String ssqyName)
    {
        this.ssqyName = ssqyName;
    }

    public String getSsbdz()
    {
        return ssbdz;
    }

    public void setSsbdz(String ssbdz)
    {
        this.ssbdz = ssbdz;
    }

    public String getSsbdzName()
    {
        return ssbdzName;
    }

    public void setSsbdzName(String ssbdzName)
    {
        this.ssbdzName = ssbdzName;
    }

    public String getUpdata()
    {
        return updata;
    }

    public void setUpdata(String updata)
    {
        this.updata = updata;
    }

    public String getUpuser()
    {
        return upuser;
    }

    public void setUpuser(String upuser)
    {
        this.upuser = upuser;
    }

    public String getUpuserName()
    {
        return upuserName;
    }

    public void setUpuserName(String upuserName)
    {
        this.upuserName = upuserName;
    }

    public String getXlbh()
    {
        return xlbh;
    }

    public void setXlbh(String xlbh)
    {
        this.xlbh = xlbh;
    }

    public String getXlmc()
    {
        return xlmc;
    }

    public void setXlmc(String xlmc)
    {
        this.xlmc = xlmc;
    }

    public String getSjnf()
    {
        return sjnf;
    }

    public void setSjnf(String sjnf)
    {
        this.sjnf = sjnf;
    }

    public String getZlllx1()
    {
        return zlllx1;
    }

    public void setZlllx1(String zlllx1)
    {
        this.zlllx1 = zlllx1;
    }

    public String getZlllx2()
    {
        return zlllx2;
    }

    public void setZlllx2(String zlllx2)
    {
        this.zlllx2 = zlllx2;
    }

    public String getZlllx3()
    {
        return zlllx3;
    }

    public void setZlllx3(String zlllx3)
    {
        this.zlllx3 = zlllx3;
    }

    public String getZjllx1()
    {
        return zjllx1;
    }

    public void setZjllx1(String zjllx1)
    {
        this.zjllx1 = zjllx1;
    }

    public String getZjllx2()
    {
        return zjllx2;
    }

    public void setZjllx2(String zjllx2)
    {
        this.zjllx2 = zjllx2;
    }

    public String getZjllx3()
    {
        return zjllx3;
    }

    public void setZjllx3(String zjllx3)
    {
        this.zjllx3 = zjllx3;
    }

    public String getJxms()
    {
        return jxms;
    }

    public void setJxms(String jxms)
    {
        this.jxms = jxms;
    }

    public String getLlxsl()
    {
        return llxsl;
    }

    public void setLlxsl(String llxsl)
    {
        this.llxsl = llxsl;
    }

    public String getYwdw()
    {
        return ywdw;
    }

    public void setYwdw(String ywdw)
    {
        this.ywdw = ywdw;
    }

    public String getDwmz()
    {
        return dwmz;
    }

    public void setDwmz(String dwmz)
    {
        this.dwmz = dwmz;
    }

    public String getYnw()
    {
        return ynw;
    }

    public void setYnw(String ynw)
    {
        this.ynw = ynw;
    }

    public String getYnwName()
    {
        return ynwName;
    }

    public void setYnwName(String ynwName)
    {
        this.ynwName = ynwName;
    }

    public String getSyfs()
    {
        return syfs;
    }

    public void setSyfs(String syfs)
    {
        this.syfs = syfs;
    }

    public String getSyfsName()
    {
        return syfsName;
    }

    public void setSyfsName(String syfsName)
    {
        this.syfsName = syfsName;
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

    public String getZt()
    {
        return zt;
    }

    public void setZt(String zt)
    {
        this.zt = zt;
    }

    public String getQxjkjyx()
    {
        return qxjkjyx;
    }

    public void setQxjkjyx(String qxjkjyx)
    {
        this.qxjkjyx = qxjkjyx;
    }

    public String getQxjklx()
    {
        return qxjklx;
    }

    public void setQxjklx(String qxjklx)
    {
        this.qxjklx = qxjklx;
    }

    public String getQxdl()
    {
        return qxdl;
    }

    public void setQxdl(String qxdl)
    {
        this.qxdl = qxdl;
    }

    public String getQxzc()
    {
        return qxzc;
    }

    public void setQxzc(String qxzc)
    {
        this.qxzc = qxzc;
    }

    public String getZgjkjyx()
    {
        return zgjkjyx;
    }

    public void setZgjkjyx(String zgjkjyx)
    {
        this.zgjkjyx = zgjkjyx;
    }

    public String getZgjklx()
    {
        return zgjklx;
    }

    public void setZgjklx(String zgjklx)
    {
        this.zgjklx = zgjklx;
    }

    public String getDlzgx()
    {
        return dlzgx;
    }

    public void setDlzgx(String dlzgx)
    {
        this.dlzgx = dlzgx;
    }

    public String getZczgx()
    {
        return zczgx;
    }

    public void setZczgx(String zczgx)
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

    public String getGbts()
    {
        return gbts;
    }

    public void setGbts(String gbts)
    {
        this.gbts = gbts;
    }

    public String getGbrl()
    {
        return gbrl;
    }

    public void setGbrl(String gbrl)
    {
        this.gbrl = gbrl;
    }

    public String getZbts()
    {
        return zbts;
    }

    public void setZbts(String zbts)
    {
        this.zbts = zbts;
    }

    public String getZbrl()
    {
        return zbrl;
    }

    public void setZbrl(String zbrl)
    {
        this.zbrl = zbrl;
    }

    public String getZts()
    {
        return zts;
    }

    public void setZts(String zts)
    {
        this.zts = zts;
    }

    public String getZrl()
    {
        return zrl;
    }

    public void setZrl(String zrl)
    {
        this.zrl = zrl;
    }

    public String getHwg()
    {
        return hwg;
    }

    public void setHwg(String hwg)
    {
        this.hwg = hwg;
    }

    public String getDlfzx()
    {
        return dlfzx;
    }

    public void setDlfzx(String dlfzx)
    {
        this.dlfzx = dlfzx;
    }

    public String getZskg()
    {
        return zskg;
    }

    public void setZskg(String zskg)
    {
        this.zskg = zskg;
    }

    public String getDlq()
    {
        return dlq;
    }

    public void setDlq(String dlq)
    {
        this.dlq = dlq;
    }

    public String getWgbcd()
    {
        return wgbcd;
    }

    public void setWgbcd(String wgbcd)
    {
        this.wgbcd = wgbcd;
    }

    public String getFds()
    {
        return fds;
    }

    public void setFds(String fds)
    {
        this.fds = fds;
    }

    public String getZgxzdyxzll()
    {
        return zgxzdyxzll;
    }

    public void setZgxzdyxzll(String zgxzdyxzll)
    {
        this.zgxzdyxzll = zgxzdyxzll;
    }

    public String getCtyceddl()
    {
        return ctyceddl;
    }

    public void setCtyceddl(String ctyceddl)
    {
        this.ctyceddl = ctyceddl;
    }

    public String getZxjmdxzll()
    {
        return zxjmdxzll;
    }

    public void setZxjmdxzll(String zxjmdxzll)
    {
        this.zxjmdxzll = zxjmdxzll;
    }

    public String getQtyyxzzdzll()
    {
        return qtyyxzzdzll;
    }

    public void setQtyyxzzdzll(String qtyyxzzdzll)
    {
        this.qtyyxzzdzll = qtyyxzzdzll;
    }

    public String getAqdl()
    {
        return aqdl;
    }

    public void setAqdl(String aqdl)
    {
        this.aqdl = aqdl;
    }

    public String getJxcsll()
    {
        return jxcsll;
    }

    public void setJxcsll(String jxcsll)
    {
        this.jxcsll = jxcsll;
    }

    public String getGspbts()
    {
        return gspbts;
    }

    public void setGspbts(String gspbts)
    {
        this.gspbts = gspbts;
    }

    public String getGspbrl()
    {
        return gspbrl;
    }

    public void setGspbrl(String gspbrl)
    {
        this.gspbrl = gspbrl;
    }

    public String getWgbcrl()
    {
        return wgbcrl;
    }

    public void setWgbcrl(String wgbcrl)
    {
        this.wgbcrl = wgbcrl;
    }

    public String getKgbh()
    {
        return kgbh;
    }

    public void setKgbh(String kgbh)
    {
        this.kgbh = kgbh;
    }

    public String getZyxlId()
    {
        return zyxlId;
    }

    public void setZyxlId(String zyxlId)
    {
        this.zyxlId = zyxlId;
    }

    public String getBz()
    {
        return bz;
    }

    public void setBz(String bz)
    {
        this.bz = bz;
    }

    public String getZyxl()
    {
        return zyxl;
    }

    public void setZyxl(String zyxl)
    {
        this.zyxl = zyxl;
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

    public String getFdcd()
    {
        return fdcd;
    }

    public void setFdcd(String fdcd)
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

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
