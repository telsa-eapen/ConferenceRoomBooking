package com.conference_room_booking.models;

public class Slot {

	private int startTime;
	private int endTime;
	public Slot(int startTime, int endTime) {
		this.setStartTime(startTime);
		this.setEndTime(endTime);
	}
	public int getEndTime() {
		return endTime;
	}
	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}
	public int getStartTime() {
		return startTime;
	}
	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}
}
