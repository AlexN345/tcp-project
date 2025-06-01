package com.example.myapp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientShortDto {
    private Long clientId;
    private String name;

    // Конструкторы
    public ClientShortDto() {
    }

    public ClientShortDto(Long clientId, String name) {
        this.clientId = clientId;
        this.name = name;
    }
}
