package com.chubb.dgmk.caf.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class StringUtil 	{

	public static String concatenateMessage(List<String> strings, String separator){
		StringBuffer sb = new StringBuffer();
		for (String message:strings){
			sb.append(message);
			sb.append(separator);
		}

		return sb.toString();
	}

	public static String formatDate(Date aDate){
		DateFormat df = new SimpleDateFormat("dd MMM yyyy");// example :30 June 2015
		return df.format(aDate);
	}

	/**
	 * <pre>
	 * padWithTrailingZeroesStr
	 * 
	 * July 10, 2015
	 * 
	 * This method pads a string with the trailing zeroes to the length specified.
	 * 
	 * 
	 * @param aString String
	 * @param aLength int
	 * @return trimmedString String
	 * </pre>
	 */
	public static String padWithTrailingZeroesStr(String aString, int aLength) {
		String rtnStr=padWithTrailingCharacterStr(aString, "0".charAt(0), aLength);
		return(rtnStr);

	}
	
	/**
	 * <pre>
	 * padWithTrailingCharacterStr
	 * 
	 * July 10, 2015 
	 * 
	 * This method pads a string with the trailing character provided to the length specified.
	 * 
	 * @param aString String
	 * @param aChar char
	 * @param aLength int
	 * @return paddedString String
	 * </pre>
	 */
	public static String padWithTrailingCharacterStr(String aString, char aChar, int aLength) {
		StringBuffer stringBuffer = new StringBuffer(aString);
		int size = aString.length();
		while (size < aLength) {
			stringBuffer.insert(0,aChar);
			size++;
		}
		String rtnStr=stringBuffer.toString();
		return(rtnStr);
		
	}
	
	/**
	 * This method is used to set date without time
	 * @param c
	 * @return
	 */
	public static XMLGregorianCalendar toXMLGregorianCalendarDateOnly(Calendar c){
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTimeInMillis(c.getTimeInMillis());
		XMLGregorianCalendar xc= null;
		try {
			xc = DatatypeFactory.newInstance().newXMLGregorianCalendarDate(gc.get(Calendar.YEAR),gc.get(Calendar.MONTH)+1,gc.get(Calendar.DAY_OF_MONTH),DatatypeConstants.FIELD_UNDEFINED);
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		}
		
		return xc;
		
	}
	
}
