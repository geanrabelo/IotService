package com.br.IotService.usecases.impl;

import com.br.IotService.core.domain.Event;
import com.br.IotService.core.exceptions.EventNotFound;
import com.br.IotService.infrastructure.dto.event.EventEntityToDomain;
import com.br.IotService.infrastructure.dto.event.EventToEntity;
import com.br.IotService.infrastructure.entity.EventEntity;
import com.br.IotService.infrastructure.repositories.EventEntityRepository;
import com.br.IotService.usecases.EventUsecases;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class EventUsecasesImpl implements EventUsecases {

    private final EventEntityRepository eventEntityRepository;

    public EventUsecasesImpl(EventEntityRepository eventEntityRepository){
        this.eventEntityRepository = eventEntityRepository;
    }

    @Override
    public Event createEvent(Event event) {
        EventEntity conversion = new EventToEntity(event).toEntity();
        EventEntity eventSaved = eventEntityRepository.save(conversion);
        return new EventEntityToDomain(eventSaved).toDomain();
    }

    @Override
    public Event findById(UUID id) {
        if(existsById(id)){
            EventEntity eventEntity = eventEntityRepository.getReferenceById(id);
            return new EventEntityToDomain(eventEntity).toDomain();
        }
        throw new EventNotFound("Event find by id not found");
    }

    @Override
    public List<Event> findAll() {
        return eventEntityRepository.findAll().stream()
                .map(e -> new EventEntityToDomain(e).toDomain()).toList();
    }

    @Override
    public boolean existsById(UUID id) {
        return eventEntityRepository.existsById(id);
    }

    @Override
    public void deleteById(UUID id) {
        if(existsById(id)){
            eventEntityRepository.deleteById(id);
        }else{
            throw new EventNotFound("Event find by id not found");
        }
    }
}
