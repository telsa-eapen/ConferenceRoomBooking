package com.example.ConferenceRoomBooking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ConferenceRoomBooking.models.SlotEntity;

public interface SlotRepositoryPostgre extends JpaRepository<SlotEntity,Integer>  {

}
