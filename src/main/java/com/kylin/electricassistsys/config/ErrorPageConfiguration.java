package com.kylin.electricassistsys.config;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

/**
 * Created by Threecolors on 2018/1/26.
 */
@Configuration
public class ErrorPageConfiguration
{
    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {
        return (container -> {
            ErrorPage error401Page = new ErrorPage(HttpStatus.FORBIDDEN, "/error");
            ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/error");
            ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error");
            container.addErrorPages(error401Page, error404Page, error500Page);
        });
    }
}
