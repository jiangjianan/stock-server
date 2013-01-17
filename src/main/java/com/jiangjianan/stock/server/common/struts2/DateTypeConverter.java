package com.jiangjianan.stock.server.common.struts2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import com.opensymphony.xwork2.conversion.TypeConversionException;

public class DateTypeConverter extends StrutsTypeConverter {

	@SuppressWarnings("rawtypes")
	@Override
	public Object convertFromString(Map arg0, String[] arg1, Class arg2) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Date result = null;
		try {
			result = dateFormat.parse(arg1[0]);
		} catch (ParseException e) {
			throw new TypeConversionException("Invalid Syntax");
		}
		return result;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public String convertToString(Map arg0, Object arg1) {
		Date date = (Date) arg1;
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		return dateFormat.format(date);
	}

}
