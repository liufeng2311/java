package com.beiming;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)  //不排除的话在多数据源时会启动报错
@EnableSwagger2  //开启Swagger文档
@EnableAsync  //开启异步任务
@EnableScheduling //开启定时任务，开启定时任务后,如果我们自定义的连接池不是taskExecutor,
							    //他会使用默认的连接池SimpleAsyncTaskExecutor，造成我们自定义连接池失效,解决办法，自定义连接池的名字为taskExecutor,或者使用@Primary
public class DataSourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataSourceApplication.class, args);
	}

}
