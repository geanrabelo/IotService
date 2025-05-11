package com.br.IotService.infrastructure.dto.device;

import com.br.IotService.core.domain.Device;
import com.br.IotService.core.enums.Status;
import com.br.IotService.core.enums.Type;

import java.time.LocalDateTime;
import java.util.UUID;

public record DeviceDetailsDTO(UUID id,
                               String name,
                               Type type,
                               Status status,
                               String location,
                               LocalDateTime created,
                               LocalDateTime lastSeen) {
    public DeviceDetailsDTO(Device device){
        this(
                device.getId(),
                device.getName(),
                device.getType(),
                device.getStatus(),
                device.getLocation(),
                device.getCreatedAt(),
                device.getLastSeen()
        );
    }
}
