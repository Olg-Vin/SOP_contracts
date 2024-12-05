package org.vinio.dtos.response;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.links.Link;

import java.util.Date;
import java.util.List;

@Schema(description = "Ответ, представляющий комментарий или ответ на сообщение")
public record ReplyResponse(

        @Schema(description = "Идентификатор ответа", example = "101")
        Long replyId,

        @Schema(description = "Идентификатор сообщения, к которому относится этот ответ", example = "123")
        Long messageId,

        @Schema(description = "Текст ответа", example = "Ваше сообщение было передано на обработку. Мы свяжемся с вами в ближайшее время.")
        String body,

        @Schema(description = "Дата создания ответа", example = "2024-11-15T12:34:56.789Z")
        Date createdAt,

        @Schema(description = "Имя пользователя или идентификатор, ответственного за обработку", example = "support_agent_01")
        String handler,

        @ArraySchema(
                schema = @Schema(description = "Доступные действия для ответа", example = "[{\"href\":\"/replies/101/edit\",\"rel\":\"edit\"}]"),
                minItems = 0
        )
        List<Link> actions,

        @ArraySchema(
                schema = @Schema(description = "Связанные гипермедийные ссылки", example = "[{\"href\":\"/messages/123\",\"rel\":\"message\"}]"),
                minItems = 0
        )
        List<Link> links

) {}

