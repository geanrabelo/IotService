package com.br.IotService.infrastructure.service.impl;

import com.br.IotService.core.domain.Alert;
import com.br.IotService.infrastructure.dto.alert.AlertCreationDTO;
import com.br.IotService.infrastructure.dto.alert.AlertDetailsDTO;
import com.br.IotService.infrastructure.service.AlertService;
import com.br.IotService.usecases.AlertUsecases;
import com.br.IotService.usecases.DeviceUsecases;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AlertServiceImpl implements AlertService {

    private final DeviceUsecases deviceUsecases;
    private final AlertUsecases alertUsecases;

    public AlertServiceImpl(DeviceUsecases deviceUsecases, AlertUsecases alertUsecases){
        this.deviceUsecases = deviceUsecases;
        this.alertUsecases = alertUsecases;
    }

    @Override
    public String createAlert(AlertCreationDTO alertCreationDTO) {
        Alert alert = new Alert.AlertBuilder()
                .builder()
                .device(deviceUsecases.findById(alertCreationDTO.deviceId()))
                .severity(alertCreationDTO.severity())
                .description(alertCreationDTO.description())
                .build();
        alertUsecases.createAlert(alert);
        return "Alert registered successfully";
    }

    @Override
    public AlertDetailsDTO findById(UUID id) {
        return new AlertDetailsDTO(alertUsecases.findById(id));
    }

    @Override
    public List<AlertDetailsDTO> findAll() {
        return alertUsecases.findAll().stream().map(AlertDetailsDTO::new).toList();
    }

    @Override
    public void deleteById(UUID id) {
        alertUsecases.deleteById(id);
    }
}
