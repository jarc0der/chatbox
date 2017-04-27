package com.jarcode.auth.utils;

import java.sql.Timestamp;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateTimeUtils {

	private DateTimeUtils() {
	}

	public static String getCurTimeStamp() {
		return String.valueOf(new Timestamp(System.currentTimeMillis()).getTime());
	}

	public static String convertStampToDate(String timestamp) {
//	 return new Timestamp(Long.valueOf(timestamp)).toString();
		String time = null;
		Pattern p = Pattern.compile("(\\d+)\\:(\\d+)");  
        Matcher m = p.matcher(new Timestamp(Long.valueOf(timestamp)).toString());
        if(m.find()){
        	return time = m.group(1) + ":" + m.group(2);
        }else{
        	return time = "unknown";
        }
		
	}

}
