package com.br.IotService.usecases.impl;

import com.br.IotService.core.domain.Device;
import com.br.IotService.infrastructure.repositories.DeviceEntityRepository;
import com.br.IotService.usecases.DeviceUsecases;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class DeviceUsecasesImpl implements DeviceUsecases {

    private final DeviceEntityRepository deviceEntityRepository;

    public DeviceUsecasesImpl(DeviceEntityRepository deviceEntityRepository){
        this.deviceEntityRepository = deviceEntityRepository;
    }

    @Override
    public Device createDevice(Device device) {
        return null;
    }

    @Override
    public Device findById(UUID id) {
        return null;
    }

    @Override
    public List<Device> findAll() {
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
