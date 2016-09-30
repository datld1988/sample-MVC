package com.vtc.util;


public class MathUtil {
	public static Integer parseInt(String str) {
		int number = 0;
		try {
			number = Integer.parseInt(str);
		} catch (NumberFormatException e) {
			return null;
		}
		
		return number;
	}
	public static int parseInt(String str, int numDefault) {
		int number = 0;
		try {
			number = Integer.parseInt(str);
			return number;
		} catch (NumberFormatException e) {
			return numDefault;
		}
	}
	
	public static long parseLong(String str) {
		long number = 0L;
		try {
			number = Long.parseLong(str);
		} catch (NumberFormatException e) {
			number = 0L;
		}
		
		return number;
	}
	public static long parseLong(String str, long defaultValue) {
		long number = 0L;
		try {
			number = Long.parseLong(str);
		} catch (NumberFormatException e) {
			number = 0L;
		}
		
		return number;
	}

}
