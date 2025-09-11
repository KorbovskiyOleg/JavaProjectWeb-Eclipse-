package com.olegkorbovskij.cardatabase.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.olegkorbovskij.cardatabase.domain.Note;
import com.olegkorbovskij.cardatabase.domain.NoteRepository;

@RestController
@RequestMapping("/api")
public class NoteController {
	
	@Autowired
	private NoteRepository noteRepository;
	
	@GetMapping("/notes")
	public Iterable<Note> getNote(){
		return noteRepository.findAll();
	}
	

	
	
	
	

}
