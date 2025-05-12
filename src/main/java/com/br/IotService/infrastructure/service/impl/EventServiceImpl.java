package com.br.IotService.infrastructure.service.impl;

import com.br.IotService.core.domain.Event;
import com.br.IotService.infrastructure.dto.event.EventCreationDTO;
import com.br.IotService.infrastructure.dto.event.EventDetailsDTO;
import com.br.IotService.infrastructure.service.EventService;
import com.br.IotService.usecases.DeviceUsecases;
import com.br.IotService.usecases.EventUsecases;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EventServiceImpl implements EventService {

    private final EventUsecases eventUsecases;
    private final DeviceUsecases deviceUsecases;

    public EventServiceImpl(EventUsecases eventUsecases, DeviceUsecases deviceUsecases){
        this.eventUsecases = eventUsecases;
        this.deviceUsecases = deviceUsecases;
    }

    @Override
    public String createEvent(EventCreationDTO eventCreationDTO) {
        Event event = new Event.EventBuilder()
                .builder()
                .device(deviceUsecases.findById(eventCreationDTO.deviceId()))
                .eventType(eventCreationDTO.eventType())
                .value(eventCreationDTO.value())
                .build();
        eventUsecases.createEvent(event);
        return "Event registered successfully";
    }

    @Override
    public EventDetailsDTO findById(UUID id) {
        return new EventDetailsDTO(eventUsecases.findById(id));
    }

    @Override
    public List<EventDetailsDTO> findAll() {
        return eventUsecases.findAll().stream().map(EventDetailsDTO::new).toList();
    }

    @Override
    public void deleteById(UUID id) {
        eventUsecases.deleteById(id);
    }
}
