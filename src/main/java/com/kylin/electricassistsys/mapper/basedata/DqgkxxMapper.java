package com.kylin.electricassistsys.mapper.basedata;

import com.kylin.electricassistsys.commonmapper.BaseMapper;
import com.kylin.electricassistsys.entity.basedata.DqgkxxEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * Created by Threecolors on 2017/11/29.
 */
@Mapper
@Component(value="DqgkxxMapper")
public interface DqgkxxMapper extends BaseMapper<DqgkxxEntity>
{
}
