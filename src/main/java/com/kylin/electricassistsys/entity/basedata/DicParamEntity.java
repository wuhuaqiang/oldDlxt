package com.kylin.electricassistsys.entity.basedata;

import com.kylin.electricassistsys.entity.BaseEntity;
import com.kylin.electricassistsys.entity.enumparam.KeyValueType;
import com.kylin.electricassistsys.entity.enumparam.Status;
import com.kylin.electricassistsys.utility.FieldMeta;
import com.kylin.electricassistsys.utility.TagType;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Table;
import java.util.Date;

/**
 * Created by Threecolors on 2017/11/17.
 */
@NameStyle(Style.normal)
@Table(name = "DicParam")
public class DicParamEntity extends BaseEntity {
    @NotBlank(message = "必填项")
    @Length(max = 20, message = "20位以内字符")
    @FieldMeta(description = "名称", index = 1, queryField = true, required = true)
    private String name = "";

    @NotBlank(message = "必填项")
    @FieldMeta(description = "状态", index = 2, editTagType = TagType.SELECT, keyValueType = KeyValueType.STATUS, required = true)
    private String status = "";

    @FieldMeta(description = "备注", index = 3, editTagType = TagType.TEXTAREA)
    private String remark = "";

    @FieldMeta(description = "类型", index = 4, isExport = false, show = false, editTagType = TagType.NONE)
    private Integer type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTypeTxt() {
        return DicParamType.getName(this.type);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
