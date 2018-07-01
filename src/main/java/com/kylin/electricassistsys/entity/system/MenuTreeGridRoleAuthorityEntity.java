package com.kylin.electricassistsys.entity.system;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Threecolors on 2017/12/11.
 */
public class MenuTreeGridRoleAuthorityEntity extends MenuEntity
{
    private String state = "open";
    private String lookCheckBox="";
    private String addCheckBox="";
    private String deleteCheckBox="";
    private String modifyCheckBox="";
    private String queryCheckBox="";
    private String importCheckBox="";
    private String exportCheckBox="";

    private List<MenuTreeGridRoleAuthorityEntity> children = new ArrayList<>();

    public String getLookCheckBox()
    {
        return lookCheckBox;
    }

    public void setLookCheckBox(String lookCheckBox)
    {
        this.lookCheckBox = lookCheckBox;
    }

    public String getAddCheckBox()
    {
        return addCheckBox;
    }

    public void setAddCheckBox(String addCheckBox)
    {
        this.addCheckBox = addCheckBox;
    }

    public String getDeleteCheckBox()
    {
        return deleteCheckBox;
    }

    public void setDeleteCheckBox(String deleteCheckBox)
    {
        this.deleteCheckBox = deleteCheckBox;
    }

    public String getModifyCheckBox()
    {
        return modifyCheckBox;
    }

    public void setModifyCheckBox(String modifyCheckBox)
    {
        this.modifyCheckBox = modifyCheckBox;
    }

    public String getQueryCheckBox()
    {
        return queryCheckBox;
    }

    public void setQueryCheckBox(String queryCheckBox)
    {
        this.queryCheckBox = queryCheckBox;
    }

    public String getImportCheckBox()
    {
        return importCheckBox;
    }

    public void setImportCheckBox(String importCheckBox)
    {
        this.importCheckBox = importCheckBox;
    }

    public String getExportCheckBox()
    {
        return exportCheckBox;
    }

    public void setExportCheckBox(String exportCheckBox)
    {
        this.exportCheckBox = exportCheckBox;
    }

    public List<MenuTreeGridRoleAuthorityEntity> getChildren()
    {
        return children;
    }

    public void setChildren(List<MenuTreeGridRoleAuthorityEntity> children)
    {
        this.children = children;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }
}
