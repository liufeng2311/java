package com.beiming.service;

import com.beiming.dto.request.RegisterUserDTO;
import com.beiming.entity.User;

public interface UserService {
	
	User register(RegisterUserDTO user);
}
