package com.kylin.electricassistsys.entity.facility;


/**
 * 中压联络线
 */
public class ZyxLlxEntity
{
    /**
     * 主键
     */
    private String id;

    /**
     * 起点线路名称
     */
    private String bid;

    /**
     * 终点线路名称
     */
    private String eid;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getBid()
    {
        return bid;
    }

    public void setBid(String bid)
    {
        this.bid = bid;
    }

    public String getEid()
    {
        return eid;
    }

    public void setEid(String eid)
    {
        this.eid = eid;
    }
}
