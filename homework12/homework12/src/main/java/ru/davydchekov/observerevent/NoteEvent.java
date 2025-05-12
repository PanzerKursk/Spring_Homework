package ru.davydchekov.observerevent;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;
import ru.davydchekov.model.Note;

@Getter
public class NoteEvent extends ApplicationEvent {
    private final Note note;

    public NoteEvent(Object source, Note note) {
        super(source);
        this.note= note;
        }

    @Override
    public String toString() {
        return "NoteEvent " +
                "note = " + note;
    }
}
