package com.kylin.electricassistsys.entity;

/**
 * Created by Threecolors on 2017/11/30.
 */
public class AutoBuilderParam
{
    private String title ="";

    private String mapUrl="";

    private String layH ="";

    private String layW = "";

    private int colNum;

    public AutoBuilderParam(String title, String mapUrl, String layH, String layW, int colNum)
    {
        this.title = title;
        this.mapUrl = mapUrl;
        this.layH = layH;
        this.layW = layW;
        this.colNum = colNum;
    }

    public AutoBuilderParam()
    {
    }

    public String getTitle()
    {
        return title;
    }

    public String getMapUrl()
    {
        return mapUrl;
    }

    public String getLayH()
    {
        return layH;
    }

    public String getLayW()
    {
        return layW;
    }

    public int getColNum()
    {
        return colNum;
    }
}
