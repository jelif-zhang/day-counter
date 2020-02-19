package com.jelif.daycounter.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtil {
	private static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	public static LocalDate convertStringToLocalDate(String string) {
		return LocalDate.parse(string, FORMATTER);
	}
	
	public static String convertLocalDateToString(LocalDate localDate) {
		return localDate.format(FORMATTER);
	}
}
