package com.nekotasks.arc.domain.dto;

public record ErrorResponse(
        int status,
        String message,
        String details

) {
}
