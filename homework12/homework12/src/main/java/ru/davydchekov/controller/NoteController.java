package ru.davydchekov.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.davydchekov.model.Note;
import ru.davydchekov.service.MessageService;
import ru.davydchekov.service.NoteService;


import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/notes")
@RequiredArgsConstructor
public class NoteController {

    private final NoteService noteService;
    private final MessageService messageService;

    @PostMapping
    public Note addedNewNote(@RequestBody Note note){
        messageService.writeToFile("Новая заметка.txt", "Создана заметка: " + note.toString());
        note.setLocalDateTime(LocalDateTime.now());
        return noteService.addNote(note);
    }

    @GetMapping
    public List<Note> getAllNotes(){
        messageService.writeToFile("Все заметки.txt", "Список " + noteService.findByAllNote().toString());
        return noteService.findByAllNote();
    }

    @GetMapping("/{id}")
    public Note getNoteById(@PathVariable("id") Long id){
        messageService.writeToFile("Найденные Заметки.txt", "Заметки " + getNoteById(id).getId());
        return noteService.findByIdNote(id);
    }


    @PutMapping("/{id}")
    public Note getNoteForUpdate(Note note){
        messageService.writeToFile("Обновленная заметка.txt", "Обновлена заметка " + note.getHeadline() + note.toString());
        return noteService.updateNote(note);
    }

    @DeleteMapping("/{id}")
    public void deleteNote(@PathVariable("id") Long id){
        Note deletedNote = noteService.findByIdNote(id);
        messageService.writeToFile("Удаленная заметка.txt", "Удалена заметка " + deletedNote.toString());
        noteService.deleteNotes(id);
    }
}
