package com.kylin.electricassistsys.entity.facility;


/**
 * 开闭所信息
 */
public class KbsEntity
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
    private int dydjName;


    /**
     * 供区类型
     */
    private String gqlxid;

    /**
     * 供区类型中文
     */
    private String gqlxidName;

    /**
     * 区域
     */
    private String gdqyid;

    /**
     * 区域中文
     */
    private String gdqyName;


    /**
     * 变电站编号
     */
    private String num;

    /**
     * 变电站名称
     */
    private String bdzName;


    /**
     * 变电站属性
     */
    private String syfs;

    /**
     * 变电站属性中文
     */
    private String syfsName;

    /**
     * 城农网
     */
    private String cnw;

    /**
     * 城农网中文
     */
    private String cnwName;

    /**
     * 投运时间
     */
    private String btysj;

    /**
     * 运行状态
     */
    private String yxzt;

    /**
     * 220kV出线间隔总数
     */
    private String cxjg220kv;

    /**
     * 110kV出线间隔总数
     */
    private String cxjg110kv;

    /**
     * 35kV出线间隔总数
     */
    private String cxjg35kv;

    /**
     * 10kV出线间隔总数
     */
    private String cxjg10kv;

    /**
     * 已用220kV出线间隔总数
     */
    private String yy220kv;

    /**
     * 已用110kV出线间隔总数
     */
    private String yy110kv;

    /**
     * 已用110kV出线间隔总数
     */
    private String yy35kv;

    /**
     * 已用10kV出线间隔总数
     */
    private String yy10kv;

    /**
     * 退役时间
     */
    private String etysj;

    /**
     * 安装形式
     */
    private String azxs;

    /**
     * 安装形式中文
     */
    private String name;

    /**
     * 运维单位
     */
    private String ywdw;

    /**
     * 运维单位中文
     */
    private String dwmz;


    /**
     * 占地面积(公顷)
     */
    private String zdmj;

    /**
     * 坐标
     */
    private String zb;


    /**
     * 高压侧主接线1
     */
    private String gyczjx1;

    /**
     * 高压侧主接线2
     */
    private String gyczjx2;

    /**
     * 高压侧主接线3
     */
    private String gyczjx3;

    /**
     * 中压侧主接线
     */
    private String zyczjx1;

    /**
     * 中压侧主接线
     */
    private String zyczjx2;

    /**
     * 中压侧主接线
     */
    private String zyczjx3;

    /**
     * 低压侧主接线
     */
    private String dyczjx1;

    /**
     * 低压侧主接线
     */
    private String dyczjx2;

    /**
     * 低压侧主接线
     */
    private String dyczjx3;


    /**
     * 变电站地址
     */
    private String dz;

    /**
     满足N-1
     */
    private String n_1;

    /**
     * 电网结构
     */
    private String dwjg;

    /**
     * 断路器
     */
    private String dlq;


    /**
     * 备注
     */
    private String remark;

    public String getN_1()
    {
        return n_1;
    }

    public void setN_1(String n_1)
    {
        this.n_1 = n_1;
    }

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

    public int getDydjName()
    {
        return dydjName;
    }

    public void setDydjName(int dydjName)
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

    public String getGqlxidName()
    {
        return gqlxidName;
    }

    public void setGqlxidName(String gqlxidName)
    {
        this.gqlxidName = gqlxidName;
    }

    public String getGdqyid()
    {
        return gdqyid;
    }

    public void setGdqyid(String gdqyid)
    {
        this.gdqyid = gdqyid;
    }

    public String getGdqyName()
    {
        return gdqyName;
    }

    public void setGdqyName(String gdqyName)
    {
        this.gdqyName = gdqyName;
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

    public String getCnw()
    {
        return cnw;
    }

    public void setCnw(String cnw)
    {
        this.cnw = cnw;
    }

    public String getCnwName()
    {
        return cnwName;
    }

    public void setCnwName(String cnwName)
    {
        this.cnwName = cnwName;
    }

    public String getBtysj()
    {
        return btysj;
    }

    public void setBtysj(String btysj)
    {
        this.btysj = btysj;
    }

    public String getYxzt()
    {
        return yxzt;
    }

    public void setYxzt(String yxzt)
    {
        this.yxzt = yxzt;
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

    public String getEtysj()
    {
        return etysj;
    }

    public void setEtysj(String etysj)
    {
        this.etysj = etysj;
    }

    public String getAzxs()
    {
        return azxs;
    }

    public void setAzxs(String azxs)
    {
        this.azxs = azxs;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
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

    public String getDz()
    {
        return dz;
    }

    public void setDz(String dz)
    {
        this.dz = dz;
    }

    public String getDwjg()
    {
        return dwjg;
    }

    public void setDwjg(String dwjg)
    {
        this.dwjg = dwjg;
    }

    public String getDlq()
    {
        return dlq;
    }

    public void setDlq(String dlq)
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
}
