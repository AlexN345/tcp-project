package com.example.myapp.service;

import com.example.myapp.model.*;
import com.example.myapp.repository.Task_rep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class Task_serv {

    private final Task_rep task_rep;

    @Autowired
    public Task_serv(Task_rep task_rep) {
        this.task_rep = task_rep;
    }


    public List<Task> getAllTasks() {
        return task_rep.findAll();
    }


    public Task getTaskByKey(Long TaskId) {
        return task_rep.findById(TaskId).orElse(null);
    }


    public Task saveTask(Task task) {
        return task_rep.save(task);
    }

    public Task createTask(ClientInGroup clientInGroup, LocalDate date , Responsibility responsibility, Client autor) {
        Task task = new Task(clientInGroup, date , responsibility, autor);
        return task_rep.save(task);
    }


    public Task updateTask(Task task) {
        return task_rep.save(task);
    }


    public void deleteTask(Long Key) {
        task_rep.deleteById(Key);
    }

    public List<Task> getTasksByGroup(Long groupId) {
        return task_rep.findByGroupId(groupId);
    }
    public List<Task> getGroupTasksForPeriod(Long groupId, LocalDate start, LocalDate end) {
        return task_rep.findByGroupIdAndDateRange(groupId, start, end);
    }
    public List<Task> getGroupTasksForDate (Long groupId, LocalDate date) {
        return task_rep.findByGroupIdAndDate(groupId, date);
    }

}




