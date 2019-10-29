package com.beiming.common.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 *	异步任务
 *	1.@Async注解表示该方法需要异步执行，只有在@EnableAsync存在时,才生效
 *	2.执行异步任务方法的线程由Spring提供的默认线程池执行,我们可以自定义线程池
 *	3.只有将异步方法所在的类交由Spring管理,并通过注入的方式在其他方法中调用，才会启动一个新的线程调用
 *		即如果是在方法中通过new出来的对象去调用@Async修饰的方法,不会启动新的新的线程去执行
 *
 */
@Component
public class AsyncTask {
	
	@Async
	public void asyncTest() {
		System.out.println(Thread.currentThread().getName());
	}
	
	@Async
	@Scheduled(cron ="0 0 0/1 * * ? ")  //每个一小时执行
	public void schedulTest() {
		System.out.println(Thread.currentThread().getName());
	}
}
