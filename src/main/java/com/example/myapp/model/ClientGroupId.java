package com.example.myapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ClientGroupId implements Serializable {

    @Column(name = "client_id")
    private Long client_id;

    @Column(name = "group_id")
    private Long group_id;

    // Конструктор по умолчанию (обязателен для JPA)
    public ClientGroupId() {}

    // Конструктор с параметрами
    public ClientGroupId(Long client_id, Long group_id) {
        this.client_id = client_id;
        this.group_id = group_id;
    }

    // Геттеры и сеттеры, equals, hashCode
    public Long getClientId() {
        return client_id;
    }

    public void setClientId(Long client_id) {
        this.client_id = client_id;
    }

    public Long getGroupId() {
        return group_id;
    }

    public void setGroupId(Long group_id) {
        this.group_id = group_id;
    }

    // equals и hashCode
    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientGroupId that = (ClientGroupId) o;

        if (!client_id.equals(that.client_id)) return false;
        return group_id.equals(that.group_id);
    }

    @Override
    public int hashCode() {
        int result = client_id.hashCode();
        result = 31 * result + group_id.hashCode();
        return result;
    }*/
}

