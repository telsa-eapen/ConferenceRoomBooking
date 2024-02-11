package com.example.ConferenceRoomBooking.exceptions;

public class NotFoundException extends MeetingRoomBookingException{

	NotFoundException(){
		
	}
	public NotFoundException(String message,boolean isClientException){
		super(message, isClientException);
	}

}
