package com.kylin.electricassistsys.mapper.facility;

import com.kylin.electricassistsys.commonmapper.BaseMapper;
import com.kylin.electricassistsys.entity.facility.BdzxxEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * Created by Threecolors on 2017/12/1.
 */
@Mapper
@Component(value="BdzxxMapper")
public interface BdzxxMapper extends BaseMapper<BdzxxEntity>
{

}
