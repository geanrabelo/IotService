package com.br.IotService.infrastructure.service;

import com.br.IotService.infrastructure.dto.event.EventCreationDTO;
import com.br.IotService.infrastructure.dto.event.EventDetailsDTO;

import java.util.List;
import java.util.UUID;

public interface EventService {

    String createEvent(EventCreationDTO eventCreationDTO);

    EventDetailsDTO findById(UUID id);

    List<EventDetailsDTO> findAll();

    void deleteById(UUID id);
}
