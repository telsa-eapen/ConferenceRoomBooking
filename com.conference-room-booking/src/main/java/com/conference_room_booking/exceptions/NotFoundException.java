package com.conference_room_booking.exceptions;

public class NotFoundException extends Exception {

	NotFoundException(){
		
	}
	public NotFoundException(String message){
		super(message);
	}

}
