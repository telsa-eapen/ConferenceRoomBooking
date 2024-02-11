package com.example.ConferenceRoomBooking.models;

import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Buildings")
public class BuildingEntity {
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private Integer id;
	 private String name;
	// @OneToMany(mappedBy="building",fetch = FetchType.LAZY)
	 //@JsonIgnore
	 //private List<FloorEntity> floors;
	 
	 private BuildingEntity() {
		 //floors = new LinkedList<>();
	 }
     public BuildingEntity(String buildingName,FloorEntity floor) {
		 this.setName(buildingName);
		 
	 }
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	/*public List<FloorEntity> getFloors() {
		return floors;
	}
	public void setFloors(List<FloorEntity> floors) {
		this.floors = floors;
	}
	 */
}
