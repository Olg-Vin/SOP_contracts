package org.vinio.dtos.response;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.links.Link;

import java.util.List;

@Schema(description = "Ответ, представляющий информацию о пользователе")
public record UserResponse(

        @Schema(description = "Идентификатор пользователя", example = "456")
        Long userId,

        @Schema(description = "Имя пользователя", example = "John Doe")
        String name,

        @Schema(description = "Электронная почта пользователя", example = "johndoe@example.com")
        String email,

        @ArraySchema(
                schema = @Schema(description = "Доступные действия для пользователя", example = "[{\"href\":\"/users/456/edit\",\"rel\":\"edit\"}]"),
                minItems = 0
        )
        List<Link> actions,

        @ArraySchema(
                schema = @Schema(description = "Ссылки, связанные с данным пользователем", example = "[{\"href\":\"/users/456\",\"rel\":\"self\"}]"),
                minItems = 0
        )
        List<Link> links

) {}
