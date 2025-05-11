package com.br.IotService.infrastructure.dto;

import com.br.IotService.core.domain.Alert;
import com.br.IotService.infrastructure.entity.AlertEntity;

public record AlertToEntity(Alert alert) {

    public AlertEntity toAlertEntity(){
        return AlertEntity
                .builder()
                .id(alert.getId())
                .deviceEntity(new DeviceToEntity(alert.getDevice()).toEntity())
                .timestamp(alert.getTimestamp())
                .severity(alert.getSeverity())
                .description(alert.getDescription())
                .build();
    }
}
