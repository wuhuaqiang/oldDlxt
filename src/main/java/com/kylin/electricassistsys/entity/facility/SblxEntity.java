package com.kylin.electricassistsys.entity.facility;


/**
 * 设备类型
 */
public class SblxEntity
{
    /**
     * 主键
     */
    private String id;

    /**
     * 单位名称
     */
    private String name;

    /**
     * 编号
     */
    private String bh;

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

    public String getBh()
    {
        return bh;
    }

    public void setBh(String bh)
    {
        this.bh = bh;
    }
}
