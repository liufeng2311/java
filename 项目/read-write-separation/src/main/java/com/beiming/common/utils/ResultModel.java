package com.beiming.common.utils;

import com.beiming.common.enums.ResultCodeEnums;
import com.beiming.common.exception.MyException;

import lombok.Data;

/**
 *	统一接口输出类
 */
@Data
public class ResultModel {
	
	private String message;
	
	private String code;
	
	private Object data;
	
	public static ResultModel success() {
		return success(null);
	}
	
	public static ResultModel success(Object data) {
		return success(data, ResultCodeEnums.REQUEST_SUCCESS);
	}
	
	public static ResultModel success(Object data,ResultCodeEnums enums) {
		ResultModel model = new ResultModel();
		model.setCode(enums.getCode());
		model.setMessage(enums.getMessage());
		model.setData(data);
		return model;
	}
	
	public static ResultModel fail(MyException e) {
		ResultModel model = new ResultModel();
		model.setCode(e.getCode());
		model.setMessage(e.getMessage());
		return model;
		
	}
	
	public static ResultModel fail(ResultCodeEnums enums, String message) {
		ResultModel model = new ResultModel();
		model.setCode(enums.getCode());
		model.setMessage(message);
		return model;
	}
	
	public static ResultModel fail(Exception e) {
		if(e instanceof MyException) {
			fail(e);
		}
		
		return null;
		
	}
}
