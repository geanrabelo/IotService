package com.br.IotService.usecases;

import com.br.IotService.core.domain.Event;

import java.util.List;
import java.util.UUID;

public interface EventUsecases {

    Event createEvent(Event device);

    Event findById(UUID id);

    List<Event> findAll();

    boolean existsById(UUID id);

    void deleteById(UUID id);

}
