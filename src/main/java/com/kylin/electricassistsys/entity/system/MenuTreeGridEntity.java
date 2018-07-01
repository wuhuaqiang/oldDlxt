package com.kylin.electricassistsys.entity.system;

import java.util.ArrayList;
import java.util.List;

public class MenuTreeGridEntity extends MenuEntity
{
    private String state = "open";

    private String progress ="";

    private List<MenuTreeGridEntity> children = new ArrayList<>();

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public String getProgress()
    {
        return progress;
    }

    public void setProgress(String progress)
    {
        this.progress = progress;
    }

    public List<MenuTreeGridEntity> getChildren()
    {
        return children;
    }

    public void setChildren(List<MenuTreeGridEntity> children)
    {
        this.children = children;
    }
}
