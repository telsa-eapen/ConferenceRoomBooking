package com.example.ConferenceRoomBooking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ConferenceRoomBooking.models.FloorEntity;

public interface FloorRepositoryPostgre extends JpaRepository<FloorEntity,Integer> {

}
