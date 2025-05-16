
package com.example.myapp.model;


// сущность клиента в группе
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "client_in_group")
public class ClientInGroup {

    @EmbeddedId
    private ClientGroupId key= new ClientGroupId();

    @ManyToOne                       //!!!!!ВРЕМЕННО!!!!!
    @MapsId("clientId")
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @MapsId("groupId")
    @JoinColumn(name = "group_id")
    private Groupp group;

    @OneToMany(mappedBy = "clientInGroup", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Task> tasks;
    public ClientInGroup () {}
    public ClientInGroup (Client client, Groupp group) {
        this.group = group;
        this.client =client;
    }

    // Геттеры и сеттеры
    public ClientGroupId getKey() {
        return key;
    }

    public void setKey(ClientGroupId key) {
        this.key = key;
    }

    public Client getClient() {                //!!!!!ВРЕМЕННО!!!!!
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Groupp getGroup() {
        return group;
    }

    public void setGroup(Groupp group) {
        this.group = group;
    }

    public Set<Task> getTasks(){
        return tasks;
    }
    @Override
    public String toString() {
        return "ClientInGroup{" +
                "key=" + (key != null ? key : "null") +
                ", client=" + (client != null ? client.getPhoneNumber() : "null") +
                ", group=" + (group != null ? group.getGroupId() : "null") +
                '}';
    }
}


