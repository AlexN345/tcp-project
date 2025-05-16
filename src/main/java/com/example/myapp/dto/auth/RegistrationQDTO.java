package com.example.myapp.dto.auth;

import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * DTO для запроса регистрации
 */
public record RegistrationQDTO(
        @NotBlank(message = "Телефон обязателен")
        @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Некорректный формат телефона")
        @Schema(description = "Номер телефона", example = "+79161234567")
        String phone,

        @NotBlank(message = "Пароль обязателен")
        @Size(min = 8, max = 100, message = "Пароль должен быть от 8 до 100 символов")
        @Schema(description = "Пароль", example = "mySecurePassword123")
        String password,

        @NotBlank(message = "Подтверждение пароля обязательно")
        @Schema(description = "Подтверждение пароля", example = "mySecurePassword123")
        String confirmPassword,

        @NotBlank(message = "Имя обязательно")
        @Size(max = 50, message = "Имя не должно превышать 50 символов")
        @Schema(description = "Имя пользователя", example = "Иван Иванов")
        String name
) {
    // Дополнительная проверка совпадения паролей
    public RegistrationQDTO() {
        this("", "", "", "");
    }
    public boolean isPasswordMatch() {
        return password != null && password.equals(confirmPassword);
    }
}
