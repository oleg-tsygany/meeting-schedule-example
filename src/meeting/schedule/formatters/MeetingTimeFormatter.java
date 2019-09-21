package meeting.schedule.formatters;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MeetingTimeFormatter {
	private static final String meetingFormat = "yyyy-MM-dd HH:mm";
	
	public static LocalDateTime parse(String submissionTimeStr) {
		DateTimeFormatter f = DateTimeFormatter.ofPattern(meetingFormat);
		return LocalDateTime.from(f.parse(submissionTimeStr));
	}
	
	public static String format(LocalDateTime date) {
		return date.format(DateTimeFormatter.ofPattern(meetingFormat));
	}
}
