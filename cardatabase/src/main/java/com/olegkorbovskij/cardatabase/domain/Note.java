package com.olegkorbovskij.cardatabase.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Note {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long noteId;
	private String nameNote;
	private String contentNote;
	
	public Note(String nameNote, String contentNote) {
		super();
		this.nameNote = nameNote;
		this.contentNote = contentNote;
	}
	
	public Note() {}

	public Long getNoteId() {
		return noteId;
	}

	public void setNoteId(Long noteId) {
		this.noteId = noteId;
	}

	public String getNameNote() {
		return nameNote;
	}

	public void setNameNote(String nameNote) {
		this.nameNote = nameNote;
	}

	public String getContentNote() {
		return contentNote;
	}

	public void setContentNote(String contentNote) {
		this.contentNote = contentNote;
	}
	
	
	
	
	
	
	

}
