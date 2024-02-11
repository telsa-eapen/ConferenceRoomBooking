package com.example.ConferenceRoomBooking.repositories;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.example.ConferenceRoomBooking.models.User;

@Component
public interface IUserRepository {

	User registerUser(User user);
	public Map<Integer,User> getUsers();
}
