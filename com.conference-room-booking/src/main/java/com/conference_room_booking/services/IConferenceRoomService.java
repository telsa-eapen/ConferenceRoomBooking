package com.conference_room_booking.services;

import java.util.List;

import com.conference_room_booking.models.ConferenceRoom;
import com.conference_room_booking.models.Slot;

public interface IConferenceRoomService {
public ConferenceRoom addConferenceRoom(String buildingName,int floorId,String confRoomId);
public List<ConferenceRoom> searchAvailableRoomByFloor(String slot,String buildingName,int floor);
public List<ConferenceRoom> searchAvailableRoomByCapacity(String slot,String buildingName,int floor,int capacity);
public boolean searchAvailabilityByRoom(ConferenceRoom room,String slot);
public boolean removeBookedSlotFromConfRoom(int userId,String room,Slot s,String buildingName,int floorId);
}
