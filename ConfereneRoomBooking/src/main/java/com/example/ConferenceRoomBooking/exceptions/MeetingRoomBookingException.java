package com.example.ConferenceRoomBooking.exceptions;

public class MeetingRoomBookingException extends Exception {
	boolean isClientException;
	MeetingRoomBookingException(){
		
	}
	public MeetingRoomBookingException(String message,boolean isClientException){
		super(message);
		this.isClientException = isClientException;
	}
	public boolean isClientException() {
		return isClientException;
	}
	public void setClientException(boolean isClientException) {
		this.isClientException = isClientException;
	}
	
	
}
