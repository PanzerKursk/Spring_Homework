package ru.davydchenkov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.davydchenkov.model.Task;
import ru.davydchenkov.model.TaskStatus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository <Task, Long> {
    List<Task> findTaskByName (String name);
    Optional<Task> findTaskById(Long id);
    List<Task> findTaskByStatus(TaskStatus status);
    List<Task> findTaskByLocalDateTime(LocalDateTime localDateTime);


}
