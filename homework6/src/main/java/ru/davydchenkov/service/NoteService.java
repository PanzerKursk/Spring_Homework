package ru.davydchenkov.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.davydchenkov.model.Note;
import ru.davydchenkov.repository.NoteRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteService {
    private final NoteRepository noteRepository;

    public Note addNote(Note note){
        return noteRepository.save(note);
    }

    public Note updateNote(Note note){
        Note updNote = findByIdNote(note.getId());
        updNote.setHeadline(note.getHeadline());
        updNote.setContent(note.getContent());
        updNote.setLocalDateTime(note.getLocalDateTime());
        return noteRepository.save(updNote);
    }

    public void deleteNotes(Long id){
        Note deleteNote = findByIdNote(id);
        noteRepository.delete(deleteNote);
    }

    public List<Note> findByAllNote(){
        return noteRepository.findAll();
    }

    public Note findByHeadlineNote(String headline){
       return noteRepository.findByHeadline(headline);
    }
    public Note findByIdNote(Long id){
        return noteRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Note с данным Id " + id + " не найдена"));
    }

}
