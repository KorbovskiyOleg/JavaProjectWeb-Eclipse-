package com.olegkorbovskij.cardatabase.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olegkorbovskij.cardatabase.domain.Car;
import com.olegkorbovskij.cardatabase.domain.CarRepository;
import com.olegkorbovskij.cardatabase.domain.Owner;
import com.olegkorbovskij.cardatabase.domain.OwnerRepository;
import com.olegkorbovskij.cardatabase.dto.CarDTO;

@Service
public class CarService {
	
	@Autowired
    private CarRepository carRepository;
    
    @Autowired
    private OwnerRepository ownerRepository;

    public Car addCar(CarDTO carDTO) {
        // Проверяем, есть ли уже владелец с таким именем и фамилией
        Optional<Owner> ownerOptional = ownerRepository.findByFirstNameAndLastName(
            carDTO.getFirstName(), 
            carDTO.getLastName()
        );

        Owner owner;
        
        // Если нет — создаём нового
        if (ownerOptional.isEmpty()) {
            owner = new Owner();
            owner.setFirstName(carDTO.getFirstName());
            owner.setLastName(carDTO.getLastName());
            owner = ownerRepository.save(owner);
        } else {
            owner = ownerOptional.get();
        }

        // Создаём авто и привязываем владельца
        Car car = new Car();
        car.setBrand(carDTO.getBrand());
        car.setModel(carDTO.getModel());
        car.setColor(carDTO.getColor());
        car.setMake(carDTO.getMake());
        car.setPrice(carDTO.getPrice());
        car.setOwner(owner);

        return carRepository.save(car);
    }
	
	
	

}
