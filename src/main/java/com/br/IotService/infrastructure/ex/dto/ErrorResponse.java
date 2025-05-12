package com.br.IotService.infrastructure.ex.dto;

import org.springframework.http.HttpStatus;

import java.util.List;

public record ErrorResponse(int status,
                            String message,
                            List<ErrorField> errorFieldList) {

    public static ErrorResponse notFound(String message){
        return new ErrorResponse(HttpStatus.NOT_FOUND.value(), message, List.of());
    }
}
