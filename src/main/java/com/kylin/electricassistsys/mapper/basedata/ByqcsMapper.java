package com.kylin.electricassistsys.mapper.basedata;

import com.kylin.electricassistsys.commonmapper.BaseMapper;
import com.kylin.electricassistsys.entity.basedata.ByqcsEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * Created by Threecolors on 2017/11/28.
 */
@Mapper
@Component(value="ByqcsMapper")
public interface ByqcsMapper extends BaseMapper<ByqcsEntity>
{
}
