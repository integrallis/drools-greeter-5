package org.integrallis.greeting;

public class TimeOfDay {
    private Integer hour;
    private Integer minutes;
    
	public TimeOfDay(Integer hour, Integer minutes) {
		this.hour = hour;
		this.minutes = minutes;
	}
	
	public Integer getHour() { return hour; }
	public Integer getMinutes() { return minutes; }
}
