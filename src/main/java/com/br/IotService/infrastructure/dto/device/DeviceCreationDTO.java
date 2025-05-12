package com.br.IotService.infrastructure.dto.device;

import com.br.IotService.core.domain.Device;
import com.br.IotService.core.enums.Status;
import com.br.IotService.core.enums.Type;

public record DeviceCreationDTO(String name,
                                Type type,
                                Status status,
                                String location) {
}
