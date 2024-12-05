package org.vinio.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlers {

    private static final String ERROR_STATUS = "error";

    /**
     * Обработчик для исключений InvalidArgumentException.
     *
     * @param e экземпляр исключения InvalidArgumentException.
     * @return стандартизированный ответ с HTTP-статусом BAD_REQUEST (400).
     */
    @ExceptionHandler(InvalidArgumentException.class)
    public ResponseEntity<StatusResponse> handleBadRequestException(InvalidArgumentException e) {
        var status = HttpStatus.BAD_REQUEST;
        return ResponseEntity
                .status(status)
                .body(new StatusResponse(ERROR_STATUS, e.getMessage()));
    }

    // TODO: добавьте обработку других исключений, если потребуется.

    /**
     * Обработчик для всех остальных исключений.
     *
     * @param e экземпляр исключения Exception.
     * @return стандартизированный ответ с HTTP-статусом INTERNAL_SERVER_ERROR (500).
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<StatusResponse> handleGlobalException(Exception e) {
        var status = HttpStatus.INTERNAL_SERVER_ERROR;
        return ResponseEntity
                .status(status)
                .body(new StatusResponse(ERROR_STATUS, "Внутренняя ошибка сервера: " + e.getMessage()));
    }
}
