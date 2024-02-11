package com.example.ConferenceRoomBooking.exceptions;

public class RoomNotAvailable extends Exception {

	RoomNotAvailable(){
		
	}
	public RoomNotAvailable(String message){
		super(message);
	}

}

