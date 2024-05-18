package ru.gb.homework_5.domain;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;


@Data
@Entity(name = "task")
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    @Column(name = "date_create")
    private LocalDateTime date;

    public String getStatusString() {
        return status.toString();
    }

}
