package com.olegkorbovskij.cardatabase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.olegkorbovskij.cardatabase.domain.CarRepository;

@SpringBootApplication
public class CardatabaseApplication implements CommandLineRunner{
	 private static final Logger logger = 
             LoggerFactory.getLogger
                 (CardatabaseApplication.class);
	 @Autowired
	 private CarRepository repository;

	public static void main(String[] args) {
		//This is comment a important
		SpringApplication.run(CardatabaseApplication.class, args);
		logger.info("Application started");
	}

	@Override
	public void run(String... args) throws Exception {
		
		
	}

}
