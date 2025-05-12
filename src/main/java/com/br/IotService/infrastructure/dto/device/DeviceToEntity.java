package com.br.IotService.infrastructure.dto.device;

import com.br.IotService.core.domain.Device;
import com.br.IotService.infrastructure.entity.DeviceEntity;

import java.time.LocalDateTime;

public record DeviceToEntity(Device device) {

    public DeviceEntity toEntity(){
        return DeviceEntity.builder()
                .id(device.getId())
                .name(device.getName())
                .type(device.getType())
                .status(device.getStatus())
                .location(device.getLocation())
                .createdAt(LocalDateTime.now())
                .lastSeen(LocalDateTime.now())
                .build();
    }
}
