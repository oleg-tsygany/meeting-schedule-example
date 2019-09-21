package meeting.schedule;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import meeting.schedule.exceptions.BookingException;
import meeting.schedule.model.BookingRequest;
import meeting.schedule.model.MeetingSchedule;

public class MeetingScheduleCalculatorTest {

	
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void NoBookingsReturnEmptyStringTest() {
		// If there is no bookings schedule will be empty
		MeetingScheduleCalculator calculator = new MeetingScheduleCalculator();
		MeetingSchedule schedule = calculator.calculate();
		
		assertTrue(schedule.toString().isEmpty());
	}
	
	@Test
	public void EmptyOfficeHoursTest() {
		// Office hours is not initialized for new object
		MeetingScheduleCalculator calculator = new MeetingScheduleCalculator();
		assertEquals(null, calculator.getOfficeTimes());
	}
	
	@Test
	public void NoBookingTest() throws BookingException {
		MeetingScheduleCalculator calculator = new MeetingScheduleCalculator();
		thrown.expect(BookingException.class);
		thrown.expectMessage("Can not add null booking");
		calculator.addBooking(null);
	}
	
	@Test
	public void EmptyBookingTest() throws BookingException {
		MeetingScheduleCalculator calculator = new MeetingScheduleCalculator();
		thrown.expect(BookingException.class);
		thrown.expectMessage("Can not add booking with empty dates");
		calculator.addBooking(new BookingRequest());
	}

	@Test
	public void NoEmployeeIDBookingTest() throws BookingException {
		MeetingScheduleCalculator calculator = new MeetingScheduleCalculator();
		thrown.expect(BookingException.class);
		thrown.expectMessage("Can not add booking without Employee ID");
		calculator.addBooking(new BookingRequest(LocalDateTime.now(), "", LocalDateTime.now(), 1));
	}
	
	@Test
	public void WrongDurationBookingTest() throws BookingException {
		MeetingScheduleCalculator calculator = new MeetingScheduleCalculator();
		thrown.expect(BookingException.class);
		thrown.expectMessage("Can not add booking without Employee ID");
		calculator.addBooking(new BookingRequest(LocalDateTime.now(), "", LocalDateTime.now(), 1));
	}
	
	@Test
	public void NoOfficeTimesTest() throws BookingException {
		MeetingScheduleCalculator calculator = new MeetingScheduleCalculator();
		thrown.expect(BookingException.class);
		thrown.expectMessage("Office times is not initialized");
		calculator.addBooking(new BookingRequest(LocalDateTime.now(), "1", LocalDateTime.now(), 1));
	}

}
