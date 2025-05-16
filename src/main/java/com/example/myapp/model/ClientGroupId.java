package com.example.myapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ClientGroupId implements Serializable {

    @Column(name = "client_id")
    private Long clientId;

    @Column(name = "group_id")
    private Long groupId;

    public ClientGroupId() {
    }
    // Конструктор с параметрами
    public ClientGroupId(Long clientId, Long groupId) {
        this.clientId = clientId;
        this.groupId = groupId;
    }

    // Геттеры и сеттеры, equals, hashCode
    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    // equals и hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientGroupId that = (ClientGroupId) o;

        if (!clientId.equals(that.clientId)) return false;
        return groupId.equals(that.groupId);
    }



    @Override
    public int hashCode() {
        return Objects.hash(clientId, groupId);
    }

    @Override
    public String toString() {
        return "ClientGroupId{" +
                "clientId='" + clientId + '\'' +
                ", groupId=" + groupId +
                '}';
    }

}

