package com.kylin.electricassistsys.entity.facility;


/**
 * 光伏信息
 */
public class GfxxEntity
{
    /**
     * 主键
     */
    private String id;

    /**
     * 电厂名称
     */
    private String name;

    /**
     * 年份
     */
    private String year;

    /**
     * 并网容量
     */
    private String bwrl;

    /**
     * 并网台数
     */
    private String bwts;

    /**
     * 容量构成
     */
    private String rlgc;

    /**
     * 投运时间
     */
    private String tysj;

    /**
     * 并网线路
     */
    private String bwxl;

    /**
     * 年发电量
     */
    private String nfdl;

    /**
     * 计划发电量
     */
    private String jhfdl;

    /**
     * 实际发电量
     */
    private String sjfdl;

    /**
     * 发电设备平均利用小时数
     */
    private String fdsb;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getYear()
    {
        return year;
    }

    public void setYear(String year)
    {
        this.year = year;
    }

    public String getBwrl()
    {
        return bwrl;
    }

    public void setBwrl(String bwrl)
    {
        this.bwrl = bwrl;
    }

    public String getBwts()
    {
        return bwts;
    }

    public void setBwts(String bwts)
    {
        this.bwts = bwts;
    }

    public String getRlgc()
    {
        return rlgc;
    }

    public void setRlgc(String rlgc)
    {
        this.rlgc = rlgc;
    }

    public String getTysj()
    {
        return tysj;
    }

    public void setTysj(String tysj)
    {
        this.tysj = tysj;
    }

    public String getBwxl()
    {
        return bwxl;
    }

    public void setBwxl(String bwxl)
    {
        this.bwxl = bwxl;
    }

    public String getNfdl()
    {
        return nfdl;
    }

    public void setNfdl(String nfdl)
    {
        this.nfdl = nfdl;
    }

    public String getJhfdl()
    {
        return jhfdl;
    }

    public void setJhfdl(String jhfdl)
    {
        this.jhfdl = jhfdl;
    }

    public String getSjfdl()
    {
        return sjfdl;
    }

    public void setSjfdl(String sjfdl)
    {
        this.sjfdl = sjfdl;
    }

    public String getFdsb()
    {
        return fdsb;
    }

    public void setFdsb(String fdsb)
    {
        this.fdsb = fdsb;
    }
}
