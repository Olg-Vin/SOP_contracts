package org.vinio.dtos.response;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.links.Link;

import java.util.Date;
import java.util.List;

@Schema(description = "Ответ, представляющий сообщение, хранящееся в системе")
public record MessageResponse(
        @Schema(description = "Идентификатор сообщения", example = "123")
        Long messageId,
        @Schema(description = "Идентификатор пользователя, отправившего сообщение", example = "456")
        Long userId,
        @Schema(description = "Категория сообщения (например, 'complaint', 'suggestion')", example = "complaint")
        String category,
        @Schema(description = "Тема сообщения", example = "Ошибка в работе калькулятора")
        String subject,
        @Schema(description = "Приоритет сообщения, используемый для обработки", example = "1")
        int priority,
        @Schema(description = "Полный текст сообщения", example = "Калькулятор возвращает неверный результат для выражения 2+2.")
        String body,
        @Schema(description = "Дата создания сообщения", example = "2024-11-15T12:34:56.789Z")
        Date createdAt,
        @Schema(description = "Статус обработки сообщения (например, 'new', 'in progress', 'resolved')", example = "new")
        String status,
        @ArraySchema(
                schema = @Schema(description = "Доступные действия для сообщения", example = "[{\"href\":\"/messages/123/reopen\",\"rel\":\"reopen\"}]"),
                minItems = 0
        )
        List<Link> actions,
        @ArraySchema(
                schema = @Schema(description = "Ссылки, связанные с данным сообщением", example = "[{\"href\":\"/users/456\",\"rel\":\"user\"}]"),
                minItems = 0
        )
        List<Link> links
) {}
