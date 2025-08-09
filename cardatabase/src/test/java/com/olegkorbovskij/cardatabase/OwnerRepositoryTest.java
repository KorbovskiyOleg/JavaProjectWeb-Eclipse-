package com.olegkorbovskij.cardatabase;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.olegkorbovskij.cardatabase.domain.Owner;
import com.olegkorbovskij.cardatabase.domain.OwnerRepository;

@DataJpaTest
public class OwnerRepositoryTest {
	
	 @Autowired
     private OwnerRepository orepository;
	 
	 @Test
	 @DisplayName("Two example test case")
	 void saveOwner() {
	  orepository.save(new Owner("Lucy", "Smith", 422313131L, "sdsc@dwdww"));
	  assertThat(orepository.findByFirstName
	      ("Lucy").isPresent())
	    .isTrue();
	 }
	 
	 @Test
	 @DisplayName("Three example test case")
	 void deleteOwners() {
	  orepository.save(new Owner("Lisa", "Morrison", 234312112L, "add@dwdqqq"));
	  orepository.deleteAll();
	  assertThat(orepository.count()).isEqualTo(0);
	 }

}
