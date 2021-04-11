package com.yy.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import javax.servlet.MultipartConfigElement;

@SpringBootApplication
public class SpringbootProjectApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringbootProjectApplication.class, args);
	}


	@Bean
	public MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		//单个文件最大
		factory.setMaxFileSize("50MB");
		/// 设置总上传数据总大小
		factory.setMaxRequestSize("50MB");
		return factory.createMultipartConfig();
	}

}
