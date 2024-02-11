package com.example.ConferenceRoomBooking.repositories;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.ConferenceRoomBooking.models.Booking;

@Component
public interface IConferenceRoomBookingRepository {

	Booking addBooking(Booking booking);
	List<String> listBooking(String buildingName, int floorId);
	boolean updateBooking(int userId, int bookingId);//use booking id for cancel
	List<Booking> getBooking(int userId);
	List<Booking> getBookingByBuildingNameAndFloorId(String buildingName, int floorId);
}
