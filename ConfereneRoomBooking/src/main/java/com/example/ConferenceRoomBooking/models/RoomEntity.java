package com.example.ConferenceRoomBooking.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Rooms")
public class RoomEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	//@JoinColumn(name = "floor_id", nullable = false)
	@ManyToOne
	@JoinColumn(name = "floor_id", nullable = false)
	private FloorEntity floor;
	public FloorEntity getFloor() {
		return floor;
	}
	public void setFloor(FloorEntity floor) {
		this.floor = floor;
	}
	//@OneToMany(mappedBy="room",fetch = FetchType.LAZY)
	 //@JsonIgnore
	 //private List<SlotEntity> slot;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
