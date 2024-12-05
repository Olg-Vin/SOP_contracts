package org.vinio.dtos.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;

public record AddMessageRequest(
        @NotNull
        Long userId,
        @Max(value = 1024, message = "Тема должна кратко описывать содержимое сообщения")
        String subject,
        @NotNull
        @Max(value = 10_000, message = "Превышено количество символов для сообщения")
        String body
) {
}
