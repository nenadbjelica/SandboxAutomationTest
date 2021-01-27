package sandbox.selenium.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTime {

	private static final String DATE_PATTERN = "dd.MM.yyyy";
	private static final String DATE_TIME_PATTERN = "dd.MM.yyyy 'at' HH.mm.ss";

	public static String getToday() {
		return formatDate(LocalDate.now());
	}

	public static String getNowTimestamp() {
		return formatDateTime(LocalDateTime.now());
	}

	private static String formatDate(LocalDate date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_PATTERN);
		return date.format(formatter);
	}

	private static String formatDateTime(LocalDateTime date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_TIME_PATTERN);
		return date.format(formatter);
	}

}
