package com.mirhenge.jyl.calendar.help;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarUtil {
	//3 ->03
	public static String two(int tt){
		String ss="";
		return (tt+"").length()>1?(tt+""):"0"+tt;
	}
	public static String yyyymm(int year, int month){
		return ""+year+two(month);
	}
	public static String yyyymmdd(int year, int month, int day){
		return yyyymm(year,month)+two(day);
	}
	public static String yyyymmddhhmm(int year, int month, int day,
			int hour, int min){
		return yyyymmdd(year,month,day)+two(hour)+two(min);
	}
	public static int one(String tt){
		if(tt.charAt(0)=='0'){
			return Integer.parseInt(""+tt.charAt(1));
		}else{
			return Integer.parseInt(tt);
		}
	}
	public static int toOne(String tt){
		if(tt.charAt(0)=='0'){
			return Integer.parseInt(""+tt.charAt(1));
		}else{
			return Integer.parseInt(tt);
		}
	}
	
	public static Calendar toCalendar(int year, int month, int day){
		Calendar cal=Calendar.getInstance();
		cal.set(year, month-1, day);
		return cal;
	}
	
	public static Date toDate(int year, int month, int day){
		return toCalendar(year,month,day).getTime();
	}
	
	public static java.sql.Date toSqlDate(int year, int month, int day){
		//SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String s=""+year+"-"+two(month)+"-"+two(day);
		return java.sql.Date.valueOf(s);
	}
	public static String toStrDate(Date dd){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		return sdf.format(dd);
	}
	
	public static String toStrDate(String dd){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmm");
		try {
			return toStrDate(sdf.parse(dd));
		} catch (ParseException e) {
			return dd;
		}
	}
	
	public static Calendar toCal(Date dd){
		Calendar cal=Calendar.getInstance();
		cal.setTime(dd);
		return cal;
	}
	
	
}
