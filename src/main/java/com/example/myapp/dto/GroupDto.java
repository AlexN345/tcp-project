package com.example.myapp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GroupDto {
    private Long id;
    private String name;
    private int memberCount;

    public GroupDto(Long id, String name, int memberCount) {
        this.id = id;
        this.name = name;
        this.memberCount = memberCount;
    }
}
