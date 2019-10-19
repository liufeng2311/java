package com.beiming.entity;

import java.util.Date;

import javax.persistence.Table;

import lombok.Data;

@Table(name = "USER")
@Data
public class User {
	
	private String name;
	
	private String password;
	
	private String isLogin;
	
	private Date LoginTime;
}
