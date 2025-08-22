package com.olegkorbovskij.cardatabase.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.olegkorbovskij.cardatabase.domain.Owner;
import com.olegkorbovskij.cardatabase.domain.OwnerRepository;

@RestController
public class OwnerController {
	
	@Autowired
	private OwnerRepository repository;
	
	@RequestMapping("api/owners")
	public Iterable<Owner> getOwner() {
		return repository.findAll();
	}

}
