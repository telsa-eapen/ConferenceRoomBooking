package com.conference_room_booking.models;

import com.conference_room_booking.enums.BookingStatus;

public class Booking {
	
	private int bookingId;
	private int userId;
	private int floorId;
	private String buildingName;
	private String conferenceRoomId;
	private Slot bookingSlot;
	private BookingStatus bookingSatus;
	
	Booking(int bookingId,int userId,int floorId,String buildingName,String conferenceRoomId,Slot bookingSlot,BookingStatus bookingStatus){
		this.setBookingId(bookingId);
		this.setUserId(userId);
		this.setFloorId(floorId);
		this.setBuildingName(buildingName);
		this.setConferenceRoomId(conferenceRoomId);
		this.setBookingSlot(bookingSlot);
		this.setBookingSatus(bookingStatus);
	}

	public String getConferenceRoomId() {
		return conferenceRoomId;
	}

	public void setConferenceRoomId(String conferenceRoomId) {
		this.conferenceRoomId = conferenceRoomId;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public Slot getBookingSlot() {
		return bookingSlot;
	}

	public void setBookingSlot(Slot bookingSlot) {
		this.bookingSlot = bookingSlot;
	}

	public BookingStatus getBookingSatus() {
		return bookingSatus;
	}

	public void setBookingSatus(BookingStatus bookingSatus) {
		this.bookingSatus = bookingSatus;
	}

	public int getFloorId() {
		return floorId;
	}

	public void setFloorId(int floorId) {
		this.floorId = floorId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

}
