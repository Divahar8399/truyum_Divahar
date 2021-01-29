package com.cognizant.truyum.util;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateUtil {
	public static Date convertToDate(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
		sdf.setLenient(false);
		Date d= null;
		try {
			d= sdf.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return d;
		
		
	}

}
