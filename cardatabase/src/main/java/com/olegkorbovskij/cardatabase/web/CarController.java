package com.olegkorbovskij.cardatabase.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.olegkorbovskij.cardatabase.domain.Car;
import com.olegkorbovskij.cardatabase.domain.CarRepository;

@RestController
public class CarController {
	
	@Autowired
	private CarRepository repository;
	
	@RequestMapping("/cars")
	public Iterable<Car> getCars() {
		return repository.findAll();
	}

}
