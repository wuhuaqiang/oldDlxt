package com.kylin.electricassistsys.entity.system;

import com.kylin.electricassistsys.entity.enumparam.MenuType;
import com.kylin.electricassistsys.entity.enumparam.Status;
import com.kylin.electricassistsys.utility.HierarchicalEntity;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 系统菜单实体
 */
@NameStyle(Style.normal)
@Table(name="Menu")
public class MenuEntity extends HierarchicalEntity
{
    private String url = "";

    private String iconName ="icon-dashboard";

    private String type="";

    private String status="";

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public String getIconName()
    {
        return iconName;
    }

    public void setIconName(String iconName)
    {
        this.iconName = iconName;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }
}
