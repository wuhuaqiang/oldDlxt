package com.kylin.electricassistsys.entity.facility;


/**
 * 调度设备关联
 */
public class DDSBEntity
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
     * 电压等级
     */
    private int dydjName;


    /**
     * 设备类型
     */
    private String lx;

    /**
     * 单位设备类型
     */
    private String sblxName;

    /**
     * 调度设备编码
     */
    private String sbbm;

    /**
     * 调度设备名称
     */
    private String sbname;

    /**
     * 调度变电站
     */
    private String sbbdz;

    /**
     * 关联设备名称
     */
    private String glsbname;


    /**
     * 变电站
     */
    private String glbdz;

    /**
     * 变电站中文
     */
    private String glbdzName;

    /**
     * 变电站日期
     */
    private String rq;

    /**
     * 备注
     */
    private String bz;

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

    public String getLx()
    {
        return lx;
    }

    public void setLx(String lx)
    {
        this.lx = lx;
    }

    public String getSblxName()
    {
        return sblxName;
    }

    public void setSblxName(String sblxName)
    {
        this.sblxName = sblxName;
    }

    public String getSbbm()
    {
        return sbbm;
    }

    public void setSbbm(String sbbm)
    {
        this.sbbm = sbbm;
    }

    public String getSbname()
    {
        return sbname;
    }

    public void setSbname(String sbname)
    {
        this.sbname = sbname;
    }

    public String getSbbdz()
    {
        return sbbdz;
    }

    public void setSbbdz(String sbbdz)
    {
        this.sbbdz = sbbdz;
    }

    public String getGlsbname()
    {
        return glsbname;
    }

    public void setGlsbname(String glsbname)
    {
        this.glsbname = glsbname;
    }

    public String getGlbdz()
    {
        return glbdz;
    }

    public void setGlbdz(String glbdz)
    {
        this.glbdz = glbdz;
    }

    public String getGlbdzName()
    {
        return glbdzName;
    }

    public void setGlbdzName(String glbdzName)
    {
        this.glbdzName = glbdzName;
    }

    public String getRq()
    {
        return rq;
    }

    public void setRq(String rq)
    {
        this.rq = rq;
    }

    public String getBz()
    {
        return bz;
    }

    public void setBz(String bz)
    {
        this.bz = bz;
    }
}
