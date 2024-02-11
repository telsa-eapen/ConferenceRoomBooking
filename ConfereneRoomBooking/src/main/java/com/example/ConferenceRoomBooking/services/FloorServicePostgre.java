package com.example.ConferenceRoomBooking.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.ConferenceRoomBooking.exceptions.MeetingRoomBookingException;
import com.example.ConferenceRoomBooking.models.BuildingEntity;
import com.example.ConferenceRoomBooking.models.FloorEntity;
import com.example.ConferenceRoomBooking.repositories.BuildingRepositoryPostgre;
import com.example.ConferenceRoomBooking.repositories.FloorRepositoryPostgre;

@Component
public class FloorServicePostgre implements IFloorServicePostgre {
	@Autowired
	FloorRepositoryPostgre floorRepo;
	@Autowired 
	BuildingRepositoryPostgre buildingRepo;
	@Override
	public FloorEntity addFloor(String buildingName, FloorEntity floorDetail) throws MeetingRoomBookingException {
		BuildingEntity building = buildingRepo.findByName(buildingName);
		if(building == null) {
			
			throw new MeetingRoomBookingException("Building not found",true);
		}
		floorDetail.setBuilding(building);
		//List<FloorEntity> floors = building.getFloors();
		//floors.add(floorDetail);
		//building.setFloors(floors);
		//buildingRepo.save(building);
		FloorEntity floor = floorRepo.save(floorDetail);
		return floor;
	}

}
