package model;

public class Activity {
	
	String categoryName;
	String activityName;
	String dateTime;
	int dayOfWeek;
	int duration;
	int mood;
	
	public Activity(String categoryName, String activityName, String dateTime, int dayOfWeek, int duration, int mood) {
		this.categoryName = categoryName;
		this.activityName = activityName;
		this.dateTime = dateTime;
		this.dayOfWeek = dayOfWeek;
		this.duration = duration;
		this.mood = mood;
	}
	
	public String getCategory() {
		return categoryName;
	}
	
	public String getActivity() {
		return activityName;
	}
	
	public String getDateTime() {
		return dateTime;
	}
	
	public int getDayOfWeek() {
		return dayOfWeek;
	}
	
	public int getDuration() {
		return duration;
	}
	
	public int getMood() {
		return mood;
	}

	@Override
	public String toString() {
		return "Activity [categoryName=" + categoryName + ", activityName=" + activityName + ", dateTime=" + dateTime
				+ ", dayOfWeek=" + dayOfWeek + ", duration=" + duration + ", mood=" + mood + "]";
	}
	
	

}
