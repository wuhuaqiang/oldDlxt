package com.kylin.electricassistsys.entity.facility;


/**
 * 联络线历史
 */
public class LlxLsEntity
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

    /**
     * 修改时间
     */
    private String updata;


    /**
     * 修改人
     * <p>
     * 出表后 更改条件
     */
    private String upuser;

    /**
     * 修改人中文
     * <p>
     * 出表后 更改条件
     */
    private String name;

    /**
     * 第几次修改
     */
    private int cishu;

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

    public String getUpdata()
    {
        return updata;
    }

    public void setUpdata(String updata)
    {
        this.updata = updata;
    }

    public String getUpuser()
    {
        return upuser;
    }

    public void setUpuser(String upuser)
    {
        this.upuser = upuser;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getCishu()
    {
        return cishu;
    }

    public void setCishu(int cishu)
    {
        this.cishu = cishu;
    }
}
