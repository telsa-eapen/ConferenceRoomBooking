package com.example.ConferenceRoomBooking.models;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Slots")
public class SlotEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private int startTime;
	private int endTime;
	@ManyToOne
	@JoinColumn(name = "room_id", nullable = false)
	private RoomEntity room;
	//add date column and do indexing
	//private Date date;
	
	public RoomEntity getRoom() {
		return room;
	}
	public void setRoom(RoomEntity room) {
		this.room = room;
	}
	public SlotEntity(int startTime,int endTime){//, Date date) {
		this.setStartTime(startTime);
		this.setEndTime(endTime);
		//this.setDate(date);
	}
	public int getStartTime() {
		return startTime;
	}
	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}
	public int getEndTime() {
		return endTime;
	}
	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}
	/*public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}*/
}
