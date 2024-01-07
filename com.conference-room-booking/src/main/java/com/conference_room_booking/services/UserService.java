package com.conference_room_booking.services;

import com.conference_room_booking.models.*;
import com.conference_room_booking.repositories.UserRepository;

public class UserService implements IUserService{

	private UserRepository userRepoObj= UserRepository.getInstance();
	@Override
	public User registerUser(int userId, String name) {
		User user = new UserBuilder().setUserId(userId).setUserName(name).getUser();
		
		return userRepoObj.registerUser(user);
	}

}
