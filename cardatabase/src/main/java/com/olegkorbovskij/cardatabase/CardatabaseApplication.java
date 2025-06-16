package com.olegkorbovskij.cardatabase;

import org.slf4j.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CardatabaseApplication {
	 private static final Logger logger = 
             LoggerFactory.getLogger
                 (CardatabaseApplication.class);

	public static void main(String[] args) {
		//This is comment a important
		SpringApplication.run(CardatabaseApplication.class, args);
		logger.info("Application started");
	}

}
