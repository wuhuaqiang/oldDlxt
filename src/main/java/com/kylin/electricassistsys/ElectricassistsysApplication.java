package com.kylin.electricassistsys;

import com.kylin.electricassistsys.listener.ApplicationReadyEventListener;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan
@MapperScan(basePackages = "tk.mybatis.springboot.mapper")
public class ElectricassistsysApplication extends SpringBootServletInitializer
{

	@Override
	protected SpringApplicationBuilder configure(
			SpringApplicationBuilder application) {
		return application.sources(ElectricassistsysApplication.class);
	}


	public static void main(String[] args) {
		SpringApplication  springApplication =new SpringApplication(ElectricassistsysApplication.class);
		springApplication.addListeners(new ApplicationReadyEventListener());
		springApplication.run(args);
	}
}
