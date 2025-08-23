package com.olegkorbovskij.cardatabase.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.olegkorbovskij.cardatabase.domain.Owner;
import com.olegkorbovskij.cardatabase.domain.OwnerRepository;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/api")
public class OwnerController {
	
	@Autowired
	private OwnerRepository repository;
	
	@GetMapping("/owners")
	public Iterable<Owner> getOwner() {
		return repository.findAll();
	}
	
	@GetMapping("/owners/{id}") // ← Добавьте этот метод
	@Transactional 
    public ResponseEntity<Owner> getOwnerById(@PathVariable Long id) {
        Optional<Owner> owner = repository.findById(id);
        return owner.map(ResponseEntity::ok)
                   .orElse(ResponseEntity.notFound().build());
    }

}
