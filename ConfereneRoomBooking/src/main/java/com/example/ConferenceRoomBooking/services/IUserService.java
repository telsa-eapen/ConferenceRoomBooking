package com.example.ConferenceRoomBooking.services;

import org.springframework.stereotype.Component;

import com.example.ConferenceRoomBooking.models.User;

@Component
public interface IUserService {
public User registerUser(int userId,String name);
}
