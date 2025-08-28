package com.olegkorbovskij.cardatabase.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.olegkorbovskij.cardatabase.domain.Owner;
import com.olegkorbovskij.cardatabase.domain.OwnerRepository;
import com.olegkorbovskij.cardatabase.service.OwnerService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/api")
public class OwnerController {
	
	@Autowired
	private OwnerRepository repository;
	
	@Autowired
	private OwnerService ownerService;
	
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
	
	// Метод для обновления владельца (PUT)
	@PutMapping("/owners/{id}")
    public ResponseEntity<?> updateOwner(@PathVariable Long id, @RequestBody Owner ownerDetails) {
        try {
            Owner updatedOwner = ownerService.updateOwner(id, ownerDetails);
            return ResponseEntity.ok(updatedOwner);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Ошибка при обновлении владельца: " + e.getMessage());
        }
    }
	
	
	@DeleteMapping("/owners/{id}")
	public ResponseEntity<String> deleteOwner(@PathVariable Long id) {
	    try {
	        repository.deleteById(id);
	        return ResponseEntity.ok("Owner deleted successfully");
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Owner not found");
	    }
	}

}
