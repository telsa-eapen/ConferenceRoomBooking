package com.example.ConferenceRoomBooking.services;

import java.util.Iterator;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ConferenceRoomBooking.enums.BookingStatus;
import com.example.ConferenceRoomBooking.exceptions.MeetingRoomBookingException;
import com.example.ConferenceRoomBooking.exceptions.NotFoundException;
import com.example.ConferenceRoomBooking.exceptions.RoomNotAvailable;
import com.example.ConferenceRoomBooking.models.Booking;
import com.example.ConferenceRoomBooking.models.BookingEntity;
import com.example.ConferenceRoomBooking.models.RoomEntity;
import com.example.ConferenceRoomBooking.models.SlotEntity;
import com.example.ConferenceRoomBooking.models.UserEntity;
import com.example.ConferenceRoomBooking.repositories.BookingRepositoryPostgre;
import com.example.ConferenceRoomBooking.repositories.RoomRepositoryPostgre;
import com.example.ConferenceRoomBooking.repositories.SlotRepositoryPostgre;
import com.example.ConferenceRoomBooking.repositories.UserRepositoryPostgre;

@Service
public class BookingServicePostgre implements IBookingServicePostgre{
	@Autowired
	UserRepositoryPostgre userRepo;
	@Autowired
	RoomRepositoryPostgre roomRepo;
	@Autowired
	BookingRepositoryPostgre bookingRepo;
	@Autowired
	SlotRepositoryPostgre slotRepo;
	@Override
	public BookingEntity bookConferenceRoom(Booking booking) throws NotFoundException, RoomNotAvailable, Exception {
		// TODO Auto-generated method stub
		//add check for building exists or not
		BookingEntity bookingDone;
		SlotEntity slot;
		Optional<UserEntity> user = userRepo.findById(booking.getUserId());
		Optional<RoomEntity> room = roomRepo.findById(booking.getConfRoomId());
		if(user.isEmpty()) {
			throw new MeetingRoomBookingException("User not found",true);
		}
		if(room.isEmpty()) {
			throw new MeetingRoomBookingException("Room not found",true);
		}
		try {
		slot = new SlotEntity(booking.getStartTime(),booking.getEndTime());
		slot.setRoom(room.get());
		BookingEntity bookingEntity = new BookingEntity(booking.getFloorId(),booking.getBuildingName());
		bookingEntity.setUser(user.get());
		bookingEntity.setConferenceRoom(room.get());
		//one more logic to check slot availability is needed
		bookingEntity.setBookingSatus(BookingStatus.BOOKED);
		bookingDone = bookingRepo.save(bookingEntity);
		}
		catch(Exception e) {
			throw new MeetingRoomBookingException(e.getMessage(),false);
		}
		slotRepo.save(slot);
		return bookingDone;
	}

	@Override
	public Iterator<BookingEntity> listBookings(int userId) throws MeetingRoomBookingException {
		UserEntity user = this.userRepo.findById(userId).get();
		if(user == null) {
			throw new MeetingRoomBookingException("User not found",true);
		}
		return this.bookingRepo.findByUser(user);
	}

}
