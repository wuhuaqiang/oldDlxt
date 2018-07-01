package com.kylin.electricassistsys.entity.enumparam;

/**
 * Created by Threecolors on 2017/11/30.
 */
public enum  KeyValueType
{
    NONE("未知",0),
    WIRING("接线",1),
    VOLTAGE("电压",2),
    SUPPLY_ZONE_TYPE("供区类型",3),
    CNW("城农网",4),
    SYFS("使用方式",5),
    AZXS("安装形式",6),
    BZFS("布置方式",7),
    GYPDZZLX("高压配电装置类型",8),
    TYFS("调压方式",9),
    CTBV("CT变比",10),
    JSFS("架设方式",11),
    MPBB("铭牌变比",12),
    MPXH("铭牌型号",13),
    XMXZ("项目性质",14),
    XMLX("项目类型",15),
    FSFS("敷设方式",16),
    ZJX("主接线",17),
    ZLLX("资料类型",18),
    DCLX("电厂类型",19),
    RZXS("绕组型式",20),



    OPERATING_STATE("运营状态",200),
    QY("区域",201),
    BDZ("变电站",202),
    GDGS("供电公司",203),
    STATUS("状态",204),
    ADMINISTRATIVE_LEVEL("行政级别",205),
    WIRE_TYPE("导线类型",206),
    DXCS("导线参数",207),
    ZYYH("重要用户",208),
    GYXLXX("高压线路",209);






    private String name;
    private int index;

    KeyValueType(String name, int index)
    {
        this.name = name;
        this.index = index;
    }

    public static String getName(int index)
    {
        for (KeyValueType c : KeyValueType.values())
        {
            if (c.getIndex() == index)
            {
                return c.name;
            }
        }
        return null;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getIndex()
    {
        return index;
    }

    public void setIndex(int index)
    {
        this.index = index;
    }
}
