package com.kylin.electricassistsys.mapper.facility;

import com.kylin.electricassistsys.commonmapper.BaseMapper;
import com.kylin.electricassistsys.entity.facility.ByqxxEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * Created by Threecolors on 2017/12/2.
 */
@Mapper
@Component(value="ByqxxMapper")
public interface ByqxxMapper extends BaseMapper<ByqxxEntity>
{
}
