package org.vinio.controllers.Rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.vinio.dtos.request.AddReplyRequest;
import org.vinio.dtos.response.ReplyResponse;

@Tag(name = "replies", description = "API для управления ответами")
@ApiResponses({
        @ApiResponse(responseCode = "200", description = "Успешная обработка запроса"),
        @ApiResponse(responseCode = "400", description = "Ошибка валидации"),
        @ApiResponse(responseCode = "404", description = "Ресурс не найден"),
        @ApiResponse(responseCode = "409", description = "Конфликт. Совпадение."),
        @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера")
})
public interface ReplyApi {

    @Operation(summary = "Получить ответ по ID сообщения")
    @GetMapping(value = "/replies/getReply/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ReplyResponse> getReplyByMessageId(@PathVariable("id") Long id);

    @Operation(summary = "Создать новый ответ")
    @PostMapping(value = "/replies", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ReplyResponse> createReply(@RequestBody AddReplyRequest reply);

    @Operation(summary = "Обновить ответ")
    @PutMapping(value = "/replies/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ReplyResponse> updateReply(@PathVariable("id") Long id, @RequestBody AddReplyRequest updatedReply);

    @Operation(summary = "Удалить ответ")
    @DeleteMapping(value = "/replies/{id}")
    ResponseEntity<Void> deleteReply(@PathVariable("id") Long id);
}
