package ru.davydchekov.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.GenericTransformer;
import org.springframework.integration.file.FileWritingMessageHandler;
import org.springframework.integration.file.support.FileExistsMode;
import org.springframework.messaging.MessageChannel;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Configuration
public class TextMessageConfigurator {


    @Bean
    public MessageChannel textRecipient() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel fileWriter() {
        return new DirectChannel();
    }


    @Bean
    @Transformer(inputChannel = "textRecipient", outputChannel = "fileWriter")
    public GenericTransformer<String, String> mainTransformer() {
        return text -> {
            String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            return "[" + time + "] " + text.toLowerCase().trim();
        };
    }


    @Bean
    @ServiceActivator(inputChannel = "fileWriter")
    public FileWritingMessageHandler messageHandler() {
        FileWritingMessageHandler handler =
                new FileWritingMessageHandler(new File(
                        "./RequestMessage"));
        handler.setExpectReply(false);
        handler.setFileExistsMode(FileExistsMode.APPEND);
        handler.setAppendNewLine(true);

        return handler;
    }
}
