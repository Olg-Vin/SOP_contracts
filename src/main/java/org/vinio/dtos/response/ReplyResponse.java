package org.vinio.dtos.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;

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
        String handler
) {
}

