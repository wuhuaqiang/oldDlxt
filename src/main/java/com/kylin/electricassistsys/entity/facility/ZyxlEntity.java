package com.kylin.electricassistsys.entity.facility;


/**
 * 设备-中压线路
 */
public class ZyxlEntity
{
    /**
     * 主键jgNf
     */
    private String glid;

    /**
     * open3000设备编号
     */
    private String opensbid;

    /**
     * open3000设备名称
     */
    private String opensbname;

    /**
     * open3000厂站编号
     */
    private String id;

    /**
     * 设备类型 变压器，变电站 ，交流线路 ， 中压线路
     */
    private String sbtype;

    /**
     * 关联设备
     */
    private String mysbid;

    /**
     * 关联设备
     */
    private String xlmc;

    /**
     * 关联日期
     */
    private String sbgltime;

    /**
     * 关联类型 手动，自动
     */
    private String gltype;


    /**
     * 备注
     */
    private String remark;

    public String getGlid()
    {
        return glid;
    }

    public void setGlid(String glid)
    {
        this.glid = glid;
    }

    public String getOpensbid()
    {
        return opensbid;
    }

    public void setOpensbid(String opensbid)
    {
        this.opensbid = opensbid;
    }

    public String getOpensbname()
    {
        return opensbname;
    }

    public void setOpensbname(String opensbname)
    {
        this.opensbname = opensbname;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getSbtype()
    {
        return sbtype;
    }

    public void setSbtype(String sbtype)
    {
        this.sbtype = sbtype;
    }

    public String getMysbid()
    {
        return mysbid;
    }

    public void setMysbid(String mysbid)
    {
        this.mysbid = mysbid;
    }

    public String getXlmc()
    {
        return xlmc;
    }

    public void setXlmc(String xlmc)
    {
        this.xlmc = xlmc;
    }

    public String getSbgltime()
    {
        return sbgltime;
    }

    public void setSbgltime(String sbgltime)
    {
        this.sbgltime = sbgltime;
    }

    public String getGltype()
    {
        return gltype;
    }

    public void setGltype(String gltype)
    {
        this.gltype = gltype;
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
