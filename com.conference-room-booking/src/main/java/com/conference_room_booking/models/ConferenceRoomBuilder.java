package com.conference_room_booking.models;

import java.sql.Date;
import java.util.List;
import java.util.Map;

public class ConferenceRoomBuilder {
	private int confRoomId;
	private String confRoomName;
	private Map<Date,List<Slot>> bookedSlots;
	
	public ConferenceRoomBuilder setConfRoomId(int confRoomId) {
		this.confRoomId = confRoomId;
		return this;
	}
	public ConferenceRoomBuilder setBookedSlots(Map<Date, List<Slot>> bookedSlots) {
		this.bookedSlots = bookedSlots;
		return this;
	}
	public ConferenceRoomBuilder setConferenceRoomName(String confRoomName) {
		this.confRoomName = confRoomName;
		return this;
	}
	
	public ConferenceRoom getConferenceRoom() {
		return new ConferenceRoom(this.confRoomName,this.confRoomId,this.bookedSlots);
	}
}
