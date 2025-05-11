package com.br.IotService.infrastructure.dto.event;

import com.br.IotService.core.enums.EventType;

import java.util.UUID;

public record EventCreationDTO(UUID deviceId,
                               EventType eventType,
                               String value) {
}
