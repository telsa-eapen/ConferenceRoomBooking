package com.example.ConferenceRoomBooking.repositories;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Component;

import com.example.ConferenceRoomBooking.enums.BookingStatus;
import com.example.ConferenceRoomBooking.models.Booking;

@Component
public class ConferenceRoomBookingRepository implements IConferenceRoomBookingRepository {

	private static ConferenceRoomBookingRepository bookingRepoObj;
	private Map<Integer,List<Booking>> bookingRepo;
	
	private ConferenceRoomBookingRepository() {
		bookingRepo = new HashMap<>();
	}
	
	@Override
	public Booking addBooking(Booking booking) {
		List<Booking> bookings=new LinkedList<>();
		int bookingId=bookingRepo.size();//id shuldnot be calculated like this
		booking.setBookingId(bookingId);
		if(bookingRepo.containsKey(booking.getUserId())) {
			bookings= bookingRepo.get(booking.getUserId());
		}
		bookings.add(booking);
		bookingRepo.put(booking.getUserId(), bookings);
		return booking;
	}

	public List<Booking> getBooking(int userId) {
		return bookingRepo.get(userId);
	}
	
	public List<Booking> getBookingByBuildingNameAndFloorId(String buildingName, int floorId){
		List<Booking> listBookingByBuildingNameAndfloor = new LinkedList<>();
		for(Entry<Integer, List<Booking>> bookings: bookingRepo.entrySet()) {
			for(Booking booking:bookings.getValue()) {
				if(booking.getBuildingName() == buildingName && booking.getFloorId() == floorId) {
					listBookingByBuildingNameAndfloor.add(booking);
				}
			}
		}
		return listBookingByBuildingNameAndfloor;
	}

	@Override
	public List<String> listBooking(String buildingName, int floorId) {
		List<String> listOfBookings = new LinkedList<>();
		for(Entry<Integer, List<Booking>> bookings: bookingRepo.entrySet()) {
			for(Booking booking:bookings.getValue()) {
				listOfBookings.add(booking.getBookingId()+" "+booking.getUserId()+" "+booking.getBookingSlot()+" "+booking.getBuildingName()+" "+
			booking.getFloorId()+" "+booking.getConferenceRoomId()+booking.getBookingSatus());
			}
		}
		return listOfBookings;
	}

	@Override
	public boolean updateBooking(int userId, int bookingId) {
		//System.out,println('hi');
		List<Booking> bookings = bookingRepo.get(userId);
		boolean isBookedEarlier=false;
		for(Booking b: bookings) {
			if(b.getBookingId() == bookingId) {
				b.setBookingSatus(BookingStatus.CANCELLED);
				isBookedEarlier = true;
				break;
			}
		}
		return isBookedEarlier;
	}

	public static synchronized ConferenceRoomBookingRepository getInstance() {
		if(bookingRepoObj == null) {
			bookingRepoObj = new ConferenceRoomBookingRepository();
		}
		return bookingRepoObj;
	}

//use singleton design whenever database related 
}
