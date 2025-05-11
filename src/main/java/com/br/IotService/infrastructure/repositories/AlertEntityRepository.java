package com.br.IotService.infrastructure.repositories;

import com.br.IotService.infrastructure.entity.AlertEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AlertEntityRepository extends JpaRepository<AlertEntity, UUID> {
}
