package com.kylin.electricassistsys.entity.facility;


/**
 * 变压器历史
 */
public class ByqlsEntity
{
    /**
     * 主键
     */
    private String id;

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
    private String gqlxid;

    /**
     * 供区类型中文
     */
    private String gqlxName;

    /**
     * 所属区域
     */
    private String qyid;

    /**
     * 所属区域中文
     */
    private String qyName;

    /**
     * 年份
     */
    private String year;

    /**
     * 变压器编号
     */
    private String num;


    /**
     * 变压器名称
     */
    private String byqName;

    /**
     * 变压器名称中文
     * <p>
     * 出表后 更改条件
     */
    private String xh;


    /**
     * 变电站编号
     * <p>
     * 出表后 更改条件
     */
    private String bdzid;

    /**
     * 变电站编号中文
     */
    private String bdzName;

    /**
     * 运维单位
     */
    private String ywdw;

    /**
     * 额定电压
     */
    private String eddy;

    /**
     * 调压方式
     */
    private String tsfs;

    /**
     * 绕阻型式
     */
    private String rzxs;

    /**
     * 铭牌型号
     */
    private String mpxh;


    /**
     * 变电容量
     */
    private String bdrl;


    /**
     * 铭牌变比
     */
    private String mpbb;

    /**
     * 铭牌变比中文
     */
    private String mpbbName;


    /**
     * 投运时间
     */
    private String btysj;

    /**
     * 退役时间
     */
    private String etysj;

    /**
     * 状态
     */
    private String zt;

    /**
     * 高-中阻抗%
     */
    private String gzzk;

    /**
     * 中-低阻抗%
     */
    private String zdzk;

    /**
     * 高-低阻抗%
     */
    private String gdzk;

    /**
     * 高-中损耗KW
     */
    private String gzsh;

    /**
     * 中-低损耗KW
     */
    private String zdsh;

    /**
     * 高-低损耗KW
     */
    private String gdsh;

    /**
     * 高-中电阻
     */
    private String gzdz;

    /**
     * 中-低电阻
     */
    private String zddz;

    /**
     * 高-低电阻
     */
    private String gddz;

    /**
     * 高-中电抗
     */
    private String gzdk;

    /**
     * 中-低电抗
     */
    private String zddk;

    /**
     * 高-低电抗
     */
    private String gddk;

    /**
     * 无功补偿容量
     */
    private String wgbcrl;

    /**
     * 无功补偿构成
     */
    private String wgbcgc;

    /**
     * 无功补偿度
     */
    private String wgbcd;


    /**
     * 备注
     */
    private String remark;

    /**
     * 修改时间
     */
    private String xgsj;

    /**
     * 变压器名称
     */
    private String xgr;

    /**
     * 变压器名称中文
     */
    private String Name;

    /**
     * 变压器编号
     */
    private String byqId;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
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

    public String getGqlxid()
    {
        return gqlxid;
    }

    public void setGqlxid(String gqlxid)
    {
        this.gqlxid = gqlxid;
    }

    public String getGqlxName()
    {
        return gqlxName;
    }

    public void setGqlxName(String gqlxName)
    {
        this.gqlxName = gqlxName;
    }

    public String getQyid()
    {
        return qyid;
    }

    public void setQyid(String qyid)
    {
        this.qyid = qyid;
    }

    public String getQyName()
    {
        return qyName;
    }

    public void setQyName(String qyName)
    {
        this.qyName = qyName;
    }

    public String getYear()
    {
        return year;
    }

    public void setYear(String year)
    {
        this.year = year;
    }

    public String getNum()
    {
        return num;
    }

    public void setNum(String num)
    {
        this.num = num;
    }

    public String getByqName()
    {
        return byqName;
    }

    public void setByqName(String byqName)
    {
        this.byqName = byqName;
    }

    public String getXh()
    {
        return xh;
    }

    public void setXh(String xh)
    {
        this.xh = xh;
    }

    public String getBdzid()
    {
        return bdzid;
    }

    public void setBdzid(String bdzid)
    {
        this.bdzid = bdzid;
    }

    public String getBdzName()
    {
        return bdzName;
    }

    public void setBdzName(String bdzName)
    {
        this.bdzName = bdzName;
    }

    public String getYwdw()
    {
        return ywdw;
    }

    public void setYwdw(String ywdw)
    {
        this.ywdw = ywdw;
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

    public String getBdrl()
    {
        return bdrl;
    }

    public void setBdrl(String bdrl)
    {
        this.bdrl = bdrl;
    }

    public String getMpbb()
    {
        return mpbb;
    }

    public void setMpbb(String mpbb)
    {
        this.mpbb = mpbb;
    }

    public String getMpbbName()
    {
        return mpbbName;
    }

    public void setMpbbName(String mpbbName)
    {
        this.mpbbName = mpbbName;
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

    public String getGzzk()
    {
        return gzzk;
    }

    public void setGzzk(String gzzk)
    {
        this.gzzk = gzzk;
    }

    public String getZdzk()
    {
        return zdzk;
    }

    public void setZdzk(String zdzk)
    {
        this.zdzk = zdzk;
    }

    public String getGdzk()
    {
        return gdzk;
    }

    public void setGdzk(String gdzk)
    {
        this.gdzk = gdzk;
    }

    public String getGzsh()
    {
        return gzsh;
    }

    public void setGzsh(String gzsh)
    {
        this.gzsh = gzsh;
    }

    public String getZdsh()
    {
        return zdsh;
    }

    public void setZdsh(String zdsh)
    {
        this.zdsh = zdsh;
    }

    public String getGdsh()
    {
        return gdsh;
    }

    public void setGdsh(String gdsh)
    {
        this.gdsh = gdsh;
    }

    public String getGzdz()
    {
        return gzdz;
    }

    public void setGzdz(String gzdz)
    {
        this.gzdz = gzdz;
    }

    public String getZddz()
    {
        return zddz;
    }

    public void setZddz(String zddz)
    {
        this.zddz = zddz;
    }

    public String getGddz()
    {
        return gddz;
    }

    public void setGddz(String gddz)
    {
        this.gddz = gddz;
    }

    public String getGzdk()
    {
        return gzdk;
    }

    public void setGzdk(String gzdk)
    {
        this.gzdk = gzdk;
    }

    public String getZddk()
    {
        return zddk;
    }

    public void setZddk(String zddk)
    {
        this.zddk = zddk;
    }

    public String getGddk()
    {
        return gddk;
    }

    public void setGddk(String gddk)
    {
        this.gddk = gddk;
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

    public String getRemark()
    {
        return remark;
    }

    public void setRemark(String remark)
    {
        this.remark = remark;
    }

    public String getXgsj()
    {
        return xgsj;
    }

    public void setXgsj(String xgsj)
    {
        this.xgsj = xgsj;
    }

    public String getXgr()
    {
        return xgr;
    }

    public void setXgr(String xgr)
    {
        this.xgr = xgr;
    }

    public String getName()
    {
        return Name;
    }

    public void setName(String name)
    {
        Name = name;
    }

    public String getByqId()
    {
        return byqId;
    }

    public void setByqId(String byqId)
    {
        this.byqId = byqId;
    }
}
