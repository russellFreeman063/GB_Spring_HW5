package ru.gb.homework_5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.homework_5.domain.Task;
import ru.gb.homework_5.domain.TaskStatus;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByStatus(TaskStatus taskStatus);

}
