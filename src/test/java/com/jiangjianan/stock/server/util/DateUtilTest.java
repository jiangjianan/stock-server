package com.jiangjianan.stock.server.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.ParseException;
import java.util.Date;

import org.junit.Test;

public class DateUtilTest {
	@Test
	public void stringToDate() throws ParseException {
		Date date = DateUtil.stringToDate("1982-12-20 00:00:00");
		assertNotNull(date);
	}

	@Test
	public void dateToString() throws ParseException {
		Date date = DateUtil.stringToDate("1982-12-20 00:00:00");
		assertEquals("19821220", DateUtil.dateToString(date));
	}
}
