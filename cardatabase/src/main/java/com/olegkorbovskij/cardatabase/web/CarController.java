package com.olegkorbovskij.cardatabase.web;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.olegkorbovskij.cardatabase.domain.Car;
import com.olegkorbovskij.cardatabase.domain.CarRepository;
import com.olegkorbovskij.cardatabase.dto.CarDTO;
import com.olegkorbovskij.cardatabase.dto.CarResponseDTO;
import com.olegkorbovskij.cardatabase.service.CarService;

import jakarta.transaction.Transactional;


@RestController
@RequestMapping("/api")
public class CarController {

    @Autowired
    private CarService carService;

    @Autowired
    private CarRepository repository;

    @PostMapping("/cars")
    public ResponseEntity<Car> addCar(@RequestBody CarDTO carDTO) {
        Car savedCar = carService.addCar(carDTO);
        return ResponseEntity.ok(savedCar);
    }

    @GetMapping("/cars")
    @Transactional
    public ResponseEntity<?> getCars(@RequestParam(required = false) Long ownerId) {
        if (ownerId != null) {
            // ВОТ ИСПРАВЛЕНИЕ: Возвращаем автомобили конкретного владельца, преобразованные в DTO
            List<CarResponseDTO> cars = repository.findByOwnerId(ownerId).stream() // <- Теперь работаем с результатом репозитория
                .map(car -> {
                    CarResponseDTO dto = new CarResponseDTO();
                    dto.setId(car.getId());
                    dto.setBrand(car.getBrand());
                    dto.setModel(car.getModel());
                    dto.setColor(car.getColor());
                    dto.setMake(car.getMake());
                    dto.setPrice(car.getPrice());
                    
                    // Важно! Данные владельца загружаются здесь, внутри транзакции
                    if (car.getOwner() != null) {
                        dto.setOwnerId(car.getOwner().getOwnerId());
                        dto.setOwnerFirstName(car.getOwner().getFirstName());
                        dto.setOwnerLastName(car.getOwner().getLastName());
                    }
                    
                    return dto;
                })
                .collect(Collectors.toList());
            return ResponseEntity.ok(cars); // <- Возвращаем List<CarResponseDTO>, а не List<Car>
        }
        // Возвращаем все автомобили с DTO (код остается без изменений)
        List<CarResponseDTO> cars = ((List<Car>) repository.findAll()).stream()
            .map(car -> {
                CarResponseDTO dto = new CarResponseDTO();
                dto.setId(car.getId());
                dto.setBrand(car.getBrand());
                dto.setModel(car.getModel());
                dto.setColor(car.getColor());
                dto.setMake(car.getMake());
                dto.setPrice(car.getPrice());
                
                if (car.getOwner() != null) {
                    dto.setOwnerId(car.getOwner().getOwnerId());
                    dto.setOwnerFirstName(car.getOwner().getFirstName());
                    dto.setOwnerLastName(car.getOwner().getLastName());
                }
                
                return dto;
            })
            .collect(Collectors.toList());
        return ResponseEntity.ok(cars);
    }
}