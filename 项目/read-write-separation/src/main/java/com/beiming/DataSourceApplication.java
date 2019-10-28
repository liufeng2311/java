package com.beiming;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)  //不排除的话在多数据源时会启动报错
@EnableSwagger2
public class DataSourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataSourceApplication.class, args);
	}

}
