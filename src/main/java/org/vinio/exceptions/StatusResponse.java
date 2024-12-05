package org.vinio.exceptions;

/**
 * Класс для формирования стандартизированных ответов на ошибки.
 */
public record StatusResponse (
        String status,
        String message
) {}
