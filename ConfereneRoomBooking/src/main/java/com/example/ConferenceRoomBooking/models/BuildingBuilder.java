package com.example.ConferenceRoomBooking.models;

import java.util.Map;

public class BuildingBuilder {
	
	private String id;
	private String name;
	private Map<Integer,Floor> floors;
	
	public BuildingBuilder setName(String name) {
		this.name = name;
		return this;
	}
	public BuildingBuilder setFloors(Map<Integer,Floor> floors) {
		this.floors = floors;
		return this;
	}
	
	/*public BuildingBuilder setBuildingId(String buildingId) {
		this.buildingId = buildingId;
		return this;
	}**/
	
	public BuildingBuilder setId(String buildingId) {
		this.id = buildingId;
		return this;
	}
	
	public Building getBuilding() {
		return new Building(this.id,this.name,this.floors);
	}
}
