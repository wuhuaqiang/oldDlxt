package com.kylin.electricassistsys.mapper.basedata;

import com.kylin.electricassistsys.commonmapper.BaseMapper;
import com.kylin.electricassistsys.entity.basedata.DyxxEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * Created by Threecolors on 2017/11/30.
 */
@Mapper
@Component(value="DyxxMapper")
public interface DyxxMapper extends BaseMapper<DyxxEntity>
{
}
