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
	
	// Метод для обновления владельца (PUT)
    @PutMapping("/owners/{id}")
    public ResponseEntity<?> updateOwner(@PathVariable Long id, @RequestBody Owner ownerDetails) {
        try {
            // 1. Находим существующего владельца по ID
            Optional<Owner> optionalOwner = repository.findById(id);
            
            if (optionalOwner.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Владелец с ID " + id + " не найден");
            }
            
            Owner existingOwner = optionalOwner.get();
            
            // 2. Обновляем только те поля, которые пришли в запросе
            if (ownerDetails.getFirstName() != null) {
                existingOwner.setFirstName(ownerDetails.getFirstName());
            }
            if (ownerDetails.getLastName() != null) {
                existingOwner.setLastName(ownerDetails.getLastName());
            }
            if (ownerDetails.getEmail() != null) {
                existingOwner.setEmail(ownerDetails.getEmail());
            }
            if (ownerDetails.getPhone() != null) {
                existingOwner.setPhone(ownerDetails.getPhone());
            }
            if (ownerDetails.getAddress() != null) {
                existingOwner.setAddress(ownerDetails.getAddress());
            }
            
            // 3. Сохраняем обновленного владельца
            Owner updatedOwner = repository.save(existingOwner);
            
            // 4. Возвращаем обновленного владельца
            return ResponseEntity.ok(updatedOwner);
            
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
