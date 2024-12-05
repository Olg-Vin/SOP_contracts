package org.vinio.dtos.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Ответ, представляющий информацию о пользователе")
public record UserResponse(

        @Schema(description = "Идентификатор пользователя", example = "456")
        Long userId,

        @Schema(description = "Имя пользователя", example = "John Doe")
        String name,

        @Schema(description = "Электронная почта пользователя", example = "johndoe@example.com")
        String email
) {
}
