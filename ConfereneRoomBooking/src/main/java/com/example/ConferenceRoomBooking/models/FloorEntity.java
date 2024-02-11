package com.example.ConferenceRoomBooking.models;

import java.util.LinkedList;
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
@Table(name="Floors")
public class FloorEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "building_id", nullable = false)
	//@ManyToOne
	private BuildingEntity building;
	//@OneToMany(mappedBy="floor",fetch = FetchType.LAZY)
	//@JsonIgnore
	//private List<RoomEntity> room;
	
	public BuildingEntity getBuilding() {
		return building;
	}
	public void setBuilding(BuildingEntity building) {
		this.building = building;
	}
/*	private FloorEntity() {
		this.room = new LinkedList<>();
	}
	public FloorEntity(RoomEntity room) {
		//this.setRoom(room);
	}
	public List<RoomEntity> getRoom() {
		return room;
	}
	public void setRoom(List<RoomEntity> room) {
		this.room = room;
	}*/
	
}
