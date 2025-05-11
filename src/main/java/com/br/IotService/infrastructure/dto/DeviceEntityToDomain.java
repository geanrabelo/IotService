package com.br.IotService.infrastructure.dto;

import com.br.IotService.core.domain.Device;
import com.br.IotService.infrastructure.entity.DeviceEntity;

public record DeviceEntityToDomain(DeviceEntity deviceEntity) {

    public Device toDomain(){
        return new Device.DeviceBuilder()
                .builder()
                .id(deviceEntity.getId())
                .name(deviceEntity.getName())
                .type(deviceEntity.getType())
                .status(deviceEntity.getStatus())
                .location(deviceEntity.getLocation())
                .createdAt(deviceEntity.getCreatedAt())
                .lastSeen(deviceEntity.getLastSeen())
                .build();
    }
}
