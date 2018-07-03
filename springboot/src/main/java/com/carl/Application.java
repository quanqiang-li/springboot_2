package com.carl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 启动类
 * @author liqq
 *
 */
@Controller
@SpringBootApplication
@MapperScan(basePackages="com.carl.dao")
public class Application{
	/**
	 * 工程程序入口
	 * 
	 * @Description: 工程程序入口
	 * @param args
	 *            启动参数
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@RequestMapping("/")
	String home() {
		return "/pages/login.html";
	}

}