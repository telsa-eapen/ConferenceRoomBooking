package com.example.ConferenceRoomBooking.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ConferenceRoomBooking.models.User;
import com.example.ConferenceRoomBooking.models.UserBuilder;
import com.example.ConferenceRoomBooking.repositories.IUserRepository;

@Service
public class UserService implements IUserService{

	@Autowired
	private IUserRepository userRepoObj;
	
	@Override
	public User registerUser(int userId, String name) {
		User user = new UserBuilder().setUserId(userId).setUserName(name).getUser();
		
		return userRepoObj.registerUser(user);
	}

}
