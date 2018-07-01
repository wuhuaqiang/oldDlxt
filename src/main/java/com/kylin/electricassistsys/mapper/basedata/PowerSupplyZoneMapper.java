package com.kylin.electricassistsys.mapper.basedata;

import com.kylin.electricassistsys.commonmapper.BaseMapper;
import com.kylin.electricassistsys.entity.basedata.PowerSupplyZoneEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Threecolors on 2017/11/17.
 */
@Mapper
@Component(value="PowerSupplyZoneMapper")
public interface PowerSupplyZoneMapper extends BaseMapper<PowerSupplyZoneEntity>
{
    /**获取所有
     * @return 所有实体集合
     */
    List<PowerSupplyZoneEntity> getAll();

    /**添加
     * @param entity 实体
     * @return 影响条数
     */
    int add(PowerSupplyZoneEntity entity);


    /**更新
     * @param entity 实体
     * @return 影响条数
     */
    int update(PowerSupplyZoneEntity entity);


    /**根据id获取实体
     * @param id
     * @return 实体
     */
    PowerSupplyZoneEntity getEntityById(String id);


    /**根据id删除
     * @param id
     * @return 影响条数
     */
    int deleteById(String id);

    /**根据id批量删除
     * id集合
     * */
    int deleteByIds(String[] ids);

    /**
     * 根据名称获取
     *
     * @return 所有实体集合
     */
    List<PowerSupplyZoneEntity> getByName(String name);
}
