package com.beiming.common.exception;

import lombok.Data;

@Data
public class MyException extends RuntimeException{
	
	private String code;

	public MyException(String code, String message) {
		super(message);
		this.code = code;
	}
}
