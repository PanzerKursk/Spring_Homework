package ru.davydchekov.service;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final MessageChannel textRecipient;
    public void writeToFile(String filename, String data) {
        textRecipient.send(org.springframework.messaging.support.MessageBuilder
                .withPayload(data)
                .setHeader("file_name", filename)
                .build());
    }
}

