package ru.davydchekov.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.davydchekov.model.Note;

import java.util.List;
import java.util.Optional;


@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

    Optional<Note> findById(Long id);
    Note findByHeadline(String headline);
    List<Note> findAll();
}
