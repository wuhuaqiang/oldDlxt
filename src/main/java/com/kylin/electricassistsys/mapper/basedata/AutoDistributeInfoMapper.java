package com.kylin.electricassistsys.mapper.basedata;

import com.kylin.electricassistsys.commonmapper.BaseMapper;
import com.kylin.electricassistsys.entity.basedata.AutoDistributeInfoEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Threecolors on 2017/11/17.
 */
@Mapper
@Component(value="AutoDistributeInfoMapper")
public interface AutoDistributeInfoMapper extends BaseMapper<AutoDistributeInfoEntity>
{
}
