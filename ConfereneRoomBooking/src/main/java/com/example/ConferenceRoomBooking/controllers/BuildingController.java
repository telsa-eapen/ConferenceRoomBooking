package com.example.ConferenceRoomBooking.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.ConferenceRoomBooking.exceptions.MeetingRoomBookingException;
import com.example.ConferenceRoomBooking.models.Building;
import com.example.ConferenceRoomBooking.models.BuildingBuilder;
import com.example.ConferenceRoomBooking.models.BuildingEntity;
import com.example.ConferenceRoomBooking.models.UserEntity;
import com.example.ConferenceRoomBooking.repositories.BuildingRepository;
import com.example.ConferenceRoomBooking.repositories.BuildingRepositoryPostgre;
import com.example.ConferenceRoomBooking.services.IBuildingService;

@Profile("dev")
@RestController
public class BuildingController {
	
	@Autowired
	IBuildingService buildingService;
	
	@GetMapping("buildings/{name}")
	public ResponseEntity<Building> getBuilding(@PathVariable("name") String buildignName) throws IOException, MeetingRoomBookingException {
		Building building = null;

		try {
		building = buildingService.getBuilding(buildignName);
		}
		catch(Exception e) {
			throw new MeetingRoomBookingException("Server error",false);
		}
		return ResponseEntity.status(HttpStatus.OK).body(building);
	}
	
	@PostMapping("buildings")
	public ResponseEntity<Building> addBuilding(@RequestBody Building buildignReq) throws MeetingRoomBookingException {
		Building building = null;
		//System.out.println(buildignReq.getName());
		if(buildignReq.getName()==null) {
			throw new MeetingRoomBookingException("Building name shouldn't be empty",true);
		}
	/*	try {
		building = buildingService.addBuilding(buildignReq.getName());
		if(building == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Already exists the building");
		}
		}
		catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Server error");
		}*/
		return ResponseEntity.status(HttpStatus.CREATED).body(building);
	}
	

}
/*
 * Swagger ui
 * POST,GET mapping
 * name taking in url params is incorrect,it shld part of req body
 * return type should be status code+ some additional message /WHole building obj
 * 400 return status case also handled in case of empty name in req body
 * make sure no business logic in the controller
 * AOP --> implementing the logger and use logic to categorize it, handle the logging level(config in application.properties) use diff types of logging eg debug log
 * global exception handling
 * Spring profiling userrepo separate implementation 
 * spriboot jpa/orm
 * db setup postgresql, watch videos about JPA
 * 
 * */
 