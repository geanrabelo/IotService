package com.br.IotService.core.domain;

import com.br.IotService.core.enums.EventType;

import java.time.LocalDateTime;
import java.util.UUID;

public class Event {

    private UUID id;

    private Device device;

    private LocalDateTime timestamp;

    private EventType eventType;

    private String value;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Event(UUID id, Device device, LocalDateTime timestamp, EventType eventType, String value) {
        this.id = id;
        this.device = device;
        this.timestamp = timestamp;
        this.eventType = eventType;
        this.value = value;
    }

    public static class EventBuilder{
        private UUID id;
        private Device device;
        private LocalDateTime timestamp;
        private EventType eventType;
        private String value;

        public EventBuilder builder(){
            return new EventBuilder();
        }

        public EventBuilder id(UUID id) {
            this.id = id;
            return this;
        }

        public EventBuilder device(Device device) {
            this.device = device;
            return this;
        }

        public EventBuilder timestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public EventBuilder eventType(EventType eventType) {
            this.eventType = eventType;
            return this;
        }

        public EventBuilder value(String value) {
            this.value = value;
            return this;
        }

        public Event build(){
            return new Event(
                    this.id,
                    this.device,
                    this.timestamp,
                    this.eventType,
                    this.value
            );
        }
    }

}
