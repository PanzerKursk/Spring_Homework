package ru.davydchenkov.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.davydchenkov.model.Note;
import ru.davydchenkov.service.NoteService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/notes")
@RequiredArgsConstructor
public class NoteController {

    private final NoteService noteService;

    @PostMapping
    public void addedNewNote(@RequestBody Note note){
        note.setLocalDateTime(LocalDateTime.now());
        noteService.addNote(note);
    }

    @GetMapping
    public List<Note> getAllNotes(){
        return noteService.findByAllNote();
    }

    @GetMapping("/{id}")
    public Note getNoteById(@PathVariable("id") Long id){
        return noteService.findByIdNote(id);
    }


    @PutMapping("/{id}")
    public Note getNoteForUpdate(Note note){
        return noteService.updateNote(note);
    }

    @DeleteMapping("/{id}")
    public void deleteNote(Long id){
        noteService.deleteNotes(id);
    }


}
