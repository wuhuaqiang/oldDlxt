package com.kylin.electricassistsys.utility;

import com.alibaba.fastjson.JSON;
import org.apache.calcite.linq4j.Linq4j;

import java.util.List;

/**
 * Created by hhq on 2017/11/15.
 * 根据实体生成Jqgrid表格脚本
 */
public class JQGridHelper
{
    public static <T> String bulidJqGirdScript(String title, List<T> entityList,  List<CustomField> customFields, String prmNames,int buttonAuthority)
    {
        StringBuilder jqGridScript = new StringBuilder();
        customFields = Linq4j.asEnumerable(customFields).toList();
        //数据源
        String gridData = JSON.toJSONString(entityList);
        //列设置
        String colModel = JSON.toJSONString(customFields);
        //表头列名
        List<String> names = Linq4j.asEnumerable(customFields).select(c->c.getColName()).toList();
        String colNames = JSON.toJSONString(names);
        jqGridScript.append("jQuery(function ($) {\n            buildJqGrid(");
        jqGridScript.append(gridData);
        jqGridScript.append(",");
        jqGridScript.append(colNames);
        jqGridScript.append(",");
        jqGridScript.append(colModel);
        jqGridScript.append(",'");
        jqGridScript.append(title);
        jqGridScript.append("','");
        jqGridScript.append(prmNames);
        jqGridScript.append("','");
        jqGridScript.append(buttonAuthority);
        jqGridScript.append("');\n});");
        return  jqGridScript.toString();
    }
}
