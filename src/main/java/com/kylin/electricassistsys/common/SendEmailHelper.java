package com.kylin.electricassistsys.common;

import com.kylin.electricassistsys.entity.system.SysSetting;
import com.kylin.electricassistsys.service.system.SysSettingService;
import com.kylin.electricassistsys.utility.mail.MailProperties;
import com.kylin.electricassistsys.utility.mail.MailSender;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;

/**
 * Created by Threecolors on 2018/3/16.
 */
@Component
public class SendEmailHelper
{
    @Autowired
    SysSettingService sysSettingService;

    private Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private MailSender mailSender;

    private MailProperties getMailProperties()
    {
        MailProperties mailProperties=null;
        SysSetting sysSetting = sysSettingService.selectSysSetting();
        mailProperties = new MailProperties();
        mailProperties.setPassword(sysSetting.getMailPassword());
        mailProperties.setUsername(sysSetting.getMailAccount());
        mailProperties.setFrom(sysSetting.getMailAccount());
        mailProperties.setHost(sysSetting.getMailHost());

        return mailProperties;
    }

    public void SendEmailForUserPwd(String[] sendTo,String subject,Map<String, Object> contentMap,String templateName)
    {
        try
        {
            MailProperties mailProperties = this.getMailProperties();
            mailSender.setJavaMailSender(buidJavaMailSender(mailProperties));
            mailSender.sendTemplateMail(mailProperties.getFrom(),sendTo, subject, templateName, contentMap, new ArrayList<>());
        }
        catch (Exception ex)
        {
            logger.error(ex);
        }
    }
    private JavaMailSender buidJavaMailSender(MailProperties mailProperties)
    {

        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost(mailProperties.getHost());
        javaMailSender.setUsername(mailProperties.getUsername());
        javaMailSender.setPassword(mailProperties.getPassword());

        Properties pro = System.getProperties();
        pro.put("mail.smtp.auth", "true");
        pro.put("mail.smtp.socketFactory.port", "25");
        pro.put("mail.smtp.socketFactory.fallback", "false");

        javaMailSender.setJavaMailProperties(pro);
        return  javaMailSender;
    }
}
