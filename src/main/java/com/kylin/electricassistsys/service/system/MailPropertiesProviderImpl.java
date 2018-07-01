package com.kylin.electricassistsys.service.system;

import com.kylin.electricassistsys.utility.mail.MailProperties;
import com.kylin.electricassistsys.utility.mail.MailPropertiesProvider;
import org.springframework.stereotype.Service;

/**
 * Created by Threecolors on 2018/3/2.
 */
@Service
public class MailPropertiesProviderImpl implements MailPropertiesProvider
{
    @Override
    public MailProperties getMailProperties()
    {
        return null;
    }
}
