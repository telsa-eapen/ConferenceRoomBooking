package com.example.ConferenceRoomBooking.services;

import org.springframework.stereotype.Component;

import com.example.ConferenceRoomBooking.exceptions.MeetingRoomBookingException;
import com.example.ConferenceRoomBooking.models.Floor;
import com.example.ConferenceRoomBooking.models.FloorEntity;

@Component
public interface IFloorServicePostgre {
	public FloorEntity addFloor(String buildingName,FloorEntity floor) throws MeetingRoomBookingException;
}
