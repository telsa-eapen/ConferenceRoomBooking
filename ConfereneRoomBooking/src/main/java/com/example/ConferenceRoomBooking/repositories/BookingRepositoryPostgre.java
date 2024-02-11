package com.example.ConferenceRoomBooking.repositories;

import java.util.Iterator;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ConferenceRoomBooking.models.BookingEntity;
import com.example.ConferenceRoomBooking.models.UserEntity;

public interface BookingRepositoryPostgre extends JpaRepository<BookingEntity,Integer>{

	Iterator<BookingEntity> findByUser(UserEntity user);
}
