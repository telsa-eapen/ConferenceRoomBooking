package com.example.ConferenceRoomBooking.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.ConferenceRoomBooking.exceptions.MeetingRoomBookingException;
import com.example.ConferenceRoomBooking.models.RoomEntity;

@Component
public interface IConferenceRoomServicePostgre {
	public RoomEntity addConferenceRoomToFloor(String buildingName,int floorId, RoomEntity room) throws MeetingRoomBookingException;
}
