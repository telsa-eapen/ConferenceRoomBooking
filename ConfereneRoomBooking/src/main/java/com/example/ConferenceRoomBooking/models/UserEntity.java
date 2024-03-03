package com.example.ConferenceRoomBooking.models;



import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;



@Entity
@Table(name = "Users")
public class UserEntity {
	
	  @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private String password;
	@ManyToMany(fetch = FetchType.EAGER)
    private Set<UserRole> roles = new HashSet<>();
	
	private UserEntity() {
		
	}
	public UserEntity(String userName,String password) {
		//this.setUserId(userId);
		this.setName(userName);
		this.setPassword(password);
	}


	public Set<UserRole> getRoles() {
		return roles;
	}
	public void setRoles(Set<UserRole> roles) {
		this.roles = roles;
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
