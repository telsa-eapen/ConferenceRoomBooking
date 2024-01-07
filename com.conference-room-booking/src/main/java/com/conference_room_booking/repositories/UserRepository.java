package com.conference_room_booking.repositories;

import java.util.HashMap;
import java.util.Map;

import com.conference_room_booking.models.User;

public class UserRepository implements IUserRepository{

	private static UserRepository userRepoObj;
	private Map<Integer,User> userRepo;
	private UserRepository() {
		userRepo = new HashMap<>();
	}
	@Override
	public User registerUser(User user) {
		userRepo.put(user.getUserId(), user);
		return user;
	}
	public Map<Integer,User> getUsers(){
		return userRepo;
	}
//add user name and extra infos and trigger this from user service?
	public static synchronized UserRepository getInstance() {
		if(userRepoObj == null) {
			userRepoObj = new UserRepository();
		}
		return userRepoObj;
	}
}
