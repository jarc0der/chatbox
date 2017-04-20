package com.jarcode.auth.utils;

import java.sql.Timestamp;

public class DateTimeUtils {
	
	private DateTimeUtils() {}
	
	public static String getCurTimeStamp(){
		return String.valueOf(new Timestamp(System.currentTimeMillis()).getTime());
	}
	
	public static String convertStampToDate(String timestamp){
		return new Timestamp(Long.valueOf(timestamp)).toString();
	}

}
