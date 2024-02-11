package com.example.ConferenceRoomBooking.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ConferenceRoomBooking.exceptions.MeetingRoomBookingException;
import com.example.ConferenceRoomBooking.exceptions.NotFoundException;
import com.example.ConferenceRoomBooking.models.Building;
import com.example.ConferenceRoomBooking.models.Floor;
import com.example.ConferenceRoomBooking.models.FloorBuilder;
import com.example.ConferenceRoomBooking.repositories.BuildingRepository;
import com.example.ConferenceRoomBooking.repositories.IBuildingRepository;

@Service
public class FloorService implements IFloorService {
	
	@Autowired
	private IBuildingRepository buildingRepo;
	//private BuildingRepository buildingRepo = BuildingRepository.getInstance();//meaninful variable,intitialize in cosntructor
	@Override
	public Floor addFloor(String buildingName, int floorId) throws MeetingRoomBookingException {//return type
		Floor floor = null;
		try {//line 17 is wrong, entire data is fetching which is nto optimized//repo should return building by name
			if(buildingRepo.getBuilding(buildingName) != null) {
				Building building = buildingRepo.getBuilding(buildingName);
				floor = new FloorBuilder().setFloorId(floorId).getFloor();
				floor = buildingRepo.addFloor(building,floor);
				
			}
			else {
				throw new MeetingRoomBookingException("Building doesn't exist",true);
			}
		}
		catch(NotFoundException e) {
			System.out.println(e.getMessage());
		}
		return floor;
	}

}
