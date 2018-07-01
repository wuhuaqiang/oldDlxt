package com.kylin.electricassistsys.utility.mail.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.util.Properties;

/**
 * Created by Threecolors on 2018/3/14.
 */
@Configuration
public class FreeMarkerConfig
{
        @Bean(name = "freeMarkerConfigurer")
        public FreeMarkerConfigurer getFreeMarkerConfigurer()
        {
            FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
            freeMarkerConfigurer.setTemplateLoaderPath("classpath:ftl");
            Properties settings = new Properties();
                settings.put("template_update_delay","0");
            settings.put("default_encoding","utf-8");
            settings.put("locale","zh_CH");
            freeMarkerConfigurer.setFreemarkerSettings(settings);
            return  freeMarkerConfigurer;
        }
}
