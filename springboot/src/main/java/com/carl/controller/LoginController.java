package com.carl.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carl.framework.Code;
import com.carl.framework.ReturnData;
import com.carl.service.UserService;

@RestController
@RequestMapping("/login")
public class LoginController {

	Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserService userService;

	@PostMapping("doLogin")
	public ReturnData doLogin(HttpServletRequest request, String userName, String password) {
		log.info("请求登录{},{}", userName, password);
		ReturnData returnData = userService.loginWithMobilePassword(userName, password);
		// 登录成功,暂存session
		if (Code.OK.getCode() == returnData.getErrorCode()) {
			request.getSession().setAttribute("loginName", userName);
		}
		return returnData;
	}

	@GetMapping("loginOut")
	public void loginOut(HttpServletRequest request,HttpServletResponse response) {
		String userName = (String) request.getSession().getAttribute("loginName");
		log.info("请求退出{}", userName);
		// 清理session
		request.getSession().removeAttribute("loginName");
		try {
			response.sendRedirect("/pages/login.html");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
