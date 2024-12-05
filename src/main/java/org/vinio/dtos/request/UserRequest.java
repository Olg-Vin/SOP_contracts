package org.vinio.dtos.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;

public record UserRequest(
        @NotNull(message = "Имя не может быть пустым")
        @Max(value = 25, message = "Имя не должно быть длине 25 символов")
        String name,
        @NotNull(message = "Email не может быть пустым")
        @Email(message = "Проверьте правильность введённого email")
        String email
) {
}
