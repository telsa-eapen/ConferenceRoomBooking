package com.example.ConferenceRoomBooking.services;

import org.springframework.stereotype.Component;

import com.example.ConferenceRoomBooking.models.User;
import com.example.ConferenceRoomBooking.models.UserEntity;

@Component
public interface IUserServicePostgre{
	
	public UserEntity registerUser(UserEntity user);
	public Iterable<UserEntity> findAllUsers();
}
