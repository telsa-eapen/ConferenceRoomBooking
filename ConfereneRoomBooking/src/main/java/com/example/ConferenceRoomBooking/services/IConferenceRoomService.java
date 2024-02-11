package com.example.ConferenceRoomBooking.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.ConferenceRoomBooking.exceptions.MeetingRoomBookingException;
import com.example.ConferenceRoomBooking.models.ConferenceRoom;
import com.example.ConferenceRoomBooking.models.Slot;


@Component
public interface IConferenceRoomService {
public ConferenceRoom addConferenceRoom(String buildingName,int floorId,String confRoomId) throws MeetingRoomBookingException;
public List<ConferenceRoom> searchAvailableRoomByFloor(String slot,String buildingName,int floor);
public List<ConferenceRoom> searchAvailableRoomByCapacity(String slot,String buildingName,int floor,int capacity);
public boolean searchAvailabilityByRoom(ConferenceRoom room,String slot);
public boolean removeBookedSlotFromConfRoom(int userId,String room,Slot s,String buildingName,int floorId);
}
