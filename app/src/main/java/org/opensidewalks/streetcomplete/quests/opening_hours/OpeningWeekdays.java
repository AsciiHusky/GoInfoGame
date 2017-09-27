package org.opensidewalks.streetcomplete.quests.opening_hours;

public class OpeningWeekdays
{
	public OpeningWeekdays(Weekdays weekdays, TimeRange timeRange)
	{
		this.weekdays = weekdays;
		this.timeRange = timeRange;
	}

	public Weekdays weekdays;
	public TimeRange timeRange;
}
