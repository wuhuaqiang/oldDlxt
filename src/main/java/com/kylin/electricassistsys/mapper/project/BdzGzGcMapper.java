package com.kylin.electricassistsys.mapper.project;

import com.kylin.electricassistsys.commonmapper.BaseMapper;
import com.kylin.electricassistsys.entity.project.BdzGzGcEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * Created by Threecolors on 2017/12/28.
 */
@Mapper
@Component(value="BdzGzGcMapper")
public interface BdzGzGcMapper extends BaseMapper<BdzGzGcEntity>
{
}
