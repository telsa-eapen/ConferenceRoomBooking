package com.example.ConferenceRoomBooking.controllers;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ConferenceRoomBooking.exceptions.MeetingRoomBookingException;
import com.example.ConferenceRoomBooking.exceptions.NotFoundException;
import com.example.ConferenceRoomBooking.exceptions.RoomNotAvailable;
import com.example.ConferenceRoomBooking.models.Booking;
import com.example.ConferenceRoomBooking.models.BookingEntity;

import com.example.ConferenceRoomBooking.services.IBookingServicePostgre;

@RestController
public class BookingControllerPostgre {
	@Autowired
	IBookingServicePostgre bookingService;
	
	
	
	@PostMapping("/bookings")
	public ResponseEntity<BookingEntity> addBooking(@RequestBody Booking booking) throws NotFoundException, RoomNotAvailable, Exception{
	
		BookingEntity bookingDone = bookingService.bookConferenceRoom(booking);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(bookingDone);
	}
	@GetMapping("/bookings")
	public Iterator<BookingEntity> getBookingsByUser(@RequestParam int user) throws MeetingRoomBookingException{
		return this.bookingService.listBookings(user);
	}
}
