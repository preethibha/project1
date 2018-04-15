package com.chubb.dgmk.common.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class DateUtils {
	public static SimpleDateFormat formatter_dd_MMM_yy = new SimpleDateFormat("dd-MMM-yy");
	public static SimpleDateFormat dateFormatterForDB = new SimpleDateFormat("yyyy-mm-dd");
	private static Date forever = new GregorianCalendar(9999, 11, 31).getTime();

	public static Date dateForever() {
		return forever;
	}

	/**
	 * String to date.
	 * 
	 * @param dateString
	 *            the date string
	 * @param formatter
	 *            the formatter
	 * @return the date
	 * @throws ParseException
	 *             the parse exception
	 */
	public static Date stringToDate(String dateString, SimpleDateFormat formatter) throws ParseException {
		return formatter.parse(dateString);
	}
	
	/**
	 * Gets the zero time of the date.
	 *
	 * @param dt the dt
	 * @return the zero time date
	 */
	public static Date getZeroTimeDate(Date dt) {
	    Date res = dt;
	    Calendar calendar = Calendar.getInstance();

	    calendar.setTime( dt );
	    calendar.set(Calendar.HOUR_OF_DAY, 0);
	    calendar.set(Calendar.MINUTE, 0);
	    calendar.set(Calendar.SECOND, 0);
	    calendar.set(Calendar.MILLISECOND, 0);

	    res = calendar.getTime();

	    return res;
	}
	
	/**
	 * Gets the zero time of the date.
	 *
	 * @param dt the dt
	 * @return the zero time date
	 */
	public static Date getLastMinDate(Date dt) {
	    Date res = dt;
	    Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);

	    res = cal.getTime();

	    return res;
	}
	
	/**
	 * Gets the zero time of the date.
	 *
	 * @param dt the dt
	 * @return the zero time date
	 */
	public static Date getYesterdayLastMinDate(Date dt) {
	    Date res = dt;
	    Calendar cal = Calendar.getInstance();
	  	cal.setTime(dt);
	  	cal.add(Calendar.DAY_OF_MONTH, -1);
	  	cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);

	    res = cal.getTime();

	    return res;
	}


	public Date dateToday() {
		Date today = new GregorianCalendar().getTime();
		return today;
	}
	
	/*
     * Converts XMLGregorianCalendar to java.util.Date in Java
     */
    public static Date toDate(XMLGregorianCalendar calendar){
        if(calendar == null) {
            return null;
        }
        return calendar.toGregorianCalendar().getTime();
    }


	public Timestamp timestampNow() {
		Timestamp now = new Timestamp(dateToday().getTime());
		return now;
	}
	
	public static String asDatabaseQueryString(java.util.Date myDate){
		java.sql.Date sqlDate = new java.sql.Date(myDate.getTime());
		return DateUtils.dateFormatterForDB.format(sqlDate);
	}
	
	public XMLGregorianCalendar getXMLGregorianCalendar() throws DatatypeConfigurationException{
		GregorianCalendar c = new GregorianCalendar();
		c.setTime(dateToday());
		XMLGregorianCalendar xmlGregdate = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
		return xmlGregdate;
	}
	
	public XMLGregorianCalendar getXMLGregorianCalForever() throws DatatypeConfigurationException{
		GregorianCalendar c = new GregorianCalendar();
		c.setTime(dateForever());
		XMLGregorianCalendar xmlGregdate = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
		return xmlGregdate;
	}
	
	public static Date addDays(Date date, int days){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days); //minus number would decrement the days
        return cal.getTime();
    }
	
	public static Date trimTimeOfDay(Date date) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        return calendar.getTime();
    }
}
