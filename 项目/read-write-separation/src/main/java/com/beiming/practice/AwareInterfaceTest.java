package com.beiming.practice;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * 	当我们使用Spring管理bean时,这些bean对Spring容器的存在是无感知的,
 * Aware接口是spring容器提供的用于获取bean在spring容器中的信息的,比如在容器中的id,类加载器信息等
 *	InitializingBean接口是Spring对对象初始化的时候执行的，通过new是不执行的
 */
@Data
@Component
public class AwareInterfaceTest implements BeanNameAware,InitializingBean{

	private String springName;
	
	//用于获取Spring容器中该bean的id
	@Override
	public void setBeanName(String name) {
		this.springName=name;
	}
	
	//初始化该bean时的处理
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println(springName);
	}
}
