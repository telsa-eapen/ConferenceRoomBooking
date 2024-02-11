package com.example.ConferenceRoomBooking.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ConferenceRoomBooking.models.BuildingEntity;
import com.example.ConferenceRoomBooking.repositories.BuildingRepositoryPostgre;

@RestController
public class BuildingControllerPostgre {
	@Autowired
	BuildingRepositoryPostgre buildingRepo;
	
	@GetMapping("/buildings")
	  public List<BuildingEntity> findAllBuildings() {
	    return this.buildingRepo.findAll();
	  }
	@PostMapping("/buildings")
	  public BuildingEntity addOneBuilding(@RequestBody BuildingEntity building) {
	    return this.buildingRepo.save(building);
	  }
}
