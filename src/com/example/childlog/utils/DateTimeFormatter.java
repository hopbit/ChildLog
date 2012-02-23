package com.example.childlog.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class DateTimeFormatter {

	/** Hide default public constructor */
	private DateTimeFormatter(){}
	
	public static final String DATE = "yyyy-MM-dd";
	public static final String DATE_WITH_TIME = "yyyy-MM-dd HH:mm";
	
	public static String timestampToString(Timestamp ts, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(ts);
	}
}
