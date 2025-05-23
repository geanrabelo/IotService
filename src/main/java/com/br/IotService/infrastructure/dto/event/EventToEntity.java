package com.br.IotService.infrastructure.dto.event;

import com.br.IotService.core.domain.Event;
import com.br.IotService.infrastructure.dto.device.DeviceToEntity;
import com.br.IotService.infrastructure.entity.EventEntity;

import java.time.LocalDateTime;

public record EventToEntity(Event event) {

    public EventEntity toEntity(){
        return EventEntity
                .builder()
                .id(event.getId())
                .deviceEntity(new DeviceToEntity(event.getDevice()).toEntity())
                .timestamp(LocalDateTime.now())
                .eventType(event.getEventType())
                .value(event.getValue())
                .build();
    }
}
