package com.conference_room_booking.models;

import java.util.Map;

public class Building {
	
	private String buildingId;
	private String name;
	private Map<Integer,Floor> floors;
	
	public Building(String buildingId,String name, Map<Integer,Floor> floors) {
		this.setName(name);
		this.setListOfFloors(floors);
		this.setBuildingId(buildingId);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<Integer,Floor> getListOfFloors() {
		return floors;
	}

	public void setListOfFloors(Map<Integer,Floor> floors) {
		this.floors = floors;
	}

	public String getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(String buildingId) {
		this.buildingId = buildingId;
	}
}
