package com.example.ConferenceRoomBooking.aspect;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.ConferenceRoomBooking.exceptions.MeetingRoomBookingException;
import com.example.ConferenceRoomBooking.exceptions.NotFoundException;

@ControllerAdvice
public class GlobalExceptionFilter {
	private static final Logger LOGGER = LogManager.getLogger(GlobalExceptionFilter.class);
	@ExceptionHandler(MeetingRoomBookingException.class)
	public ResponseEntity<Object> handleException(MeetingRoomBookingException ex){
		 Map<String, Object> body = new HashMap<>();
		 LOGGER.error(ex.getMessage());
		 body.put("message", ex.getLocalizedMessage());
		 	if(ex.isClientException()) {
		 		
		 		return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
		 	}
		 	return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);     
	}
	/*	GlobalExceptionFilter
		
		=> condition check
		=> log the stack trace 
		
		MeetingRoomBookingException => custom Exception
		
		{
		    erroCode
		    Message => "Building Error . Building Room"
		    Name =>
		    isClientException => true
		}
		
		
		Exception 
		
		 => 400
		
		
		
		catch(Exception) {
		    return 500 , Message = "Internal Servcie Error";
		}*/

}
