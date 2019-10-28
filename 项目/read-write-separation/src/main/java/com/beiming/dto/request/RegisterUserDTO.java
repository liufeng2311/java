package com.beiming.dto.request;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(description ="用户注册DTO")
@Data
public class RegisterUserDTO {
	
	@ApiModelProperty(value = "用户名", required = true)
	@NotNull(message = "请输入用户名")
	@Length(max = 6,message ="用户名最多六位数")
	private String username;
	
	@ApiModelProperty(value = "密码",required = true)
	@NotNull(message = "请输入密码")
	private String password;
	
	@ApiModelProperty(value = "验证码",required = true)
	@NotNull(message = "请输入验证码")
	private String verifyCode;
}
