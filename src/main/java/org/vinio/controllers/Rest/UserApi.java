package org.vinio.controllers.Rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.vinio.dtos.request.UserRequest;
import org.vinio.dtos.response.UserResponse;

import java.util.List;

@Tag(name = "users", description = "API для управления пользователями")
@ApiResponses({
        @ApiResponse(responseCode = "200", description = "Успешная обработка запроса"),
        @ApiResponse(responseCode = "400", description = "Ошибка валидации"),
        @ApiResponse(responseCode = "404", description = "Ресурс не найден"),
        @ApiResponse(responseCode = "409", description = "Конфликт. Совпадение."),
        @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера")
})
public interface UserApi {

    @Operation(summary = "Получить пользователя по ID")
    @GetMapping(value = "/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<UserResponse> getUserById(@PathVariable("id") Long id);

    @Operation(summary = "Получить список всех пользователей")
    @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<UserResponse>> getAllUsers();

    @Operation(summary = "Создать нового пользователя")
    @PostMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<UserResponse> createUser(@Valid @RequestBody UserRequest user);

    @Operation(summary = "Обновить данные пользователя")
    @PutMapping(value = "/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<UserResponse> updateUser(@PathVariable("id") Long id, @Valid @RequestBody UserRequest updatedUserDTO);

    @Operation(summary = "Удалить пользователя")
    @DeleteMapping(value = "/users/{id}")
    ResponseEntity<Void> deleteUser(@PathVariable("id") Long id);
}
