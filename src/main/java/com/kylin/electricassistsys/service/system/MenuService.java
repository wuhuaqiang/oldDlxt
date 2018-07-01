package com.kylin.electricassistsys.service.system;

import com.kylin.electricassistsys.entity.enumparam.FunctionType;
import com.kylin.electricassistsys.entity.enumparam.MenuType;
import com.kylin.electricassistsys.entity.enumparam.Status;
import com.kylin.electricassistsys.entity.system.MenuEntity;
import com.kylin.electricassistsys.entity.system.MenuTreeGridEntity;
import com.kylin.electricassistsys.entity.system.MenuTreeGridRoleAuthorityEntity;
import com.kylin.electricassistsys.entity.system.RoleAuthorityEntity;
import com.kylin.electricassistsys.mapper.system.MenuMapper;
import com.kylin.electricassistsys.service.BaseService;
import com.kylin.electricassistsys.service.system.CustomSecurity.CustomGrantedAuthority;
import com.kylin.electricassistsys.service.system.CustomSecurity.CustomInvocationSecurityMetadataSourceService;
import com.kylin.electricassistsys.utility.AuthorityType;
import com.kylin.electricassistsys.utility.HierarchicalEntity;
import com.kylin.electricassistsys.utility.SelectHierarchicalHelper;
import com.kylin.electricassistsys.utility.StringHelper;
import org.apache.calcite.linq4j.Linq4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Collection;
import java.util.List;


/**
 * 菜单服务类
 */
@Service
public class MenuService extends BaseService<MenuEntity>
{
    private MenuMapper mapper;

    @Autowired
    public void setMapper(MenuMapper mapper)
    {
        this.mapper = mapper;
        setBaseMapper(mapper);
    }

    @Autowired
    private RoleAuthorityService roleAuthorityService;

    @Autowired
    CustomInvocationSecurityMetadataSourceService customInvocationSecurityMetadataSourceService;

    public List<MenuTreeGridEntity> getMenuTreeGridEntityList(){
        List<MenuTreeGridEntity> menus=mapper.getAllMenus();
        return menus;
    }

    public boolean insertSelective (MenuEntity menu){
        if(mapper.insertSelective(menu)==1)
        {
            customInvocationSecurityMetadataSourceService.loadResourceDefine();
            return true;
        }
        return false;
    }

    public int deleteByIds(String[] ids)
    {
        int count = super.deleteByIds(ids);
        if(count>0)
        {
            customInvocationSecurityMetadataSourceService.loadResourceDefine();
        }

        return count;
    }

    public boolean setSort(String id, String type){
        mapper.setSort(id,type);
        return true;
    }

    public boolean updateByPrimaryKeySelective(MenuEntity menu){
        if(mapper.updateByPrimaryKeySelective(menu)==1)
        {
            customInvocationSecurityMetadataSourceService.loadResourceDefine();
            return true;
        }
        return false;
    }

    public MenuEntity getEntityById(String id){
        MenuEntity menu=mapper.getMenuById(id);
        return menu;
    }

    public List<MenuEntity> selectAllEnable()
    {
        Example example = new Example(MenuEntity.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("status","有效");
        criteria.andNotEqualTo("type",MenuType.MAIN.getName());
        criteria.andIsNotNull("url");
        return this.mapper.selectByExample(example);
    }

    /**获取菜单树数据
     * @return
     */
    public List<MenuTreeGridRoleAuthorityEntity>  getAllMenuTreeForAuthority(String roleId)
    {
        List<MenuTreeGridRoleAuthorityEntity> menuList= null;
        List<MenuTreeGridRoleAuthorityEntity> dataSource = this.mapper.getAllMenuTreeGridRoleAuthority();
        //筛选状态
        dataSource = Linq4j.asEnumerable(dataSource).where(a->a.getStatus().equals(Status.VALID.getName())).toList();

        //一级父菜单
        menuList = Linq4j.asEnumerable(dataSource).where(a->a.getType().equals(MenuType.MAIN.getName())).toList();

        //角色权限
        List<RoleAuthorityEntity> roleAuthorityEntities =roleAuthorityService.getRoleAuthorityByRoleId(roleId);

        buildChildrenListForAuthority(menuList, dataSource,roleAuthorityEntities);

        return menuList;
    }

    private void buildChildrenListForAuthority(List<MenuTreeGridRoleAuthorityEntity> preList, List<MenuTreeGridRoleAuthorityEntity> dataSource,List<RoleAuthorityEntity> roleAuthorityEntities)
    {
        for(MenuTreeGridRoleAuthorityEntity entity : preList)
        {
            List<MenuTreeGridRoleAuthorityEntity> newPreList = Linq4j.asEnumerable(dataSource).where(a->a.getPreId().equals(entity.getId())).toList();
            //List<MenuTreeGridRoleAuthorityEntity> newPreList = Linq4j.asEnumerable(dataSource).where(a->a.getType().equals(MenuType.SUB.getName())&&a.getPreId().equals(entity.getId())).toList();
            buildChildrenListForAuthority(newPreList,dataSource,roleAuthorityEntities);
            entity.setChildren(newPreList);
            buidAuthoritySetting( entity,roleAuthorityEntities);
        }
    }

    private  void buidAuthoritySetting(MenuTreeGridRoleAuthorityEntity menuTreeGridRoleAuthorityEntity,List<RoleAuthorityEntity> roleAuthorityEntities)
    {
        String checkStr = "<input type='checkbox' name='%s' value='%s' id='%s' style='display: inline-block;'/><label for='%s'>%s</label>";
        RoleAuthorityEntity roleAuthorityEntity = Linq4j.asEnumerable(roleAuthorityEntities).firstOrDefault(a->a.getMenuId().equals(menuTreeGridRoleAuthorityEntity.getId()));
        menuTreeGridRoleAuthorityEntity.setName(String.format(checkStr,"ckNavi",menuTreeGridRoleAuthorityEntity.getId(),menuTreeGridRoleAuthorityEntity.getId(),menuTreeGridRoleAuthorityEntity.getId(),menuTreeGridRoleAuthorityEntity.getName()));
        buidAuthorityButton(menuTreeGridRoleAuthorityEntity,roleAuthorityEntity);
    }
    private void buidAuthorityButton(MenuTreeGridRoleAuthorityEntity menuTreeGridRoleAuthorityEntity,RoleAuthorityEntity roleAuthorityEntity)
    {
        String checkStr = "<input type='checkbox' name='ckButtonQx' %s value='%s' style='display: inline-block;'/>";
        int methods =roleAuthorityEntity==null?0: roleAuthorityEntity.getMethods();

        if ((methods&FunctionType.VIEW.getIndex())>0)
        {
            menuTreeGridRoleAuthorityEntity.setLookCheckBox(String.format(checkStr,"checked='checked'",menuTreeGridRoleAuthorityEntity.getId()+"|"+FunctionType.VIEW.getIndex()));
        }
        else
        {
            menuTreeGridRoleAuthorityEntity.setLookCheckBox(String.format(checkStr,"",menuTreeGridRoleAuthorityEntity.getId()+"|"+FunctionType.VIEW.getIndex()));
        }


        if(menuTreeGridRoleAuthorityEntity.getType().equals(MenuType.SUB.getName())&& !StringUtils.isEmpty(menuTreeGridRoleAuthorityEntity.getUrl()))
        {
            if ((methods&FunctionType.ADD.getIndex())>0)
            {
                menuTreeGridRoleAuthorityEntity.setAddCheckBox(String.format(checkStr,"checked='checked'",menuTreeGridRoleAuthorityEntity.getId()+"|"+FunctionType.ADD.getIndex()));
            }
            else
            {
                menuTreeGridRoleAuthorityEntity.setAddCheckBox(String.format(checkStr,"",menuTreeGridRoleAuthorityEntity.getId()+"|"+FunctionType.ADD.getIndex()));
            }

            if ((methods&FunctionType.DELETE.getIndex())>0)
            {
                menuTreeGridRoleAuthorityEntity.setDeleteCheckBox(String.format(checkStr,"checked='checked'",menuTreeGridRoleAuthorityEntity.getId()+"|"+FunctionType.DELETE.getIndex()));
            }
            else
            {
                menuTreeGridRoleAuthorityEntity.setDeleteCheckBox(String.format(checkStr,"",menuTreeGridRoleAuthorityEntity.getId()+"|"+FunctionType.DELETE.getIndex()));
            }

            if ((methods&FunctionType.MODIFY.getIndex())>0)
            {
                menuTreeGridRoleAuthorityEntity.setModifyCheckBox(String.format(checkStr,"checked='checked'",menuTreeGridRoleAuthorityEntity.getId()+"|"+FunctionType.MODIFY.getIndex()));
            }
            else
            {
                menuTreeGridRoleAuthorityEntity.setModifyCheckBox(String.format(checkStr,"",menuTreeGridRoleAuthorityEntity.getId()+"|"+FunctionType.MODIFY.getIndex()));
            }

            if ((methods&FunctionType.QUERY.getIndex())>0)
            {
                menuTreeGridRoleAuthorityEntity.setQueryCheckBox(String.format(checkStr,"checked='checked'",menuTreeGridRoleAuthorityEntity.getId()+"|"+FunctionType.QUERY.getIndex()));
            }
            else
            {
                menuTreeGridRoleAuthorityEntity.setQueryCheckBox(String.format(checkStr,"",menuTreeGridRoleAuthorityEntity.getId()+"|"+FunctionType.QUERY.getIndex()));
            }

            if ((methods&FunctionType.IMPORT.getIndex())>0)
            {
                menuTreeGridRoleAuthorityEntity.setImportCheckBox(String.format(checkStr,"checked='checked'",menuTreeGridRoleAuthorityEntity.getId()+"|"+FunctionType.IMPORT.getIndex()));
            }
            else
            {
                menuTreeGridRoleAuthorityEntity.setImportCheckBox(String.format(checkStr,"",menuTreeGridRoleAuthorityEntity.getId()+"|"+FunctionType.IMPORT.getIndex()));
            }

            if ((methods&FunctionType.EXPORT.getIndex())>0)
            {
                menuTreeGridRoleAuthorityEntity.setExportCheckBox(String.format(checkStr,"checked='checked'",menuTreeGridRoleAuthorityEntity.getId()+"|"+FunctionType.EXPORT.getIndex()));
            }
            else
            {
                menuTreeGridRoleAuthorityEntity.setExportCheckBox(String.format(checkStr,"",menuTreeGridRoleAuthorityEntity.getId()+"|"+FunctionType.EXPORT.getIndex()));
            }
        }
    }


    public List<MenuTreeGridEntity> queryMenuTree(String id, String status)
    {
        List<MenuTreeGridEntity> menuList= null;
        List<MenuTreeGridEntity> dataSource = this.getMenuTreeGridEntityList();
        //筛选状态
        if(!StringHelper.isNullOrWhiteSpace(status))
        {
            dataSource = Linq4j.asEnumerable(dataSource).where(a->a.getStatus().equals(status)).toList();
        }

        if(StringHelper.isNullOrWhiteSpace(id))
        {
            //一级父菜单
            menuList = Linq4j.asEnumerable(dataSource).where(a->a.getType().equals(MenuType.MAIN.getName())).toList();
            buildList(menuList, dataSource);
        }
        else
        {
            //获取当前菜单
            menuList = Linq4j.asEnumerable(dataSource).where(a->a.getId().equals(id)).toList();
            for(MenuTreeGridEntity entity : menuList)
            {
                List<MenuTreeGridEntity> childList = Linq4j.asEnumerable(dataSource).where(a->a.getPreId().equals(entity.getId())).toList();
                for (MenuTreeGridEntity child: childList)
                {
                    child.setOperate(buildOperate(child.getId()));
                }
                entity.setOperate(buildOperate(entity.getId()));
                entity.setChildren(childList);
            }
        }

        return menuList;
    }

    /**获取菜单树数据
     * @param id
     * @param status
     * @return
     */
    public List<MenuTreeGridEntity>  getMenuTree(String id, String status)
    {
        List<MenuTreeGridEntity> menuList= null;
        List<MenuTreeGridEntity> dataSource = this.getMenuTreeGridEntityList();
        //筛选状态
        if(StringHelper.isNullOrWhiteSpace(id))
        {
            dataSource = Linq4j.asEnumerable(dataSource).where(a->a.getStatus().equals(status)).toList();
        }

        if(StringHelper.isNullOrWhiteSpace(id))
        {
            //一级父菜单
            menuList = Linq4j.asEnumerable(dataSource).where(a->a.getType().equals(MenuType.MAIN.getName())).toList();
        }
        else
        {
            //子菜单
            menuList = Linq4j.asEnumerable(dataSource).where(a->a.getPreId().equals(id)).toList();
        }

        buildList(menuList, dataSource);

        return menuList;
    }

    private void buildList(List<MenuTreeGridEntity> preList, List<MenuTreeGridEntity> dataSource)
    {
        for(MenuTreeGridEntity entity : preList)
        {
            List<MenuTreeGridEntity> newPreList = Linq4j.asEnumerable(dataSource).where(a->a.getPreId().equals(entity.getId())).toList();
            if(newPreList.size()>0)
            {
                entity.setState("closed");
            }
            entity.setOperate(buildOperate(entity.getId()));
        }
    }

    private void buildChildrenList(List<MenuTreeGridEntity> preList, List<MenuTreeGridEntity> dataSource)
    {
        for(MenuTreeGridEntity entity : preList)
        {
            List<MenuTreeGridEntity> newPreList = Linq4j.asEnumerable(dataSource).where(a->a.getType().equals(MenuType.SUB.getName())&&a.getPreId().equals(entity.getId())).toList();
             buildChildrenList(newPreList,dataSource);
            if(newPreList.size()>0)
            {
                entity.setState("closed");
            }
            entity.setOperate(buildOperate(entity.getId()));
            entity.setChildren(newPreList);
        }
    }

    private String buildOperate(String id)
    {
        String content = "<a onclick=\"UpOrDown('%s','down')\" ><div class='ui-pg-div' style=\"display: inline\"><span class='ui-icon icon-download blue'></span></div></a>"
                + "<a onclick=\"UpOrDown('%s','up')\" ><div class='ui-pg-div' style=\"display: inline\"><span class='ui-icon icon-upload blue'></span></div></a>"
                +"<a onclick=\"updateMenu('%s')\"><div class='ui-pg-div' style=\"display: inline\"><span class='ui-icon icon-pencil blue'></span></div></a>"
                +"<a onclick=\"Del('%s')\"><div class='ui-pg-div' style=\"display: inline\"><span class='ui-icon icon-trash red'></span></div></a>";
        return String.format(content,id,id,id,id);
    }

    /**获取下拉框分层
     * @return 分层集合
     */
    public List<HierarchicalEntity> getSelectHierarchical(String preId)
    {
        List<MenuTreeGridEntity> menus=mapper.getAllMenus();
        menus = Linq4j.asEnumerable(menus).where(a->a.getStatus().equals(Status.VALID.getName())).toList();
        return SelectHierarchicalHelper.buildHierarchicalData(preId,menus);
    }


    /**获取左侧菜单
     * @return
     */
    public String getLeftMenuTree()
    {
        StringBuilder sb = new StringBuilder();
        List<MenuTreeGridEntity> dataSource = this.getMenuTreeGridEntityList();
        //筛选有效状态,且具有查看权限的菜单
        dataSource = Linq4j.asEnumerable(dataSource).where(a->a.getStatus().equals(Status.VALID.getName())&&this.isViewAuthority(a)).toList();

        List<MenuTreeGridEntity> preMenuList = Linq4j.asEnumerable(dataSource).where(a->a.getType().equals(MenuType.MAIN.getName())).toList();
        for(MenuTreeGridEntity preMenu : preMenuList)
        {
            List<MenuTreeGridEntity> subMenuList = Linq4j.asEnumerable(dataSource).where(a->a.getType().equals(MenuType.SUB.getName())&&a.getPreId().equals(preMenu.getId())).toList();
            if(subMenuList.size()>0)
            {
                sb.append("<li ><a href=\"javascript:void(0);\" class=\"dropdown-toggle mainBiu\"><i class=\"" + preMenu.getIconName() + "\"></i><span class=\"menu-text\">" + preMenu.getName() + " </span><b class=\"arrow icon-angle-down\"></b></a>");
                sb.append(getLeftSubTree(subMenuList, dataSource, 1));
                sb.append("</li>");
            }
            else
                {
                    sb.append("<li><a class=\"mainBiu\" href=\"javascript:void(0);\"  url=\"" + preMenu.getUrl() + "\" icon=\"" + preMenu.getIconName() + "\"><i class=\"" + preMenu.getIconName() + "\"></i><span class=\"menu-text\">" + preMenu.getName() + " </span></a></li>");
                }
        }

        return  sb.toString();
    }

    private String getLeftSubTree(List<MenuTreeGridEntity> preMenuList, List<MenuTreeGridEntity> dataSource, int level)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("<ul class=\"submenu\">");
        for(MenuTreeGridEntity entity : preMenuList)
        {
            if (entity.getType().equals(MenuType.SUB.getName()))
            {
                List<MenuTreeGridEntity> subMenuList = Linq4j.asEnumerable(dataSource).where(a->a.getType().equals(MenuType.SUB.getName())&&a.getPreId().equals(entity.getId())).toList();
                if (subMenuList.size() > 0)
                {
                    sb.append("<li ><a  href=\"javascript:void(0);\" class=\"dropdown-toggle biu\" href=\"#\"><i class=\"icon-double-angle-right\"></i><span class=\"menu-text\">" + entity.getName() + " </span><b class=\"arrow icon-angle-down\"></b></a>");
                    sb.append(getLeftSubTree(subMenuList, dataSource, level + 1));
                    sb.append("</li>");
                }
                else
                {
                    if (level == 1)
                        sb.append("<li><a href=\"javascript:void(0);\" class=\"biu\" url=\"" + entity.getUrl() + "\" icon=\"" + entity.getIconName() + "\"><i class=\"icon-double-angle-right\"></i><span class=\"menu-text\">" + entity.getName() + " </span></a></li>");
                    else
                        sb.append("<li><a href=\"javascript:void(0);\" class=\"biu\" url=\"" + entity.getUrl() + "\" icon=\"" + entity.getIconName()+ "\"><i class=\"active\"></i><span class=\"menu-text\">" + entity.getName() + " </span></a></li>");
                }
            }
        }
        sb.append("</ul>");
        return sb.toString();
    }

    protected boolean isViewAuthority(MenuTreeGridEntity entity)
    {
        String key = StringHelper.isNullOrEmpty(entity.getUrl())?entity.getId():entity.getUrl();
        Collection<CustomGrantedAuthority> grantedAuthorityList = (Collection<CustomGrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        CustomGrantedAuthority customGrantedAuthority = Linq4j.asEnumerable(grantedAuthorityList).firstOrDefault(a->a.getPermissionUrl().equals(key));
        if(customGrantedAuthority==null)
        {
            return  false;
        }
        return (customGrantedAuthority.getMethod()& AuthorityType.VIEW.getIndex())>0;
    }
}
