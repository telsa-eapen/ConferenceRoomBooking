package com.conference_room_booking.services;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.conference_room_booking.enums.BookingStatus;
import com.conference_room_booking.exceptions.NotFoundException;
import com.conference_room_booking.exceptions.RoomNotAvailable;
import com.conference_room_booking.models.*;
import com.conference_room_booking.repositories.BuildingRepository;
import com.conference_room_booking.repositories.ConferenceRoomBookingRepository;
import com.conference_room_booking.repositories.UserRepository;

public class BookingService implements IBookingService{

	private ConferenceRoomBookingRepository bookingRepo = ConferenceRoomBookingRepository.getInstance();
	private UserRepository userRepo = UserRepository.getInstance();
	private BuildingRepository buildingRepo = BuildingRepository.getInstance();
	
	private ConferenceRoomService confRoomService =new ConferenceRoomService();
	
	@Override
	public boolean bookConferenceRoom(int userId, String slot, String buildingName, int floorId, String confRoomId) throws Exception {
		Slot s = new Slot(Integer.parseInt(slot.split(":")[0]),Integer.parseInt(slot.split(":")[1]));
		

		if(!userRepo.getUsers().containsKey(userId)) {//reduce if else 
			/*System.out.print("check for user");
			User u =new UserBuilder().setUserId(userId).getUser();
			userRepo.registerUser(u);*/
			throw new Exception("User not registered");
		}
		//also check if slot is available for the room else throw error 
		if(buildingRepo.getBuilding(buildingName)==null) {
			throw new NotFoundException("Buildign not found");
		}
		if(buildingRepo.getBuilding(buildingName)!=null) {
			
			Building b= buildingRepo.getBuilding(buildingName);
			if(b.getListOfFloors().containsKey(floorId)){
				/*List<ConferenceRoom> availableRooms = confRoomService.searchAvailableRoomByFloor(slot, buildingName, floorId);
				for(ConferenceRoom r: availableRooms) {//avoid this loop and chekc availability by room directly
					if(r.getConfRoomId() == confRoomId) {
						Booking booking = new BookingBuilder().setUserId(userId).setBuildingName(buildingName).setFloorId(floorId)
								.setConferenceRoomId(confRoomId).setBookingSlot(s).setBookingSatus(BookingStatus.BOOKED).getBooking();
						bookingRepo.addBooking(booking);
						return true;
					}
				  }*/
				  ConferenceRoom room= b.getListOfFloors().get(floorId).getListOfConferenceRoom().get(confRoomId);
				 
				  if(confRoomService.searchAvailabilityByRoom(room, slot)) {
					  Booking booking = new BookingBuilder().setUserId(userId).setBuildingName(buildingName).setFloorId(floorId)
								.setConferenceRoomId(confRoomId).setBookingSlot(s).setBookingSatus(BookingStatus.BOOKED).getBooking();
						bookingRepo.addBooking(booking);
						Date today= Date.valueOf(LocalDate.now());
						if(room.getBookedSlots()== null || room.getBookedSlots().size() == 0) {
							Map<Date,List<Slot>> listOfSlots = new HashMap<>();
							List<Slot> listSlot = new LinkedList<>();
							listSlot.add(s);
							listOfSlots.put(today,listSlot);
							room.setBookedSlots(listOfSlots);
						}
						else {
						room.getBookedSlots().get(today).add(s);
						}
						System.out.println("your booking id"+ booking.getBookingId());
						return true;
				  }
				  else {
					  return false;					  
				  }
				}
			else {
				throw new NotFoundException("Floor not found");
			}
			
		}
		throw new RoomNotAvailable("Slot not available for the selected room");
	}

	@Override
	public boolean cancelBooking(int userId,int bookingId) {
		List<Booking> bookings =  bookingRepo.getBooking(userId);
		for(Booking b:bookings) {
			if(b.getBookingId() == bookingId) {
				confRoomService.removeBookedSlotFromConfRoom(userId, b.getConferenceRoomId(), b.getBookingSlot(), b.getBuildingName(), b.getFloorId());
			}
		}
		
		return bookingRepo.updateBooking(userId,bookingId);
	}


	public List<Booking> getBookingByBuildingNameAndFloorId(String buildingName, int floorId) {
		
		return bookingRepo.getBookingByBuildingNameAndFloorId(buildingName, floorId);
	}

	@Override
	public List<Booking> getBookingByUserId(int userId, String buildingName, int floorId, String confRoomId) {//getBookingByUserId
		
		return bookingRepo.getBooking(userId);
	}
	public void listBookings(String buildingName, int floorId) {
		for(String booking:bookingRepo.listBooking(buildingName, floorId)) {
			System.out.print(booking+" ");
		}
	}
}
