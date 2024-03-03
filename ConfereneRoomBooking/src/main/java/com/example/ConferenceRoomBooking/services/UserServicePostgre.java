package com.example.ConferenceRoomBooking.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.ConferenceRoomBooking.config.CustomUserDetails;
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

	 @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	        UserEntity user = userRepo.findByName(username);
	        if (user == null) {
	            throw new UsernameNotFoundException("User not found: " + username);
	        }
	       
	        return new CustomUserDetails(user);
	    }
}
