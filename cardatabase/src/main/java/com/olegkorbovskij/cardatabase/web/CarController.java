package com.olegkorbovskij.cardatabase.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.olegkorbovskij.cardatabase.domain.Car;
import com.olegkorbovskij.cardatabase.domain.CarRepository;
//import com.olegkorbovskij.cardatabase.domain.CarRepository;
import com.olegkorbovskij.cardatabase.dto.CarDTO;
import com.olegkorbovskij.cardatabase.service.CarService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/api")
public class CarController {
	
	@Autowired
    private CarService carService;

    @PostMapping("/cars")
    public ResponseEntity<Car> addCar(@RequestBody CarDTO carDTO) {
        Car savedCar = carService.addCar(carDTO);
        return ResponseEntity.ok(savedCar);
    }
	
	
	
	
	@Autowired
	private CarRepository repository;
	
	@GetMapping("/cars")
	@Transactional // ← ВАЖНО: добавляем транзакцию!
	public Iterable<Car> getCars() {
	    List<Car> cars = (List<Car>) repository.findAll();
	    
	    // Принудительно загружаем владельцев
	    for (Car car : cars) {
	        if (car.getOwner() != null) {
	            // Загружаем данные владельца
	            car.getOwner().getFirstName();
	            car.getOwner().getLastName();
	        }
	    }
	    
	    return cars;
}}
