package com.br.IotService.infrastructure.dto.alert;

import com.br.IotService.core.domain.Alert;
import com.br.IotService.infrastructure.dto.device.DeviceToEntity;
import com.br.IotService.infrastructure.entity.AlertEntity;

import java.time.LocalDateTime;

public record AlertToEntity(Alert alert) {

    public AlertEntity toAlertEntity(){
        return AlertEntity
                .builder()
                .id(alert.getId())
                .deviceEntity(new DeviceToEntity(alert.getDevice()).toEntity())
                .timestamp(LocalDateTime.now())
                .severity(alert.getSeverity())
                .description(alert.getDescription())
                .build();
    }
}
