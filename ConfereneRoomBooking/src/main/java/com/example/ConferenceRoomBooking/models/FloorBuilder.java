package com.example.ConferenceRoomBooking.models;

import java.util.List;
import java.util.Map;

public class FloorBuilder {
	private int floorId;
	private Map<String, ConferenceRoom> conferenceRooms;
	public FloorBuilder setFloorId(int floorId) {
		this.floorId = floorId;
		return this;
	}
	public FloorBuilder setConferenceRooms(Map<String, ConferenceRoom> conferenceRooms) {
		this.conferenceRooms = conferenceRooms;
		return this;
	}
	public Floor getFloor() {
		return new Floor(this.floorId,this.conferenceRooms);
	}
}
