package com.kylin.electricassistsys.config;

import com.kylin.electricassistsys.Interceptor.AccessHandlerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Threecolors on 2018/3/16.
 */
@Configuration
public class CustomWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter
{
    @Autowired
    AccessHandlerInterceptor accessHandlerInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry)
    {
        registry.addInterceptor(accessHandlerInterceptor)
                .excludePathPatterns("/login","/logout","/captchImg","/images/**","/js/**","/css/**","/fonts/**","/","/favicon.ico");  //对来自/user/** 这个链接来的请求进行拦截
    }
}
