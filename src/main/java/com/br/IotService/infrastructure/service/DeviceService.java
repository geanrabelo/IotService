package com.br.IotService.infrastructure.service;

import com.br.IotService.infrastructure.dto.device.DeviceCreationDTO;
import com.br.IotService.infrastructure.dto.device.DeviceDetailsDTO;

import java.util.List;
import java.util.UUID;

public interface DeviceService {

    String createDevice(DeviceCreationDTO deviceCreationDTO);

    DeviceDetailsDTO findById(UUID id);

    List<DeviceDetailsDTO> findAll();

    void deleteById(UUID id);
}
