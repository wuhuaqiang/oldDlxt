package com.kylin.electricassistsys.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by Threecolors on 2018/3/2.
 */
@Configuration
@EnableScheduling
@EnableAsync
public class ExecutorConfig
{
//    @Value("${mailAsync.executor.corePoolSize}")
//    private int corePoolSize;
//
//    @Value("${mailAsync.executor.maxPoolSize}")
//    private int maxPoolSize;
//
//    @Value("${mailAsync.executor.queueCapacity}")
//    private int queueCapacity;



    @Bean(name = "mailAsync")
    public Executor mailAsync() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(10);
        executor.setQueueCapacity(1000);
        executor.setKeepAliveSeconds(3000);
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.setThreadNamePrefix("MailExecutor-");
        executor.initialize();
        return executor;
    }
}
