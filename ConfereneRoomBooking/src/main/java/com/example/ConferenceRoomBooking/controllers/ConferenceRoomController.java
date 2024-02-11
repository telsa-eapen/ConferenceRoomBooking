package com.example.ConferenceRoomBooking.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.ConferenceRoomBooking.exceptions.MeetingRoomBookingException;
import com.example.ConferenceRoomBooking.exceptions.NotFoundException;
import com.example.ConferenceRoomBooking.models.ConferenceRoom;
import com.example.ConferenceRoomBooking.models.FloorEntity;
import com.example.ConferenceRoomBooking.models.RoomEntity;
import com.example.ConferenceRoomBooking.repositories.FloorRepositoryPostgre;
import com.example.ConferenceRoomBooking.repositories.RoomRepositoryPostgre;
import com.example.ConferenceRoomBooking.services.IConferenceRoomService;

@Profile("dev")
@RestController
public class ConferenceRoomController {
	
	
	@Autowired
	IConferenceRoomService confRoomService;
	
	@PostMapping("/buildings/{buildingName}/floors/{floorId}")
	public ResponseEntity<ConferenceRoom> addConferenceRoomToFloor(@PathVariable("buildingName") String buildingName,@PathVariable("floorId") int floorId, @RequestBody ConferenceRoom room) throws MeetingRoomBookingException{
		ConferenceRoom roomCreated = null;
		//try {
			roomCreated = confRoomService.addConferenceRoom(room.getConfRoomName(), floorId, buildingName);
		//}
		//catch(Exception e) {
		//	throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getLocalizedMessage());
		//}
		
		return ResponseEntity.status(HttpStatus.CREATED).body(roomCreated);
	}

}
