package com.olegkorbovskij.cardatabase.web;

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

@RestController
@RequestMapping("/api/cars")
public class CarController {
	
	@Autowired
    private CarService carService;

    @PostMapping
    public ResponseEntity<Car> addCar(@RequestBody CarDTO carDTO) {
        Car savedCar = carService.addCar(carDTO);
        return ResponseEntity.ok(savedCar);
    }
	
	
	
	
	@Autowired
	private CarRepository repository;
	
	@GetMapping
	public Iterable<Car> getCars() {
		return repository.findAll();
	}
}
