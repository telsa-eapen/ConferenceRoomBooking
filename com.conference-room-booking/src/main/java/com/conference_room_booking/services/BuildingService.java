package com.conference_room_booking.services;

import java.io.IOException;

import com.conference_room_booking.models.Building;
import com.conference_room_booking.models.BuildingBuilder;
import com.conference_room_booking.repositories.BuildingRepository;

public class BuildingService implements IBuildingService {

	private BuildingRepository buildingRepo = BuildingRepository.getInstance();;
	
	public Building addBuilding(String buildingName) {//always return whole object
		Building building = null;
		try {
		if(buildingRepo.getBuilding(buildingName) != null) {
			throw new IOException();
		}
		else {
			building = new BuildingBuilder().setName(buildingName).getBuilding();;
			building = buildingRepo.addBuilding(building);
			//System.out.print(building.getBuildingId());
		}
		}
		catch(Exception e) {
			System.out.println("Building already exists");
		}
		return building;
	}

}
