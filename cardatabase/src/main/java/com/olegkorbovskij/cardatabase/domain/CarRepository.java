package com.olegkorbovskij.cardatabase.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car,Long>{
	// Получить авто по бренду
	List<Car> findByBrand(String brand);
	// Получить авто по бредну и цвету
	List<Car> findByBrandAndModel(String brand,String model);
	
	

}
