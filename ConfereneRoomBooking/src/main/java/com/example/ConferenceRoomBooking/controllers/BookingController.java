package com.example.ConferenceRoomBooking.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


import com.example.ConferenceRoomBooking.exceptions.MeetingRoomBookingException;
import com.example.ConferenceRoomBooking.exceptions.NotFoundException;
import com.example.ConferenceRoomBooking.exceptions.RoomNotAvailable;
import com.example.ConferenceRoomBooking.models.Booking;

import com.example.ConferenceRoomBooking.services.IBookingService;

@Profile("dev")
@RestController
public class BookingController {
	
	@Autowired
	IBookingService bookingService;
	
	
	
	//addBooking
	@PostMapping("/bookings")
	public ResponseEntity<Booking> addBooking(@RequestBody Booking booking) throws NotFoundException, RoomNotAvailable, Exception{
		Booking bookingDone = null;
		//try {
			bookingDone =  bookingService.bookConferenceRoom(booking.getUserId(), booking.getSlotAsString(), booking.getBuildingName(), 
					booking.getFloorId(), booking.getConferenceRoomId());
		//}catch (Exception e) {
			// TODO Auto-generated catch block
			//throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getLocalizedMessage());
		//}
	
		return ResponseEntity.status(HttpStatus.CREATED).body(bookingDone);
	}
	//get booking by user
	
	@GetMapping("/bookings")
	public ResponseEntity<List<Booking>> getBookingsByUser(@RequestParam int user){
		List<Booking> listOfBookings = null;
		//try {
			listOfBookings = bookingService.getBookingByUserId(user);
		//}catch(Exception e) {
			//throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getLocalizedMessage());
		//}
		return ResponseEntity.status(HttpStatus.OK).body(listOfBookings);
	}
	
	//cancelBooking
	@PostMapping("/bookings/{bookingId}/cancellation")
	public ResponseEntity<String> cancelBooking(@PathVariable int bookingId,@RequestBody Booking booking) throws MeetingRoomBookingException{
		Boolean bookingCancelled = bookingService.cancelBooking(booking.getUserId(), bookingId);
		if(!bookingCancelled) {
			throw new MeetingRoomBookingException("Booking not found",true);
		}
		return ResponseEntity.status(HttpStatus.OK).body("Booking is cancelled");
	}

}
