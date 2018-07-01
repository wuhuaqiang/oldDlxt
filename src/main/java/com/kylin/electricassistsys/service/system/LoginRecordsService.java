package com.kylin.electricassistsys.service.system;

import com.kylin.electricassistsys.entity.system.LoginRecords;
import com.kylin.electricassistsys.mapper.system.LoginRecordsMapper;
import com.kylin.electricassistsys.mapper.system.UnitMapper;
import com.kylin.electricassistsys.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Threecolors on 2018/1/22.
 */
@Service
public class LoginRecordsService extends BaseService<LoginRecords>
{
    @Autowired
    private LoginRecordsMapper mapper;

    @Autowired
    public void setMapper(LoginRecordsMapper mapper)
    {
        this.mapper = mapper;
        setBaseMapper(mapper);
    }
}
