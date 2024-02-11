package com.example.ConferenceRoomBooking.models;

import java.util.List;
import java.util.Map;

public class Floor {

	private int floorId;
	private Map<String,ConferenceRoom> conferenceRooms;
	/*
	 * one to many annotation for list of conference room
	 * */
	
	public Floor(int floorId,Map<String, ConferenceRoom> conferenceRooms) {
		this.setFloorId(floorId);
		this.setConferenceRooms(conferenceRooms);
	}

	public int getFloorId() {
		return floorId;
	}

	public void setFloorId(int floorId) {
		this.floorId = floorId;
	}

	public Map<String, ConferenceRoom> getConferenceRooms() {
		return conferenceRooms;
	}

	public void setConferenceRooms(Map<String, ConferenceRoom> conferenceRooms) {
		this.conferenceRooms = conferenceRooms;
	}
	
}
