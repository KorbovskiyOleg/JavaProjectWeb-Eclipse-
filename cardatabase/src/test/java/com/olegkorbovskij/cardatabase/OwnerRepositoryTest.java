package com.olegkorbovskij.cardatabase;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.olegkorbovskij.cardatabase.domain.Owner;
import com.olegkorbovskij.cardatabase.domain.OwnerRepository;

@DataJpaTest
public class OwnerRepositoryTest {
	
	 @Autowired
     private OwnerRepository repository;
	 
	

}
