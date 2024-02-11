package com.example.ConferenceRoomBooking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ConferenceRoomBooking.models.BuildingEntity;

public interface BuildingRepositoryPostgre extends JpaRepository<BuildingEntity,Integer>{
	BuildingEntity findByName(String name);
}
