package com.example.myapp.mapper;

import com.example.myapp.dto.ClientShortDto;
import com.example.myapp.model.Client;
import org.mapstruct.*;
@Mapper(componentModel = "spring")
public interface ClientMapper {
    @Mapping(target = "clientId", source = "clientId")
    @Mapping(target = "name", source = "name")
    ClientShortDto toClientShortDto(Client client);

}
