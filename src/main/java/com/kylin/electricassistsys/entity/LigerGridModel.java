package com.kylin.electricassistsys.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Threecolors on 2018/1/3.
 */

public class LigerGridModel<T extends BaseEntity>
{
    @JsonProperty("Rows")
    @JSONField(name="Rows")
    private List<T> rows = new ArrayList<T>();

    @JsonProperty("Total")
    @JSONField(name="Total")
    private int total;

    public List<T> getRows()
    {
        return rows;
    }

    public void setRows(List<T> rows)
    {
        this.rows = rows;
    }

    public int getTotal()
    {
        return rows.size();
    }
}
