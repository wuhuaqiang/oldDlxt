package com.kylin.electricassistsys.entity.basedata;

import com.kylin.electricassistsys.entity.BaseEntity;

import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Created by Threecolors on 2017/11/29.
 */
@Table(name="Dqgkxx")
public class DqgkxxEntity extends BaseEntity
{
    /**
     * 数据年月
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
     * 土地面积
     */
    private float tdmj;

    /**
     * 年末总人口
     */
    @Transient
    private float nmzrk;

    /**
     * 人口密度
     */
    @Transient
    private float rkmd;

    /**
     * 年平均气温
     */
    private float npjqw;


    /**
     * 经度
     */
    private float jd;

    /**
     * 纬度
     */
    private float wd;

    /**
     * 城市人口
     */
    private float csrk;

    /**
     * 农村人口
     */
    private float ncrk;

    /**
     * 平均最高气温
     */
    private float pjzgqw;

    /**
     * 平均最低气温
     */
    private float pjzdqw;

    /**
     * 建成区面积
     */
    private float jcqmj;

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

    public float getTdmj()
    {
        return tdmj;
    }

    public void setTdmj(float tdmj)
    {
        this.tdmj = tdmj;
    }

    public float getNmzrk()
    {
        return this.ncrk+this.csrk;
    }

    public float getRkmd()
    {
        return this.nmzrk/tdmj;
    }

    public float getNpjqw()
    {
        return npjqw;
    }

    public void setNpjqw(float npjqw)
    {
        this.npjqw = npjqw;
    }

    public float getJd()
    {
        return jd;
    }

    public void setJd(float jd)
    {
        this.jd = jd;
    }

    public float getWd()
    {
        return wd;
    }

    public void setWd(float wd)
    {
        this.wd = wd;
    }

    public float getCsrk()
    {
        return csrk;
    }

    public void setCsrk(float csrk)
    {
        this.csrk = csrk;
    }

    public float getNcrk()
    {
        return ncrk;
    }

    public void setNcrk(float ncrk)
    {
        this.ncrk = ncrk;
    }

    public float getPjzgqw()
    {
        return pjzgqw;
    }

    public void setPjzgqw(float pjzgqw)
    {
        this.pjzgqw = pjzgqw;
    }

    public float getPjzdqw()
    {
        return pjzdqw;
    }

    public void setPjzdqw(float pjzdqw)
    {
        this.pjzdqw = pjzdqw;
    }

    public float getJcqmj()
    {
        return jcqmj;
    }

    public void setJcqmj(float jcqmj)
    {
        this.jcqmj = jcqmj;
    }
}
