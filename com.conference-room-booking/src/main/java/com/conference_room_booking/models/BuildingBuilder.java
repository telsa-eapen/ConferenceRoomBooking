package com.conference_room_booking.models;

import java.util.Map;

public class BuildingBuilder {
	
	private String buildingId;
	private String name;
	private Map<Integer,Floor> floors;
	
	public BuildingBuilder setName(String name) {
		this.name = name;
		return this;
	}
	public BuildingBuilder setListOfFloors(Map<Integer,Floor> floors) {
		this.floors = floors;
		return this;
	}
	
	/*public BuildingBuilder setBuildingId(String buildingId) {
		this.buildingId = buildingId;
		return this;
	}**/
	
	public BuildingBuilder setBuildingId(String buildingId) {
		this.buildingId = buildingId;
		return this;
	}
	
	public Building getBuilding() {
		return new Building(this.buildingId,this.name,this.floors);
	}
}
