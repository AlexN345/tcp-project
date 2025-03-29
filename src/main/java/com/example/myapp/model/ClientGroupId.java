package com.example.myapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ClientGroupId implements Serializable {

    @Column(name = "phone_number")
    private String phone_number;

    @Column(name = "group_id")
    private Long group_id;

    // Конструктор по умолчанию (обязателен для JPA)
    public ClientGroupId() {}

    // Конструктор с параметрами
    public ClientGroupId(String phone_number, Long group_id) {
        this.phone_number = phone_number;
        this.group_id = group_id;
    }

    // Геттеры и сеттеры, equals, hashCode
    public String getClientNumber() {
        return phone_number;
    }

    public void setClientNumber(String phone_number) {
        this.phone_number = phone_number;
    }

    public Long getGroupId() {
        return group_id;
    }

    public void setGroupId(Long group_id) {
        this.group_id = group_id;
    }

    // equals и hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientGroupId that = (ClientGroupId) o;

        if (!phone_number.equals(that.phone_number)) return false;
        return group_id.equals(that.group_id);
    }



    @Override
    public int hashCode() {
        return Objects.hash(phone_number, group_id);
    }

}

