package com.vtc.util;


import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	public static final String PATTERN_YYYY_MM_DD_HH_MM_SS = "yyyy/MM/dd HH:mm:ss";
//	public static final String PATTERN_DDMMYYYY_HHMMSS = "dd/MM/yyyy HH:mm:ss";
	public static final String PATTERN_DDMMYYYY_HHMM = "dd/MM/yyyy HH:mm";
	public static final String PATTERN_YYYYMMDD = "yyyyMMdd";
	public static final String PATTERN_DD_MM = "dd/MM";
	public static final String PATTERN_MM_DD = "MMdd";
	public static final String PATTERN_D_M_Y = "d-M-y";
	public static final String PATTERN_YYYY_MM_DD = "yyyy_MM_dd";
	public static final String PATTERN_YYYYMMDDHHMMSS = "yyyyMMddhhmmss";
	public static final String PATTERN_YYYYMMDDHH = "yyyyMMddhh";
	public static final String PATTERN_YYYYMMDD_HYPHEN = "yyyy-MM-dd";
	public static final String PATTERN_YYYYMMDD_T_HHMMSS_Z = "yyyy-MM-dd'T'hh:mm:ssZ";

	public static String toString(Calendar calendar, String pattern) {
		try {
			DateFormat df = new SimpleDateFormat(pattern);
			
			String reportDate = df.format(calendar.getTime());
			return reportDate;
		} catch (Exception e) {
			return null;
		}
	}
	public static String toString(Timestamp time, String pattern) {
		try {
			DateFormat df = new SimpleDateFormat(pattern);
			
			String reportDate = df.format(time.getTime());
			return reportDate;
		} catch (Exception e) {
			return null;
		}
	}

	public static Timestamp toTimestamp(String datetime, String pattern) {
		Date date = null;
		try {
			DateFormat formatter = new SimpleDateFormat(pattern);
			formatter.setLenient(false);
			date = (Date) formatter.parse(datetime);
		} catch (ParseException e) {
			// System.out.println("Exception :" + e);
		}

		if (date == null) {
			return null;
		}

		return new Timestamp(date.getTime());
	}
	
	public static String convert(String src, String patternFrom, String patternTo) {
		try {
			DateFormat formatter = new SimpleDateFormat(patternFrom);
			formatter.setLenient(false);
			Date date = formatter.parse(src);
			Calendar c = Calendar.getInstance();
			c.setTime(date);
			return toString(c, patternTo);
		} catch (ParseException e) {
			// System.out.println("Exception :" + e);
		}
		return "";
	}

	public static Calendar toCalendar(String src, String pattern) {
		try {
			DateFormat formatter = new SimpleDateFormat(pattern);
			formatter.setLenient(false);
			Date date = formatter.parse(src);
			Calendar c = Calendar.getInstance();
			c.setTime(date);
			return c;
		} catch (ParseException e) {
			// System.out.println("Exception :" + e);
		}
		return Calendar.getInstance();
	}
	
	public static String longToString(String timeMillis, String pattern){
		try {
			Calendar c = Calendar.getInstance();
			c.setTimeInMillis(Long.parseLong(timeMillis));
			DateFormat df = new SimpleDateFormat(pattern);
			String reportDate = df.format(c.getTime());
			return reportDate;	
		} catch (Exception e) {
			// System.out.println("Exception :" + e);
		}
		
		return "";
	}
}
