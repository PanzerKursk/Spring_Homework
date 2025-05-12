package ru.davydchekov.observerevent;

import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class NoteListener implements ApplicationListener <NoteEvent> {

    @Override
    public void onApplicationEvent(NoteEvent event) {
        System.out.println("Сообщение о новом событии: " + event);
    }
}
