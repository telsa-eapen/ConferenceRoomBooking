package com.example.ConferenceRoomBooking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ConferenceRoomBooking.exceptions.MeetingRoomBookingException;
import com.example.ConferenceRoomBooking.models.FloorEntity;
import com.example.ConferenceRoomBooking.services.IFloorServicePostgre;

@RestController
public class FloorControllerPostgre {
	@Autowired 
	IFloorServicePostgre floorService;
	@PostMapping("buildings/{buildingName}/floors")
	public ResponseEntity<FloorEntity> addFloor(@PathVariable String buildingName, @RequestBody FloorEntity floorDetail) throws MeetingRoomBookingException {
	
		
		FloorEntity floor = floorService.addFloor(buildingName, floorDetail);
		return ResponseEntity.status(HttpStatus.CREATED).body(floor);
	}
}
