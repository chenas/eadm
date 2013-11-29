package com.base.framwork.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.lang3.StringUtils;


/**
 * 
 * 日期工具类
 * 
 */
public class DateUtil {

	/**
	 * ���ڸ�ʽ
	 */
	private static String datePattern = "yyyy-MM-dd";

	/**
	 * ʱ���ʽ
	 */
	private static String timePattern = "HH:mm:ss";


	/**
	 * Return default datePattern (MM/dd/yyyy)
	 * 
	 * @return a string representing the date pattern on the UI
	 */
	public static String getDatePattern() {
		return datePattern;
	}

	/**
	 * This method attempts to convert an Oracle-formatted date in the form
	 * dd-MMM-yyyy to mm/dd/yyyy.
	 * 
	 * @param aDate
	 *            date from database as a string
	 * @return formatted string for the ui
	 */
	public static final String getDate(Date aDate) {
		SimpleDateFormat df = null;
		String returnValue = "";

		if (aDate != null) {
			df = new SimpleDateFormat(datePattern);
			returnValue = df.format(aDate);
		}

		return (returnValue);
	}

	/**
	 * This method generates a string representation of a date/time in the
	 * format you specify on input
	 * 
	 * @param aMask
	 *            the date pattern the string is in
	 * @param strDate
	 *            a string representation of a date
	 * @return a converted Date object
	 * @see java.text.SimpleDateFormat
	 * @throws ParseException
	 *             ת���쳣
	 */
	public static final Date convertStringToDate(String aMask, String strDate)
			throws ParseException {
		SimpleDateFormat df = null;
		Date date = null;
		df = new SimpleDateFormat(aMask);

		try {
			date = df.parse(strDate);
		} catch (ParseException pe) {
			// log.error("ParseException: " + pe);
			throw new ParseException(pe.getMessage(), pe.getErrorOffset());
		}

		return (date);
	}

	/**
	 * This method generates a string representation of a date/time in the
	 * format you specify on input
	 * 
	 * @param strDate
	 *            a string representation of a date
	 * @return a converted Date object
	 * @see java.text.SimpleDateFormat
	 * @throws ParseException
	 *             ת���쳣
	 */
	public static final Date convertStringToDateTime(String strDate)
			throws ParseException {
		SimpleDateFormat df = null;
		Date date = null;
		df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (strDate != null && strDate.length() == 16) {
			strDate += ":00";
		}
		if (strDate != null && strDate.length() == 15) {
			strDate = strDate.substring(0, 5) + "0" + strDate.substring(5, 10)
					+ "0" + strDate.substring(10, 14) + ":00";
		}
		if (StringUtils.isEmpty(strDate)) {
			return null;
		}
		try {
			date = df.parse(strDate);
		} catch (ParseException pe) {
			// log.error("ParseException: " + pe);
			throw new ParseException(pe.getMessage(), pe.getErrorOffset());
		}

		return (date);
	}

	/**
	 * This method returns the given date time in the format: HH:MM:SS
	 * 
	 * @param theTime
	 *            the time string
	 * @return the given date/time
	 */
	public static String getTimeString(Date theTime) {
		return getDateTime(timePattern, theTime);
	}

	/**
	 * This method returns the current date in the format: MM/dd/yyyy
	 * 
	 * @return the current date
	 * @throws ParseException
	 *             ת���쳣
	 */
	public static Calendar getToday() throws ParseException {
		Date today = new Date();
		SimpleDateFormat df = new SimpleDateFormat(datePattern);

		// This seems like quite a hack (date -> string -> date),
		// but it works ;-)
		String todayAsString = df.format(today);
		Calendar cal = new GregorianCalendar();
		cal.setTime(convertStringToDate(todayAsString));

		return cal;
	}

	/**
	 * This method generates a string representation of a date's date/time in
	 * the format you specify on input
	 * 
	 * @param aMask
	 *            the date pattern the string is in
	 * @param aDate
	 *            a date object
	 * @return a formatted string representation of the date
	 * 
	 * @see java.text.SimpleDateFormat
	 */
	public static final String getDateTime(String aMask, Date aDate) {
		SimpleDateFormat df = null;
		String returnValue = "";

		if (aDate == null) {
		} else {
			df = new SimpleDateFormat(aMask);
			returnValue = df.format(aDate);
		}

		return (returnValue);
	}

	/**
	 * This method generates a string representation of a date's date/time in
	 * the format you specify on input
	 * 
	 * @param aDate
	 *            a date object
	 * @return a formatted string representation of the date
	 * 
	 * @see java.text.SimpleDateFormat
	 */
	public static final String getDateTime(Date aDate) {
		SimpleDateFormat df = null;
		String returnValue = "";

		if (aDate == null) {
		} else {
			df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			returnValue = df.format(aDate);
		}

		return (returnValue);
	}

	/**
	 * This method generates a string representation of a date based on the
	 * System Property 'dateFormat' in the format you specify on input
	 * 
	 * @param aDate
	 *            A date to convert
	 * @return a string representation of the date
	 */
	public static final String convertDateToString(Date aDate) {
		return getDateTime(datePattern, aDate);
	}

	/**
	 * This method converts a String to a date using the datePattern
	 * 
	 * @param strDate
	 *            the date to convert (in format MM/dd/yyyy)
	 * @return a date object
	 * 
	 * @throws ParseException
	 *             ת���쳣
	 */
	public static Date convertStringToDate(String strDate)
			throws ParseException {
		Date aDate = null;
		if (StringUtils.isEmpty(strDate)) {
			return null;
		}
		try {
			aDate = convertStringToDate(datePattern, strDate);
		} catch (ParseException pe) {
			pe.printStackTrace();
			throw new ParseException(pe.getMessage(), pe.getErrorOffset());

		}

		return aDate;
	}

	/**
	 * ���date1>date2 ���� 1 = 0 < -1
	 * 
	 * @param date1
	 *            ����1
	 * @param date2
	 *            ����2
	 * @return �ȽϽ��
	 */
	public static int compareDate(Date date1, Date date2) {
		String d1 = getDateTime(datePattern, date1);
		String d2 = getDateTime(datePattern, date2);

		if (d1 == null && d2 != null)
			return -1;
		else if (d1 != null && d2 == null)
			return 1;
		else if (d1 == null && d2 == null)
			return 0;
		else
			return d1.compareTo(d2);
	}

	/**
	 * ������ת��Ϊ���ĵ�������ʽyyyy��MM��dd�գ���2009��11��24��
	 * @param date ������
	 * @return ���ĸ�ʽ������
	 */
	public static String convertDateToChineseString(Date date) {
		DateFormat df = new SimpleDateFormat("yyyy��MM��dd��");

		String strDate = df.format(date);

		return strDate;
	}

	/**
	 * ���·ݣ�������������
	 * @param month ���·�
	 * @return ��������
	 */
	public static String getQuarterByMonth(String month) {
		return "" + ((Integer.parseInt(month) - 1) / 3 + 1);

	}

	/**
	 * ��������µĵ�һ��
	 * @param thisMonth ���µ��κ�һ�죬����2009-12-13
	 * @return ����
	 */
	public static String getThisMonthFirstDay(String thisMonth) {
		String[] t = StringUtils.split(thisMonth, "-");

		return t[0] + "-" + t[1] + "-01";
	}


	/**
	 * ����ͳ�����ں�ʱ��
	 * 
	 * @param dateStr ͳ�����ڴ�
	 * @param timeStr ʱ�δ�
	 * @return ͳ�����ں�ʱ�����ϴ�
	 */
	public static String unionDateAndTime(String dateStr, String timeStr) {
		Date date = null;
		try {
			date = DateUtil.convertStringToDate(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.HOUR_OF_DAY, Integer.parseInt(timeStr));
		return DateUtil.getDateTime(cal.getTime());
	}

	/**
	 * �����ڣ��������ܼ������ĸ�ʽ�ģ�����2009-11-25�ǡ�������
	 * @param date ������
	 * @return �ܼ�
	 */
	public static String getWeek(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat(" E ");
		String ctime = formatter.format(date);
		return ctime;
	}
}
