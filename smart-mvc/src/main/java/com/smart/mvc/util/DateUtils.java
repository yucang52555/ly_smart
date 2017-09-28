package com.smart.mvc.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.joda.time.DateTime;

/**
 * 时间操作工具类
 * 
 * @author ktc 2016年9月1日 下午3:21:00
 */
public class DateUtils {
	
	
	/**
	 * 时间格式化
	 */
	public static final String DATE_FORMAT_YYYYMMDDHHMM = "yyyy-MM-dd HH:mm";
	
	public static final String DATE_FORMAT_YYYYMMDDHHMMSS = "yyyy-MM-dd HH:mm:ss";
	
	public static final String DATE_FORMATYYYYMMDDHHMMSS = "yyyyMMddHHmmss";
	
	public static final String DATE_FORMAT_YYYYMMDDHHMMSSSSS = "yyyy-MM-dd HH:mm:ss.SSS";
	
	public static final String DATE_FORMAT_YYYYMMDD = "yyyy-MM-dd";
	
	public static final String DATE_FORMAT_YYYYMM = "yyyy-MM";
	
	/**
	 * 获取年月日时分秒
	 * 
	 * @return 返回格式 yyyy-MM-dd HH:mm:ss
	 */
	public static String getDateTime() {
		DateTime dt = new DateTime();
		String date = dt.toString(DATE_FORMAT_YYYYMMDDHHMMSS);
		return date;
	}
	
	/**
	 * 获取当前日期
	 * 
	 * @param
	 * @return
	 * @变更记录 2016年8月9日 上午10:37:05 ktc
	 */
	public static String getCurDateStr() {
		DateTime dt = new DateTime();
		String date = dt.toString(DATE_FORMAT_YYYYMMDD);
		return date;
	}
	
	/**
	 * 获取当前日期
	 * 
	 * @param
	 * @return
	 * @变更记录 2016年8月9日 上午10:37:05 ktc
	 */
	public static Date getCurDate() {
		Date date = new Date();// 获取时间
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_YYYYMMDD);// 转换格式
		try {
			date = sdf.parse(sdf.format(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * 获取年月日时分秒
	 * 
	 * @return 返回格式 yyyy-MM-dd HH:mm:ss
	 */
	public static String dateToStr(Date date) {
		DateFormat df = new SimpleDateFormat(DATE_FORMAT_YYYYMMDDHHMMSS);
		return df.format(date);
	}
	
	/**
	 * 获取年月日时分
	 * 
	 * @return 返回格式 yyyy-MM-dd HH:mm:ss
	 */
	public static String getDatebranch() {
		DateTime dt = new DateTime();
		String date = dt.toString(DATE_FORMAT_YYYYMMDDHHMM);
		return date;
	}
	
	/**
	 * 获取当前系统时间
	 * 
	 * @return
	 */
	public static Date currentDateTime() {
		DateTime dt = new DateTime();
		Calendar calendar = dt.toCalendar(Locale.getDefault());
		return calendar.getTime();
	}
	
	/**
	 * 当前时间减 X 秒
	 * 
	 * @return 返回格式 yyyy-MM-dd HH:mm
	 */
	public static String reduceDateTime(int second) {
		DateTime dt = null;
		DateTime date = new DateTime();
		if (second > 0) {
			dt = date.minusSeconds(second);
		} else {
			dt = date;
		}
		return dt.toString(DATE_FORMAT_YYYYMMDDHHMM);
	}
	
	/**
	 * 按照(yyyy-MM-dd HH:mm)格式将字符串转换成Date类型
	 * 
	 * @param
	 * @return
	 * @变更记录 2016年8月5日 下午5:55:31 ktc
	 */
	public static Date toDate(String dateStr) {
		Date date = null;
		SimpleDateFormat formater = new SimpleDateFormat();
		formater.applyPattern(DATE_FORMAT_YYYYMMDDHHMM);
		try {
			date = formater.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * 按照提供的格式将字符串转换成Date类型
	 * 
	 * @param
	 * @return
	 * @变更记录 2016年8月5日 下午5:55:31 ktc
	 */
	public static Date toDate(String dateStr, String formatStr) {
		Date date = null;
		SimpleDateFormat formater = new SimpleDateFormat();
		formater.applyPattern(formatStr);
		try {
			date = formater.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * 指定时间往前推一个小时
	 * 
	 * @return
	 */
	public static Date reduceOneHour(Date tdate) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(tdate);
		calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - 1);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}
	
	/**
	 * 指定时间往前推指定单位时间
	 * 
	 * @param tdate
	 * @param timeUnit
	 * @param count
	 * @return
	 */
	public static Date reduceDays(Date tdate, int timeUnit, int count) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(tdate);
		if (Calendar.DAY_OF_MONTH == timeUnit) {
			calendar.set(Calendar.DAY_OF_MONTH, calendar.get(timeUnit) - count);
		}
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}
	
	/**
	 * 指定时间往后推一个小时
	 * 
	 * @return
	 */
	public static Date addOneHour(Date tdate) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(tdate);
		calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) + 1);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}
	
	/**
	 * 指定时间往后推一个小时
	 * 
	 * @return
	 */
	public static Date getClearHour(Date tdate) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(tdate);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}
	
	/**
	 * 获取当前小时数
	 * @param
	 * @return
	 * @变更记录 2016年8月11日 下午3:21:34 ktc
	 */
	public static Integer getCurHour() {
		Calendar calendar = Calendar.getInstance();
		return calendar.get(Calendar.HOUR_OF_DAY);
	}
	
	/**
	 * 计算两个日期之间相差的天数
	 * @param smdate 较小的时间
	 * @param bdate 较大的时间
	 * @return 相差天数
	 * @throws ParseException
	 */
	public static int daysBetween(Date smdate, Date bdate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		smdate = sdf.parse(sdf.format(smdate));
		bdate = sdf.parse(sdf.format(bdate));
		Calendar cal = Calendar.getInstance();
		cal.setTime(smdate);
		long time1 = cal.getTimeInMillis();
		cal.setTime(bdate);
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);
		return Integer.parseInt(String.valueOf(between_days));
	}
	
	/**
	 * 字符串的日期格式的计算
	 */
	public static int daysBetween(String smdate, String bdate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(sdf.parse(smdate));
		long time1 = cal.getTimeInMillis();
		cal.setTime(sdf.parse(bdate));
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);
		
		return Integer.parseInt(String.valueOf(between_days));
	}
	
	public static void main(String[] args) {
		System.out.println(getCurHour());
		Date date = DateUtils.toDate("2015-12-20", DATE_FORMAT_YYYYMMDD);
		date = reduceDays(date, Calendar.DAY_OF_MONTH, 280);
		System.out.println(DateUtils.dateToStr(date));
	}
}
