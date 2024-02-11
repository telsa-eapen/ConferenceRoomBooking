package com.example.ConferenceRoomBooking.services;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.ConferenceRoomBooking.exceptions.MeetingRoomBookingException;
import com.example.ConferenceRoomBooking.exceptions.NotFoundException;
import com.example.ConferenceRoomBooking.models.Building;
import com.example.ConferenceRoomBooking.models.BuildingBuilder;
import com.example.ConferenceRoomBooking.repositories.BuildingRepository;
import com.example.ConferenceRoomBooking.repositories.IBuildingRepository;

@Service
public class BuildingService implements IBuildingService {

	@Autowired
	private IBuildingRepository buildingRepo;// = BuildingRepository.getInstance();
	
	public Building addBuilding(String buildingName) throws MeetingRoomBookingException {//always return whole object
		Building building = null;
		try {
		if(buildingRepo.getBuilding(buildingName) != null) {
			throw new MeetingRoomBookingException("Not found",true);
		}
		else {
			building = new BuildingBuilder().setName(buildingName).getBuilding();
			//System.out.print(building.getName());
			building = buildingRepo.addBuilding(building);
			//System.out.print(building.getBuildingId());
		}
		}
		catch(Exception e) {
			throw new MeetingRoomBookingException("Internal server error",false);
		}
		return building;
	}
	
	public Building getBuilding(String buildingName) throws MeetingRoomBookingException {
		Building building = buildingRepo.getBuilding(buildingName);
		if(building != null)
		return building;
		else {
			throw new MeetingRoomBookingException("Not found",true);
		}
	}

}
