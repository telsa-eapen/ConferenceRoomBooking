package com.example.ConferenceRoomBooking.services;


import java.sql.Date;
import java.time.LocalDate;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ConferenceRoomBooking.exceptions.MeetingRoomBookingException;
import com.example.ConferenceRoomBooking.exceptions.NotFoundException;
import com.example.ConferenceRoomBooking.models.Building;
import com.example.ConferenceRoomBooking.models.ConferenceRoom;
import com.example.ConferenceRoomBooking.models.ConferenceRoomBuilder;
import com.example.ConferenceRoomBooking.models.Floor;
import com.example.ConferenceRoomBooking.models.Slot;
import com.example.ConferenceRoomBooking.repositories.BuildingRepository;
import com.example.ConferenceRoomBooking.repositories.IBuildingRepository;



@Service
public class ConferenceRoomService implements IConferenceRoomService{

	@Autowired
	private IBuildingRepository buildingRepo;
	
	public ConferenceRoom addConferenceRoom( String confRoomName,int floorId, String buildingName) throws MeetingRoomBookingException {
		ConferenceRoom room = null;
	    try {
	    	if(buildingRepo.getBuilding(buildingName) !=null) {
	    		Building building = buildingRepo.getBuilding(buildingName);//var name meaningful
	    		
	    		Map<Integer,Floor> floors = building.getFloors();
	    		if(floors.containsKey(floorId)) {
	    			room = new ConferenceRoomBuilder().setConferenceRoomName(confRoomName).getConferenceRoom();
					room = buildingRepo.addConferenceRoom(building, floors.get(floorId), room);
					floors.get(floorId).getConferenceRooms().put(confRoomName, room);
	    		}
	    		else {
	    			throw new MeetingRoomBookingException("Floor not found",true);
	    		}
	    	}
	    	else {
	    		throw new MeetingRoomBookingException("Building not found",true);
	    	}
	    }
	    catch(Exception e) {
	    	throw new MeetingRoomBookingException("Server error",false);
	    }
		return room;
	}


	public List<ConferenceRoom> searchAvailableRoomByFloor(String slot, String buildingName, int floor) {
		// TODO Auto-generated method stub
		List<ConferenceRoom> availableRooms= new LinkedList<>();
		if(buildingRepo.getBuilding(buildingName)!=null) {
			Map<Integer,Floor> floors= buildingRepo.getBuilding(buildingName).getFloors();
			if(floors.containsKey(floor)) {
				//System.out.print("check for floor");
				availableRooms = validateAvailability(floors.get(floor).getConferenceRooms(),slot);
			}
		}
		return availableRooms;
	}


	private List<ConferenceRoom> validateAvailability(Map<String,ConferenceRoom> conferenceRooms, String slot) {
		List<ConferenceRoom> list=new LinkedList<>();
	
		for(Entry<String, ConferenceRoom> r: conferenceRooms.entrySet()) {
			if(isSlotAvailableForRoom(r.getValue(),slot)) {
				list.add(r.getValue());
			}	
		}
		return list;
	}
	
	public boolean isSlotAvailableForRoom(ConferenceRoom r, String slot) {
		
		int chosenStartTime= Integer.parseInt(slot.split(":")[0]);
		int chosenEndTime= Integer.parseInt(slot.split(":")[1]);

		Date today= Date.valueOf(LocalDate.now());//date should be given by user
		//System.out.println(today);
		if(r.getBookedSlots()== null || r.getBookedSlots().get(today).size() == 0) {
			System.out.println(today);
			return true;
		}
		List<Slot> bookedSlots=r.getBookedSlots().get(today);
		//System.out.println(bookedSlots.size());
		//sort the slots by start time and loop and see overlapping?
		Collections.sort(bookedSlots, new SlotComparator());
		if(bookedSlots.size() == 1) {
			if(bookedSlots.get(0).getEndTime() <= chosenStartTime ||
					bookedSlots.get(0).getStartTime() >= chosenEndTime) {
				return true;
			}
		}
		for(int i=1;i<bookedSlots.size();i++) {
			if(bookedSlots.get(i).getEndTime() > bookedSlots.get(i-1).getEndTime()) {
				if(bookedSlots.get(i-1).getEndTime() <= chosenStartTime &&
						bookedSlots.get(i).getStartTime() >= chosenEndTime) {
					return true;
				}
				if(i+1 == bookedSlots.size() && (chosenStartTime > bookedSlots.get(i).getEndTime())) {
					return true;
				}
			}
		}
		return false;
	}


	public List<ConferenceRoom> searchAvailableRoomByCapacity(String slot, String buildingName, int floor,
			int capacity) {//capacity should be from user
		// TODO implement it after implementing 65th line function logic
		return null;
	}


	@Override
	public boolean searchAvailabilityByRoom(ConferenceRoom room, String slot) {
		return isSlotAvailableForRoom(room,slot);
	}
	
	public boolean removeBookedSlotFromConfRoom(int userId,String room,Slot s,String buildingName,int floorId) {
		Date today= Date.valueOf(LocalDate.now());
		return buildingRepo.updateConferenceRoom(userId, room, s, buildingName,floorId,today);
	}

}

class SlotComparator implements java.util.Comparator<Slot> {
	
	public int compare(Slot a, Slot b) {
		return a.getStartTime() -b.getStartTime();
	}
	
}
