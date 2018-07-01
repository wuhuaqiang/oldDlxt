package com.kylin.electricassistsys.controller.system;

import com.kylin.electricassistsys.controller.BaseController;
import com.kylin.electricassistsys.entity.AutoBuilderParam;
import com.kylin.electricassistsys.entity.ProcessResult;
import com.kylin.electricassistsys.entity.log.AuditEventType;
import com.kylin.electricassistsys.entity.system.MenuEntity;
import com.kylin.electricassistsys.entity.system.MenuTreeGridEntity;
import com.kylin.electricassistsys.entity.system.MenuTreeGridRoleAuthorityEntity;
import com.kylin.electricassistsys.entity.system.UserSetRoleEntity;
import com.kylin.electricassistsys.mapper.system.MenuMapper;
import com.kylin.electricassistsys.service.system.MenuService;
import com.kylin.electricassistsys.utility.CustomField;
import com.kylin.electricassistsys.utility.HierarchicalEntity;
import com.kylin.electricassistsys.utility.StringHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;

/**
 * 菜单控制器
 */
@Controller
@RequestMapping("/system/menu")
public class MenuController extends BaseController<MenuEntity,MenuService>
{
    @Autowired
    private void setService(MenuService service)
    {
        setBaseService(service);
    }

    @Autowired
    private void setAutoBuilderParam()
    {
        AutoBuilderParam autoBuilderParam = new AutoBuilderParam("菜单信息", "/system/menu","500px","900px",1);
        this.setAutoBuilderParam(autoBuilderParam);
    }

    @Autowired
    protected void setAuditEventType()
    {
        this.auditEventType = AuditEventType.SYS_EVENT;
    }

    protected String getListUrl()
    {
        return "system/menulist";
    }

    protected String getEditUrl()
    {
        return "system/menuedit";
    }

    protected void buildListModel(Model model,
                                  String type) throws IllegalAccessException, InstantiationException
    {
        try
        {
            List<HierarchicalEntity> hierarchicalEntityList = service.getSelectHierarchical("");
            HierarchicalEntity firsHierarchicalEntity = new HierarchicalEntity();
            firsHierarchicalEntity.setName("---所有功能---");
            firsHierarchicalEntity.setId("");
            firsHierarchicalEntity.setPreId("");
            hierarchicalEntityList.add(0, firsHierarchicalEntity);
            model.addAttribute("hierarchicalEntityList", hierarchicalEntityList);
            model.addAttribute("preId", "");
        }
        catch (Exception ex)
        {
            String s = ex.getMessage();
        }
    }

    @ResponseBody
    @RequestMapping("/getTreeGridData")
    public List<MenuTreeGridEntity> getTreeGridData(@RequestParam(value = "id", required = false, defaultValue = "") String id, @RequestParam(value = "status", required = false, defaultValue = "-1") String status, Model model)
    {
        List<MenuTreeGridEntity> menuTreeGridEntityList = service.getMenuTree(id, status);
        return menuTreeGridEntityList;
    }

    @ResponseBody
    @RequestMapping("/queryTreeGridData")
    public List<MenuTreeGridEntity> queryTreeGridData(@RequestParam(value = "id", required = false, defaultValue = "") String id, @RequestParam(value = "status", required = false, defaultValue = "") String status, Model model)
    {
        List<MenuTreeGridEntity> menuTreeGridEntityList = service.queryMenuTree(id, status);
        return menuTreeGridEntityList;
    }

    @ResponseBody
    @RequestMapping("/getAllMenuTreeForAuthority")
    public List<MenuTreeGridRoleAuthorityEntity> getAllMenuTreeForAuthority(@RequestParam(value = "roleId") String roleId)
    {
        List<MenuTreeGridRoleAuthorityEntity> menuTreeGridEntityList = service.getAllMenuTreeForAuthority(roleId);
        return menuTreeGridEntityList;
    }

    @RequestMapping("/roleSetAuthority")
    public String roleSetAuthority(@RequestParam(value = "roleId") String roleId,Model model)
    {
        model.addAttribute("roleId",roleId);
        return "system/roleSetAuthority";
    }

    protected void buildEdit(HttpServletRequest request,
                             Model model,
                             MenuEntity entity,
                             String type)
    {
        List<HierarchicalEntity> hierarchicalEntityList = service.getSelectHierarchical("");
        HierarchicalEntity firsHierarchicalEntity = new HierarchicalEntity();
        firsHierarchicalEntity.setName("---系统菜单---");
        firsHierarchicalEntity.setId("");
        firsHierarchicalEntity.setPreId("");
        hierarchicalEntityList.add(0, firsHierarchicalEntity);

        model.addAttribute("menu", entity);
        model.addAttribute("hierarchicalEntityList", hierarchicalEntityList);
        model.addAttribute("autoBuilderParam", this.autoBuilderParam);
    }

    @ResponseBody
    @RequestMapping("/setSort")
    public ProcessResult setSort(String id,String type)
    {
        ProcessResult processResult = new ProcessResult();
        processResult.setSuccess(service.setSort(id,type));
        return processResult;
    }

    @ResponseBody
    @RequestMapping("/leftTee")
    public String leftMenuTee()
    {
        return  service.getLeftMenuTree();
    }
}
