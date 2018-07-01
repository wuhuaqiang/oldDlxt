package com.kylin.electricassistsys.controller.basedata;

import com.kylin.electricassistsys.controller.BaseController;
import com.kylin.electricassistsys.entity.AutoBuilderParam;
import com.kylin.electricassistsys.entity.basedata.DicParamEntity;
import com.kylin.electricassistsys.entity.basedata.DicParamType;
import com.kylin.electricassistsys.service.basedata.DicParamService;
import com.kylin.electricassistsys.utility.CustomField;
import com.kylin.electricassistsys.utility.JQGridColModel;
import com.kylin.electricassistsys.utility.JQGridHelper;
import com.kylin.electricassistsys.utility.StringHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Threecolors on 2017/11/17.
 */
@Controller
@RequestMapping("/basedata/dicparam/{type}")
public class DicParamController extends BaseController<DicParamEntity,DicParamService>
{
    @Autowired
    public void setService(DicParamService service)
    {
        setBaseService(service);
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
        int dicParamType = Integer.parseInt(type);
        DicParamEntity dicParamEntity = new DicParamEntity();
        dicParamEntity.setType(dicParamType);
        String typeName = DicParamType.getName(dicParamType);
        this.autoBuilderParam = new AutoBuilderParam(typeName+"信息", "/basedata/dicparam","300px","500px",1);


        int buttonAuthority = this.getAuthority();
        List<CustomField> customFields = service.getCustomFields(null);
        buildQueryForm(model, customFields);
        List<DicParamEntity> entities = service.getEntitiesByConditionForJGrid(dicParamEntity,buttonAuthority);
        String jGridString = JQGridHelper.bulidJqGirdScript(autoBuilderParam.getTitle() + "列表", entities, customFields, "id",buttonAuthority);
        model.addAttribute("jGrid", jGridString);
        model.addAttribute("autoBuilderParam", autoBuilderParam);
        model.addAttribute("type", dicParamType);
    }

    /**
     * 构建编辑
     *
     * @param model
     * @param entity
     */
    protected void buildEdit(HttpServletRequest request, Model model, DicParamEntity entity, String type)
    {
        int dicParamType = Integer.parseInt(type);
        entity.setType(dicParamType);
        String typeName = DicParamType.getName(dicParamType);
        this.autoBuilderParam = new AutoBuilderParam(typeName+"信息", "/basedata/dicparam","300px","500px",1);
        List<CustomField> customFields = service.getCustomFields(entity);
        String tableContent = editFormHelper.buildEditTable(customFields, autoBuilderParam.getColNum());
        model.addAttribute("tableContent", tableContent);
        model.addAttribute("entity", entity);
        model.addAttribute("autoBuilderParam", autoBuilderParam);
        model.addAttribute("type", entity.getType());
    }
}
