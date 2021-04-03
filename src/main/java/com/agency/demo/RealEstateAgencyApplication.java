package com.agency.demo;

import com.agency.demo.enums.UserRole;
import com.agency.demo.models.Advertisement;
import com.agency.demo.models.Estate;
import com.agency.demo.models.Realtor;
import com.agency.demo.models.User;
import com.agency.demo.services.AdvertisementService;
import com.agency.demo.services.EstateService;
import com.agency.demo.services.RealtorService;
import com.agency.demo.services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class RealEstateAgencyApplication {

	public static void main(String[] args) {
		SpringApplication.run(RealEstateAgencyApplication.class, args);
	}

}
