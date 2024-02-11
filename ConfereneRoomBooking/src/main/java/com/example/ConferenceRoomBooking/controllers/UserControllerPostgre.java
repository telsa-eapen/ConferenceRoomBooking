package com.example.ConferenceRoomBooking.controllers;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ConferenceRoomBooking.models.UserEntity;
import com.example.ConferenceRoomBooking.services.IUserServicePostgre;


@RestController
public class UserControllerPostgre {
	
	

	@Autowired
	IUserServicePostgre userService;
	
	@GetMapping("/users")
	  public Iterable<UserEntity> findAllUsers() {
	    return this.userService.findAllUsers();
	  }
	@PostMapping("/register")
	  public UserEntity addOneUser(@RequestBody UserEntity user) {
	    return this.userService.registerUser(user);
	  }

}
