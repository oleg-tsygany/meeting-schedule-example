package meeting.schedule.model;

import java.time.LocalDateTime;

public class Meeting {
	 private LocalDateTime meetingStartTime;
	 private LocalDateTime meetingEndTime;
	 private String employeeID;
	 
	 
	public Meeting(LocalDateTime meetingStartTime, LocalDateTime meetingEndTime, String employeeID) {
		this.meetingStartTime = meetingStartTime;
		this.meetingEndTime = meetingEndTime;
		this.employeeID = employeeID;
	}

	
	public LocalDateTime getMeetingStartTime() {
		return meetingStartTime;
	}

	public void setMeetingStartTime(LocalDateTime meetingStartTime) {
		this.meetingStartTime = meetingStartTime;
	}

	public LocalDateTime getMeetingEndTime() {
		return meetingEndTime;
	}

	public void setMeetingEndTime(LocalDateTime meetingEndTime) {
		this.meetingEndTime = meetingEndTime;
	}

	public String getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}

	@Override
	public String toString() {
		return "Meeting [meetingStartTime=" + meetingStartTime + ", meetingEndTime=" + meetingEndTime + ", employeeID="
				+ employeeID + "]";
	}
 
}
