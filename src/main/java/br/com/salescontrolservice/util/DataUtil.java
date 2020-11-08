package br.com.salescontrolservice.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DataUtil {
	
	public static String convertLocalDateTimeToDate(LocalDateTime localDateTime) {
	    return DateTimeFormatter.ofPattern("dd/MM/yyyy").format(localDateTime);
	}
	
	public static String convertLocalDateTimeToTime(LocalDateTime localDateTime) {
	    return DateTimeFormatter.ofPattern("HH:mm").format(localDateTime);
	}

}
