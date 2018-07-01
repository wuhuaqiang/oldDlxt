package com.kylin.electricassistsys.utility;

import com.kylin.electricassistsys.service.KeyValueService;
import org.apache.calcite.linq4j.Linq4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Threecolors on 2017/11/19.
 */
@Service
public class QueryFormHelper {
    private static String QUERY_BUTTON = " <button type=\"button\" class=\"btn btn-primary btn-sm\" style=\"margin-right: 10px\" id=\"btnSearch\">\n" + "            <i class=\"icon-search  align-center  icon-on-left\"></i>查询</button>";
    private static String ADD_BUTTON = "<button type=\"button\" class=\"btn btn-primary btn-sm\" style=\"margin-right: 10px\" id=\"btnAdd\">\n" + "            <span class=\"icon-plus-sign align-center  icon-on-left\"></span>新增</button>";
    private static String EXPORT_BUTTON = "<button type=\"button\" class=\"btn btn-primary btn-sm\" style=\"margin-right: 10px\" id=\"btnExport\">\n" + "            <span class=\"icon-cloud-download align-center  icon-on-left\"></span>导出</a>";
    private static String IMPORT_BUTTON = "<button type=\"button\" class=\"btn btn-primary btn-sm\" style=\"margin-right: 10px\" id=\"btnImport\">\n" + "            <span class=\"icon-cloud-upload align-center  icon-on-left\"></span>导入</button>";
    private static String LABLE_FOR = "<label for=\"%s\">%s：</label>";
    private static String INPUT_TEXT = "<input type=\"text\" name=\"%s\" class=\"add_input\"/>";
    private static String SELECT = "<select name=\"%s\" class=\"chosen-select\" style=\"width: 180px\">\n" + "%s" + "        </select>";
    private static String SELECT_OPTION = "<option value=\"%s\">%s</option>";
    @Autowired
    private KeyValueService keyValueService;

    private static String buidElements(List<UIElement> elements) {
        String elementsStr = "";
        for (UIElement element : elements) {
            elementsStr += buidElement(element);
        }

        return elementsStr;
    }

    private static String buidElement(UIElement element) {
        String elementStr = String.format(LABLE_FOR, element.getId(), element.getLbTxt());

        switch (element.getTagType()) {
            case INPUT_TEXT:
                elementStr += buildInputText(element);
                break;
            case SELECT:
                elementStr += buildSelect(element);
                break;
            default:
                return "";
        }
        return elementStr;
    }

    private static String buildInputText(UIElement element) {
        String inputText = String.format(INPUT_TEXT, element.getName());
        return inputText + "&nbsp;";
    }

    private static String buildSelect(UIElement element) {
        String select = "";
        if (element.getOptionMap().size() > 0) {
            String options = "";
            for (String key : element.getOptionMap().keySet()) {
                options += String.format(SELECT_OPTION, key, element.getOptionMap().get(key));
            }

            select += String.format(SELECT, element.getName(), options);
        }

        return select + "&nbsp;&nbsp;&nbsp;";
    }

    public String bulidQueryForm(List<CustomField> customFields, int buttonAuthority) {
        customFields = Linq4j.asEnumerable(customFields).where(a -> a.isQueryField()).toList();
        List<UIElement> elements = new ArrayList<>();
        System.out.println("**********************************************");
        System.out.println(customFields);
        System.out.println("**********************************************");
        for (CustomField customField : customFields) {
            UIElement uiElement = new UIElement(customField.getEditTagType(), customField.getColName(), customField.getName());
            System.out.println(uiElement);
            if (customField.getEditTagType().equals(TagType.SELECT)) {
                uiElement.setOptionMap(keyValueService.getKeyValueMap(customField.getKeyValueType()));
            }
            elements.add(uiElement);
        }
        String queryForm = "";
        if (elements.size() > 0) {
            queryForm += "<form id=\"queryForm\">";
            if ((buttonAuthority & AuthorityType.QUERY.getIndex()) > 0 && elements.size() > 0) {
                queryForm += buidElements(elements);
                queryForm += QUERY_BUTTON;
            }

            if ((buttonAuthority & AuthorityType.ADD.getIndex()) > 0) {
                queryForm += ADD_BUTTON;
            }
            if ((buttonAuthority & AuthorityType.EXPORT.getIndex()) > 0) {
                queryForm += EXPORT_BUTTON;
            }

            if ((buttonAuthority & AuthorityType.IMPORT.getIndex()) > 0) {
                queryForm += IMPORT_BUTTON;
            }

            queryForm += "</form>";
        }
        return queryForm;
    }
}
