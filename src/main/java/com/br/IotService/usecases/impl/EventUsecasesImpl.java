package com.br.IotService.usecases.impl;

import com.br.IotService.core.domain.Event;
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

        return null;
    }

    @Override
    public Event findById(UUID id) {
        return null;
    }

    @Override
    public List<Event> findAll() {
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
