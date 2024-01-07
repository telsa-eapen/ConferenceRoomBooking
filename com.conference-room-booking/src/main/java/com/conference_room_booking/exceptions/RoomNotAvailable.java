package com.conference_room_booking.exceptions;

public class RoomNotAvailable extends Exception {

	RoomNotAvailable(){
		
	}
	public RoomNotAvailable(String message){
		super(message);
	}

}

