package com.br.IotService.infrastructure.dto.alert;

import com.br.IotService.core.domain.Alert;
import com.br.IotService.infrastructure.dto.device.DeviceEntityToDomain;
import com.br.IotService.infrastructure.entity.AlertEntity;

public record AlertEntityToDomain(AlertEntity alertEntity) {

    public Alert toDomain(){
        return new Alert.AlertBuilder()
                .builder()
                .id(alertEntity.getId())
                .device(new DeviceEntityToDomain(alertEntity.getDeviceEntity()).toDomain())
                .timestamp(alertEntity.getTimestamp())
                .severity(alertEntity.getSeverity())
                .description(alertEntity.getDescription())
                .build();
    }
}
