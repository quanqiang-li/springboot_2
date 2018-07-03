package com.carl.framework;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * webmvc 配置
 * 
 * @author liqq
 *
 */
@Configuration
public class ConfigWebMvc implements WebMvcConfigurer {
	Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private LoginInterceptor loginInterceptor;

	/**
	 * 添加拦截器
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns("/", "/vendor/**", "/dist/**", "/pages/login.html", "/error","/login/doLogin");
		WebMvcConfigurer.super.addInterceptors(registry);
		log.info("===注册登录拦截器loginInterceptor===");
	}

}
