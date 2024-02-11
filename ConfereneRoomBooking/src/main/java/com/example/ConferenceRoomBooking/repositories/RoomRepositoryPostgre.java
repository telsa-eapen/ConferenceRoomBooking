package com.example.ConferenceRoomBooking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ConferenceRoomBooking.models.RoomEntity;

public interface RoomRepositoryPostgre extends JpaRepository<RoomEntity,Integer> {

}
