package com.example.ConferenceRoomBooking.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.ConferenceRoomBooking.exceptions.MeetingRoomBookingException;
import com.example.ConferenceRoomBooking.exceptions.NotFoundException;
import com.example.ConferenceRoomBooking.exceptions.RoomNotAvailable;
import com.example.ConferenceRoomBooking.models.Booking;



@Component
public interface IBookingService{
public Booking bookConferenceRoom(int userId,String slot,String buildingName,int floorId,String confRoomId) throws NotFoundException, RoomNotAvailable, Exception;
public boolean cancelBooking(int userId, int bookingId) throws MeetingRoomBookingException;
public List<Booking> getBookingByBuildingNameAndFloorId(String buildingName,int floorId);
public List<Booking> getBookingByUserId(int userId);
public void listBookings(String buildingName, int floorId);
}
