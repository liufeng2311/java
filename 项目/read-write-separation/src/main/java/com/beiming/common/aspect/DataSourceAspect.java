package com.beiming.common.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.beiming.common.annotation.Read;
import com.beiming.datasource.TargerDataSource;

@Aspect
@Component
public class DataSourceAspect {
	
	@Pointcut("@annotation(com.beiming.common.annotation.Read) || execution(* com.beiming.controller..*.*(..))")
	public void master() {
		
	}
	
	//格式   返回值类型+方法全限定名(包括方法的路径和参数)
	//第一个*表示任何类型的返回值
	//.表示匹配controller包及其子包
	//第二个*表示包下的任何类
	//第三个*表示类中的任何方法
	//(..)表示任意参数
	//.作为路径
	@Pointcut("execution(* com.beiming.controller..*.*(..))")
	public void master1() {
		
	}
	
	//根据注解拦截,@annotation里存放的是注解的全限定名
	@Pointcut("@annotation(com.beiming.common.annotation.Write)")
	public void slave() {
		
	}
	
	//以注解的形式匹配某一切入点
	@Before("master()&&@annotation(read)")                   //获取注解里的信息&&@annotation(read)表示把注解里的信息放到read中,annotation()里的参数要和方法里的命名一直
	public void read(Read read) {
		System.out.println(read.name());
		TargerDataSource.master();
	}
	
	
	@Before("master()")              
	public void read1() {
		TargerDataSource.master();
	}
	
	@Before("slave()")
	public void write() {
		TargerDataSource.slave();
	}
}
