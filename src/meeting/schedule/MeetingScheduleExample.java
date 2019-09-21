package meeting.schedule;

import java.util.Scanner;

import meeting.schedule.exceptions.BookingException;
import meeting.schedule.exceptions.BookingReaderException;
import meeting.schedule.exceptions.TimeFormatException;
import meeting.schedule.model.BookingRequest;
import meeting.schedule.model.MeetingSchedule;
import meeting.schedule.model.OfficeTimes;

public class MeetingScheduleExample {
	
	public static void main(String[] args) throws TimeFormatException, BookingException  {
		System.out.println("Please enter your booking request.");
		System.out.println("To end of input use '--', for example:");
		System.out.println("---------------------------------");
		System.out.println("0900 1730");
		System.out.println("2011-03-17 10:17:06");
		System.out.println("EMP001");
		System.out.println("2011-03-21 09:00 2");
		System.out.println("--");
		System.out.println("---------------------------------");

		MeetingScheduleCalculator calculator = new MeetingScheduleCalculator();
		
		Scanner scanner = new Scanner(System.in);

		String[] workingHours = scanner.nextLine().split(" ");
		OfficeTimes officeTimes = new OfficeTimes();
		officeTimes.setWorkingHours(workingHours[0], workingHours[1]);
		calculator.setOfficeTimes(officeTimes);
		
		try {
			do {
				BookingRequest request = BookingRequestReader.read(scanner);
				try {
					calculator.addBooking(request);
				} catch (BookingException ex) {
					System.out.println(ex.getMessage());
				}
			} while (true);
		} catch (BookingReaderException ex) {
		} finally {
			scanner.close();
		}
		
		MeetingSchedule schedule = calculator.calculate();
		System.out.println(schedule);
		
	}

}
