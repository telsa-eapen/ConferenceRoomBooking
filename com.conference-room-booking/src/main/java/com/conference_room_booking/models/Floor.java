package com.conference_room_booking.models;

import java.util.List;
import java.util.Map;

public class Floor {

	private int floorId;
	private Map<String,ConferenceRoom> conferenceRooms;
	
	public Floor(int floorId,Map<String, ConferenceRoom> conferenceRooms) {
		this.setFloorId(floorId);
		this.setListOfConferenceRoom(conferenceRooms);
	}

	public int getFloorId() {
		return floorId;
	}

	public void setFloorId(int floorId) {
		this.floorId = floorId;
	}

	public Map<String, ConferenceRoom> getListOfConferenceRoom() {
		return conferenceRooms;
	}

	public void setListOfConferenceRoom(Map<String, ConferenceRoom> conferenceRooms) {
		this.conferenceRooms = conferenceRooms;
	}
	
}
