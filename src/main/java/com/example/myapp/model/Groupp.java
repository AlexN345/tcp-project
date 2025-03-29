package com.example.myapp.model;

// Сущность группы

import jakarta.persistence.*;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "groupp")
public class Groupp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id")
    private Long group_id;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    /*@OneToMany(mappedBy = "group_id", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<client_in_group> groupClients;

    @OneToMany(mappedBy = "group_id", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<task> tasks;*/

    // Геттеры и сеттеры
    public Long getGroupId() {
        return group_id;
    }

    public void setGroupId(Long group_id) {
        this.group_id = group_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*public Set<client_in_group> getClientGroups() {
        return groupClients;
    }*/

    /*public void setClientGroups(Set<client_in_group> clientGroups) {
        this.groupClients = clientGroups;
    }*/

    /*public Set<Client> getClients() {
        return groupClients.stream().map(client_in_group::getClient).collect(Collectors.toSet());
    }

    public void setClients(Set<Client> clients) {
        this.groupClients = clients.stream().map(client -> {
            client_in_group cig = new client_in_group();
            cig.setClient(client);
            cig.setGroup(this);
            return cig;
        }).collect(Collectors.toSet());
    }

    public Set<task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<task> tasks) {
        this.tasks = tasks;
    }*/
}