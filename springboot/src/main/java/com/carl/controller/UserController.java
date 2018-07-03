package com.carl.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.carl.framework.Code;
import com.carl.framework.PageData;
import com.carl.framework.ReturnData;
import com.carl.model.User;
import com.carl.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@RestController
@RequestMapping("/user")
public class UserController {

	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserService userService;
	
	@PostMapping("getAll")
	public ReturnData getAll(HttpServletRequest request){
		log.info("请求所有用户信息");
		ReturnData returnData = new ReturnData(Code.OK);
		List<User> selectAll = userService.selectAll();
		returnData.getDataBody().put("allUser", selectAll);
		return returnData;
	}
	
	@PostMapping("getPage")
	public PageData getPage(HttpServletRequest request,@RequestParam Map<String, Object> params){
		log.info("请求分页用户信息");
		/*
		 * 
draw:1  //绘制计数器。这个是用来确保Ajax从服务器返回的是对应的
order[0][column]:0   //告诉后台那些列是需要排序的,i是一个数组索引，对应的是 columns配置的数组，从0开始
order[0][dir]:asc  //告诉后台列排序的方式， desc 降序 asc升序
start:0  //第一条数据的起始位置，比如0代表第一条数据
length:2  //每页显示的条数
search[value]://全局的搜索条件，条件会应用到每一列
search[regex]:false
		 */
		int draw = Integer.parseInt((String) params.get("draw"));
		int start = Integer.parseInt((String) params.get("start"));
		int length = Integer.parseInt((String) params.get("length"));
		PageData pageData = new PageData(Code.OK);
		User user = new User();
		Page<Object> startPage = PageHelper.offsetPage(start, length);
		List<User> selectPage = userService.selectPage(user);
		pageData.getDataBody().put("pageUser", selectPage);
		pageData.setDraw(draw);
		//下面两个设置成一样的才会分页
		pageData.setRecordsTotal(Integer.parseInt(String.valueOf(startPage.getTotal())));
		pageData.setRecordsFiltered(Integer.parseInt(String.valueOf(startPage.getTotal())));
		return pageData;
	}
}
