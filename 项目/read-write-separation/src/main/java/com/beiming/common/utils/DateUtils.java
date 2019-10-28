package com.beiming.common.utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 
 *	时间工具类
 */
public class DateUtils {
	
	public static final String DATETIME_FORMATTER= "yyyy-MM-dd HH:mm:ss";

	/**
	 *  LocalDateTime转Date
	 */
	public static Date localDateTime2Date(LocalDateTime time) {
		Date date = Date.from(time.atZone(ZoneId.systemDefault()).toInstant());
		return date;
	}
	
	/**
	 *  LocalDate转Date
	 */
	public static Date localDate2Date(LocalDate time) {
		Date date = localDateTime2Date(time.atStartOfDay());
		return date;
	}
	
	/**
	 *  Date转LocalDateTime
	 */
	public static LocalDateTime date2LocalDateTime(Date time) {
		LocalDateTime date = Instant.ofEpochMilli(time.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
		return date;
	}
	
	/**
	 *  Date转LocalDate
	 */
	public static LocalDate date2LocalDate(Date time) {
		LocalDate date = Instant.ofEpochMilli(time.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
		return date;
	}
	
	/**
	 *	格式化时间 
	 */
	public static String localDateTime2String(LocalDateTime time, String formatter) {
		DateTimeFormatter pattern = DateTimeFormatter.ofPattern(formatter);
		return pattern.format(time);
	}
	
}
