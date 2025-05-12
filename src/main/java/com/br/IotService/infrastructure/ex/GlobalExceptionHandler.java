package com.br.IotService.infrastructure.ex;

import com.br.IotService.core.exceptions.AlertNotFound;
import com.br.IotService.core.exceptions.DeviceNotFound;
import com.br.IotService.core.exceptions.EventNotFound;
import com.br.IotService.infrastructure.ex.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AlertNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse alertNotFoundHandler(AlertNotFound alertNotFound) {
        return ErrorResponse.notFound(alertNotFound.getMessage());
    }

    @ExceptionHandler(DeviceNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse deviceNotFoundHandler(DeviceNotFound deviceNotFound){
        return ErrorResponse.notFound(deviceNotFound.getMessage());
    }

    @ExceptionHandler(EventNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse eventNotFoundHandler(EventNotFound eventNotFound){
        return ErrorResponse.notFound(eventNotFound.getMessage());
    }

}
