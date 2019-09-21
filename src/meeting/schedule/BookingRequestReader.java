package meeting.schedule;

import java.util.Scanner;

import meeting.schedule.exceptions.BookingReaderException;
import meeting.schedule.formatters.MeetingTimeFormatter;
import meeting.schedule.formatters.SubmissionTimeFormatter;
import meeting.schedule.model.BookingRequest;

public class BookingRequestReader {
	
	private static String nextEntry(Scanner scanner) throws BookingReaderException {
		String input = scanner.next();
		if(input.startsWith("--")) {
			throw new BookingReaderException("Can not read object, end of input");
		}
		return input;
	}
	
	public static BookingRequest read(Scanner scanner) throws BookingReaderException {
		BookingRequest request = new BookingRequest();
		
		// Read submission time
		String element = nextEntry(scanner).concat(" ").concat(nextEntry(scanner));
		request.setSubmissionTime(SubmissionTimeFormatter.parse(element));
		
		// Read Employee ID
		element = nextEntry(scanner);
		request.setEmployeeID(element);
		
		// Read submission time
		element = nextEntry(scanner).concat(" ").concat(nextEntry(scanner));
		request.setMeetingStartTime(MeetingTimeFormatter.parse(element));
		
		// Read meeting duration
		element = nextEntry(scanner);
		request.setDuration(Long.parseLong(element));
		
		return request;
	}
}
