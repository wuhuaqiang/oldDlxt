package com.kylin.electricassistsys.entity.facility;


/**
 * 电厂信息
 */
public class DcxxEntity
{
    /**
     * 主键
     */
    private String id;

    /**
     * 并网类型
     */
    private String bwlx;

    /**
     * 电源类型中文
     */
    private String dyxxName;

    /**
     * 年份
     */
    private String year;


    /**
     * 并网电源名称
     */
    private String bwdymc;

    /**
     * 装机容量
     */
    private String zjrl;

    /**
     * 装机台数
     */
    private String zjts;

    /**
     * 容量
     */
    private String rl;


    /**
     * 发电年份
     */
    private String nfdl;

    /**
     * 年计划发电量
     */
    private String jhfdl;

    /**
     * 年实际发电量
     */
    private String sjfdl;

    /**
     * 发电设备平均利用小时数
     */
    private String fdsb;

    /**
     * 投运时间
     */
    private String tysj;

    /**
     * 退运时间
     */
    private String tuiysj;


    /**
     * 电压等级
     */
    private String bwdydj;

    /**
     * 电压等级中文
     */
    private int bwdydjName;

    /**
     * 并网线路名称
     */
    private String bwxlmc;

    /**
     * 并网容量
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

    public String getBwlx()
    {
        return bwlx;
    }

    public void setBwlx(String bwlx)
    {
        this.bwlx = bwlx;
    }

    public String getDyxxName()
    {
        return dyxxName;
    }

    public void setDyxxName(String dyxxName)
    {
        this.dyxxName = dyxxName;
    }

    public String getYear()
    {
        return year;
    }

    public void setYear(String year)
    {
        this.year = year;
    }

    public String getBwdymc()
    {
        return bwdymc;
    }

    public void setBwdymc(String bwdymc)
    {
        this.bwdymc = bwdymc;
    }

    public String getZjrl()
    {
        return zjrl;
    }

    public void setZjrl(String zjrl)
    {
        this.zjrl = zjrl;
    }

    public String getZjts()
    {
        return zjts;
    }

    public void setZjts(String zjts)
    {
        this.zjts = zjts;
    }

    public String getRl()
    {
        return rl;
    }

    public void setRl(String rl)
    {
        this.rl = rl;
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

    public String getTysj()
    {
        return tysj;
    }

    public void setTysj(String tysj)
    {
        this.tysj = tysj;
    }

    public String getTuiysj()
    {
        return tuiysj;
    }

    public void setTuiysj(String tuiysj)
    {
        this.tuiysj = tuiysj;
    }

    public String getBwdydj()
    {
        return bwdydj;
    }

    public void setBwdydj(String bwdydj)
    {
        this.bwdydj = bwdydj;
    }

    public int getBwdydjName()
    {
        return bwdydjName;
    }

    public void setBwdydjName(int bwdydjName)
    {
        this.bwdydjName = bwdydjName;
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
