package meeting.schedule.model;

import java.time.LocalDateTime;

import meeting.schedule.formatters.MeetingTimeFormatter;
import meeting.schedule.formatters.SubmissionTimeFormatter;

public class BookingRequest {
	private LocalDateTime submissionTime;
	private String employeeID;
	private LocalDateTime meetingStartTime;
	private long duration;
	
	public BookingRequest() {
	}
	
	public BookingRequest(LocalDateTime submissionTime, String employeeID, LocalDateTime meetingStartTime,
			long duration) {
		this.submissionTime = submissionTime;
		this.employeeID = employeeID;
		this.meetingStartTime = meetingStartTime;
		this.duration = duration;
	}

	public LocalDateTime getSubmissionTime() {
		return submissionTime;
	}
	public void setSubmissionTime(LocalDateTime submissionTime) {
		this.submissionTime = submissionTime;
	}
	public String getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}
	public LocalDateTime getMeetingStartTime() {
		return meetingStartTime;
	}
	public void setMeetingStartTime(LocalDateTime meetingStartTime) {
		this.meetingStartTime = meetingStartTime;
	}
	public long getDuration() {
		return duration;
	}
	public void setDuration(long duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "BookingRequest [from " + SubmissionTimeFormatter.format(submissionTime) + ", employeeID=" + employeeID + ", start at "
				+ MeetingTimeFormatter.format(meetingStartTime) + ", duration=" + duration + "]";
	}
	
}
