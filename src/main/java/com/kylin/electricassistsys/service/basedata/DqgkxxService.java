package com.kylin.electricassistsys.service.basedata;

import com.kylin.electricassistsys.entity.basedata.DqgkxxEntity;
import com.kylin.electricassistsys.mapper.basedata.DqgkxxMapper;
import com.kylin.electricassistsys.service.BaseService;
import com.kylin.electricassistsys.utility.CustomField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Threecolors on 2017/11/29.
 */
@Service
public class DqgkxxService extends BaseService<DqgkxxEntity>
{
    private DqgkxxMapper mapper;

    @Autowired
    public void setDwpbsbMapper(DqgkxxMapper mapper)
    {
        this.mapper = mapper;
        setBaseMapper(mapper);
    }
}
