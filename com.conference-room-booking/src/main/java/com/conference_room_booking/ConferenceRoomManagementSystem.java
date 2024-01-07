package com.conference_room_booking;

import java.io.IOException;
import java.util.Scanner;

import com.conference_room_booking.exceptions.NotFoundException;
import com.conference_room_booking.exceptions.RoomNotAvailable;
import com.conference_room_booking.models.Building;
import com.conference_room_booking.models.ConferenceRoom;
import com.conference_room_booking.models.Floor;
import com.conference_room_booking.services.BookingService;
import com.conference_room_booking.services.BuildingService;
import com.conference_room_booking.services.ConferenceRoomService;
import com.conference_room_booking.services.FloorService;
import com.conference_room_booking.services.UserService;

public class ConferenceRoomManagementSystem {

	public static void main(String[] args) throws IOException, NotFoundException, RoomNotAvailable {
		// TODO Auto-generated method stub
		
		System.out.println("Conference Room Booking System");
		BuildingService buildingService = new BuildingService();
		FloorService floorService =  new FloorService();
		ConferenceRoomService confRoomService = new ConferenceRoomService();
		BookingService bookingService = new BookingService();
		UserService userService = new UserService();
		/*
		 * add building b1
		 * */
		while(true) {
			try {
				Scanner sc=new Scanner(System.in);
				String input= sc.nextLine();
				if(input.equalsIgnoreCase("Exit")) {
					System.out.println("Shutting down");
					break;
				}
				if(input.split(" ")[0].equalsIgnoreCase("ADD")) {
					//System.out.print(input.split(" ")[2]);
					if(input.split(" ")[1].equalsIgnoreCase("BUILDING")) {
						Building building = buildingService.addBuilding(input.split(" ")[2]);
						if(building!=null) {
						System.out.println("Added building "+input.split(" ")[2]+" to the system");
						}
					}
					else if(input.split(" ")[1].equalsIgnoreCase("FLOOR")) {
						Floor floor = floorService.addFloor(input.split(" ")[2], Integer.parseInt(input.split(" ")[3]));
						if(floor !=null) {
							
							System.out.println("Added floor "+input.split(" ")[3]+" to the building "+input.split(" ")[2]);
						}
					}
					else if(input.split(" ")[1].equalsIgnoreCase("CONFROOM")) {
						ConferenceRoom room = confRoomService.addConferenceRoom(input.split(" ")[2], Integer.parseInt(input.split(" ")[3]),input.split(" ")[4]);
						if(room !=null) {
							System.out.print("Added conference room "+input.split(" ")[2]+" on floor "+input.split(" ")[3]+" of building "+input.split(" ")[4]);
						}
					}
					else {
						System.out.print(input);
						throw new IOException("Invalid Input");
					}
				}
				else if(input.split(" ")[0].equalsIgnoreCase("BOOK")) {
					bookingService.bookConferenceRoom(Integer.parseInt(input.split(" ")[1]), input.split(" ")[2], input.split(" ")[3], Integer.parseInt(input.split(" ")[4]),input.split(" ")[5]);
				}
				else if(input.split(" ")[0].equalsIgnoreCase("CANCEL")) {
					bookingService.cancelBooking(Integer.parseInt(input.split(" ")[2]),Integer.parseInt(input.split(" ")[3]));
				}
				else if(input.split(" ")[0].equalsIgnoreCase("LIST")) {
					bookingService.listBookings(input.split(" ")[2],Integer.parseInt(input.split(" ")[3]));
				}
				else if(input.split(" ")[0].equalsIgnoreCase("REGISTER")) {
					userService.registerUser(Integer.parseInt(input.split(" ")[1]), input.split(" ")[2]);
				}
			}
			catch(Exception e) {
				System.out.println();e.printStackTrace();
			}
		}

	}

}
