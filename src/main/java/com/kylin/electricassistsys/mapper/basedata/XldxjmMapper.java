package com.kylin.electricassistsys.mapper.basedata;


import com.kylin.electricassistsys.commonmapper.BaseMapper;
import com.kylin.electricassistsys.entity.basedata.XldxjmEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Threecolors on 2017/11/18.
 */
@Mapper
@Component(value="XldxjmMapper")
public interface XldxjmMapper extends BaseMapper<XldxjmEntity>
{
}
