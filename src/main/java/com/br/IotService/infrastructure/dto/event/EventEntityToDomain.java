package com.br.IotService.infrastructure.dto.event;

import com.br.IotService.core.domain.Event;
import com.br.IotService.infrastructure.dto.device.DeviceEntityToDomain;
import com.br.IotService.infrastructure.entity.EventEntity;

public record EventEntityToDomain(EventEntity eventEntity) {

    public Event toDomain(){
        return new Event.EventBuilder()
                .builder()
                .id(eventEntity.getId())
                .device(new DeviceEntityToDomain(eventEntity.getDeviceEntity()).toDomain())
                .timestamp(eventEntity.getTimestamp())
                .eventType(eventEntity.getEventType())
                .value(eventEntity.getValue())
                .build();
    }
}
