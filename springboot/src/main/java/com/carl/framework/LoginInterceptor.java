package com.carl.framework;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LoginInterceptor implements HandlerInterceptor {

	Logger log = LoggerFactory.getLogger(this.getClass());

	/*
	 * 进入controller层之前拦截请求
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		log.info("===进入controller层之前拦截请求===");
		log.info("getContextPath:{}", request.getContextPath());
		log.info("getServletPath:{}", request.getServletPath());
		log.info("getRequestURI:{}", request.getRequestURI());
		log.info("getRequestURL:{}", request.getRequestURL());
		log.info("getRealPath:{}", request.getSession().getServletContext().getRealPath("/"));
		String token = request.getHeader("token");
		log.info("token:{}", token);
		String loginName = (String) request.getSession().getAttribute("loginName");
		if (null == loginName || "".equals(loginName)) {
			response.sendRedirect("/pages/login.html");
			log.info("未登录,重定向到登录页面");
			return false;
		}else{
			log.info("已登录,loginName:{},准许放行", loginName);
		}
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
}
