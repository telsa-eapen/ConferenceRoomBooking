package com.example.ConferenceRoomBooking.controllers;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ConferenceRoomBooking.config.JwtUtil;
import com.example.ConferenceRoomBooking.models.UserEntity;
import com.example.ConferenceRoomBooking.services.IUserServicePostgre;


@RestController
public class UserControllerPostgre {
	
	
	@Autowired
    private AuthenticationManager authenticationManager;
	@Autowired
    private JwtUtil jwtUtil;
	

	@Autowired
	IUserServicePostgre userService;
	
	//@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/users")
	  public Iterable<UserEntity> findAllUsers() {
	    return this.userService.findAllUsers();
	  }
	@PostMapping("/register")
	  public UserEntity addOneUser(@RequestBody UserEntity user) {
	    return this.userService.registerUser(user);
	  }
	 @PostMapping("/login")
	    public ResponseEntity<String> loginUser(@RequestBody UserEntity request) {
	      /*  try {
	        	//jwtUtil.generateToken(request.getName());
	            authenticationManager.authenticate(
	                new UsernamePasswordAuthenticationToken(request.getName(), request.getPassword())
	            );
	        } catch (BadCredentialsException e) {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
	        }
*/
	        UserDetails userDetails = userService.loadUserByUsername(request.getName());
	        String token = jwtUtil.generateToken(userDetails.getUsername());

	        return ResponseEntity.ok(token);
	    }
}
