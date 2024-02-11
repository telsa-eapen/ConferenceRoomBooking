package com.example.ConferenceRoomBooking.models;

import java.util.Map;

public class Building {
	
	private String id;
	private String name;
	private Map<Integer,Floor> floors;
	/*
	 * one to many annotation for list of floors map
	 * */
	
	public Building(String buildingId,String name, Map<Integer,Floor> floors) {
		this.setName(name);
		this.setFloors(floors);
		this.setId(buildingId);
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Building [buildingId=" + id + ", name=" + name + ", floors=" + floors + "]";
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<Integer,Floor> getFloors() {
		return floors;
	}

	public void setFloors(Map<Integer,Floor> floors) {
		this.floors = floors;
	}

	public String getId() {
		return id;
	}

	public void setId(String buildingId) {
		this.id = buildingId;
	}
}
