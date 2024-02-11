package com.example.ConferenceRoomBooking.services;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.example.ConferenceRoomBooking.exceptions.MeetingRoomBookingException;
import com.example.ConferenceRoomBooking.models.Building;

@Component
public interface IBuildingService {

	public Building addBuilding(String buildingName) throws MeetingRoomBookingException;
	public Building getBuilding(String buildingName) throws IOException, Exception;
	
}
