package com.example.ConferenceRoomBooking.models;

import com.example.ConferenceRoomBooking.enums.BookingStatus;

public class Booking {
	
	//one to one mapping with user id
	private int bookingId;
	private int userId;//one to one mapping with user id //user user class
	private int floorId;
	private String buildingName;
	private int confRoomId;
	private String conferenceRoomId;//one to one mapping with conference room class,use object
	private String slotAsString;
	private int startTime;
	private int endTime;
	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public int getEndTime() {
		return endTime;
	}

	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}

	private Slot bookingSlot;//maintain start time and end time
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

	public String getSlotAsString() {
		return slotAsString;
	}

	public void setSlotAsString(String slotAsString) {
		this.slotAsString = slotAsString;
	}

	public int getConfRoomId() {
		return confRoomId;
	}

	public void setConfRoomId(int confRoomId) {
		this.confRoomId = confRoomId;
	}

}
