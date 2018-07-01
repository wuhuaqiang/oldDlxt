package com.kylin.electricassistsys.mapper.facility;

import com.kylin.electricassistsys.commonmapper.BaseMapper;
import com.kylin.electricassistsys.entity.facility.GyxlxxEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * Created by Threecolors on 2017/12/31.
 */
@Mapper
@Component(value="GyxlxxMapper")
public interface GyxlxxMapper extends BaseMapper<GyxlxxEntity>
{
}
