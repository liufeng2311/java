package com.beiming.common.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import com.beiming.datasource.TargerDataSource;

@Aspect
@Component
public class DataSourceAspect {
	
	@Pointcut("@annotation(com.beiming.common.annotation.Read)")
	public void master() {
		
	}
	
	@Pointcut("@annotation(com.beiming.common.annotation.Write)")
	public void slave() {
		
	}
	
	@Before("master()")
	public void read() {
		TargerDataSource.master();
	}
	
	@Before("slave()")
	public void write() {
		TargerDataSource.slave();
	}
}
