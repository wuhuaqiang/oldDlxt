package com.kylin.electricassistsys.entity.facility;


/**
 * 装机组成
 */
public class ZJZCEntity
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
     * 台数
     */
    private String ts;

    /**
     * 容量(MW)
     */
    private String rl;

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

    public String getTs()
    {
        return ts;
    }

    public void setTs(String ts)
    {
        this.ts = ts;
    }

    public String getRl()
    {
        return rl;
    }

    public void setRl(String rl)
    {
        this.rl = rl;
    }
}
