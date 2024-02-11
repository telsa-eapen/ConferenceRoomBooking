package com.example.ConferenceRoomBooking.models;

import com.example.ConferenceRoomBooking.enums.BookingStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Bookings")
public class BookingEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
	private UserEntity user;
	private int floorId;
	private String buildingName;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "room_id")
	private RoomEntity conferenceRoom;

	//private SlotEntity bookingSlot;dont add slot here as it is hard to delete when we cancel booking
	private BookingStatus bookingStatus;
    
	public BookingEntity(int floorId, String buildingName) {
		this.setFloorId(floorId);
		this.setBuildingName(buildingName);
	}
	
	public BookingStatus getBookingSatus() {
		return bookingStatus;
	}

	public void setBookingSatus(BookingStatus bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
	public RoomEntity getConferenceRoom() {
		return conferenceRoom;
	}

	public void setConferenceRoom(RoomEntity conferenceRoom) {
		this.conferenceRoom = conferenceRoom;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public int getFloorId() {
		return floorId;
	}

	public void setFloorId(int floorId) {
		this.floorId = floorId;
	}
	
	
}
