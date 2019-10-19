package com.beiming.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beiming.common.annotation.Read;
import com.beiming.common.annotation.Write;
import com.beiming.dao.UserMapper;
import com.beiming.entity.User;

@RequestMapping("user")
@RestController
public class UserController {
	
	@Autowired
	UserMapper mapper;
	
	@Read(name = "刘峰")
	@RequestMapping("master")
	public void master(){
		User user = new User();
		user.setIsLogin("1");
		user.setName("liufeng");
		user.setPassword("123456");
		user.setLoginTime(new Date());
		mapper.insert(user);
	}
	
	@Read
	@RequestMapping("master1")
	public void master1() {
		User user = new User();
		user.setIsLogin("1");
		user.setName("liufeng");
		user.setPassword("123456");
		user.setLoginTime(new Date());
		List<User> selectAll = mapper.selectAll();
		for(User var : selectAll) {
			String string = var.toString();
			System.out.println(string);
		}
	}
	
	@Write
	@RequestMapping("slave")
	@Transactional
	public void slave(){
		User user = new User();
		user.setIsLogin("1");
		user.setName("liufeng");
		user.setPassword("123456");
		user.setLoginTime(new Date());
		mapper.insert(user);
	}
	
	@Write
	@RequestMapping("slave1")
	public void slave1() {
		User user = new User();
		user.setIsLogin("1");
		user.setName("liufeng");
		user.setPassword("123456");
		user.setLoginTime(new Date());
		List<User> selectAll = mapper.selectAll();
		for(User var : selectAll) {
			String string = var.toString();
			System.out.println(string);
		}
	}

}
