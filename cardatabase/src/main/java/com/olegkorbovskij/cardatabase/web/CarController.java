package com.olegkorbovskij.cardatabase.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.olegkorbovskij.cardatabase.domain.Car;
import com.olegkorbovskij.cardatabase.dto.CarDTO;
import com.olegkorbovskij.cardatabase.dto.CarResponseDTO;
import com.olegkorbovskij.cardatabase.service.CarService;

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

	@GetMapping("/cars")
	public ResponseEntity<List<CarResponseDTO>> getCars(@RequestParam(required = false) Long ownerId) {
		List<CarResponseDTO> cars;

		if (ownerId != null) {
			cars = carService.getCarsByOwnerId(ownerId);
		} else {
			cars = carService.getAllCars();
		}

		return ResponseEntity.ok(cars);
	}
}