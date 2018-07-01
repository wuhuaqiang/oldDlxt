package com.kylin.electricassistsys.service.basedata;

import com.kylin.electricassistsys.entity.basedata.DyxxEntity;
import com.kylin.electricassistsys.mapper.basedata.DyxxMapper;
import com.kylin.electricassistsys.service.BaseService;
import com.kylin.electricassistsys.utility.CustomField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Threecolors on 2017/11/30.
 */
@Service
public class DyxxService extends BaseService<DyxxEntity>
{
    private DyxxMapper mapper;

    @Autowired
    public void setDwpbsbMapper(DyxxMapper mapper)
    {
        this.mapper = mapper;
        setBaseMapper(mapper);
    }
}
