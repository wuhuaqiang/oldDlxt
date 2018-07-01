package com.kylin.electricassistsys.entity;

import com.kylin.electricassistsys.utility.FieldMeta;
import com.kylin.electricassistsys.utility.TagType;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Threecolors on 2017/11/17.
 */
@NameStyle(Style.normal)
public class BaseEntity
{
    @Id
    @FieldMeta(description = "ID",editTagType = TagType.NONE,show = false,search = false, isExport = false,isImport = false)
    private String id;

    @Transient
    @FieldMeta(description = "操作",editTagType = TagType.NONE,index = 100,search = false, isExport = false,isImport = false)
    private String operate;

//    @FieldMeta(description = "添加时间",editTagType = TagType.NONE,index = 100, show = false,search = false, isExport = false,isImport = false)
//    private Date addTime;

    @FieldMeta(description = "修改时间",editTagType = TagType.NONE,index = 100, show = false,search = false, isExport = false,isImport = false)
    private Date updateTime;

    public String getOperate()
    {
        return operate;
    }

    public void setOperate(String operate)
    {
        this.operate = operate;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

//    public Date getAddTime()
//    {
//        return addTime;//==null? new Date():addTime;
//    }
//
//    public void setAddTime(Date addTime)
//    {
//        this.addTime = addTime;
//    }

    public Date getUpdateTime()
    {
        return updateTime;//==null? new Date():updateTime;
    }

    public void setUpdateTime(Date updateTime)
    {
        this.updateTime = updateTime;
    }
}
