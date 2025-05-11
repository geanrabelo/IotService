package com.br.IotService.usecases;

import com.br.IotService.core.domain.Alert;

import java.util.List;
import java.util.UUID;

public interface AlertUsecases {

    Alert createAlert(Alert alert);

    Alert findById(UUID id);

    List<Alert> findAll();

    boolean existsById(UUID id);

    void deleteById(UUID id);
}
