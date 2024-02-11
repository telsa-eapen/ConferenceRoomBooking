package com.example.ConferenceRoomBooking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.ConferenceRoomBooking.exceptions.MeetingRoomBookingException;
import com.example.ConferenceRoomBooking.models.User;
import com.example.ConferenceRoomBooking.models.UserEntity;
import com.example.ConferenceRoomBooking.repositories.UserRepositoryPostgre;
import com.example.ConferenceRoomBooking.services.IUserService;

@Profile("dev")
@RestController
public class UserController {
	
	@Autowired
	IUserService userService;
	
	@PostMapping("/users")
	public ResponseEntity<User> registerUser(@RequestBody User user) throws MeetingRoomBookingException{
		User userRegistered = null;
		try {
			userRegistered = userService.registerUser(user.getUserId(), user.getUserName());
		}
		catch(Exception e) {
			throw new MeetingRoomBookingException(e.getLocalizedMessage(),false);
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(userRegistered);
		
	}
	

}
