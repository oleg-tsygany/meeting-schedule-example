package meeting.schedule.formatters;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class OfficeTimeFomatter {
	private static final String hourFormat = "HHmm";
	
	public static LocalTime parse(String hourStr) {
		DateTimeFormatter f = DateTimeFormatter.ofPattern(hourFormat);
		return LocalTime.from(f.parse(hourStr));
	}
	
	public static String format(LocalTime date) {
		return date.format(DateTimeFormatter.ofPattern(hourFormat));
	}
}
