package com.kylin.electricassistsys.mapper.basedata;

import com.kylin.electricassistsys.commonmapper.BaseMapper;
import com.kylin.electricassistsys.entity.basedata.DczjEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * Created by Threecolors on 2017/11/19.
 */
@Mapper
@Component(value="DczjMapper")
public interface DczjMapper extends BaseMapper<DczjEntity>
{
}
