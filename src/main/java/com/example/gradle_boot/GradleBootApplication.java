package com.example.gradle_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@ComponentScan(basePackages="com.example.gradle_boot.*")//指定要扫描的包
@EntityScan(basePackages="com.example.gradle_boot.*")
@EnableAspectJAutoProxy
public class GradleBootApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(GradleBootApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(GradleBootApplication.class, args);
	}
}
