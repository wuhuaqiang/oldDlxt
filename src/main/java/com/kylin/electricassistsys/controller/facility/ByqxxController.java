package com.kylin.electricassistsys.controller.facility;

import com.kylin.electricassistsys.controller.BaseController;
import com.kylin.electricassistsys.controller.BaseController;
import com.kylin.electricassistsys.entity.AutoBuilderParam;
import com.kylin.electricassistsys.entity.enumparam.KeyValueType;
import com.kylin.electricassistsys.entity.facility.BdzxxEntity;
import com.kylin.electricassistsys.entity.facility.ByqxxEntity;
import com.kylin.electricassistsys.service.KeyValueService;
import com.kylin.electricassistsys.service.facility.BdzxxService;
import com.kylin.electricassistsys.service.facility.ByqxxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Threecolors on 2017/12/2.
 */
@Controller
@RequestMapping("/facility/byqxx")
public class ByqxxController extends BaseController<ByqxxEntity,ByqxxService>
{
    @Autowired
    KeyValueService keyValueService;

    @Autowired
    public void setService(ByqxxService service)
    {
        setBaseService(service);
    }

    @Autowired
    private void setAutoBuilderParam()
    {
        AutoBuilderParam autoBuilderParam =new AutoBuilderParam("变压器信息", "/facility/byqxx","600px","1250px",2);
        this.setAutoBuilderParam(autoBuilderParam);
    }

    protected  String getEditUrl()
    {
        return "facility/byqxxEdit";
    }

    protected  void buildEdit(Model model, ByqxxEntity entity,String type)
    {
        //铭牌变比
        HashMap<String,String> mpbbs =  keyValueService.getKeyValueMap(KeyValueType.MPBB);

        //调压方式
        HashMap<String,String> tsfss =  keyValueService.getKeyValueMap(KeyValueType.TYFS);

        //绕组型式
        HashMap<String,String> qys =  keyValueService.getKeyValueMap(KeyValueType.RZXS);

        HashMap<String,String> bdzs = keyValueService.getKeyValueMap(KeyValueType.BDZ);

        model.addAttribute("tsfss",tsfss);
        model.addAttribute("mpbbs",mpbbs);
        model.addAttribute("qys",qys);
        model.addAttribute("bdzs",bdzs);
        model.addAttribute("entity",entity);
        model.addAttribute("autoBuilderParam", autoBuilderParam);
    }
}
