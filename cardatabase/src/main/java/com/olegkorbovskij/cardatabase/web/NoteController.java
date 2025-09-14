package com.olegkorbovskij.cardatabase.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.olegkorbovskij.cardatabase.domain.Note;
import com.olegkorbovskij.cardatabase.domain.NoteRepository;

import java.util.List;
//import java.util.Optional;

@RestController
@RequestMapping("/api/notes")
@CrossOrigin(origins = "http://localhost:3000") // Для фронтенда
public class NoteController {
    
    @Autowired
    private NoteRepository noteRepository;
    
    // GET все заметки
    @GetMapping
    public List<Note> getAllNotes() {
        return (List<Note>) noteRepository.findAll();
    }
    
    // GET заметка по ID
    @GetMapping("/{id}")
    public Note getNoteById(@PathVariable Long id) {
        return noteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Заметка не найдена"));
    }
    
    // GET поиск по имени
    @GetMapping("/search")
    public Note getNoteByName(@RequestParam String name) {
        return noteRepository.findByNameNote(name)
                .orElseThrow(() -> new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Заметка с именем '" + name + "' не найдена"));
    }
    
    // POST создание новой заметки
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Note createNote(@RequestBody Note note) {
        // Валидация
        if (note.getNameNote() == null || note.getNameNote().trim().isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "Название заметки обязательно");
        }
        
        if (note.getContentNote() == null) {
            note.setContentNote(""); // Устанавливаем пустое содержание если null
        }
        
        return noteRepository.save(note);
    }
    
    // PUT полное обновление заметки
    @PutMapping("/{id}")
    public Note updateNote(@PathVariable Long id, @RequestBody Note noteDetails) {
        Note existingNote = noteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Заметка не найдена"));
        
        // Обновляем поля
        existingNote.setNameNote(noteDetails.getNameNote());
        existingNote.setContentNote(noteDetails.getContentNote());
        
        return noteRepository.save(existingNote);
    }
    
    // PATCH частичное обновление
    @PatchMapping("/{id}")
    public Note partialUpdateNote(@PathVariable Long id, @RequestBody Note noteDetails) {
        Note existingNote = noteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Заметка не найдена"));
        
        // Обновляем только переданные поля
        if (noteDetails.getNameNote() != null) {
            existingNote.setNameNote(noteDetails.getNameNote());
        }
        
        if (noteDetails.getContentNote() != null) {
            existingNote.setContentNote(noteDetails.getContentNote());
        }
        
        return noteRepository.save(existingNote);
    }
    
    // DELETE удаление заметки
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteNote(@PathVariable Long id) {
        if (!noteRepository.existsById(id)) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Заметка не найдена");
        }
        
        noteRepository.deleteById(id);
    }
    
    // Дополнительный endpoint для проверки существования
    @GetMapping("/{id}/exists")
    public boolean noteExists(@PathVariable Long id) {
        return noteRepository.existsById(id);
    }
}

