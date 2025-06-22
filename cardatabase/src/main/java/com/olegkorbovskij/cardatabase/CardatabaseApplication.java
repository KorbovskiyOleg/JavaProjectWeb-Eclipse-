package com.olegkorbovskij.cardatabase;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.olegkorbovskij.cardatabase.domain.Car;
import com.olegkorbovskij.cardatabase.domain.CarRepository;
import com.olegkorbovskij.cardatabase.domain.Owner;
import com.olegkorbovskij.cardatabase.domain.OwnerRepository;

@SpringBootApplication
public class CardatabaseApplication implements CommandLineRunner{
	 private static final Logger logger = 
             LoggerFactory.getLogger
                 (CardatabaseApplication.class);
	 @Autowired
	 private CarRepository repository;
	 
	 @Autowired
	 private OwnerRepository orepository;

	public static void main(String[] args) {
		//This is comment a important
		SpringApplication.run(CardatabaseApplication.class, args);
		logger.info("Application started");
	}

	@Override
	public void run(String... args) throws Exception {
		
		Owner owner1 = new Owner("John"," Jonson");
		Owner owner2 = new Owner("Mary ", " Robinson");
		orepository.saveAll(Arrays.asList(owner1,owner2));
		
		
		 repository.save(new Car("Ford", "Mustang", "Red", "ADF-1121", 2021, 59000, owner1));
		 repository.save(new  Car("Nissan", "Leaf", "White", "SSJ-3002", 2019, 29000, owner2));
		 repository.save(new Car("Toyota", "Prius", "Silver", "KKO-0212", 2020, 39000,owner2));
		 repository.save(new Car("Ford","Mustang","Black","AMB-3222",2024,100000,owner1));
		 
		
		 
		 
		 for (Car car : repository.findAll()) {
	           logger.info(car.getBrand() + " " + car
	               .getModel());
	       }
		 
		 
		 for (Car car : repository.findByBrandAndModel("Ford", "Mustang")) {
	           logger.info(car.getBrand() + " " + car.getModel()+ " "+ car.getId());
	       }
		//repository.deleteAll();
		
	}
}
