package com.olegkorbovskij.cardatabase.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.olegkorbovskij.cardatabase.domain.Owner;
import com.olegkorbovskij.cardatabase.domain.OwnerRepository;

@RestController
@RequestMapping("/api")
public class OwnerController {
	
	@Autowired
	private OwnerRepository repository;
	
	@GetMapping("/owners")
	public Iterable<Owner> getOwner() {
		return repository.findAll();
	}

}
