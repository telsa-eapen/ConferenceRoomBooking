package com.example.ConferenceRoomBooking.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import com.example.ConferenceRoomBooking.models.User;
import com.example.ConferenceRoomBooking.models.UserEntity;

@Component
public interface IUserServicePostgre extends UserDetailsService{
	
	public UserEntity registerUser(UserEntity user);
	public Iterable<UserEntity> findAllUsers();
	UserDetails loadUserByUsername(String username);
}
