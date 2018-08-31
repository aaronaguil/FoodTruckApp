package com.util;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class CurrentTimeFoodTruckQueryBuilder implements QueryBuilder{
	
	private LocalDateTime currentLocalDateTime;
	private DayOfWeekENUMToStringConverter dayOfWeekToStringConverter;
	
	public CurrentTimeFoodTruckQueryBuilder() {
		currentLocalDateTime = LocalDateTime.now();
		dayOfWeekToStringConverter = new DayOfWeekENUMToStringConverter();
	}

	@Override
	public String buildQuery() {
		DayOfWeek dayOfWeek = currentLocalDateTime.getDayOfWeek();
		String currentDayOfWeekStr = dayOfWeekToStringConverter.convertDayOfWeekToString(dayOfWeek);
		String currentTime = LocalTime.of(currentLocalDateTime.getHour(), currentLocalDateTime.getMinute()).toString();
	
		StringBuilder query = new StringBuilder();
		
		query.append("?$query=SELECT%20");			//SELECT 
		query.append("applicant,%20");				//applicant,
		query.append("location%20");				//location
		query.append("where%20");					//WHERE
		query.append("start24%20%3C=%20%22");		//start24 <=
		query.append(currentTime);					//currentTime
		query.append("%22%20");
		query.append("AND%20");						//AND
		query.append("end24%20%3E=%20%22");			//end24 >=
		query.append(currentTime);					//currentTime
		query.append("%22%20");		
		query.append("AND%20");						//AND
		query.append("dayofweekstr=%22");			//dayOfWeekStr =
		query.append(currentDayOfWeekStr);			//currentDayOfWeek
		query.append("%22%20");
		query.append("ORDER%20BY%20applicant%20");	//ORDER BY applicant
		query.append("LIMIT%2050000");				//LIMIT 50000
		
		return query.toString();
	
	}
}
