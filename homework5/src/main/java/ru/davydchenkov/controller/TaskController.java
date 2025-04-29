package ru.davydchenkov.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.davydchenkov.model.Task;
import ru.davydchenkov.model.TaskStatus;
import ru.davydchenkov.service.TaskService;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    public Task addTask(@RequestBody Task task){
        task.setLocalDateTime(LocalDateTime.now());
        return taskService.addTask(task);
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTask();
    }


    @GetMapping("/status/{status}")
    public List<Task> findByStatus(@PathVariable TaskStatus status){
        return taskService.getTaskByStatus(status);
    }


    @PutMapping("/{id}")
    public void updateTaskStatus(@PathVariable Long id, @RequestBody Task task){
       taskService.updateTaskStatus(id,task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){
        taskService.deleteTaskById(id);
    }
}
