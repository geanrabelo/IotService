package com.br.IotService.usecases;


import com.br.IotService.core.domain.Device;

import java.util.List;
import java.util.UUID;

public interface DeviceUsecases {

    Device createDevice(Device device);

    Device findById(UUID id);

    List<Device> findAll();

    boolean existsById(UUID id);

    void deleteById(UUID id);
}
