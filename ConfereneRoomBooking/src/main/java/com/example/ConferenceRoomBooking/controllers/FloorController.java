package com.example.ConferenceRoomBooking.controllers;

import java.io.IOException;
import java.util.List;

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
import com.example.ConferenceRoomBooking.models.Building;
import com.example.ConferenceRoomBooking.models.BuildingEntity;
import com.example.ConferenceRoomBooking.models.Floor;
import com.example.ConferenceRoomBooking.models.FloorEntity;
import com.example.ConferenceRoomBooking.repositories.BuildingRepositoryPostgre;
import com.example.ConferenceRoomBooking.repositories.FloorRepositoryPostgre;
import com.example.ConferenceRoomBooking.services.IFloorService;
@Profile("dev")
@RestController
public class FloorController {

	@Autowired
	IFloorService floorService;
	
	@PostMapping("buildings/{buildingName}/floors")
	public ResponseEntity<Floor> addFloor(@PathVariable String buildingName, @RequestBody Floor floorDetail) throws MeetingRoomBookingException {
		Floor floor = null;
		//System.out.println(buildignReq.getName());
		//if(floorReq.getFloorId()) {
			//throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Building name shouldn't be empty");
		//}
		//try {
		floor = floorService.addFloor(buildingName,floorDetail.getFloorId());
		
		//}
		//catch(Exception e) {
		//	throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Already exists the floor");
		//}
		return ResponseEntity.status(HttpStatus.CREATED).body(floor);
	}
	
}
