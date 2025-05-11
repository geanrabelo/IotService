package com.br.IotService.infrastructure.dto.alert;

import com.br.IotService.core.domain.Alert;
import com.br.IotService.core.enums.Severity;

import java.time.LocalDateTime;
import java.util.UUID;

public record AlertDetailsDTO(UUID id,
                              UUID deviceId,
                              LocalDateTime timestamp,
                              Severity severity,
                              String description) {
    public AlertDetailsDTO(Alert alert){
        this(
                alert.getId(),
                alert.getDevice().getId(),
                alert.getTimestamp(),
                alert.getSeverity(),
                alert.getDescription()
        );
    }
}
