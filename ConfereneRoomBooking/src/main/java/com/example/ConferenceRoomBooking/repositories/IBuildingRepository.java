package com.example.ConferenceRoomBooking.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.ConferenceRoomBooking.models.Building;
import com.example.ConferenceRoomBooking.models.ConferenceRoom;
import com.example.ConferenceRoomBooking.models.Floor;
import com.example.ConferenceRoomBooking.models.Slot;

@Component
public interface IBuildingRepository {

	Building addBuilding(Building building);
	public Building getBuilding(String buildingName);
	Floor addFloor(Building building,Floor floor);
	ConferenceRoom addConferenceRoom(Building building,Floor floor,ConferenceRoom room);
	List<ConferenceRoom> listAvailableConferenceRooms(Slot slot,String buildingName,int floorId);//should we keep this in repo or only in service??
	//ToDo: filter above by capacity also
	boolean updateConferenceRoom(int userId, String room, Slot s, String buildingName, int floorId, Date today);
}
