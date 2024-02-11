package com.example.ConferenceRoomBooking.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ConferenceRoomBooking.exceptions.MeetingRoomBookingException;
import com.example.ConferenceRoomBooking.models.FloorEntity;
import com.example.ConferenceRoomBooking.models.RoomEntity;
import com.example.ConferenceRoomBooking.repositories.FloorRepositoryPostgre;
import com.example.ConferenceRoomBooking.repositories.RoomRepositoryPostgre;
import com.example.ConferenceRoomBooking.services.IConferenceRoomServicePostgre;

@RestController
public class ConferenceRoomControllerPostgre {
	
	@Autowired
	IConferenceRoomServicePostgre roomService;
	
	@PostMapping("/buildings/{buildingName}/floors/{floorId}")
	public ResponseEntity<RoomEntity> addConferenceRoomToFloor(@PathVariable("buildingName") String buildingName,@PathVariable("floorId") int floorId, @RequestBody RoomEntity room) throws MeetingRoomBookingException{
		
		
		RoomEntity roomSaved = this.roomService.addConferenceRoomToFloor(buildingName, floorId, room);
		return ResponseEntity.status(HttpStatus.CREATED).body(roomSaved);
	}
}
