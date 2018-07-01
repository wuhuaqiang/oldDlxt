package com.kylin.electricassistsys.service.system;

import com.kylin.electricassistsys.entity.system.SysSetting;
import com.kylin.electricassistsys.mapper.system.SysSettingMapper;
import com.kylin.electricassistsys.service.BaseService;
import com.kylin.electricassistsys.utility.DESCryptography;
import com.kylin.electricassistsys.utility.mail.MailProperties;
import com.kylin.electricassistsys.utility.mail.MailSender;
import com.kylin.electricassistsys.utility.mail.MailSenderImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Created by Threecolors on 2018/1/31.
 */
@Service
public class SysSettingService extends BaseService<SysSetting>
{
    @Autowired
    private SysSettingMapper mapper;

    @Autowired
    public void setMapper(SysSettingMapper mapper)
    {
        this.mapper = mapper;
        setBaseMapper(mapper);
    }

    public SysSetting selectSysSetting()
    {
        List<SysSetting> sysSettings = mapper.selectAll();
        if(sysSettings.size()>0)
        {
            SysSetting sysSetting = sysSettings.get(0);
            sysSetting.setMailPassword(DESCryptography.decodeValue(sysSetting.getMailPassword()));
            return  sysSetting;
        }
        else
        {
            return  new SysSetting();
        }
    }
}
