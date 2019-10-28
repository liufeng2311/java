package com.beiming.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *	设置全局跨域
 *
 */
@Configuration
public class CrosConfigure implements WebMvcConfigurer{

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
					.allowedHeaders("*")
					.allowedOrigins("*")
					.allowedMethods("*");
	}
	
	
}
