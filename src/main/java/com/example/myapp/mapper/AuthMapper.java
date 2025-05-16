package com.example.myapp.mapper;

import com.example.myapp.dto.request.*;
import com.example.myapp.dto.response.*;
import com.example.myapp.model.*;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthMapper {

    // Маппинг из RegistrationQDTO в Client (сущность)
    @Mapping(target = "phoneNumber", source = "phone")
    @Mapping(target = "password", ignore = true) // Пароль будем обрабатывать отдельно
    Client toClient(RegistrationQDTO dto);

    // Маппинг из Client в EntranceSDTO
    @Mapping(target = "userId", source = "clientId")
    @Mapping(target = "userName", source = "name")
    @Mapping(target = "authToken", ignore = true) // Токен генерируется отдельно
    EntranceSDTO toEntranceSDTO(Client client);

    default EntranceSDTO toEntranceSDTOWithGroups(Client client) {
        EntranceSDTO dto = toEntranceSDTO(client);
        if (client.getClientGroups() != null) {
            List<EntranceSDTO.GroupInfo> groupInfos = client.getClientGroups().stream()
                    .map(this::toGroupInfo)
                    .toList();
            return new EntranceSDTO(
                    dto.userId(),
                    dto.userName(),
                    groupInfos,
                    dto.authToken()
            );
        }
        return dto;
    }

    // Маппинг для GroupInfo
    @Mapping(target = "groupName", source = "name")
    @Mapping(target = "memberCount", expression = "java(group.getClients().size())")
    EntranceSDTO.GroupInfo toGroupInfo(Groupp group);
}
