package ru.davydchenkov.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
@Entity
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Name")
    @Nonnull
    private String name;

    @Column(name = "Status")
    @Nonnull
    private TaskStatus status;

    @Column(name = "Date")
    private LocalDateTime localDateTime;
}
