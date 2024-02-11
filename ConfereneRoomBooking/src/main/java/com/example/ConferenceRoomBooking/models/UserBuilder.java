package com.example.ConferenceRoomBooking.models;

public class UserBuilder {
	private int userId;
	private String userName;
	
	public UserBuilder setUserId(int userId) {
		this.userId = userId;
		return this;
	}
	public UserBuilder setUserName(String userName) {
		this.userName = userName;
		return this;
	}
	public User getUser() {
		return new User(this.userId,this.userName);
	}
}
