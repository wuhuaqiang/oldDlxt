package com.kylin.electricassistsys.commonmapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;

/**
 * Created by Threecolors on 2017/11/18.
 */
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T>
{
    /**根据id获取实体
     * @param id
     * @return 实体
     */
    T getEntityById(String id);

    /**根据id批量删除
     * id集合
     * */
    int deleteByIds(String[] ids);


    /**根据条件获取实体集合
     * @param entity 条件实体
     * @return 实体集合
     */
    List<T> getEntitiesByCondition(T entity);
}
