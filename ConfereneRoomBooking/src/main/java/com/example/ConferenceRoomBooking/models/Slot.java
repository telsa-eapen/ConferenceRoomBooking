package com.example.ConferenceRoomBooking.models;

public class Slot {

	//slot id
	private int startTime;
	private int endTime;
	//date also
	
	/*
	 * add date column and do indexing on date
	 * */
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
