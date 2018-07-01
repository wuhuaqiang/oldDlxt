package com.kylin.electricassistsys.mapper.basedata;

import com.kylin.electricassistsys.commonmapper.BaseMapper;
import com.kylin.electricassistsys.entity.basedata.DicParamEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Threecolors on 2017/11/17.
 */
@Mapper
@Component(value="DicParamMapper")
public interface DicParamMapper extends BaseMapper<DicParamEntity>
{
}
