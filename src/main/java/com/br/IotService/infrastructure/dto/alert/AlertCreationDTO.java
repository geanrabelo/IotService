package com.br.IotService.infrastructure.dto.alert;

import com.br.IotService.core.enums.Severity;

import java.util.UUID;

public record AlertCreationDTO(UUID deviceId,
                               Severity severity,
                               String description) {
}
