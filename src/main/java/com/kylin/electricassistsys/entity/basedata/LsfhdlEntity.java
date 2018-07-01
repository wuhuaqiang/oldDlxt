package com.kylin.electricassistsys.entity.basedata;


import com.kylin.electricassistsys.entity.BaseEntity;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Table;
import javax.persistence.Transient;

@NameStyle(Style.normal)
@Table(name="Lsfhdl")
public class LsfhdlEntity extends BaseEntity
{
    /**
     * 年份
     */
    private String year;

    /**
     * 所属区域
     */
    private String qyid;
    /**
     * 所属区域中文
     */
    @Transient
    private String qyname;

    /**
     * 供区类型
     */
    private String gqlx;
    /**
     * 供区类型中文
     */
    @Transient
    private String gqlxname;


    /**
     * 网供最大负荷
     */
    private float maximumload;

    /**
     * 网供最大负荷发生时刻
     */
    private float maximumloadtime;


    /**
     * 全社会用电量（亿千瓦时）
     */
    private float allsocietyydl;


    /**
     * 第一产业用电量（亿千瓦时）
     */
    private float firstindustryydl;


    /**
     * 第二产业用电量（亿千瓦时）
     */
    private float secondindustryydl;

    /**
     * 第三产业用电量（亿千瓦时
     */
    private float thirdindustryydl;

    /**
     * 居民用电量（亿千瓦时）
     */
    private float residentydl;

    /**
     * 农业用电量
     */
    private float farmingydl;

    /**
     * 林业用电量
     */
    private float forestryydl;

    /**
     * 牧业用电量
     */
    private float stockraisingydl;

    /**
     * 副业用电量
     */
    private float avocationydl;

    /**
     * 信息行业
     */
    private float fisheryydl;

    /**
     * 工业用电量
     */
    private float industryydl;

    /**
     * 商业用电量
     */
    private float businessydl;

    /**
     * 网供电量
     */
    private float netsPowerSupply;

    /**
     * 公共事业
     */
    private float monthmaximumload;

    /**
     * 供电负荷
     */
    private float supplload;

    public String getYear()
    {
        return year;
    }

    public void setYear(String year)
    {
        this.year = year;
    }

    public String getQyid()
    {
        return qyid;
    }

    public void setQyid(String qyid)
    {
        this.qyid = qyid;
    }

    public String getQyname()
    {
        return qyname;
    }

    public void setQyname(String qyname)
    {
        this.qyname = qyname;
    }

    public String getGqlx()
    {
        return gqlx;
    }

    public void setGqlx(String gqlx)
    {
        this.gqlx = gqlx;
    }

    public String getGqlxname()
    {
        return gqlxname;
    }

    public void setGqlxname(String gqlxname)
    {
        this.gqlxname = gqlxname;
    }

    public float getMaximumload()
    {
        return maximumload;
    }

    public void setMaximumload(float maximumload)
    {
        this.maximumload = maximumload;
    }

    public float getMaximumloadtime()
    {
        return maximumloadtime;
    }

    public void setMaximumloadtime(float maximumloadtime)
    {
        this.maximumloadtime = maximumloadtime;
    }

    public float getAllsocietyydl()
    {
        return allsocietyydl;
    }

    public void setAllsocietyydl(float allsocietyydl)
    {
        this.allsocietyydl = allsocietyydl;
    }

    public float getFirstindustryydl()
    {
        return firstindustryydl;
    }

    public void setFirstindustryydl(float firstindustryydl)
    {
        this.firstindustryydl = firstindustryydl;
    }

    public float getSecondindustryydl()
    {
        return secondindustryydl;
    }

    public void setSecondindustryydl(float secondindustryydl)
    {
        this.secondindustryydl = secondindustryydl;
    }

    public float getThirdindustryydl()
    {
        return thirdindustryydl;
    }

    public void setThirdindustryydl(float thirdindustryydl)
    {
        this.thirdindustryydl = thirdindustryydl;
    }

    public float getResidentydl()
    {
        return residentydl;
    }

    public void setResidentydl(float residentydl)
    {
        this.residentydl = residentydl;
    }

    public float getFarmingydl()
    {
        return farmingydl;
    }

    public void setFarmingydl(float farmingydl)
    {
        this.farmingydl = farmingydl;
    }

    public float getForestryydl()
    {
        return forestryydl;
    }

    public void setForestryydl(float forestryydl)
    {
        this.forestryydl = forestryydl;
    }

    public float getStockraisingydl()
    {
        return stockraisingydl;
    }

    public void setStockraisingydl(float stockraisingydl)
    {
        this.stockraisingydl = stockraisingydl;
    }

    public float getAvocationydl()
    {
        return avocationydl;
    }

    public void setAvocationydl(float avocationydl)
    {
        this.avocationydl = avocationydl;
    }

    public float getFisheryydl()
    {
        return fisheryydl;
    }

    public void setFisheryydl(float fisheryydl)
    {
        this.fisheryydl = fisheryydl;
    }

    public float getIndustryydl()
    {
        return industryydl;
    }

    public void setIndustryydl(float industryydl)
    {
        this.industryydl = industryydl;
    }

    public float getBusinessydl()
    {
        return businessydl;
    }

    public void setBusinessydl(float businessydl)
    {
        this.businessydl = businessydl;
    }

    public float getNetsPowerSupply()
    {
        return netsPowerSupply;
    }

    public void setNetsPowerSupply(float netsPowerSupply)
    {
        this.netsPowerSupply = netsPowerSupply;
    }

    public float getMonthmaximumload()
    {
        return monthmaximumload;
    }

    public void setMonthmaximumload(float monthmaximumload)
    {
        this.monthmaximumload = monthmaximumload;
    }

    public float getSupplload()
    {
        return supplload;
    }

    public void setSupplload(float supplload)
    {
        this.supplload = supplload;
    }
}
