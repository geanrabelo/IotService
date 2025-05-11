package com.br.IotService.usecases.impl;

import com.br.IotService.core.domain.Device;
import com.br.IotService.core.exceptions.DeviceNotFound;
import com.br.IotService.infrastructure.dto.DeviceEntityToDomain;
import com.br.IotService.infrastructure.dto.DeviceToEntity;
import com.br.IotService.infrastructure.entity.DeviceEntity;
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
        DeviceEntity conversion = new DeviceToEntity(device).toEntity();
        DeviceEntity deviceSaved = deviceEntityRepository.save(conversion);
        return new DeviceEntityToDomain(deviceSaved).toDomain();
    }

    @Override
    public Device findById(UUID id) {
        if(existsById(id)){
            DeviceEntity deviceEntity = deviceEntityRepository.getReferenceById(id);
            return new DeviceEntityToDomain(deviceEntity).toDomain();
        }
        throw new DeviceNotFound("Device find by id not found");
    }

    @Override
    public List<Device> findAll() {
        return deviceEntityRepository.findAll().stream().map(d -> new DeviceEntityToDomain(d).toDomain()).toList();
    }

    @Override
    public boolean existsById(UUID id) {
        return deviceEntityRepository.existsById(id);
    }

    @Override
    public void deleteById(UUID id) {
        if(existsById(id)){
            deviceEntityRepository.deleteById(id);
        }else{
            throw new DeviceNotFound("Device find by id not found");
        }
    }
}
