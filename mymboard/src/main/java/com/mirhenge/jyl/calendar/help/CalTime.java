package com.mirhenge.jyl.calendar.help;

import java.util.Calendar;

public class CalTime {
	private int year;
	private int month;
	private int day;
	private int hour;
	private int min;
	public CalTime() {
	}
	public CalTime(int year, int month, int day, int hour, int min) {
		this.year = year;
		this.month = month;
		this.day = day;
		this.hour = hour;
		this.min = min;
	}
	public void setCalendar(Calendar cal) {
		year=cal.get(Calendar.YEAR);
		month=cal.get(Calendar.MONTH)+1;
		day=cal.get(Calendar.DATE);
		hour=cal.get(Calendar.HOUR_OF_DAY);
		min=cal.get(Calendar.MINUTE);
	}
	@Override
	public String toString() {
		return "CalTime [year=" + year + ", month=" + month + ", day=" + day + ", hour=" + hour + ", min=" + min + "]";
	}

	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
}
