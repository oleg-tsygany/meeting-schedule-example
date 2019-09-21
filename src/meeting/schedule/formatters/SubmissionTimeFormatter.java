package meeting.schedule.formatters;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SubmissionTimeFormatter {
	private static final String submissionFormat = "yyyy-MM-dd HH:mm:ss";
	
	public static LocalDateTime parse(String submissionTimeStr) {
		DateTimeFormatter f = DateTimeFormatter.ofPattern(submissionFormat);
		return LocalDateTime.from(f.parse(submissionTimeStr));
	}
	
	public static String format(LocalDateTime date) {
		return date.format(DateTimeFormatter.ofPattern(submissionFormat));
	}
}
