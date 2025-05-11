package com.br.IotService.infrastructure.repositories;

import com.br.IotService.infrastructure.entity.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EventRepository extends JpaRepository<EventEntity, UUID> {
}
