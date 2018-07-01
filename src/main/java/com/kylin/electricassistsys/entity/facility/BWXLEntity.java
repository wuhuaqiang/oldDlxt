package com.kylin.electricassistsys.entity.facility;


/**
 * 并网线路
 */
public class BWXLEntity
{
    /**
     * 主键
     */
    private String id;

    /**
     * 电源信息编号
     */
    private String dyxxId;
    /**
     * 电源信息编号中文
     */
    private String bwdymc;

    /**
     * 并网电压等级编号
     */
    private String bwdydj;

    /**
     * 电源信息编号中文
     */
    private int name;

    /**
     * 并网线路名称
     */
    private String bwxlmc;

    /**
     * 并网容量(MW)
     */
    private String bwrl;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getDyxxId()
    {
        return dyxxId;
    }

    public void setDyxxId(String dyxxId)
    {
        this.dyxxId = dyxxId;
    }

    public String getBwdymc()
    {
        return bwdymc;
    }

    public void setBwdymc(String bwdymc)
    {
        this.bwdymc = bwdymc;
    }

    public String getBwdydj()
    {
        return bwdydj;
    }

    public void setBwdydj(String bwdydj)
    {
        this.bwdydj = bwdydj;
    }

    public int getName()
    {
        return name;
    }

    public void setName(int name)
    {
        this.name = name;
    }

    public String getBwxlmc()
    {
        return bwxlmc;
    }

    public void setBwxlmc(String bwxlmc)
    {
        this.bwxlmc = bwxlmc;
    }

    public String getBwrl()
    {
        return bwrl;
    }

    public void setBwrl(String bwrl)
    {
        this.bwrl = bwrl;
    }
}
