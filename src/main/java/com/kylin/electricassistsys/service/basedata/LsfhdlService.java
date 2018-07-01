package com.kylin.electricassistsys.service.basedata;

import com.kylin.electricassistsys.entity.basedata.LsfhdlEntity;
import com.kylin.electricassistsys.mapper.basedata.LsfhdlMapper;
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
public class LsfhdlService extends BaseService<LsfhdlEntity>
{
    private LsfhdlMapper mapper;

    @Autowired
    public void setDwpbsbMapper(LsfhdlMapper mapper)
    {
        this.mapper = mapper;
        setBaseMapper(mapper);
    }
}
