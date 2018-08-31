package com.util;

import java.time.DayOfWeek;
import java.util.HashMap;
import java.util.Map;

public class DayOfWeekENUMToStringConverter {
	
	public Map<DayOfWeek, String> daysOfWeek;
	
	{
		 daysOfWeek = new HashMap<DayOfWeek, String>();
		 daysOfWeek.put(DayOfWeek.SUNDAY, "Sunday");
		 daysOfWeek.put(DayOfWeek.MONDAY, "Monday");
		 daysOfWeek.put(DayOfWeek.TUESDAY, "Tuesday");
		 daysOfWeek.put(DayOfWeek.WEDNESDAY, "Wednesday");
		 daysOfWeek.put(DayOfWeek.THURSDAY, "Thursday");
		 daysOfWeek.put(DayOfWeek.FRIDAY, "Friday");
		 daysOfWeek.put(DayOfWeek.SATURDAY, "Saturday");
	}
	
	public String convertDayOfWeekToString(DayOfWeek dayOfWeek) {
		return daysOfWeek.get(dayOfWeek);
	}

}
