package ru.gb.homework_5.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.gb.homework_5.domain.Task;
import ru.gb.homework_5.domain.TaskStatus;
import ru.gb.homework_5.service.TaskService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/tasks")
public class TaskController {

    private TaskService taskService;

    @GetMapping()
    public List<Task> getAllTasks() {
        return taskService.getAllTask();
    }

    @PostMapping()
    public Task addTask(@RequestBody Task task) {
        return taskService.addTask(task.getDescription());
    }

    @GetMapping("/status/{status}")
    public List<Task> getTaskByStatus(@PathVariable TaskStatus status) {
        return taskService.getTaskByStatus(status);
    }

    @PutMapping("/{id}")
    public Task updateTaskStatus(@PathVariable Long id, @RequestBody Task task) {
        taskService.updateStatus(id);
        return task;
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.delTask(id);
    }

}
