package com.br.IotService.core.exceptions;

public class DeviceNotFound extends RuntimeException {
    public DeviceNotFound(String message) {
        super(message);
    }
}
