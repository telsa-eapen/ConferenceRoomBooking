package com.example.ConferenceRoomBooking.repositories;

import com.example.ConferenceRoomBooking.models.UserEntity;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepositoryPostgre extends JpaRepository<UserEntity,Integer>  {
	UserEntity findByName(String username);
}
