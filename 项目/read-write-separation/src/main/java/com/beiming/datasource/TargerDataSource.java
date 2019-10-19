package com.beiming.datasource;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import com.beiming.common.enums.DataSourceTypeEnum;

/**
 * 通过该类实现动态获取数据库
 *	
 */
public class TargerDataSource extends AbstractRoutingDataSource{
	
    private static final ThreadLocal<DataSourceTypeEnum> target = new ThreadLocal<>();

    private static final AtomicInteger counter = new AtomicInteger();
	@Override
	protected Object determineCurrentLookupKey() {
		return target.get();
	}
	
	//设置主库,用于写
    public static void master() {
    	target.set(DataSourceTypeEnum.MASTER);
    }
    
    //设置读库,并简单实现负载均衡
    public static void slave() {
        int index = counter.getAndIncrement() % 2;
        if (counter.get() > 9999) {
            counter.set(0);
        }
        if (index == 0) {
        	target.set(DataSourceTypeEnum.SLAVE1);
            System.out.println("切换到slave1");
        }else {
        	target.set(DataSourceTypeEnum.SLAVE2);
            System.out.println("切换到slave2");
        }
    }
}
