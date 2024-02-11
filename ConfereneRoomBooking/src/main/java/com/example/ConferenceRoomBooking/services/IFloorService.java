package com.example.ConferenceRoomBooking.services;

import org.springframework.stereotype.Component;

import com.example.ConferenceRoomBooking.exceptions.MeetingRoomBookingException;
import com.example.ConferenceRoomBooking.models.Floor;

@Component
public interface IFloorService {

	public Floor addFloor(String buildingName,int floorId) throws MeetingRoomBookingException;
}
