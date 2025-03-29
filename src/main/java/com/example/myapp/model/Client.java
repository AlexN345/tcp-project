package com.example.myapp.model;

// сущность клиента
import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "client")
public class Client {



    @Id
    @Column(name = "phone_number", length = 15)
    private String phone_number;


    @Column(name = "password", length = 50, nullable = false)
    private String password;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY) //!!!!!ВРЕМЕННО!!!!!
    private Set<ClientInGroup> clientGroups;

    /*@OneToMany(mappedBy = "client_id", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<task> tasks;*/

    // Конструктор по умолчанию (обязателен для JPA)
    public Client() {}


    // Геттеры и сеттеры
    public String getClientNumber() { return phone_number;}

    public void setClientNumber(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getPassword() {
        return password;
    }

    /*public Set<client_in_group> getClientGroups() {
        return clientGroups;
    }

    public void setClientGroups(Set<client_in_group> clientGroups) {
        this.clientGroups = clientGroups;
    }*/

    public Set<Groupp> getGroups() {                                                          //!!!!!ВРЕМЕННО!!!!!
        return clientGroups.stream().map(ClientInGroup::getGroup).collect(Collectors.toSet());
    }

    public void setGroups(Set<Groupp> groupps) {
        this.clientGroups = groupps.stream().map(group -> {
            ClientInGroup cig = new ClientInGroup();
            cig.setClient(this);
            cig.setGroup(group);
            return cig;
        }).collect(Collectors.toSet());
    }

    /*public Set<task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<task> tasks) {
        this.tasks = tasks;
    }

    // Установка хешированного пароля
    public void setPassword(String password) {
        this.password = PasswordUtil.hashPassword(password);
    }

    // Проверка пароля
    public boolean checkPassword(String plainPassword) {
        return PasswordUtil.checkPassword(plainPassword, this.password);
    }*/
    public void setPassword(String password) {
        this.password = password;
    }


    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(phone_number, client.phone_number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phone_number);
    }*/



}