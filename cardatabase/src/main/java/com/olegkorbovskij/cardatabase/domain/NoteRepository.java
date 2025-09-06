package com.olegkorbovskij.cardatabase.domain;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface NoteRepository extends CrudRepository<Note,Long>{
	
	Optional<Note> findByNameNote(String nameNote);



}
