package com.example.ConferenceRoomBooking.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ConferenceRoomBooking.exceptions.MeetingRoomBookingException;
import com.example.ConferenceRoomBooking.models.FloorEntity;
import com.example.ConferenceRoomBooking.models.RoomEntity;
import com.example.ConferenceRoomBooking.repositories.FloorRepositoryPostgre;
import com.example.ConferenceRoomBooking.repositories.RoomRepositoryPostgre;

@Service
public class ConferenceRoomServicePostgre implements IConferenceRoomServicePostgre {

	@Autowired
	RoomRepositoryPostgre roomRepo;
	
	@Autowired
	FloorRepositoryPostgre floorRepo;
	
	@Override
	public RoomEntity addConferenceRoomToFloor(String buildingName, int floorId, RoomEntity room)
			throws MeetingRoomBookingException {
		Optional<FloorEntity> floorOptional = this.floorRepo.findById(floorId);
		FloorEntity floor= floorOptional.get();
		room.setFloor(floor);
		RoomEntity roomSaved = this.roomRepo.save(room);
		/*List<RoomEntity> rooms = floor.getRoom();
		rooms.add(roomSaved);
		floor.setRoom(rooms);
		this.floorRepo.save(floor);*/
		return roomSaved;
	}

}
