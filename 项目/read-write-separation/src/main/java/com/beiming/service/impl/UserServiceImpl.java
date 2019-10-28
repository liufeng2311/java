package com.beiming.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beiming.common.enums.ResultCodeEnums;
import com.beiming.common.exception.MyException;
import com.beiming.dao.UserMapper;
import com.beiming.dto.request.RegisterUserDTO;
import com.beiming.entity.User;
import com.beiming.service.UserService;

@Service
public class UserServiceImpl  implements UserService{

	@Autowired
	UserMapper mapper;
	
	@Override
	public User register(RegisterUserDTO user) {
		User target = new User();
		BeanUtils.copyProperties(user, target);
		int count = mapper.insert(target);
		if(count != 1) {
			throw new MyException(ResultCodeEnums.USER_EXIST.getCode(),"注册用户失败");
		}
		return target;
	}

}
