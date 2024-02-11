package com.example.ConferenceRoomBooking;

import java.util.Arrays;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.example.ConferenceRoomBooking.services.IBuildingService;


@SpringBootApplication(exclude = {UserDetailsServiceAutoConfiguration.class })
public class ConfereneRoomBookingApplication {

	@Autowired
	IBuildingService buildingService;
	public static void main(String[] args) {
		SpringApplication.run(ConfereneRoomBookingApplication.class, args);
	}
	/*@Bean
	public CommandLineRunner commandLineRunner(ConfigurableApplicationContext ctx) {
		return args -> {

			System.out.println("Let's inspect the beans provided by Spring Boot:");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				System.out.println(beanName);
			}

		};
	}
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println(buildingService.addBuilding("b1"));

		};
	}*/
}
