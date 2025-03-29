
package com.example.myapp.model;


// сущность клиента в группе
import jakarta.persistence.*;

@Entity
@Table(name = "client_in_group")
public class ClientInGroup {

    @EmbeddedId
    private ClientGroupId Key;

    @ManyToOne                       //!!!!!ВРЕМЕННО!!!!!
    @MapsId("phone_number")
    @JoinColumn(name = "phone_number")
    private Client client;

    @ManyToOne
    @MapsId("group_id")
    @JoinColumn(name = "group_id")
    private Groupp groupp;

    // Геттеры и сеттеры
    public ClientGroupId getKey() {
        return Key;
    }

    public void setKey(ClientGroupId Key) {
        this.Key = Key;
    }

    public Client getClient() {                //!!!!!ВРЕМЕННО!!!!!
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Groupp getGroup() {
        return groupp;
    }

    public void setGroup(Groupp groupp) {
        this.groupp = groupp;
    }
}


