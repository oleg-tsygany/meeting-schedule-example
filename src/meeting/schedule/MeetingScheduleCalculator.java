package meeting.schedule;

import java.time.LocalDateTime;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.Map.Entry;

import meeting.schedule.exceptions.BookingException;
import meeting.schedule.model.BookingRequest;
import meeting.schedule.model.Meeting;
import meeting.schedule.model.MeetingSchedule;
import meeting.schedule.model.OfficeTimes;

public class MeetingScheduleCalculator {
	private OfficeTimes officeTimes;
	private SortedMap<LocalDateTime, BookingRequest> bookings = new TreeMap<LocalDateTime, BookingRequest>();
	
	public MeetingSchedule calculate() {
		MeetingSchedule meetingSchedule = new MeetingSchedule();
		
		for(Entry<LocalDateTime, BookingRequest> booking : bookings.entrySet()) {
			meetingSchedule.addMeeting(booking.getKey(), 
					new Meeting(
						booking.getValue().getMeetingStartTime(),
						booking.getValue().getMeetingStartTime().plusHours(booking.getValue().getDuration()),
						booking.getValue().getEmployeeID()
					));
		}
		return meetingSchedule;
	}
	
	public void addBooking(BookingRequest booking) throws BookingException {
		checkParams(booking);
		bookings.put(booking.getMeetingStartTime(), booking);
	}

	/*
	 * Private methods
	 */
	
	private boolean isOverlaping(BookingRequest booking) {
		LocalDateTime bookingStartTime = booking.getMeetingStartTime();
		
		for (BookingRequest bookingEntry : bookings.values()) {
			LocalDateTime bookingEntryStartTime = bookingEntry.getMeetingStartTime();
			LocalDateTime bookingEntryEndTime = bookingEntry.getMeetingStartTime().plusHours(bookingEntry.getDuration());
			if( bookingStartTime.isAfter(bookingEntryStartTime) && bookingStartTime.isBefore(bookingEntryEndTime)) {
				return true;
			}
		}
		return false;
	}

	private void checkParams(BookingRequest booking) throws BookingException {
		if(booking == null) {
			throw new BookingException("Can not add null booking");
		}
		
		if(booking.getSubmissionTime() == null || booking.getMeetingStartTime() == null) {
			throw new BookingException("Can not add booking with empty dates");
		}

		if(booking.getEmployeeID().isEmpty()) {
			throw new BookingException("Can not add booking without Employee ID");
		}

		if(booking.getDuration() <= 0 ) {
			throw new BookingException("Can not add booking with wrong duration");
		}
		
		if(officeTimes == null) {
			throw new BookingException("Office times is not initialized");
		}

		if(booking.getMeetingStartTime().toLocalTime().isBefore(officeTimes.getOpenHour())) {
			throw new BookingException("Can not add booking before open hour " + booking);
		}
		
		if(booking.getMeetingStartTime().toLocalTime().isAfter(officeTimes.getCloseHour())) {
			throw new BookingException("Can not add booking after closing hour " + booking);
		}
		
		if(booking.getMeetingStartTime().toLocalTime().plusHours(booking.getDuration()).isAfter(officeTimes.getCloseHour())) {
			throw new BookingException("Can not add booking with meeting end after closing hour " + booking);
		}
		
		if(isOverlaping(booking)) {
			throw new BookingException("Can not book, time slot is occupied  " + booking);
		}
	}

/*
 * Getter and setters
 */
		public OfficeTimes getOfficeTimes() {
			return officeTimes;
		}

		public void setOfficeTimes(OfficeTimes officeTimes) {
			this.officeTimes = officeTimes;
		}

		public SortedMap<LocalDateTime, BookingRequest> getBookings() {
			return bookings;
		}

		@Override
		public String toString() {
			return "MeetingScheduleCalculator [officeTimes=" + officeTimes + ", bookings=" + bookings + "]";
		}

}
