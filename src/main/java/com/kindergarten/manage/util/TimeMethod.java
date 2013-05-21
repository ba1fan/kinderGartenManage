package com.kindergarten.manage.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TimeMethod {

	public static String getTimestapStr(Timestamp time) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd ");// 定义格式，不显示毫秒
		String str = df.format(time);
		return str;
	}

	public static Timestamp getTimestamp(String time) {
		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
			String t = df.format(format1.parse(time));
			Timestamp ts = Timestamp.valueOf(t);
			return ts;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static int getNowYear() {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		return year;
	}

	public static int getNowMonth() {
		Calendar cal = Calendar.getInstance();
		int month = cal.get(Calendar.MONTH) + 1;
		return month;
	}

	public static int getTimestapYear(Timestamp time) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy");// 定义格式，不显示毫秒
		String str = df.format(time);
		return Integer.parseInt(str);
	}

	public static int getTimestapMonth(Timestamp time) {
		SimpleDateFormat df = new SimpleDateFormat("MM");// 定义格式，不显示毫秒
		String str = df.format(time);
		return Integer.parseInt(str);
	}
}
