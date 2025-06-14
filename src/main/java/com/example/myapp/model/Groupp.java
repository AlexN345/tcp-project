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
    private Long groupId;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL, fetch = FetchType.LAZY)    //!!!!!ВРЕМЕННО!!!!!
    private Set<ClientInGroup> groupClients;

    /*@OneToMany(mappedBy = "group", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Task> tasks;*/

    public Groupp() {}

    public Groupp(String name) {
        this.name=name;
    }

    // Геттеры и сеттеры
    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Client> getClients() {                                                           //!!!!!ВРЕМЕННО!!!!!
        return groupClients.stream().map(ClientInGroup::getClient).collect(Collectors.toSet());
    }

    /*public Set<task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<task> tasks) {
        this.tasks = tasks;
    }*/

    /*@Override
    public String toString() {
        return "Groupp{" +
                "groupId=" + groupId +
                ", name='" + name + '\'' +
                '}';
    }*/


    /*public Set<client_in_group> getClientGroups() {
        return groupClients;
    }*/

    /*public void setClientGroups(Set<client_in_group> clientGroups) {
        this.groupClients = clientGroups;
    }*/



    /*public void setClients(Set<Client> clients) {
        this.groupClients = clients.stream().map(client -> {
            ClientInGroup cig = new ClientInGroup();
            cig.setClient(client);
            cig.setGroup(this);
            return cig;
        }).collect(Collectors.toSet());
    }*/

}