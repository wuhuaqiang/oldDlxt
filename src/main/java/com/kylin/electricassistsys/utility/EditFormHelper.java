package com.kylin.electricassistsys.utility;

import com.kylin.electricassistsys.service.KeyValueService;
import org.apache.calcite.linq4j.Linq4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Threecolors on 2017/11/30.
 */
@Service
public class EditFormHelper
{
    @Autowired
    private KeyValueService keyValueService;

    private static String REQUIRED_SPAN = "<span style=\"color: red;\">*</span>";

    private static String ERRORMSG_SPAN = "<span data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"\" limit=\"6\"  class=\"errorMsgSpan tooltip-show\"  style=\"color: red;text-decoration:none;\"></span>";

    private static String REMARK_TEXTAREA="<textarea name=\"%s\"  style=\"height: 50px!important ; width:80%%;\">%s</textarea>";

    private static String OPER_DIV = " <div style=\"display: inline-block ; margin: 10px auto;\">\n" + "            <input id=\"hidId\" name=\"id\" value=\"%s\" type=\"hidden\"/>\n" + "            <button id=\"btnSave\" type=\"button\" class=\"btn btn-info\"><i class=\"icon-save bigger-110\"></i>保存</button>\n" + "            &nbsp; &nbsp; &nbsp;\n" + "            <button id=\"btnCancel\" type=\"button\" class=\"btn\"><i class=\"icon-undo bigger-110\"></i>取消</button>\n" + "        </div>";

    private static String PER_FIELD_TD = "<th class=\"th\"> %s:</th>\n" + "                            <td class=\"td\" colspan=\"%s\">\n" + "                                %s\n" + "                            </td>";

    private static String NUMBER_INPUT_TEXT = "<input type=\"text\" name=\"%s\" value=\"%s\"  style=\" width:180px;margin-right:-4px;ime-mode:disabled\" onkeyup=\"if(isNaN(value))execCommand('undo')\" onafterpaste=\"if(isNaN(value))execCommand('undo')\"/>\n";

    private static String STRING_INPUT_TEXT = "<input type=\"text\" name=\"%s\" value=\"%s\" style=\" width:180px;margin-right:-4px\" />\n";

    private static String SELECT = "<select name=\"%s\" class=\"chosen-select\" style=\"width: 180px;\">\n" + "%s" + "        </select>";

    private static String SELECT_OPTION = "<option value=\"%s\" %s>%s</option>";

    public  String buildEditTable(List<CustomField> customFields,int colNum)
    {
        String editTable = "<table>";
        customFields = Linq4j.asEnumerable(customFields).where(a->!a.getEditTagType().equals(TagType.NONE)).toList();
        if (customFields.size() > 0)
        {
            editTable += buidRows(customFields,colNum);
        }

        editTable += "</table>";
        return editTable;
    }

    private  String buidRows(List<CustomField> customFields, int colNum)
    {
        String elementsStr = "";
        String element;
        for (int i = 0; i < customFields.size(); i += colNum)
        {
            elementsStr += "<tr>";
            for (int j = 0; j < colNum; j++)
            {
                CustomField field = customFields.get(i + j);
                element = buidElement(field);
                if(field.isRequired())
                {
                    element +=REQUIRED_SPAN;
                }
                element +=ERRORMSG_SPAN;
                int colspan =1;
                if(customFields.size()==i + j+1)
                {
                    colspan=(colNum-j)*2-1;
                }

                elementsStr += String.format(PER_FIELD_TD, field.getColName(),colspan, element);

                if(colspan!=1)
                {
                    break;
                }
            }
            elementsStr += "</tr>";
        }

        return elementsStr;
    }

    private  String buidElement(CustomField field)
    {
        switch (field.getEditTagType())
        {
            case INPUT_TEXT:
                return buildInputText(field);
            case SELECT:
                return buildSelect(field);
            case TEXTAREA:
                return buildTextarea(field);
            default:
                return "";
        }
    }

    private static String buildInputText(CustomField customField)
    {
        String inputText = "";
        if (isNumberType(customField.getField().getType()))
        {
            inputText += String.format(NUMBER_INPUT_TEXT, customField.getName(), customField.getFieldValue());
        } else
        {
            inputText += String.format(STRING_INPUT_TEXT, customField.getName(), customField.getFieldValue());
        }
        return inputText;
    }

    private static boolean isNumberType(Class<?> targetClazz)
    {
        // 判断包装类
        if (Number.class.isAssignableFrom(targetClazz))
        {
            return true;
        }
        // 判断原始类,过滤掉特殊的基本类型
        if (targetClazz == boolean.class || targetClazz == char.class || targetClazz == void.class)
        {
            return false;
        }
        return targetClazz.isPrimitive();
    }

    private  String buildSelect(CustomField customField)
    {
        UIElement element = new UIElement(customField.getEditTagType(), customField.getColName(), customField.getName());
        element.setOptionMap(keyValueService.getKeyValueMap(customField.getKeyValueType()));
        String select = "";
        if (element.getOptionMap().size() > 0)
        {
            String selected;
            String options = "";
            for (String key : element.getOptionMap().keySet())
            {
                selected =  key.equalsIgnoreCase(customField.getFieldValue().toString())?"selected":"";
                options += String.format(SELECT_OPTION, key,selected ,element.getOptionMap().get(key));
            }

            select += String.format(SELECT, element.getName(), options);
        }

        return select;
    }

    private String buildTextarea(CustomField customField)
    {
        return String.format(REMARK_TEXTAREA, customField.getName(), customField.getFieldValue());
    }
}
