package com.br.IotService.usecases.impl;

import com.br.IotService.core.domain.Alert;
import com.br.IotService.infrastructure.repositories.AlertEntityRepository;
import com.br.IotService.usecases.AlertUsecases;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class AlertUsecasesImpl implements AlertUsecases {

    private final AlertEntityRepository alertEntityRepository;

    public AlertUsecasesImpl(AlertEntityRepository alertEntityRepository){
        this.alertEntityRepository = alertEntityRepository;
    }

    @Override
    public Alert createAlert(Alert alert) {
        return null;
    }

    @Override
    public Alert findById(UUID id) {
        return null;
    }

    @Override
    public List<Alert> findAll() {
        return List.of();
    }

    @Override
    public boolean existsById(UUID id) {
        return false;
    }

    @Override
    public void deleteById(UUID id) {

    }
}
