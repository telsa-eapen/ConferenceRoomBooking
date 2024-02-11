package com.example.ConferenceRoomBooking.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ConferenceRoomBooking.exceptions.MeetingRoomBookingException;
import com.example.ConferenceRoomBooking.models.UserEntity;
import com.example.ConferenceRoomBooking.repositories.UserRepositoryPostgre;
@Service
public class UserServicePostgre implements IUserServicePostgre {

	@Autowired
	UserRepositoryPostgre userRepo;
	
	@Override
	public UserEntity registerUser(UserEntity user) {
		
		return this.userRepo.save(user);
	}

	@Override
	public Iterable<UserEntity> findAllUsers() {
		
		return this.userRepo.findAll();
	}


}
