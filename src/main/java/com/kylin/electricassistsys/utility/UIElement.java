package com.kylin.electricassistsys.utility;

import java.util.HashMap;

/**
 * Created by Threecolors on 2017/11/19.
 */
public class UIElement
{
    private TagType tagType = TagType.NONE;

    private String lbTxt = "";

    private String name = "";

    private String id = "";

    private HashMap<String,String> optionMap = new HashMap<>();

    public TagType getTagType()
    {
        return tagType;
    }

    public void setTagType(TagType tagType)
    {
        this.tagType = tagType;
    }

    public String getLbTxt()
    {
        return lbTxt;
    }

    public void setLbTxt(String lbTxt)
    {
        this.lbTxt = lbTxt;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getId()
    {
        if(this.getTagType().equals(TagType.INPUT_TEXT))
        {
            return  "txt"+name;
        }

        if(this.getTagType().equals(TagType.SELECT))
        {
            return  "slt"+name;
        }
        return "";
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public HashMap<String, String> getOptionMap()
    {
        return optionMap;
    }

    public void setOptionMap(HashMap<String, String> optionMap)
    {
        this.optionMap = optionMap;
    }

    public UIElement(TagType tagType, String lbTxt, String name, HashMap<String, String> optionMap)
    {
        this.tagType = tagType;
        this.lbTxt = lbTxt;
        this.name = name;
        this.optionMap = optionMap;
    }

    public UIElement(TagType tagType, String lbTxt, String name)
    {
        this.tagType = tagType;
        this.lbTxt = lbTxt;
        this.name = name;
    }
}
