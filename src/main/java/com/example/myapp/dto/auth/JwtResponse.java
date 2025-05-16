package com.example.myapp.dto.auth;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Schema(description = "Response containing JWT tokens")
@Builder
public class JwtResponse {
    @Schema(description = "ID пользователя", example = "1")
    private Long id;
    @Schema(description = "Имя пользователя", example = "Иван Иванов")
    private String username;
    @Schema(description = "Токен аутентификации (JWT)", example = "eyJhbGciOiJIUzI1NiIsIn...")
    private String accessToken;

}
