package com.example.myapp.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TaskDto {
    private Long taskId;
    private Long authorId;
    private String executorName;
    private String responsibilityName;
    private String date;
    // Конструкторы
    public TaskDto() {
    }

    public TaskDto(Long taskId, Long authorId, String executorName, String responsibilityName, String date) {
        this.taskId = taskId;
        this.authorId = authorId;
        this.executorName = executorName;
        this.responsibilityName = responsibilityName;
        this.date = date;
    }
    @Override
    public String toString() {
        return "Task{" +
                "Key='" + taskId + '\'' +
                ", authorId='" + authorId + '\'' +
                ", executorName='" + executorName + '\'' +
                ", responsibilityName='" + responsibilityName + '\'' +
                '}';
    }
}
