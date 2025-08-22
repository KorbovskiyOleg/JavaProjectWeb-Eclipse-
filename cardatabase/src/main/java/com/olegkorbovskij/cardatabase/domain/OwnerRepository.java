package com.olegkorbovskij.cardatabase.domain;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
	
	 Optional<Owner> findByFirstName(String firstName);

	 Optional<Owner> findByFirstNameAndLastName(String firstName, String lastName);;

}

