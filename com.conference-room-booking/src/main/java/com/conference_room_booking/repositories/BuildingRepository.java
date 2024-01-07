package com.conference_room_booking.repositories;
import java.sql.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import com.conference_room_booking.models.*;

public class BuildingRepository implements IBuildingRepository {

	private static BuildingRepository buildingRepoObj;
	private Map<String, Building> buildingRepo;
	
	private BuildingRepository() {
		buildingRepo=new HashMap<>();//always intitialize within constructor
	}
	
	public Building addBuilding(Building building) {	//return type ,use id for all the objects
		String generatedUUIDBuilding = UUID.randomUUID().toString();
		building.setBuildingId(generatedUUIDBuilding);
		this.buildingRepo.put(building.getName(),building);
		return building;
	}
	
	public Building getBuilding(String buildingName){
		return buildingRepo.get(buildingName);
	}

	public Floor addFloor(Building building,Floor floor) {
		Map<Integer,Floor> floors=building.getListOfFloors();
		if(floors == null) {
			floors =new HashMap<>();
		}
		floors.put(floor.getFloorId(),floor);
		building.setListOfFloors(floors);
		this.buildingRepo.put(building.getBuildingId(),building);
		return floor;
	}
	
	public ConferenceRoom addConferenceRoom(Building building,Floor floor,ConferenceRoom room) {
		int generatedUUIDConferenceRoom = ThreadLocalRandom.current().nextInt();
		room.setConfRoomId(generatedUUIDConferenceRoom);
			Map<String, ConferenceRoom> rooms=floor.getListOfConferenceRoom();
			if(rooms == null) {
				rooms =new HashMap<>();
			}
			rooms.put(room.getConfRoomName(),room);
			floor.setListOfConferenceRoom(rooms);
			return room;
	}
	public boolean updateConferenceRoom(int userId,String room,Slot s,String buildingName,int floorId,Date today) {
		for(Slot slot : this.buildingRepo.get(buildingName).getListOfFloors().get(floorId).getListOfConferenceRoom().get(room).getBookedSlots().get(today)) {
			if(slot.getStartTime() == s.getStartTime() && slot.getEndTime() == s.getEndTime()) {
				List<Slot> listOfSlots = this.buildingRepo.get(buildingName).getListOfFloors().get(floorId).getListOfConferenceRoom().get(room).getBookedSlots().get(today);
				listOfSlots.remove(slot);
				HashMap<Date,List<Slot>> mapOfSlots = new HashMap<>();
				mapOfSlots.put(today,listOfSlots);
				this.buildingRepo.get(buildingName).getListOfFloors().get(floorId).getListOfConferenceRoom().get(room).setBookedSlots(mapOfSlots);
				return true;
			}
		}

		return false;
	}

	@Override
	public List<ConferenceRoom> listAvailableConferenceRooms(Slot slot, String buildingName, int floorId) {
		// TODO Auto-generated method stub
		return null;
	}

	public static synchronized BuildingRepository getInstance() {
		if(buildingRepoObj == null) {
			buildingRepoObj = new BuildingRepository();
		}
		return buildingRepoObj;
	}
}
