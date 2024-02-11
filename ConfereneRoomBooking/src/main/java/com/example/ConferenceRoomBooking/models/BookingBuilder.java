package com.example.ConferenceRoomBooking.models;

import com.example.ConferenceRoomBooking.enums.BookingStatus;

public class BookingBuilder {
	private int bookingId;
	private int userId;
	private int floorId;
	private String buildingName;
	private String conferenceRoomId;
	private Slot bookingSlot;
	private BookingStatus bookingSatus;
	
	public BookingBuilder setFloorId(int floorId) {
		this.floorId = floorId;
		return this;
	}
	public BookingBuilder setBookingSatus(BookingStatus bookingSatus) {
		this.bookingSatus = bookingSatus;
		return this;
	}
	public BookingBuilder setBookingId(int bookingId) {
		this.bookingId = bookingId;
		return this;
	}
	public BookingBuilder setUserId(int userId) {
		this.userId = userId;
		return this;
	}
	public BookingBuilder setBuildingName(String buildingName) {
		this.buildingName = buildingName;
		return this;
	}
	public BookingBuilder setConferenceRoomId(String conferenceRoomId) {
		this.conferenceRoomId = conferenceRoomId;
		return this;
	}
	public BookingBuilder setBookingSlot(Slot bookingSlot) {
		this.bookingSlot = bookingSlot;
		return this;
	}
	public Booking getBooking() {
		return new Booking(this.bookingId,this.userId,this.floorId,this.buildingName,this.conferenceRoomId,this.bookingSlot,this.bookingSatus);
	}
}
