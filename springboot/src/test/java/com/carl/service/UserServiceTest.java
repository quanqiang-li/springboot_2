package com.carl.service;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.carl.Application;
import com.carl.model.User;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class UserServiceTest {

	@Autowired
	private UserService userService;
	
	@Test
	public void testCreateUser(){
		User user = new User();
		user.setCreateTime(new Date());
		user.setMobile("15910756893");
		user.setPassword("1qaz2wsx");
		int createUser = userService.createUser(user);
		System.out.println("插入条数" + createUser);
	}
}
