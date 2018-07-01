package com.kylin.electricassistsys.utility;

import org.apache.calcite.linq4j.Linq4j;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hhq on 2017/11/13.
 * 下拉开分层按钮
 */
public class SelectHierarchicalHelper
{
    /**创建分层数据
     * @param preId 父ID
     * @param entityList 实体数据集合
     * @param <T> 实体类型
     * @return 实体集合
     */
    public static <T extends HierarchicalEntity> List<HierarchicalEntity> buildHierarchicalData(String preId, List<T> entityList)
    {
        List<HierarchicalEntity> resultList = new ArrayList<>();
        List<HierarchicalEntity> hierarchicalEntityList = (List<HierarchicalEntity>)entityList;
        List<HierarchicalEntity> tempList = new ArrayList<>();
        if(StringHelper.isNullOrWhiteSpace(preId))
        {
            tempList = Linq4j.asEnumerable(hierarchicalEntityList).where(a->StringHelper.isNullOrWhiteSpace(a.getPreId())).toList();
        }
        else
        {
            tempList = Linq4j.asEnumerable(hierarchicalEntityList).where(a->a.getPreId().equals(preId)).toList();
        }

        int size = tempList.size();
        for (int i = 0; i < size; i++)
        {
            boolean isLast = i==size-1;
            HierarchicalEntity temp = tempList.get(i);
            String style = getStyle(0,isLast,isLast);
            temp.setName(style + temp.getName());
            resultList.add(temp);
            buildChild(hierarchicalEntityList,resultList, 1,temp.getId(),isLast);
        }

        return resultList;
    }

    private static void buildChild(List<HierarchicalEntity> hierarchicalEntityList, List<HierarchicalEntity> resultList,int level, String preId, boolean isLastRoot)
    {
        List<HierarchicalEntity> tempList = new ArrayList<>();
        if(StringHelper.isNullOrWhiteSpace(preId))
        {
            tempList = Linq4j.asEnumerable(hierarchicalEntityList).where(a->StringHelper.isNullOrWhiteSpace(a.getPreId())).toList();
        }
        else
        {
            tempList = Linq4j.asEnumerable(hierarchicalEntityList).where(a->a.getPreId().equals(preId)).toList();
        }

        int size = tempList.size();
        for (int i = 0; i < size; i++)
        {
            boolean isLast = i==size-1;
            HierarchicalEntity temp = tempList.get(i);
            String style = getStyle(level,isLastRoot,isLast);
            temp.setName(style + temp.getName());
            resultList.add(temp);
            buildChild(hierarchicalEntityList,resultList, level+1, temp.getId(), isLastRoot);
        }
    }

    /**设置样式
     * @param level 当前节点层级(起始层级为0)
     * @param isLastRoot 是否最后根节点
     * @param isLast 是否最后子节点
     * @return 样式文本
     */
    private static String getStyle(int level, boolean isLastRoot, boolean isLast)
    {
        String style = "";

        if (isLastRoot)
        {
            //根级最后节点
            for (int i = 0; i < level; i++)
            {
                style += "　";
            }
        }
        else
        {
            //不是根级最后节点
            if (level > 0)
            {
                for (int i = 1; i < level; i++)
                {
                    style += "　";
                }
                style = "│" + style;
            }
        }

        style += isLast ? "└" : "├";
        return style;
    }
}
