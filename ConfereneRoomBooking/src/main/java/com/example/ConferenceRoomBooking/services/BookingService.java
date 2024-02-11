package com.example.ConferenceRoomBooking.services;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ConferenceRoomBooking.enums.BookingStatus;
import com.example.ConferenceRoomBooking.exceptions.MeetingRoomBookingException;
import com.example.ConferenceRoomBooking.exceptions.NotFoundException;
import com.example.ConferenceRoomBooking.exceptions.RoomNotAvailable;
import com.example.ConferenceRoomBooking.models.Booking;
import com.example.ConferenceRoomBooking.models.BookingBuilder;
import com.example.ConferenceRoomBooking.models.Building;
import com.example.ConferenceRoomBooking.models.ConferenceRoom;
import com.example.ConferenceRoomBooking.models.Slot;
import com.example.ConferenceRoomBooking.repositories.BuildingRepository;
import com.example.ConferenceRoomBooking.repositories.ConferenceRoomBookingRepository;
import com.example.ConferenceRoomBooking.repositories.IBuildingRepository;
import com.example.ConferenceRoomBooking.repositories.IConferenceRoomBookingRepository;
import com.example.ConferenceRoomBooking.repositories.IUserRepository;
import com.example.ConferenceRoomBooking.repositories.UserRepository;

@Service
public class BookingService implements IBookingService{

	@Autowired
	private IConferenceRoomBookingRepository bookingRepo;
	@Autowired
	private IUserRepository userRepo;
	@Autowired
	private IBuildingRepository buildingRepo;
	@Autowired
	private IConferenceRoomService confRoomService;
	
	@Override
	public Booking bookConferenceRoom(int userId, String slot, String buildingName, int floorId, String confRoomId) throws Exception {
		Slot s = new Slot(Integer.parseInt(slot.split(":")[0]),Integer.parseInt(slot.split(":")[1]));
		
		
		if(!userRepo.getUsers().containsKey(userId)) {//reduce if else 
			/*System.out.print("check for user");
			User u =new UserBuilder().setUserId(userId).getUser();
			userRepo.registerUser(u);*/
			throw new Exception("User not registered");
		}
		//also check if slot is available for the room else throw error 
		if(buildingRepo.getBuilding(buildingName)==null) {
			throw new NotFoundException("Buildign not found",true);
		}
		if(buildingRepo.getBuilding(buildingName)!=null) {
			
			Building b= buildingRepo.getBuilding(buildingName);
			if(b.getFloors().containsKey(floorId)){
				/*List<ConferenceRoom> availableRooms = confRoomService.searchAvailableRoomByFloor(slot, buildingName, floorId);
				for(ConferenceRoom r: availableRooms) {//avoid this loop and chekc availability by room directly
					if(r.getConfRoomId() == confRoomId) {
						Booking booking = new BookingBuilder().setUserId(userId).setBuildingName(buildingName).setFloorId(floorId)
								.setConferenceRoomId(confRoomId).setBookingSlot(s).setBookingSatus(BookingStatus.BOOKED).getBooking();
						bookingRepo.addBooking(booking);
						return true;
					}
				  }*/
				  ConferenceRoom room= b.getFloors().get(floorId).getConferenceRooms().get(confRoomId);
				 
				  if(confRoomService.searchAvailabilityByRoom(room, slot)) {
					  Booking booking = new BookingBuilder().setUserId(userId).setBuildingName(buildingName).setFloorId(floorId)
								.setConferenceRoomId(confRoomId).setBookingSlot(s).setBookingSatus(BookingStatus.BOOKED).getBooking();
						booking = bookingRepo.addBooking(booking);
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
						//System.out.println("your booking id"+ booking.getBookingId());
						return booking;
				  }
				  else {
					 throw new MeetingRoomBookingException("Sorry,No availability for the slot",true);					  
				  }
				}
			else {
				throw new NotFoundException("Floor not found",true);
			}
			
		}
		throw new RoomNotAvailable("Slot not available for the selected room");
	}

	@Override
	public boolean cancelBooking(int userId,int bookingId) throws MeetingRoomBookingException {
		try {
		List<Booking> bookings =  bookingRepo.getBooking(userId);
		for(Booking b:bookings) {
			if(b.getBookingId() == bookingId) {//not able to book to same room 
				confRoomService.removeBookedSlotFromConfRoom(userId, b.getConferenceRoomId(), b.getBookingSlot(), b.getBuildingName(), b.getFloorId());
			}
		}
		}
		catch(Exception e) {
			throw new MeetingRoomBookingException("Booking not found",true);
		}
		
		return bookingRepo.updateBooking(userId,bookingId);
	}


	public List<Booking> getBookingByBuildingNameAndFloorId(String buildingName, int floorId) {
		
		return bookingRepo.getBookingByBuildingNameAndFloorId(buildingName, floorId);
	}

	@Override
	public List<Booking> getBookingByUserId(int userId) {//getBookingByUserId
		
		return bookingRepo.getBooking(userId);
	}
	public void listBookings(String buildingName, int floorId) {
		for(String booking:bookingRepo.listBooking(buildingName, floorId)) {
			System.out.print(booking+" ");
		}
	}
}
