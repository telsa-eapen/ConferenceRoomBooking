package com.example.ConferenceRoomBooking.models;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name = "Users")
public class UserEntity {
	
	  @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private String password;
	
	private UserEntity() {
		
	}
	public UserEntity(int userId, String userName,String password) {
		//this.setUserId(userId);
		this.setName(userName);
		this.setPassword(password);
	}


	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
