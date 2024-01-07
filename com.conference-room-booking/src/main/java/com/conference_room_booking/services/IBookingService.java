package com.conference_room_booking.services;

import java.util.List;

import com.conference_room_booking.exceptions.NotFoundException;
import com.conference_room_booking.exceptions.RoomNotAvailable;
import com.conference_room_booking.models.Booking;

public interface IBookingService{
public boolean bookConferenceRoom(int userId,String slot,String buildingName,int floorId,String confRoomId) throws NotFoundException, RoomNotAvailable, Exception;
public boolean cancelBooking(int userId, int bookingId);
public List<Booking> getBookingByBuildingNameAndFloorId(String buildingName,int floorId);
public List<Booking> getBookingByUserId(int userId,String buildingName,int floorId,String confRoomId);
public void listBookings(String buildingName, int floorId);
}
