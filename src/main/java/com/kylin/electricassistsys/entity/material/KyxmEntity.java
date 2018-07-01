package com.kylin.electricassistsys.entity.material;


import com.kylin.electricassistsys.entity.BaseEntity;
import com.kylin.electricassistsys.utility.FieldMeta;
import com.kylin.electricassistsys.utility.TagType;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Table;

@NameStyle(Style.normal)
@Table(name="Kyxm")
public class KyxmEntity extends BaseEntity
{
    @FieldMeta(description = "项目名称",index =1, editTagType = TagType.NONE)
    private String xmid;

    @FieldMeta(description = "项目名称",index =1,queryField = true, editTagType = TagType.NONE)
    private String xmmc;

    @FieldMeta(description = "变电站",index =2)
    private String bdzId;

    @FieldMeta(description = "变电站",index =2)
    private String bdzName;

    @FieldMeta(description = "附件",index =3)
    private String fj;

    @FieldMeta(description = "备注",index =4)
    private String remark;
}
