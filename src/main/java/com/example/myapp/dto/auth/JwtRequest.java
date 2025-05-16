package com.example.myapp.dto.auth;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "Login request payload")
public class JwtRequest {

    @Schema(description = "Номер телефона", example = "+79178137388")
    @NotBlank(message = "Телефон не может быть пустым")//400
    private String username;

    @Schema(description = "Пароль", example = "12345578")
    @NotBlank(message = "Пароль не может быть пустым")//400
    private String password;
}
