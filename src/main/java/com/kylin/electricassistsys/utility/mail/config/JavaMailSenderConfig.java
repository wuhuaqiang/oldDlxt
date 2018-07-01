package com.kylin.electricassistsys.utility.mail.config;

import com.kylin.electricassistsys.utility.mail.MailProperties;
import com.kylin.electricassistsys.utility.mail.MailPropertiesProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 * Created by Threecolors on 2018/3/2.
 */
@Configuration
public class JavaMailSenderConfig
{

//    @Autowired
//    MailPropertiesProvider mailPropertiesProvider;
//
//    @Bean
//    public JavaMailSender getJavaMailSender()
//    {
//        MailProperties mailProperties = mailPropertiesProvider.getMailProperties();
//        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
//        javaMailSender.setHost(mailProperties.getHost());
//        javaMailSender.setUsername(mailProperties.getUsername());
//        javaMailSender.setPassword(mailProperties.getPassword());
//
//        return  javaMailSender;
//    }
}
