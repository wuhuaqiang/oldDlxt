package com.kylin.electricassistsys.service.basedata;

import com.kylin.electricassistsys.entity.basedata.ZypwyxzbEntity;
import com.kylin.electricassistsys.mapper.basedata.ZypwyxzbMapper;
import com.kylin.electricassistsys.service.BaseService;
import com.kylin.electricassistsys.utility.CustomField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Threecolors on 2017/12/1.
 */
@Service
public class ZypwyxzbService extends BaseService<ZypwyxzbEntity>
{
    private ZypwyxzbMapper mapper;

    @Autowired
    public void setZypwyxzbMapper(ZypwyxzbMapper mapper)
    {
        this.mapper = mapper;
        setBaseMapper(mapper);
    }
}