package org.vinio.dtos.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;

public record AddReplyRequest(
        @NotNull(message = "Необходимо указать для какого сообщения написан ответ")
        Long messageId,
        @NotNull(message = "Ответ не должен быть пустым, иначе какой смысл")
        @Max(value = 10_000, message = "Превышено количество символов для ответа")
        String body,
        @NotNull(message = "Укажите id ответственного сотрудника")
        String handler
) {
}
