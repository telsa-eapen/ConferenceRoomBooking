package com.conference_room_booking.repositories;

import java.util.List;

import com.conference_room_booking.models.Building;
import com.conference_room_booking.models.ConferenceRoom;
import com.conference_room_booking.models.Floor;
import com.conference_room_booking.models.Slot;

public interface IBuildingRepository {

	Building addBuilding(Building building);
	Floor addFloor(Building building,Floor floor);
	ConferenceRoom addConferenceRoom(Building building,Floor floor,ConferenceRoom room);
	List<ConferenceRoom> listAvailableConferenceRooms(Slot slot,String buildingName,int floorId);//should we keep this in repo or only in service??
	//ToDo: filter above by capacity also
}
