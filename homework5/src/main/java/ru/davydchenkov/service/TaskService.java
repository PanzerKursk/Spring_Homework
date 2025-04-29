package ru.davydchenkov.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.davydchenkov.model.Task;
import ru.davydchenkov.model.TaskStatus;
import ru.davydchenkov.repository.TaskRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;


    public Task addTask(Task task){
        return taskRepository.save(task);
    }

    public void updateTaskStatus(Long id, Task task) {
        Task task1 = taskRepository.findTaskById(id)
                .orElseThrow(() -> new IllegalArgumentException("Задача с ID " + id + " не найдена"));

        if (task.getStatus() != null) {
            task1.setStatus(task.getStatus());
        }
        taskRepository.save(task1);
    }

    public void deleteTaskById(Long id) {
        taskRepository.deleteById(id);
    }

    public List<Task> getAllTask(){
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskByID(Long id){
        return taskRepository.findTaskById(id);
    }

    public List<Task> getTaskByName(String name){
        return taskRepository.findTaskByName(name);
    }

    public List<Task> getTaskByStatus(TaskStatus status){
        return taskRepository.findTaskByStatus(status);
    }

    public List<Task> getTaskByLocalDateTime(LocalDateTime localDateTime){
        return taskRepository.findTaskByLocalDateTime(localDateTime);
    }

}
