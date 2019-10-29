package com.beiming.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.beiming.common.interceptor.LoginInterceptor;

/**
 *	设置跨域、拦截器
 *
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer{
	
	//配置跨域
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
					.allowedHeaders("*")
					.allowedOrigins("*")
					.allowedMethods("*");
	}

	//配置拦截器和拦截规则
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoginInterceptor())
				    .addPathPatterns("/**");
	}
	
	
}
