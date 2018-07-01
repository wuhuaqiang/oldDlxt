package com.kylin.electricassistsys.entity.facility;


/**
 * 设备-变压器
 */
public class ByqEntity
{
    /**
     * 主键jgNf
     */
    private String yxid;

    /**
     * 提取的运行数据时间点
     */
    private String yxnf;


    /**
     * 类别，有功 无功 电流
     */
    private String yxtype;

    /**
     * 数据值
     */
    private String yxvalue;

    /**
     * --提取类别，A点，B点cmType varchar2(10), --高、中、低 哪侧
     */
    private String tqtype;

    /**
     * --高、中、低 哪侧
     */
    private String cmtype;

    /**
     * 提取时间
     */
    private String tqshijian;

    /**
     * open3000设备编号
     */
    private String sbid;

    /**
     * 厂站编号
     */
    private String bdzid;


    /**
     * 备注
     */
    private String remark;

    public String getYxid()
    {
        return yxid;
    }

    public void setYxid(String yxid)
    {
        this.yxid = yxid;
    }

    public String getYxnf()
    {
        return yxnf;
    }

    public void setYxnf(String yxnf)
    {
        this.yxnf = yxnf;
    }

    public String getYxtype()
    {
        return yxtype;
    }

    public void setYxtype(String yxtype)
    {
        this.yxtype = yxtype;
    }

    public String getYxvalue()
    {
        return yxvalue;
    }

    public void setYxvalue(String yxvalue)
    {
        this.yxvalue = yxvalue;
    }

    public String getTqtype()
    {
        return tqtype;
    }

    public void setTqtype(String tqtype)
    {
        this.tqtype = tqtype;
    }

    public String getCmtype()
    {
        return cmtype;
    }

    public void setCmtype(String cmtype)
    {
        this.cmtype = cmtype;
    }

    public String getTqshijian()
    {
        return tqshijian;
    }

    public void setTqshijian(String tqshijian)
    {
        this.tqshijian = tqshijian;
    }

    public String getSbid()
    {
        return sbid;
    }

    public void setSbid(String sbid)
    {
        this.sbid = sbid;
    }

    public String getBdzid()
    {
        return bdzid;
    }

    public void setBdzid(String bdzid)
    {
        this.bdzid = bdzid;
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
