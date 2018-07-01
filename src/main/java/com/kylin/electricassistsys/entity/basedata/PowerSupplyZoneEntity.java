package com.kylin.electricassistsys.entity.basedata;

import com.kylin.electricassistsys.entity.BaseEntity;
import com.kylin.electricassistsys.entity.enumparam.AdministrativeLevel;
import com.kylin.electricassistsys.entity.enumparam.KeyValueType;
import com.kylin.electricassistsys.utility.FieldMeta;
import com.kylin.electricassistsys.utility.HierarchicalEntity;
import com.kylin.electricassistsys.utility.TagType;
import org.hibernate.validator.constraints.NotBlank;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Table;
import javax.validation.constraints.Pattern;

/**
 * Created by Threecolors on 2017/11/17.
 * 供电分区实体
 */
@NameStyle(Style.normal)
@Table(name="PowerSupplyZone")
public class PowerSupplyZoneEntity extends BaseEntity
{
    @Pattern(regexp="^[a-zA-Z0-9_\\u4e00-\\u9fa5]{1,20}$",message="汉字、数字和字母构成20位以内字符")
    @FieldMeta(description = "供区名称", index = 1, queryField = true,required = true)
    private String name ="";

    @NotBlank(message = "必填项")
    @FieldMeta(description = "供区级别",index = 2, editTagType = TagType.SELECT,keyValueType= KeyValueType.ADMINISTRATIVE_LEVEL,required = true)
    private String administrativeLevel = "";

    @FieldMeta(description = "备注",index = 5, show=false,editTagType =TagType.TEXTAREA)
    private String remark="";

    public String getAdministrativeLevel()
    {
        return administrativeLevel;
    }


    public void setAdministrativeLevel(String administrativeLevel)
    {
        this.administrativeLevel = administrativeLevel;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
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
