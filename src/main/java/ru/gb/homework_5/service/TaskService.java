package ru.gb.homework_5.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.homework_5.domain.Task;
import ru.gb.homework_5.domain.TaskStatus;
import ru.gb.homework_5.repository.TaskRepository;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static ru.gb.homework_5.domain.TaskStatus.*;

@Data
@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    public List<Task> getAllTask() {
        return new ArrayList<>(taskRepository.findAll());
    }

    public void saveTask(Task task) {
        taskRepository.save(task);
    }

    /** Создание новой задачи
     */
    public Task addTask(String description) {
        Task task = new Task();
        task.setDescription(description);
        task.setStatus(NOT_STARTED);
        task.setDate(LocalDateTime.now());
        return task;
    }

    /** Удаление задачи
     */
    public void delTask(Long id) {
        if (taskRepository.existsById(id))
            taskRepository.deleteById(id);
    }

    /** Получение списка задач по статусу
     */
    public List<Task> getTaskByStatus(TaskStatus taskStatus) {
        return taskRepository.findByStatus(taskStatus);
    }

    /** Обновляет ствтус
     */
    public void updateStatus(Long id) {
        if (taskRepository.existsById(id)) {
            Task task = taskRepository.findById(id).orElse(null);
            if (task != null) {
                switch (task.getStatus()) {
                    case NOT_STARTED -> {
                        task.setStatus(IN_PROGRESS);
                    }
                    case IN_PROGRESS -> {
                        task.setStatus(COMPLETED);
                    }
                    default -> {
                        return;
                    }
                }
            }
            assert task != null;
            taskRepository.save(task);
        }
    }

}
