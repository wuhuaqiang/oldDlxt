package com.kylin.electricassistsys.entity.facility;


/**
 * 高压线路历史信息
 */
public class GyxllsxxEntity
{
    /**
     * 主键
     */
    private String lsid;

    /**
     * 线路信息主键
     */
    private String xlxxId;

    /**
     * 电压等级
     */
    private String dydj;

    /**
     * 电压等级中文
     */
    private String dydjName;

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
     * 数据年份
     */
    private String sjnf;

    /**
     * 线路编号
     */
    private String xlbh;

    /**
     * 线路名称
     */
    private String xlmc;

    /**
     * 运维单位
     */
    private String ywdw;
    /**
     * 运维单位中文
     */
    private String dwmz;

    /**
     * 使用方式
     */
    private String syfs;
    /**
     * 使用方式中文
     */
    private String syfsName;

    /**
     * 城农网
     */
    private String ynw;
    /**
     * 城农网中文
     */
    private String ynwName;

    /**
     * CT变比
     */
    private String ctbb;
    /**
     * CT变比中文
     */
    private String ctbbName;


    /**
     * (实际)起点
     */
    private String sjqd;

    /**
     * 终点(变电站)
     */
    private String sjzd;

    /**
     * 开关编号首
     */
    private String kgbhs;

    /**
     * 开关编号末
     */
    private String kgbhm;

    /**
     * 起始杆号
     */
    private String qsgh;

    /**
     * 总长(全线)
     */
    private String qxqc;

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
     * 投运时间
     */
    private String tysj;

    /**
     * 退役时间
     */
    private String tuiyisj;


    /**
     * 电缆(全线)
     */
    private String qxdl;

    /**
     * 架空导线,全线
     */
    private String qxjkdx;


    /**
     * 最小截面导线
     */
    private String zxjmdx;

    /**
     * 最大充许电流
     */
    private String zdyxdl;

    /**
     * 是否CT影响
     */
    private String sfyxct;


    /**
     * 其中同塔双回
     */
    private String qzttsh;


    /**
     * 状态
     */
    private String zt;


    /**
     * 架设方式
     */
    private String jsfs;

    /**
     * 电阻
     */
    private String dz;

    /**
     * 电抗
     */
    private String dk;

    /**
     * 终端杆号
     */
    private String zdgh;

    /**
     * 备注
     */
    private String bz;

    /**
     * 操作人
     * <p>
     * 出表后 更改条件
     */
    private String xgr;

    /**
     * 操作人中文
     */
    private String czName;

    /**
     * 操作时间
     */
    private String xgsj;

    /**
     * 电缆型号
     */
    private String dlxhname;

    private String dlxh;

    /**
     * 分段数
     */
    private String fds;

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
    private String fsfsName;


    /**
     * 起点类型
     */
    private String qdlx;

    /**
     * 终点类型
     */
    private String zdlx;

    /**
     * 供电区属性
     */
    private String gdqsx;

    /**
     * 供电性质
     */
    private String gdxz;

    /**
     * 满足N-1
     */
    private String n_1;


    /**
     * 电网结构链接
     */
    private String dwjg;

    public String getLsid()
    {
        return lsid;
    }

    public void setLsid(String lsid)
    {
        this.lsid = lsid;
    }

    public String getXlxxId()
    {
        return xlxxId;
    }

    public void setXlxxId(String xlxxId)
    {
        this.xlxxId = xlxxId;
    }

    public String getDydj()
    {
        return dydj;
    }

    public void setDydj(String dydj)
    {
        this.dydj = dydj;
    }

    public String getDydjName()
    {
        return dydjName;
    }

    public void setDydjName(String dydjName)
    {
        this.dydjName = dydjName;
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

    public String getSjnf()
    {
        return sjnf;
    }

    public void setSjnf(String sjnf)
    {
        this.sjnf = sjnf;
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

    public String getCtbb()
    {
        return ctbb;
    }

    public void setCtbb(String ctbb)
    {
        this.ctbb = ctbb;
    }

    public String getCtbbName()
    {
        return ctbbName;
    }

    public void setCtbbName(String ctbbName)
    {
        this.ctbbName = ctbbName;
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

    public String getQsgh()
    {
        return qsgh;
    }

    public void setQsgh(String qsgh)
    {
        this.qsgh = qsgh;
    }

    public String getQxqc()
    {
        return qxqc;
    }

    public void setQxqc(String qxqc)
    {
        this.qxqc = qxqc;
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

    public String getQxdl()
    {
        return qxdl;
    }

    public void setQxdl(String qxdl)
    {
        this.qxdl = qxdl;
    }

    public String getQxjkdx()
    {
        return qxjkdx;
    }

    public void setQxjkdx(String qxjkdx)
    {
        this.qxjkdx = qxjkdx;
    }

    public String getZxjmdx()
    {
        return zxjmdx;
    }

    public void setZxjmdx(String zxjmdx)
    {
        this.zxjmdx = zxjmdx;
    }

    public String getZdyxdl()
    {
        return zdyxdl;
    }

    public void setZdyxdl(String zdyxdl)
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

    public String getQzttsh()
    {
        return qzttsh;
    }

    public void setQzttsh(String qzttsh)
    {
        this.qzttsh = qzttsh;
    }

    public String getZt()
    {
        return zt;
    }

    public void setZt(String zt)
    {
        this.zt = zt;
    }

    public String getJsfs()
    {
        return jsfs;
    }

    public void setJsfs(String jsfs)
    {
        this.jsfs = jsfs;
    }

    public String getDz()
    {
        return dz;
    }

    public void setDz(String dz)
    {
        this.dz = dz;
    }

    public String getDk()
    {
        return dk;
    }

    public void setDk(String dk)
    {
        this.dk = dk;
    }

    public String getZdgh()
    {
        return zdgh;
    }

    public void setZdgh(String zdgh)
    {
        this.zdgh = zdgh;
    }

    public String getBz()
    {
        return bz;
    }

    public void setBz(String bz)
    {
        this.bz = bz;
    }

    public String getXgr()
    {
        return xgr;
    }

    public void setXgr(String xgr)
    {
        this.xgr = xgr;
    }

    public String getCzName()
    {
        return czName;
    }

    public void setCzName(String czName)
    {
        this.czName = czName;
    }

    public String getXgsj()
    {
        return xgsj;
    }

    public void setXgsj(String xgsj)
    {
        this.xgsj = xgsj;
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

    public String getFds()
    {
        return fds;
    }

    public void setFds(String fds)
    {
        this.fds = fds;
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

    public String getFsfsName()
    {
        return fsfsName;
    }

    public void setFsfsName(String fsfsName)
    {
        this.fsfsName = fsfsName;
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
}
