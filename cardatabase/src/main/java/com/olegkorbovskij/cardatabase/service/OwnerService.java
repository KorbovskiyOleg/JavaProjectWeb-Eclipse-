package com.olegkorbovskij.cardatabase.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olegkorbovskij.cardatabase.domain.Owner;
import com.olegkorbovskij.cardatabase.domain.OwnerRepository;

import jakarta.transaction.Transactional;

@Service
public class OwnerService {
	
	 @Autowired
	    private OwnerRepository ownerRepository;
	 
	 

	    public Iterable<Owner> getAllOwners() {
	        return ownerRepository.findAll();
	    }

	    public Optional<Owner> getOwnerById(Long id) {
	        return ownerRepository.findById(id);
	    }

	    @Transactional
	    public Owner updateOwner(Long id, Owner ownerDetails) {
	        Owner existingOwner = ownerRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Владелец с ID " + id + " не найден"));

	        // Обновляем только не-null поля
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

	        return ownerRepository.save(existingOwner);
	    }

	    @Transactional
	    public void deleteOwner(Long id) {
	        if (!ownerRepository.existsById(id)) {
	            throw new RuntimeException("Владелец с ID " + id + " не найден");
	        }
	        ownerRepository.deleteById(id);
	    }

	    // Дополнительные методы для бизнес-логики
	    public boolean existsById(Long id) {
	        return ownerRepository.existsById(id);
	    }

}
