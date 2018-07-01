package com.kylin.electricassistsys.entity.facility;


/**
 * 变电站历史信息
 */
public class BdzlsEntity
{
    /**
     * 主键
     */
    private String id;

    /**
     * 变电站主键
     */
    private String bdzId;

    /**
     * 电压等级
     * <p>
     * 出表后 更改条件
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
    private String gdqyId;

    /**
     * 所属区域中文
     */
    private String gdqyName;

    /**
     * 年份
     */
    private String year;

    /**
     * 变电站编号
     */
    private String num;

    /**
     * 变电站名称
     */
    private String bdzName;

    /**
     * 变电站地址
     */
    private String dz;

    /**
     * 使用方式
     */
    private String syfs;

    /**
     * 城农网
     */
    private String cnw;

    /**
     * 主变总容量（MVA）
     */
    private String zbzrl;

    /**
     * 变压器数量(台)
     */
    private String byqsl;

    /**
     * 容量构成
     */
    private String rlgc;

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
     * 高压侧电压等级
     */
    private String gycdydj;

    /**
     * 中压侧电压等级
     */
    private String zycdydj;

    /**
     * 低压侧电压等级
     */
    private String dycdydj;

    /**
     * 220kv出线间隔总数
     */
    private String cxjg220kv;

    /**
     * 110kv出线间隔总数
     */
    private String cxjg110kv;

    /**
     * 35kv出线间隔总数
     */
    private String cxjg35kv;

    /**
     * 10kv出线间隔总数
     */
    private String cxjg10kv;

    /**
     * 已用220kv出线间隔总数
     */
    private String yy220kv;

    /**
     * 已用110kv出线间隔总数
     */
    private String yy110kv;

    /**
     * 已用35kv出线间隔总数
     */
    private String yy35kv;

    /**
     * 已用10kv出线间隔总数
     */
    private String yy10kv;

    /**
     * 投运时间
     */
    private String btysj;

    /**
     * 运维单位
     */
    private String ywdw;

    /**
     * 安装形式
     */
    private String azxs;

    /**
     * 占地面积(公顷)
     */
    private String zdmj;

    /**
     * 坐标
     */
    private String zb;

    /**
     * 供电公司
     */
    private String gdgs;

    /**
     * 高压配电装置类型
     */
    private String gypdzzlb;

    /**
     * 退役时间
     */
    private String etysj;

    /**
     * 运行状态
     */
    private String yxzt;

    /**
     * 接线图纸
     */
    private String jxtz;

    /**
     * 操作人
     * <p>
     * 出表后 更改条件
     */
    private String xgr;

    /**
     * 操作人中文
     * <p>
     * 出表后 更改条件
     */
    private String name;


    private String xgsj;

    /**
     * 备注
     */
    private String remark;

    /**
     * 高压侧主换线
     */
    private String gyczjx1;

    /**
     * 高压侧主换线
     */
    private String gyczjx2;

    /**
     * 高压侧主换线
     */
    private String gyczjx3;

    /**
     * 中压侧主换线
     */
    private String zyczjx1;

    /**
     * 中压侧主换线
     */
    private String zyczjx2;

    /**
     * 中压侧主换线
     */
    private String zyczjx3;

    /**
     * 低压侧主换线
     */
    private String dyczjx1;

    /**
     * 低压侧主换线
     */
    private String dyczjx2;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getBdzId()
    {
        return bdzId;
    }

    public void setBdzId(String bdzId)
    {
        this.bdzId = bdzId;
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

    public String getGdqyId()
    {
        return gdqyId;
    }

    public void setGdqyId(String gdqyId)
    {
        this.gdqyId = gdqyId;
    }

    public String getGdqyName()
    {
        return gdqyName;
    }

    public void setGdqyName(String gdqyName)
    {
        this.gdqyName = gdqyName;
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

    public String getBdzName()
    {
        return bdzName;
    }

    public void setBdzName(String bdzName)
    {
        this.bdzName = bdzName;
    }

    public String getDz()
    {
        return dz;
    }

    public void setDz(String dz)
    {
        this.dz = dz;
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

    public String getZbzrl()
    {
        return zbzrl;
    }

    public void setZbzrl(String zbzrl)
    {
        this.zbzrl = zbzrl;
    }

    public String getByqsl()
    {
        return byqsl;
    }

    public void setByqsl(String byqsl)
    {
        this.byqsl = byqsl;
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

    public String getBtysj()
    {
        return btysj;
    }

    public void setBtysj(String btysj)
    {
        this.btysj = btysj;
    }

    public String getYwdw()
    {
        return ywdw;
    }

    public void setYwdw(String ywdw)
    {
        this.ywdw = ywdw;
    }

    public String getAzxs()
    {
        return azxs;
    }

    public void setAzxs(String azxs)
    {
        this.azxs = azxs;
    }

    public String getZdmj()
    {
        return zdmj;
    }

    public void setZdmj(String zdmj)
    {
        this.zdmj = zdmj;
    }

    public String getZb()
    {
        return zb;
    }

    public void setZb(String zb)
    {
        this.zb = zb;
    }

    public String getGdgs()
    {
        return gdgs;
    }

    public void setGdgs(String gdgs)
    {
        this.gdgs = gdgs;
    }

    public String getGypdzzlb()
    {
        return gypdzzlb;
    }

    public void setGypdzzlb(String gypdzzlb)
    {
        this.gypdzzlb = gypdzzlb;
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

    public String getJxtz()
    {
        return jxtz;
    }

    public void setJxtz(String jxtz)
    {
        this.jxtz = jxtz;
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
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getXgsj()
    {
        return xgsj;
    }

    public void setXgsj(String xgsj)
    {
        this.xgsj = xgsj;
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

    public String getGyczjx2()
    {
        return gyczjx2;
    }

    public void setGyczjx2(String gyczjx2)
    {
        this.gyczjx2 = gyczjx2;
    }

    public String getGyczjx3()
    {
        return gyczjx3;
    }

    public void setGyczjx3(String gyczjx3)
    {
        this.gyczjx3 = gyczjx3;
    }

    public String getZyczjx1()
    {
        return zyczjx1;
    }

    public void setZyczjx1(String zyczjx1)
    {
        this.zyczjx1 = zyczjx1;
    }

    public String getZyczjx2()
    {
        return zyczjx2;
    }

    public void setZyczjx2(String zyczjx2)
    {
        this.zyczjx2 = zyczjx2;
    }

    public String getZyczjx3()
    {
        return zyczjx3;
    }

    public void setZyczjx3(String zyczjx3)
    {
        this.zyczjx3 = zyczjx3;
    }

    public String getDyczjx1()
    {
        return dyczjx1;
    }

    public void setDyczjx1(String dyczjx1)
    {
        this.dyczjx1 = dyczjx1;
    }

    public String getDyczjx2()
    {
        return dyczjx2;
    }

    public void setDyczjx2(String dyczjx2)
    {
        this.dyczjx2 = dyczjx2;
    }

    public String getDyczjx3()
    {
        return dyczjx3;
    }

    public void setDyczjx3(String dyczjx3)
    {
        this.dyczjx3 = dyczjx3;
    }

    /**
     * 低压侧主换线
     */
    private String dyczjx3;


}
