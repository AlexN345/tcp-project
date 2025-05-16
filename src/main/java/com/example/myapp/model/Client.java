package com.example.myapp.model;

// сущность клиента
import jakarta.persistence.*;

import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private Long clientId;


    @Column(name = "phone_number", length = 15, unique = true)
    private String phoneNumber;


    @Column(name = "password", length = 100, nullable = false)
    private String password;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY) //!!!!!ВРЕМЕННО!!!!!
    private Set<ClientInGroup> clientGroups;

    /*@OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Task> tasks;*/

    // Конструктор по умолчанию (обязателен для JPA)
    public Client() {}

    public Client(String phoneNumber, String password, String name) {
        this.phoneNumber = phoneNumber;
        this.password = PasswordUtil.hashPassword(password);
        this.name=name;
    }

    // Геттеры и сеттеры
    public String getPhoneNumber() { return phoneNumber;}
    public String getPassword() { return password;}

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public Long getClientId() { return clientId;}

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getName(){return name;}

    public void setName(String name) {this.name=name;}

    public Set<Groupp> getClientGroups() {                                                          //!!!!!ВРЕМЕННО!!!!!
        return clientGroups.stream().map(ClientInGroup::getGroup).collect(Collectors.toSet());
    }


    /*public Set<task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<task> tasks) {
        this.tasks = tasks;
    }*/

    // Установка хешированного пароля
    public void setPassword(String password) {
        this.password = PasswordUtil.hashPassword(password);
    }

    // Проверка пароля
    public boolean checkPassword(String plainPassword) {
        return PasswordUtil.checkPassword(plainPassword, this.password);
    }



    @Override
    public String toString() {
        return "Client{" +
                "clientId='" + clientId + '\'' +
                "phoneNumber='" + phoneNumber + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                '}';
    }


    /*public Set<client_in_group> getClientGroups() {
        return clientGroups;
    }

    public void setClientGroups(Set<client_in_group> clientGroups) {
        this.clientGroups = clientGroups;
    }*/

    /*public void setClientGroups(Set<Groupp> groupps) {
        this.clientGroups = groupps.stream().map(group -> {
            ClientInGroup cig = new ClientInGroup();
            cig.setClient(this);
            cig.setGroup(group);
            return cig;
        }).collect(Collectors.toSet());
    }*/
}