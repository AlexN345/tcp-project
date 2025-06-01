package com.example.myapp.dto.request;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

/**
 * DTO для запроса входа пользователя
 */
public record  EntranceQDTO (
        @NotBlank(message = "Телефон не может быть пустым")
        @Schema(description = "Номер телефона", example = "+79161234567")
        String phone,

        @NotBlank(message = "Пароль не может быть пустым")
        @Schema(description = "Пароль", example = "mySecurePassword123")
        String password
){
        public EntranceQDTO() {
                this("", "");
        }
}

