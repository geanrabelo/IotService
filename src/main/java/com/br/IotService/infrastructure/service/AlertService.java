package com.br.IotService.infrastructure.service;

import com.br.IotService.infrastructure.dto.alert.AlertCreationDTO;
import com.br.IotService.infrastructure.dto.alert.AlertDetailsDTO;

import java.util.List;
import java.util.UUID;

public interface AlertService {

    String createAlert(AlertCreationDTO alertCreationDTO);

    AlertDetailsDTO findById(UUID id);

    List<AlertDetailsDTO> findAll();

    void deleteById(UUID id);
}

