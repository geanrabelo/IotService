package com.br.IotService.infrastructure.service.impl;

import com.br.IotService.core.domain.Device;
import com.br.IotService.infrastructure.dto.device.DeviceCreationDTO;
import com.br.IotService.infrastructure.dto.device.DeviceDetailsDTO;
import com.br.IotService.infrastructure.service.DeviceService;
import com.br.IotService.usecases.DeviceUsecases;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DeviceServiceImpl implements DeviceService {

    private final DeviceUsecases deviceUsecases;

    public DeviceServiceImpl(DeviceUsecases deviceUsecases){
        this.deviceUsecases = deviceUsecases;
    }

    @Override
    public String createDevice(DeviceCreationDTO deviceCreationDTO) {
        Device device = new Device.DeviceBuilder()
                .builder()
                .name(deviceCreationDTO.name())
                .type(deviceCreationDTO.type())
                .status(deviceCreationDTO.status())
                .location(deviceCreationDTO.location())
                .build();
        return "Device registered successfully";
    }

    @Override
    public DeviceDetailsDTO findById(UUID id) {
        return new DeviceDetailsDTO(deviceUsecases.findById(id));
    }

    @Override
    public List<DeviceDetailsDTO> findAll() {
        return deviceUsecases.findAll().stream().map(DeviceDetailsDTO::new).toList();
    }

    @Override
    public void deleteById(UUID id) {
        deviceUsecases.deleteById(id);
    }
}
