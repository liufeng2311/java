package com.beiming.common.enums;

/**
 * 异常信息枚举类
 *
 */
public enum ResultCodeEnums {
	
	REQUEST_SUCCESS("10000", "请求处理成功"),
	
	//参数认证异常以2开头
	ILLEGAL_PARAMETER("20001", "非法参数"),
	
	//用户信息异常以3开头
	USER_EXIST("30001", "用户名已存在");
	
	private String code;
	
	private String message;

	private ResultCodeEnums(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	//可自定义异常信息描述
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
