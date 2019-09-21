package meeting.schedule.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

public class MeetingSchedule {
	private SortedMap<LocalDate, ArrayList<Meeting>> meetings = new TreeMap<LocalDate, ArrayList<Meeting>>();
	
	public void addMeeting(LocalDateTime meetingDateTime, Meeting meeting) {
		LocalDate meetingDate = meetingDateTime.toLocalDate();
		if(meetings.containsKey(meetingDate)) {
			ArrayList<Meeting> dailyMeetings = meetings.get(meetingDate);
			if(! dailyMeetings.contains(meeting)) {
				dailyMeetings.add(meeting);
				meetings.put(meetingDate, dailyMeetings);
			}
		} else {
			ArrayList<Meeting> dailyMeetings = new ArrayList<Meeting>();
			dailyMeetings.add(meeting);
			meetings.put(meetingDate, dailyMeetings);
		}
	}
	
	
	public ArrayList<Meeting> getDailyMeetings(LocalDate meetingsDate) {
		return meetings.get(meetingsDate);
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder("");  
		for(Entry<LocalDate, ArrayList<Meeting>> meeting : meetings.entrySet()) {
			result.append(meeting.getKey().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))).append("\n");
			for(Meeting meetingObject : meeting.getValue()) {
				result.append(meetingObject.getMeetingStartTime().format(DateTimeFormatter.ofPattern("HH:mm"))).append(" ");
				result.append(meetingObject.getMeetingEndTime().format(DateTimeFormatter.ofPattern("HH:mm"))).append("\n");
				result.append(meetingObject.getEmployeeID()).append("\n");
			}
		}
		return result.toString();
	}
	
	
}
