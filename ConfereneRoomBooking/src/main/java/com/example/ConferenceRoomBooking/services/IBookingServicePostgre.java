package com.example.ConferenceRoomBooking.services;

import java.util.Iterator;

import org.springframework.stereotype.Component;

import com.example.ConferenceRoomBooking.exceptions.MeetingRoomBookingException;
import com.example.ConferenceRoomBooking.exceptions.NotFoundException;
import com.example.ConferenceRoomBooking.exceptions.RoomNotAvailable;
import com.example.ConferenceRoomBooking.models.Booking;
import com.example.ConferenceRoomBooking.models.BookingEntity;

@Component
public interface IBookingServicePostgre {
	public BookingEntity bookConferenceRoom(Booking booking) throws NotFoundException, RoomNotAvailable, Exception;
	//public boolean cancelBooking(int userId, int bookingId) throws MeetingRoomBookingException;
	public Iterator<BookingEntity> listBookings(int userId) throws MeetingRoomBookingException;
}
