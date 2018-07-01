package com.kylin.electricassistsys.mapper.basedata;

import com.kylin.electricassistsys.commonmapper.BaseMapper;
import com.kylin.electricassistsys.entity.basedata.DxcsEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * Created by Threecolors on 2017/11/20.
 */
@Mapper
@Component(value="DxcsMapper")
public interface DxcsMapper extends BaseMapper<DxcsEntity>
{
}
