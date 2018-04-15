package com.chubb.dgmk.common.util;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class DateUtilsTest {

	@Test
	public void testGetZeroTimeDate() {

		SimpleDateFormat dateformat = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");

		String testDateString = "02-04-2013 11:35:42";
		String expectedDateString = "02-04-2013 00:00:00";

		try {

			Date testDate = dateformat.parse(testDateString);
			Date expectedDate = dateformat.parse(expectedDateString);

			// run the target method to zero the test date time
			testDate = DateUtils.getZeroTimeDate(testDate);

			// compare results, dates should equal
			assertTrue(expectedDate.compareTo(testDate) == 0);

		} catch (ParseException e) {
			e.printStackTrace();
			fail();
		}

	}

}
