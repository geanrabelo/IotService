package com.br.IotService.infrastructure.repositories;

import com.br.IotService.infrastructure.entity.DeviceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DeviceEntityRepository extends JpaRepository<DeviceEntity, UUID> {
}
