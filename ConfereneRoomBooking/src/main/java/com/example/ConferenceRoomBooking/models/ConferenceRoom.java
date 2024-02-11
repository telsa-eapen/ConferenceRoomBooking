package com.example.ConferenceRoomBooking.models;

import java.sql.Date;
import java.util.List;
import java.util.Map;

public class ConferenceRoom {
	
	private String confRoomName;
	private int confRoomId;
	private Map<Date,List<Slot>> bookedSlots;//use that instead of list and avoid sorting in slot availability emthod tree set (unique +sorted)
	/*
	 * one to many annotation for list of slots
	 * */
	public ConferenceRoom(String confRoomName,int confRoomId,Map<Date, List<Slot>> bookedSlots ){
		this.setConfRoomId(confRoomId);
		this.setConfRoomName(confRoomName);
		this.setBookedSlots(bookedSlots);
	}

	public String getConfRoomName() {
		return confRoomName;
	}

	public void setConfRoomName(String confRoomName) {
		this.confRoomName = confRoomName;
	}

	public Map<Date, List<Slot>> getBookedSlots() {
		return bookedSlots;
	}

	public void setBookedSlots(Map<Date, List<Slot>> bookedSlots) {
		this.bookedSlots = bookedSlots;
	}

	public int getConfRoomId() {
		return confRoomId;
	}

	public void setConfRoomId(int confRoomId) {
		this.confRoomId = confRoomId;
	}


}
