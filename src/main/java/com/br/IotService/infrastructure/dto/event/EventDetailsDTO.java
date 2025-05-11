package com.br.IotService.infrastructure.dto.event;

import com.br.IotService.core.domain.Event;
import com.br.IotService.core.enums.EventType;

import java.time.LocalDateTime;
import java.util.UUID;

public record EventDetailsDTO(UUID id,
                              UUID deviceId,
                              LocalDateTime timestamp,
                              EventType eventType,
                              String value) {

    public EventDetailsDTO(Event event){
        this(
                event.getId(),
                event.getDevice().getId(),
                event.getTimestamp(),
                event.getEventType(),
                event.getValue()
        );
    }
}
