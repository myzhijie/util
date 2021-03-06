package com.jingsky.util.common;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * DATE 继承于 java.common.Date，多实现了很多方法。
 * @author 朱志杰 QQ：695520848
 * May 29, 2013 9:52:51 AM
 */
public class DateUtil {

    private Date date=null;

    /**
     * 获得当前对象的Date
     * @return Date
     */
    public Date getDate(){
        return this.date;
    }

	/**
	 * 功能：转换为Calendar。
	 * @author 朱志杰 QQ：695520848
	 * Aug 21, 2013 8:58:31 AM
	 * @return Calendar
	 */
	public Calendar toCalendar() {
        Calendar c = Calendar.getInstance();
        c.setTime(this.date);
        return c;
    }

	/**
	 * 功能：判断日期是否和当前date对象在同一天。
	 * @author 朱志杰 QQ：695520848
	 * Aug 21, 2013 7:15:53 AM
	 * @param date 比较的日期
	 * @return boolean 如果在返回true，否则返回false。
	 */
	public  boolean isSameDay(Date date) {
        if (date == null) {
            throw new IllegalArgumentException("日期不能为null");
        }
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date);
        return this.isSameDay(cal2);
    }

	/**
	 * 功能：判断日期是否和当前date对象在同一天。
	 * @author 朱志杰 QQ：695520848
	 * Aug 21, 2013 7:15:53 AM
	 * @param cal 比较的日期
	 * @return boolean 如果在返回true，否则返回false。
	 */
	public  boolean isSameDay(Calendar cal) {
        if (cal == null) {
            throw new IllegalArgumentException("日期不能为null");
        }
        //当前date对象的时间
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(this.date);
        return (cal1.get(Calendar.ERA) == cal.get(Calendar.ERA) &&
                cal1.get(Calendar.YEAR) == cal.get(Calendar.YEAR) &&
                cal1.get(Calendar.DAY_OF_YEAR) == cal.get(Calendar.DAY_OF_YEAR));
    }

	/**
	 * 功能：将当前日期的秒数进行重新设置。
	 * @author 朱志杰 QQ：695520848
	 * Jul 31, 2013 2:42:36 PM
	 * @param second 秒数
	 * @return 设置后的日期
	 */
	public Date setSecondNew(int second){
		Calendar c = Calendar.getInstance();
		c.setTime(this.date);
		c.set(Calendar.SECOND,second);
		return new Date(c.getTimeInMillis());
	}

	/**
	 * 功能：将当前日期的分钟进行重新设置。
	 * @author 朱志杰 QQ：695520848
	 * Jul 31, 2013 2:42:36 PM
	 * @param minute 分钟数
	 * @return 设置后的日期
	 */
	public Date setMinuteNew(int minute){
		Calendar c = Calendar.getInstance();
		c.setTime(this.date);
		c.set(Calendar.MINUTE,minute);
		return new Date(c.getTimeInMillis());
	}

	/**
	 * 功能：将当前日期的小时进行重新设置。
	 * @author 朱志杰 QQ：695520848
	 * Jul 31, 2013 2:42:36 PM
	 * @param hour 小时数 (24小时制)
	 * @return 设置后的日期
	 */
	public Date setHourNew(int hour){
		Calendar c = Calendar.getInstance();
		c.setTime(this.date);
		c.set(Calendar.HOUR_OF_DAY, hour);
		return new Date(c.getTimeInMillis());
	}

	/**
	 * 功能：将当前日期的天进行重新设置。
	 * @author 朱志杰 QQ：695520848
	 * Jul 31, 2013 2:42:36 PM
	 * @param day 某一天
	 * @return 设置后的日期
	 */
	public Date setDayNew(int day){
		Calendar c = Calendar.getInstance();
		c.setTime(this.date);
		c.set(Calendar.DATE,day);
		return new Date(c.getTimeInMillis());
	}

	/**
	 * 功能：将当前日期的月进行重新设置。
	 * @author 朱志杰 QQ：695520848
	 * Jul 31, 2013 2:42:36 PM
	 * @param month 某一月
	 * @return 设置后的日期
	 */
	public Date setMonthNew(int month){
		Calendar c = Calendar.getInstance();
		c.setTime(this.date);
		c.set(Calendar.MONTH, month-1);
		return new Date(c.getTimeInMillis());
	}

	/**
	 * 功能：将当前日期的年进行重新设置。
	 * @author 朱志杰 QQ：695520848
	 * Jul 31, 2013 2:42:36 PM
	 * @param year 某一年
	 * @return 设置后的日期
	 */
	public Date setYearNew(int year){
		Calendar c = Calendar.getInstance();
		c.setTime(this.date);
		c.set(Calendar.YEAR, year);
		return new Date(c.getTimeInMillis());
	}

	/**
	 * 功能：得到当月有多少天。
	 * @author 朱志杰 QQ：695520848
	 * Jul 2, 2013 4:59:41 PM
	 * @return int
	 */
	public int daysNumOfMonth(){
		Calendar cal = Calendar.getInstance();
		cal.setTime(this.date);
		return cal.getActualMaximum(Calendar.DATE);
	}

	/**
	 * 将yyyy-MM-dd HH:mm:ss字符串转换成日期(Date)
	 * @param dateStr 时间字符串
	 * @param dataFormat 当前时间字符串的格式。
	 * @return Date 日期 ,转换异常时返回null。
	 */
	public static Date parseDate(String dateStr,SimpleDateFormat dataFormat){
		try {
			java.util.Date d = dataFormat.parse(dateStr);
			return new Date(d.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
			throw new RuntimeException("日期格式不正确");
		}
	}

	/**
	 * 将yyyy-MM-dd HH:mm:ss字符串转换成日期(com.jingsky.common.Date)
	 * @param dateStr 时间字符串
	 * @param dataFormatStr 当前时间字符串的格式。
	 * @return Date 日期 ,转换异常时返回null。
	 */
	public static Date parseDate(String dateStr,String dataFormatStr){
		try {
			SimpleDateFormat dataFormat=new SimpleDateFormat(dataFormatStr);
			java.util.Date d = dataFormat.parse(dateStr);
			return new Date(d.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
			throw new RuntimeException("日期格式不正确");
		}
	}

	/**
	 * 将yyyy-MM-dd HH:mm:ss字符串转换成日期(com.jingsky.common.Date)
	 * @param dateStr yyyy-MM-dd HH:mm:ss字符串
	 * @return Date 日期 ,转换异常时返回null。
	 */
	public static Date parseDate(String dateStr){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			java.util.Date d = sdf.parse(dateStr);
			return new Date(d.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
			throw new RuntimeException("日期格式不正确，需要：yyyy-MM-dd HH:mm:ss");
		}
	}

	/**
	 * 功能：将java.common.Date 转换为本类的对象。
	 * 作者：朱志杰 QQ:862990787
	 * 2014-10-13 下午4:59:46
	 * @param date java.common.Date
	 * @return Date
	 */
	public static Date parseDate(java.util.Date date){
		return date==null ? null : new Date(date.getTime());
	}

	/**
	 * 功能：将java.sql.Date 转换为本类的对象。
	 * 作者：朱志杰 QQ:862990787
	 * 2014-10-13 下午4:59:46
	 * @param date java.common.Date
	 * @return Date
	 */
	public static Date parseDate(java.sql.Date date){
		return date==null ? null : new Date(date.getTime());
	}

	/**
	 * 功能：将java.sql.Timestamp 转换为本类的对象。
	 * 作者：朱志杰 QQ:862990787
	 * 2014-10-13 下午4:59:46
	 * @param timestamp java.sql.Timestamp
	 * @return Date
	 */
	public static Date parseDate(Timestamp timestamp){
		return timestamp==null ? null : new Date(timestamp.getTime());
	}

	/**
	 * 功能：将 java.common.Calendar 转换为本类的对象。
	 * 作者：朱志杰 QQ:862990787
	 * 2014-10-13 下午4:59:46
	 * @param calendar java.common.Calendar
	 * @return Date
	 */
	public static Date parseDate(Calendar calendar){
		return calendar==null ? null : calendar.getTime();
	}

	/**
	 * 功能：计算两个时间的时间差。
	 * @author 朱志杰 QQ：695520848
	 * May 29, 2013 2:34:08 PM
	 * @param time 另一个时间。
	 * @return Timespan 时间间隔
	 */
	public Timespan substract(Date time){
		return new Timespan(this.date.getTime()-time.getTime());
	}

	/**
	 * 功能：当前时间增加毫秒数。
	 * @author 朱志杰 QQ：695520848
	 * May 29, 2013 11:26:27 AM
	 * @param milliseconds 正值时时间延后，负值时时间提前。
	 * @return Date
	 */
	public Date addMilliseconds(int milliseconds){
		Calendar c = Calendar.getInstance();
		c.setTime(this.date);
		c.set(Calendar.MILLISECOND, c.get(Calendar.MILLISECOND)+milliseconds);
		return new Date(c.getTimeInMillis());
	}

	/**
	 * 功能：当前时间增加秒数。
	 * @author 朱志杰 QQ：695520848
	 * May 29, 2013 11:26:27 AM
	 * @param seconds 正值时时间延后，负值时时间提前。
	 * @return Date
	 */
	public Date addSeconds(int seconds){
		Calendar c = Calendar.getInstance();
		c.setTime(this.date);
		c.set(Calendar.SECOND, c.get(Calendar.SECOND)+seconds);
		return new Date(c.getTimeInMillis());
	}

	/**
	 * 功能：当前时间增加分钟数。
	 * @author 朱志杰 QQ：695520848
	 * May 29, 2013 11:26:27 AM
	 * @param minutes 正值时时间延后，负值时时间提前。
	 * @return Date
	 */
	public Date addMinutes(int minutes){
		Calendar c = Calendar.getInstance();
		c.setTime(this.date);
		c.set(Calendar.MINUTE, c.get(Calendar.MINUTE)+minutes);
		return new Date(c.getTimeInMillis());
	}

	/**
	 * 功能：当前时间增加小时数。
	 * @author 朱志杰 QQ：695520848
	 * May 29, 2013 11:26:27 AM
	 * @param hours 正值时时间延后，负值时时间提前。
	 * @return Date
	 */
	public Date addHours(int hours){
		Calendar c = Calendar.getInstance();
		c.setTime(this.date);
		c.set(Calendar.HOUR, c.get(Calendar.HOUR)+hours);
		return new Date(c.getTimeInMillis());
	}

	/**
	 * 功能：当前时间增加天数。
	 * @author 朱志杰 QQ：695520848
	 * May 29, 2013 11:26:27 AM
	 * @param days 正值时时间延后，负值时时间提前。
	 * @return Date
	 */
	public Date addDays(int days){
		Calendar c = Calendar.getInstance();
		c.setTime(this.date);
		c.set(Calendar.DATE, c.get(Calendar.DATE)+days);
		return new Date(c.getTimeInMillis());
	}

	/**
	 * 功能：当前时间增加月数。
	 * @author 朱志杰 QQ：695520848
	 * May 29, 2013 11:26:27 AM
	 * @param months 正值时时间延后，负值时时间提前。
	 * @return Date
	 */
	public Date addMonths(int months){
		Calendar c = Calendar.getInstance();
		c.setTime(this.date);
		c.set(Calendar.MONTH, c.get(Calendar.MONTH)+months);
		return new Date(c.getTimeInMillis());
	}

	/**
	 * 功能：当前时间增加年数。注意遇到2月29日情况，系统会自动延后或者减少一天。
	 * @author 朱志杰 QQ：695520848
	 * May 29, 2013 11:26:27 AM
	 * @param years 正值时时间延后，负值时时间提前。
	 * @return Date
	 */
	public Date addYears(int years){
		Calendar c = Calendar.getInstance();
		c.setTime(this.date);
		c.set(Calendar.YEAR, c.get(Calendar.YEAR)+years);
		return new Date(c.getTimeInMillis());
	}

	/**
	 * 得到秒。格式：56
	 * @return int
	 */
	public int secondInt() {
		return Integer.parseInt(toString("ss"));
	}

	/**
	 * 得到分钟。格式：56
	 * @return int
	 */
	public int minuteInt() {
		return Integer.parseInt(toString("mm"));
	}

	/**
	 * 得到小时。格式：23
	 * @return int
	 */
	public int hourInt() {
		return Integer.parseInt(toString("HH"));
	}

	/**
	 * 得到日。格式：26
	 * 注意：这里1日返回1,2日返回2。
	 * @return int
	 */
	public int dayInt() {
		return Integer.parseInt(toString("dd"));
	}

	/**
	 * 得到月。格式：5
	 * 注意：这里1月返回1,2月返回2。
	 * @return int
	 */
	public int monthInt() {
		return Integer.parseInt(toString("MM"));
	}

	/**
	 * 得到年。格式：2013
	 * @return int
	 */
	public int yearInt() {
		return Integer.parseInt(toString("yyyy"));
	}

	/**
	 * 得到短时间。格式：12:01
	 * @return String
	 */
	public String shortTime() {
		return toString("HH:mm");
	}

	/**
	 * 得到长时间。格式：12:01:01
	 * @return String
	 */
	public String longTime() {
		return toString("HH:mm:ss");
	}

	/**
	 * 得到今天的第一秒的时间。
	 * @return Date
	 */
	public Date dayStart() {
		Calendar c = Calendar.getInstance();
		c.setTime(this.date);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		return new Date(c.getTimeInMillis());
	}

    /**
     * 得到本周的第一秒的时间。(周一零点零分零秒)
     * @return Date
     */
    public Date weekdayStart() {
        Calendar c = Calendar.getInstance();
        c.setTime(this.date);
        c.set(Calendar.DAY_OF_WEEK, 2);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return new Date(c.getTimeInMillis());
    }

    /**
     * 得到本周的最后一秒的时间。(周日23:59:59)
     * @return Date
     */
    public Date weekdayEnd() {
        //先计算出来周六
        Calendar c = Calendar.getInstance();
        c.setTime(this.date);
        c.set(Calendar.DAY_OF_WEEK, 7);
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        c.set(Calendar.MILLISECOND, 59);
        Date d= new Date(c.getTimeInMillis());
        //再往后加1天
        return new DateUtil(d).addDays(1);
    }

	/**
     * 得到当前所在自然月的第一天的开始,格式为长日期格式。例如：2012-03-01 00:00:00。
     * @return Date
     */
    public Date monthStart(){
    	Calendar c=Calendar.getInstance();
    	String startStr= toString("yyyy-M-")+c.getActualMinimum(Calendar.DATE)+" 00:00:00";
    	return DateUtil.parseDate(startStr);
    }

	/**
     * 得到当前所在自然月的最后一天的结束,格式为长日期格式。例如：2012-03-01 00:00:00。
     * @return Date
     */
    public Date monthEnd(){
    	Calendar c=Calendar.getInstance();
    	String startStr= toString("yyyy-M-")+c.getActualMaximum(Calendar.DAY_OF_MONTH)+" 23:59:59";
    	return DateUtil.parseDate(startStr);
    }

	/**
	 * 得到今天的最后一秒的时间。
	 * @return Date
	 */
	public Date dayEnd() {
		Calendar c = Calendar.getInstance();
		c.setTime(this.date);
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		c.set(Calendar.MILLISECOND, 0);
		return new Date(c.getTimeInMillis());
	}

	/**
	 * 根据日期得到星期几,得到数字。
	 * 7, 1, 2, 3, 4, 5, 6
	 * @return Integer 如：6
	 */
	public int dayOfWeekInt() {
		Integer dayNames[] = { 7, 1, 2, 3, 4, 5, 6 };
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(this.date);
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		if (dayOfWeek < 0)
			dayOfWeek = 0;
		return dayNames[dayOfWeek];
	}

	/**
	 * 将日期转换成长日期字符串 例如：2009-09-09 01:01:01
	 * @return String
	 */
	public String toLongDate() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return (null == this.date) ? null : df.format(this.date);
	}

	/**
	 * 将日期转换成中长日期字符串,不含秒 例如：2009-09-09 01:01
	 * @return String
	 */
	public String toMidDate() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		return (null == this.date) ? null : df.format(this.date);
	}

	/**
	 * 将日期按照一定的格式进行格式化为字符串。
	 * 例如想将时间格式化为2012-03-05 12:56 ,则只需要传入formate为yyyy-MM-dd HH:mm即可。
	 * @param formate 格式化格式，如：yyyy-MM-dd HH:mm
	 * @return String 格式后的日期字符串。如果当前对象为null，则直接返回null。
	 */
	public String toString(String formate) {
		DateFormat df = new SimpleDateFormat(formate);
		return (null == this.date) ? null : df.format(this.date);
	}

	/**
	 * 得到某个时间的时间戳yyyyMMddHHmmss。
	 * @return String 如果当前对象为null，则直接返回null。
	 */
	public String toTimeStamp() {
		DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		return (null == this.date) ? null : df.format(this.date);
	}

	/**
	 * 将日期转换成短日期字符串,例如：2009-09-09。
	 * @return String ,如果当前对象为null，返回null。
	 */
	public String toShortDate() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return (null == this.date) ? null : df.format(this.date);
	}


	/**
	 * 功能：用java.common.Date进行构造。
	 * 注意：若date为null，则构造为当前时间。
	 * @author 朱志杰 QQ：695520848
	 * May 29, 2013 10:59:05 AM
	 * @param  date
	 */
	public DateUtil(Date date) {
		this.date=date==null ? new Date() : date;
	}

    /**
     * 功能：用Timestamp进行构造。
     * 注意：若timestamp为null，则构造为当前时间。
     * @author 朱志杰 QQ：695520848
     * May 29, 2013 10:59:05 AM
     * @param  timestamp
     */
    public DateUtil(Timestamp timestamp) {
        this.date=timestamp==null ? new Date() : new Date(timestamp.getTime());
    }

	/**
	 * 功能：用毫秒进行构造。
	 * @author 朱志杰 QQ：695520848
	 * May 29, 2013 10:59:05 AM
	 * @param timeInMillis
	 */
	public DateUtil(long timeInMillis) {
        this.date=new Date(timeInMillis);
	}

    /**
     * 功能：calendar进行构造。
     * * 注意：若timestamp为null，则构造为当前时间。
     * @author 朱志杰 QQ：695520848
     * May 29, 2013 10:59:05 AM
     * @param calendar
     */
    public DateUtil(Calendar calendar) {
        this.date=calendar!=null ? calendar.getTime() : new Date();
    }


	/**
	 * 功能：默认构造函数。
	 * @author 朱志杰 QQ：695520848
	 * May 29, 2013 11:00:05 AM
	 */
	public DateUtil() {
		this.date=new Date();
	}

	//------------------------暂未详细整理 start-------------------------------
	public static long DAY = 86400000l;
	public static int DAY_SECOND = 86400;
	public static int DAYS_30 = 2592000;
	public static int ONE_HOUR = 3600;
	public static Map<String, Integer> months = new HashMap<String, Integer>() {{
		put("JANUARY", 1);
		put("JAN", 1);
		put("FEBRUARY", 2);
		put("FEB", 2);
		put("MARCH", 3);
		put("MAR", 3);
		put("APRIL", 4);
		put("APR", 4);
		put("MAY", 5);
		put("MAY", 5);
		put("JUNE", 6);
		put("JUN", 6);
		put("JULY", 7);
		put("JUL", 7);
		put("AUGUST", 8);
		put("AUG", 8);
		put("SEPTEMBER", 9);
		put("SEP", 9);
		put("SEPT", 9);
		put("OCTOBER", 10);
		put("OCT", 10);
		put("NOVEMBER", 11);
		put("NOV", 11);
		put("DECEMBER", 12);
		put("DEC", 12);
	}};

	public static SimpleDateFormat getIso8601DateFormat() {
		final SimpleDateFormat ISO8601UTC = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");// 24
		ISO8601UTC.setTimeZone(TimeZone.getTimeZone("UTC")); // UTC == GMT
		return ISO8601UTC;
	}

	public static SimpleDateFormat getYmdUtcDateFormat() {
		final SimpleDateFormat ISO8601UTC = new SimpleDateFormat("yyyy-MM-dd");// 24
		ISO8601UTC.setTimeZone(TimeZone.getTimeZone("UTC")); // UTC == GMT
		return ISO8601UTC;
	}

	public static DateFormat getDateFormat(String format) {
		return new SimpleDateFormat(format);
	}

	public static Calendar getCurrentUtcTime() {
		return Calendar.getInstance(TimeZone.getTimeZone("UTC"));
	}

	public static Long parse(String s) {
		if (s == null)
			return null;
		s = s.toUpperCase().trim();
		if (s.length() == 0)
			return null;
		s.replaceAll("[-/ \\.]+", " ");
		String[] item = s.split(" ");

		Integer year = null;
		try {
			year = Integer.parseInt(item[0]);
		} catch (Exception e) {
		}

		Integer month = null;
		Integer day = null;
		if (year != null) {
			try {
				month = Integer.parseInt(item[1]);
			} catch (Exception e) {
				month = months.get(item[1]);
			}
			if (month == null)
				throw new RuntimeException("unknow date format");
		}

		return null;
	}

	public static long firstDayOfNextMonth() {
		Calendar aCalendar = getCurrentUtcTime();
		aCalendar.add(Calendar.MONTH, 1);
		aCalendar.set(Calendar.DATE, 1);
		aCalendar.set(Calendar.HOUR_OF_DAY, 0);
		aCalendar.set(Calendar.MINUTE, 0);
		aCalendar.set(Calendar.SECOND, 0);
		aCalendar.set(Calendar.MILLISECOND, 0);
		return aCalendar.getTime().getTime();
	}

	public static long firstDayOfNextMonth(long date) {
		Calendar aCalendar = getCurrentUtcTime();
		aCalendar.setTimeInMillis(date);
		aCalendar.add(Calendar.MONTH, 1);
		aCalendar.set(Calendar.DATE, 1);
		aCalendar.set(Calendar.HOUR_OF_DAY, 0);
		aCalendar.set(Calendar.MINUTE, 0);
		aCalendar.set(Calendar.SECOND, 0);
		aCalendar.set(Calendar.MILLISECOND, 0);
		return aCalendar.getTime().getTime();
	}

	public static long firstDayOfNextYear() {
		Calendar aCalendar = getCurrentUtcTime();
		aCalendar.add(Calendar.YEAR, 1);
		aCalendar.set(Calendar.MONTH, 0);
		aCalendar.set(Calendar.DATE, 1);
		aCalendar.set(Calendar.HOUR_OF_DAY, 0);
		aCalendar.set(Calendar.MINUTE, 0);
		aCalendar.set(Calendar.SECOND, 0);
		aCalendar.set(Calendar.MILLISECOND, 0);
		return aCalendar.getTime().getTime();
	}

	public static long firstDayOfLastYear() {
		Calendar aCalendar = getCurrentUtcTime();
		aCalendar.add(Calendar.YEAR, -1);
		aCalendar.set(Calendar.MONTH, 0);
		aCalendar.set(Calendar.DATE, 1);
		aCalendar.set(Calendar.HOUR_OF_DAY, 0);
		aCalendar.set(Calendar.MINUTE, 0);
		aCalendar.set(Calendar.SECOND, 0);
		aCalendar.set(Calendar.MILLISECOND, 0);
		return aCalendar.getTime().getTime();
	}

	public static long firstDayOfCurrentMonth() {
		Calendar aCalendar = getCurrentUtcTime();
		aCalendar.set(Calendar.DATE, 1);
		aCalendar.set(Calendar.HOUR_OF_DAY, 0);
		aCalendar.set(Calendar.MINUTE, 0);
		aCalendar.set(Calendar.SECOND, 0);
		aCalendar.set(Calendar.MILLISECOND, 0);
		return aCalendar.getTime().getTime();
	}

	public static long firstDayOfCurrentYear() {
		Calendar aCalendar = getCurrentUtcTime();
		aCalendar.set(Calendar.MONTH, 0);
		aCalendar.set(Calendar.DATE, 1);
		aCalendar.set(Calendar.HOUR_OF_DAY, 0);
		aCalendar.set(Calendar.MINUTE, 0);
		aCalendar.set(Calendar.SECOND, 0);
		aCalendar.set(Calendar.MILLISECOND, 0);
		return aCalendar.getTime().getTime();
	}

	public static long firstDayOfLastMonth() {
		Calendar aCalendar = getCurrentUtcTime();
		aCalendar.add(Calendar.MONTH, -1);
		aCalendar.set(Calendar.DATE, 1);
		aCalendar.set(Calendar.HOUR_OF_DAY, 0);
		aCalendar.set(Calendar.MINUTE, 0);
		aCalendar.set(Calendar.SECOND, 0);
		aCalendar.set(Calendar.MILLISECOND, 0);
		return aCalendar.getTime().getTime();
	}

	public static long firstDayOfMonth(long date) {
		Calendar aCalendar = getCurrentUtcTime();
		aCalendar.setTimeInMillis(date);
		aCalendar.set(Calendar.DATE, 1);
		aCalendar.set(Calendar.HOUR_OF_DAY, 0);
		aCalendar.set(Calendar.MINUTE, 0);
		aCalendar.set(Calendar.SECOND, 0);
		aCalendar.set(Calendar.MILLISECOND, 0);
		return aCalendar.getTime().getTime();
	}

	public static long firstDayOfYear(long date) {
		Calendar aCalendar = getCurrentUtcTime();
		aCalendar.setTimeInMillis(date);
		aCalendar.set(Calendar.MONTH, 0);
		aCalendar.set(Calendar.DATE, 1);
		aCalendar.set(Calendar.HOUR_OF_DAY, 0);
		aCalendar.set(Calendar.MINUTE, 0);
		aCalendar.set(Calendar.SECOND, 0);
		aCalendar.set(Calendar.MILLISECOND, 0);
		return aCalendar.getTime().getTime();
	}

	public static void main(String[] args) {
		Date date = new Date(1425196800000l);
		System.out.println(date);
	}

	public static String gmt8format(Date date, String pattern) {
		if (date == null || pattern == null) {
			return "";
		}

		SimpleDateFormat simpleDateFordmat = new SimpleDateFormat(pattern);
		simpleDateFordmat.setTimeZone(TimeZone.getTimeZone("GMT+8"));
		return simpleDateFordmat.format(date);
	}

	/**
	 * 字符转日期
	 *
	 * @param source  日期字符串
	 * @param pattern 格式化类型
	 * @return 日期 date
	 */
	public static Date gmt8parse(String source, String pattern) {
		if (source == null || pattern == null) {
			return null;
		}

		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8"));
			return simpleDateFormat.parse(source);
		} catch (ParseException e) {
			return null;
		}
	}

	public static Date getWeekStartDate(Date date) {
		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	public static Date getMonthStartDate(Date date) {
		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	public static Date getGMT8TodayStart(Date date){
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	public static Date getGMT8TodayEnd(Date date){
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}
	//------------------------暂未详细整理 end-------------------------------
}
