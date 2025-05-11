package com.br.IotService.usecases.impl;

import com.br.IotService.core.domain.Alert;
import com.br.IotService.core.exceptions.AlertNotFound;
import com.br.IotService.infrastructure.dto.alert.AlertEntityToDomain;
import com.br.IotService.infrastructure.dto.alert.AlertToEntity;
import com.br.IotService.infrastructure.entity.AlertEntity;
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
        AlertEntity alertEntity = new AlertToEntity(alert).toAlertEntity();
        AlertEntity alertSaved = alertEntityRepository.save(alertEntity);
        return new AlertEntityToDomain(alertEntity).toDomain();
    }

    @Override
    public Alert findById(UUID id) {
        if(existsById(id)){
            AlertEntity alertEntity = alertEntityRepository.getReferenceById(id);
            return new AlertEntityToDomain(alertEntity).toDomain();
        }
        throw new AlertNotFound("Alert find by id not found");
    }

    @Override
    public List<Alert> findAll() {
        return alertEntityRepository.findAll().stream()
                .map(a -> new AlertEntityToDomain(a).toDomain()).toList();
    }

    @Override
    public boolean existsById(UUID id) {
        return alertEntityRepository.existsById(id);
    }

    @Override
    public void deleteById(UUID id) {
        if(existsById(id)){
            alertEntityRepository.deleteById(id);
        }else{
            throw new AlertNotFound("Alert find by id not found");
        }
    }
}
