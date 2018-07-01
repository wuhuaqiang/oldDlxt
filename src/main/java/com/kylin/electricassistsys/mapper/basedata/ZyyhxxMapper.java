package com.kylin.electricassistsys.mapper.basedata;

import com.kylin.electricassistsys.commonmapper.BaseMapper;
import com.kylin.electricassistsys.entity.basedata.ZyyhxxEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * Created by Threecolors on 2017/12/1.
 */
@Mapper
@Component(value="ZyyhxxMapper")
public interface ZyyhxxMapper extends BaseMapper<ZyyhxxEntity>
{
}
