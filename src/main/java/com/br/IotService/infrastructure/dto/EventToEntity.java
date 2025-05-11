package com.br.IotService.infrastructure.dto;

import com.br.IotService.core.domain.Event;
import com.br.IotService.infrastructure.entity.EventEntity;

public record EventToEntity(Event event) {

    public EventEntity toEntity(){
        return EventEntity
                .builder()
                .id(event.getId())
                .deviceEntity(new DeviceToEntity(event.getDevice()).toEntity())
                .timestamp(event.getTimestamp())
                .eventType(event.getEventType())
                .value(event.getValue())
                .build();
    }
}
