package com.beiming.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beiming.common.annotation.Read;
import com.beiming.common.utils.ResultModel;
import com.beiming.dto.request.RegisterUserDTO;
import com.beiming.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RequestMapping("user")
@RestController                                                     //@RestController = @Controller+@ResponseBody,@ResponseBody表示返回值是对象,如果没有的话,会把返回值作为页面解析,出现404的问题
@Api(tags = "用户信息相关接口")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("register")
	@ApiOperation(value = "用户注册")
	@Read
	public ResultModel registerUser(@RequestBody @Valid RegisterUserDTO user) {
		userService.register(user);
		return ResultModel.success();
	}
	
	@GetMapping("register1")
	@Read
	public ResultModel registerUser1() {
		return ResultModel.success();
	}
}
