package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.example.demo.mapper")
public class SpringbootSpirngsecurityDemoApplication extends WebMvcConfigurationSupport {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootSpirngsecurityDemoApplication.class, args);
	}

	@Override
	protected void configurePathMatch(PathMatchConfigurer configurer) {
	    configurer.setUseSuffixPatternMatch(false) //设置路由是否后缀匹配，譬如/user能够匹配/user.,/user.aa
				.setUseTrailingSlashMatch(false); //设置是否后缀路径匹配，比如/user能够匹配/user,/user/
	}
}
