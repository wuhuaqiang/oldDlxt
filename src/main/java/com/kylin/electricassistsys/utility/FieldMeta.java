package com.kylin.electricassistsys.utility;

import com.kylin.electricassistsys.entity.enumparam.KeyValueType;

import java.lang.annotation.*;

/**
 * Created by Threecolors on 2017/11/30.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Documented
public @interface FieldMeta
{
    /**
     * 排序
     */
    int index() default 0;

    /**
     * 是否在列表显示
     */
    boolean show() default true;
    /**
     * 是否查询字段
     */
    boolean queryField() default  false;

    /**
     * 是否查询标签类型
     */
    TagType editTagType() default TagType.INPUT_TEXT;


    /**
     * TagType.SELECT 数据源类型
     */
    KeyValueType keyValueType() default KeyValueType.NONE;

    /**
     * 表头
     */
    String description() default  "";

    /**
     * 表头宽度
     */
    int width() default  150;

    /**
     * 是否可以排序
     */
    boolean sortable() default true;

    /**
     * 排序类型
     */
    String sorttype() default "string";

    /**
     * 是否居中
     */
    String align() default  "center";

    /**
     * 是否可以搜索
     */
    boolean search() default true;

    /**
     * 是否必填
     */
    boolean required() default false;


    /**
     * @return 是否导出字段
     */
    boolean isExport() default true;

    /**
     * @return 是否导入字段
     */
    boolean isImport() default true;
}
