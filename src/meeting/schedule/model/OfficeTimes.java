package meeting.schedule.model;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import meeting.schedule.exceptions.TimeFormatException;
import meeting.schedule.formatters.OfficeTimeFomatter;


public class OfficeTimes {
	
	private LocalTime openHour;
	private LocalTime closeHour;
	
	public void setWorkingHours(String startHourStr, String endHourStr) throws TimeFormatException {
		openHour = OfficeTimeFomatter.parse(startHourStr);
		closeHour = OfficeTimeFomatter.parse(endHourStr);
		
		if(openHour.isAfter(closeHour)) {
			throw new TimeFormatException("Office opening hours is after closing hours");
		}
	}

	public LocalTime getOpenHour() {
		return openHour;
	}

	public LocalTime getCloseHour() {
		return closeHour;
	}

	@Override
	public String toString() {
		return "OfficeTimes [openHour=" + openHour + ", closeHour=" + closeHour + "]";
	}

}
