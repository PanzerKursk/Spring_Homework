package ru.davydchekov.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
@Entity
@Table(name = "Notes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Headline")
    @Nonnull
    private String headline;

    @Column(name = "Content")
    @Nonnull
    private String content;

    @Column(name = "Date")
    @CreationTimestamp
    private LocalDateTime localDateTime;
}
