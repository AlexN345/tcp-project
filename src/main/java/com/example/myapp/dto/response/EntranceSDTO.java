package com.example.myapp.dto.response;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;

/**
 * DTO для ответа после входа пользователя
 */

public record EntranceSDTO(
        @Schema(description = "ID пользователя", example = "1")
        Long userId,

        @Schema(description = "Имя пользователя", example = "Иван Иванов")
        String userName,

        @Schema(description = "Список групп пользователя")
        List<GroupInfo> groups,

        @Schema(description = "Токен аутентификации (JWT)", example = "eyJhbGciOiJIUzI1NiIsIn...")
        String authToken
) {
    /**
     * DTO для информации о группе
     */
    public record GroupInfo(
            @Schema(description = "ID группы", example = "10")
            Long groupId,

            @Schema(description = "Название группы", example = "Семья")
            String groupName,

            @Schema(description = "Количество участников", example = "3")
            int memberCount
    ) {}
}