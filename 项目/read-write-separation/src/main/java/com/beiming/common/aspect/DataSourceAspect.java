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
	
	@Pointcut("@annotation(com.beiming.common.annotation.Read)")
	public void master() {
		
	}
	
	@Pointcut("@annotation(com.beiming.common.annotation.Write)")
	public void slave() {
		
	}
	
	@Before("master()&&@annotation(read)")                   //获取注解里的信息&&@annotation(read)表示把注解里的信息放到read中,annotation()里的参数要和方法里的命名一直
	public void read(Read read) {
		TargerDataSource.master();
	}
	
	@Before("slave()")
	public void write() {
		TargerDataSource.slave();
	}
}
