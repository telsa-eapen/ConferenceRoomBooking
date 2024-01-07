package com.conference_room_booking.repositories;

import java.util.List;

import com.conference_room_booking.models.Booking;

public interface IConferenceRoomBookingRepository {

	Booking addBooking(Booking booking);
	List<String> listBooking(String buildingName, int floorId);
	boolean updateBooking(int userId, int bookingId);//use booking id for cancel
}
