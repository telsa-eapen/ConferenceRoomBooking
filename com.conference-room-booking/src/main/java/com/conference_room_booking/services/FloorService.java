package com.conference_room_booking.services;


import com.conference_room_booking.exceptions.NotFoundException;
import com.conference_room_booking.models.Building;
import com.conference_room_booking.models.Floor;
import com.conference_room_booking.models.FloorBuilder;
import com.conference_room_booking.repositories.BuildingRepository;

public class FloorService implements IFloorService {
	
	private BuildingRepository buildingRepo = BuildingRepository.getInstance();//meaninful variable,intitialize in cosntructor
	@Override
	public Floor addFloor(String buildingName, int floorId) {//return type
		Floor floor = null;
		try {//line 17 is wrong, entire data is fetching which is nto optimized//repo should return building by name
			if(buildingRepo.getBuilding(buildingName) != null) {
				Building building = buildingRepo.getBuilding(buildingName);
				floor = new FloorBuilder().setFloorId(floorId).getFloor();
				floor = buildingRepo.addFloor(building,floor);
				
			}
			else {
				throw new NotFoundException("Building doesn't exist");
			}
		}
		catch(NotFoundException e) {
			System.out.println(e.getMessage());
		}
		return floor;
	}

}
