package com.kylin.electricassistsys.controller.basedata;

import com.kylin.electricassistsys.controller.BaseController;
import com.kylin.electricassistsys.entity.AutoBuilderParam;
import com.kylin.electricassistsys.entity.basedata.ByqcsEntity;
import com.kylin.electricassistsys.entity.enumparam.KeyValueType;
import com.kylin.electricassistsys.service.KeyValueService;
import com.kylin.electricassistsys.service.basedata.ByqcsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Created by Threecolors on 2017/11/28.
 */
@Controller
@RequestMapping("/basedata/byqcs")
public class ByqcsController extends BaseController<ByqcsEntity,ByqcsService>
{
    @Autowired
    public void setService(ByqcsService service)
    {
        setBaseService(service);
    }

    @Autowired
    private void setAutoBuilderParam()
    {
        AutoBuilderParam autoBuilderParam =new AutoBuilderParam("变压器参数", "/basedata/byqcs", "470px", "1250px", 1);
        this.setAutoBuilderParam(autoBuilderParam);
    }

    @Autowired
    private KeyValueService keyValueService;

    protected  String getEditUrl()
    {
        return "basedata/byqcsEdit";
    }

    protected  void buildEdit(Model model, ByqcsEntity byqcsEntity,String type)
    {
        HashMap<String, String> mpbbs = keyValueService.getKeyValueMap(KeyValueType.MPBB);
        model.addAttribute("mpbbs", mpbbs);

        HashMap<String, String> rzfss = new LinkedHashMap<>();
        model.addAttribute("rzfss", rzfss);

        HashMap<String, String>  tyfss = keyValueService.getKeyValueMap(KeyValueType.TYFS);
        model.addAttribute("tyfss", tyfss);

        HashMap<String, String> voltages = keyValueService.getKeyValueMap(KeyValueType.VOLTAGE);
        model.addAttribute("voltages", voltages);

        model.addAttribute("entity",byqcsEntity);
        model.addAttribute("autoBuilderParam", autoBuilderParam);
    }
}
