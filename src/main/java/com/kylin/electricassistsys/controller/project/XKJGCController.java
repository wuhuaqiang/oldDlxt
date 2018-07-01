package com.kylin.electricassistsys.controller.project;

import com.kylin.electricassistsys.controller.BaseController;
import com.kylin.electricassistsys.entity.AutoBuilderParam;
import com.kylin.electricassistsys.entity.enumparam.KeyValueType;
import com.kylin.electricassistsys.entity.project.XkjGcEntity;
import com.kylin.electricassistsys.service.KeyValueService;
import com.kylin.electricassistsys.service.project.XKJGCService;
import com.kylin.electricassistsys.utility.CustomField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Threecolors on 2017/12/28.
 */
@Controller
@RequestMapping("/project/xkjgc")
public class XKJGCController extends BaseController<XkjGcEntity, XKJGCService>
{
    @Autowired
    KeyValueService keyValueService;

    @Autowired
    public void setService(XKJGCService service)
    {
        setBaseService(service);
    }

    @Autowired
    private void setAutoBuilderParam()
    {
        AutoBuilderParam autoBuilderParam =new AutoBuilderParam("新扩建工程", "/project/xkjgc", "500px", "1200px", 1);
        this.setAutoBuilderParam(autoBuilderParam);
    }

    protected  String getEditUrl()
    {
        return "project/xkjgcEdit";
    }

    protected  void buildEdit(Model model, XkjGcEntity entity,String type)
    {
        HashMap<String, String> cnws = keyValueService.getKeyValueMap(KeyValueType.CNW);
        model.addAttribute("cnws", cnws);

        HashMap<String, String>  ywdws = keyValueService.getKeyValueMap(KeyValueType.GDGS);
        model.addAttribute("ywdws", ywdws);

        HashMap<String, String>  gqlxs = keyValueService.getKeyValueMap(KeyValueType.SUPPLY_ZONE_TYPE);
        model.addAttribute("gqlxs", gqlxs);

        HashMap<String, String>  qys = keyValueService.getKeyValueMap(KeyValueType.QY);
        model.addAttribute("qys", qys);

        HashMap<String, String> voltages = keyValueService.getKeyValueMap(KeyValueType.VOLTAGE);
        model.addAttribute("voltages", voltages);

        model.addAttribute("entity",entity);
        model.addAttribute("autoBuilderParam", autoBuilderParam);
    }

    /**
     * 构建列表构建Model
     *
     * @param model
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    protected void buildListModel(Model model,String type) throws IllegalAccessException, InstantiationException
    {
        List<CustomField> customFields = service.getCustomFields(null);
        buildQueryForm(model, customFields);
        buildJGrid(model, customFields);
        model.addAttribute("autoBuilderParam", autoBuilderParam);
        model.addAttribute("type",4);
    }
}