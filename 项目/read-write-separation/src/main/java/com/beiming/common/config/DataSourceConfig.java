package com.beiming.common.config;


import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;

import com.beiming.common.enums.DataSourceTypeEnum;
import com.beiming.datasource.TargerDataSource;

@Configuration
public class DataSourceConfig {

	@ConfigurationProperties(value = "spring.datasource.master")
	@Bean
	public DataSource master() {
		return DataSourceBuilder.create().build();
	}

	@ConfigurationProperties(value = "spring.datasource.slave1")
	@Bean
	public DataSource slave1() {
		return DataSourceBuilder.create().build();
	}

	@ConfigurationProperties(value = "spring.datasource.slave2")
	@Bean
	public DataSource slave2() {
		return DataSourceBuilder.create().build(); 
	}

	@Bean
	@Primary
	public DataSource targetDataSource(@Qualifier("master")DataSource master,
			@Qualifier("slave1")DataSource slave1,
			@Qualifier("slave2")DataSource slave2) {
		Map<Object,Object> map = new HashMap<Object,Object>();
		map.put(DataSourceTypeEnum.MASTER, master);
		map.put(DataSourceTypeEnum.SLAVE1, slave1);
		map.put(DataSourceTypeEnum.SLAVE2, slave2);
		TargerDataSource target =new TargerDataSource();
		target.setTargetDataSources(map);
		target.setDefaultTargetDataSource(master);
		return target;
	}

	//设置事务,测试发现不配置多个数据源也可以回滚,如果是读写分离,此处直接指定为主库的数据源
	@Bean
	@Primary
	public DataSourceTransactionManager platformTransactionManager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}
	
	//也可以通过为每个数据源配置事务, 通过使用@Transactional("master")指定
	@Bean
	public DataSourceTransactionManager master(@Qualifier("master")DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}
	@Bean
	public DataSourceTransactionManager slave(@Qualifier("slave")DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}
}
