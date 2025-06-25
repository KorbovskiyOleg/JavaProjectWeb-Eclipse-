package com.olegkorbovskij.cardatabase.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface CarRepository extends CrudRepository<Car, Long> {
	// Получить авто по бренду
	List<Car> findByBrand(@Param("brand")String brand);

	// Получить авто по бредну и цвету
	List<Car> findByBrandAndModel(@Param("brand")String brand, @Param("model") String model);
	
	List<Car> findByColor(@Param("color") String color);

}
