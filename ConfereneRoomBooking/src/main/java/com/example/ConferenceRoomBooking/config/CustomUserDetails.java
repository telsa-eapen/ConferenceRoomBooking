package com.example.ConferenceRoomBooking.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.example.ConferenceRoomBooking.models.UserEntity;
import com.example.ConferenceRoomBooking.models.UserRole;


public class CustomUserDetails extends UserEntity implements UserDetails {
	private String username;
    private String password;
    Collection<? extends GrantedAuthority> authorities;
    
	public CustomUserDetails(UserEntity user) {
		super(user.getName(),user.getPassword());
		this.username= user.getName();
		// TODO Auto-generated constructor stub
		List<GrantedAuthority> auths = new ArrayList<>();

        for(UserRole role : user.getRoles()){

            auths.add(new SimpleGrantedAuthority(role.getName().toUpperCase()));
        }
        this.authorities = auths;
	}

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
