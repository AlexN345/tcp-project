package com.example.myapp.model;


// сущность задания
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "task")
public class Task {
    //должен быть просто id задания, класс Taskid удаляем
    //должен быть исполнитель, по умолчанию =автору
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private Long taskId;
    /*@EmbeddedId
    private TaskId key = new TaskId();*/

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "group_id", referencedColumnName = "group_id"),
            @JoinColumn(name = "client_id", referencedColumnName = "client_id")
    })
    private ClientInGroup clientInGroup;

    @ManyToOne
    @JoinColumn(name = "responsibility_id")
    private Responsibility responsibility;

    @Column(name = "date")
    private LocalDate date;


    @ManyToOne
    @JoinColumn(name = "author", nullable = false)
    private Client author;

    @ManyToOne
    @JoinColumn(name = "executor", nullable = false)
    private Client executor;

    // Конструктор по умолчанию (обязателен для JPA)
    public Task() {}

    // Конструктор с параметрами
    public Task(ClientInGroup clientInGroup, LocalDate date, Responsibility responsibility, Client author) {
        this.clientInGroup = clientInGroup;
        this.date =date;
        this.responsibility = responsibility;
        this.author = author;
        this.executor = author;
    }

    // Конструктор с параметрами
    public Task(ClientInGroup clientInGroup, LocalDate date, Responsibility responsibility, Client author, Client executor) {
        this.clientInGroup = clientInGroup;
        this.date =date;
        this.responsibility = responsibility;
        this.author = author;
        this.executor = executor;
    }
    // Геттеры и сеттеры
    public Long getTaskId() {
        return taskId;
    }

    public Client getClient() {
        return clientInGroup.getClient();
    }


    public Groupp getGroup() {
        return clientInGroup.getGroup();
    }
    public ClientInGroup getClientInGroup() {
        return clientInGroup;
    }
    public void setClientInGroup(ClientInGroup clientInGroup) {
        this.clientInGroup=clientInGroup;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date =date;
    }

    public Responsibility getResponsibility() {
        return responsibility;
    }

    public void setResponsibility(Responsibility responsibility) {
        this.responsibility = responsibility;
    }

    public Client getAuthor() {
        return author;
    }

    public void setAuthor(Client author) {
        this.author = author;
    }

    public Client getExecutor() {
        return executor;
    }

    public void setExecutor(Client executor) {
        this.executor = executor;
    }
    @Override
    public String toString() {
        return "Task{" +
                "Key='" + taskId + '\'' +
                ", client='" + clientInGroup.getClient() + '\'' +
                ", groupp='" + clientInGroup.getGroup() + '\'' +
                ", date='" + date + '\'' +
                ", responsibility='" + responsibility + '\'' +
                ", author='" + author + '\'' +
                '}';
    }


}

