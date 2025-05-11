package com.br.IotService.core.domain;

import com.br.IotService.core.enums.Status;
import com.br.IotService.core.enums.Type;

import java.time.LocalDateTime;
import java.util.UUID;

public class Device {

    private UUID id;

    private String name;

    private Type type;

    private Status status;

    private String location;

    private LocalDateTime createdAt;

    private LocalDateTime lastSeen;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getLastSeen() {
        return lastSeen;
    }

    public void setLastSeen(LocalDateTime lastSeen) {
        this.lastSeen = lastSeen;
    }

    public Device(UUID id, String name, Type type, Status status, String location, LocalDateTime createdAt, LocalDateTime lastSeen) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.status = status;
        this.location = location;
        this.createdAt = createdAt;
        this.lastSeen = lastSeen;
    }

    public static class DeviceBuilder{
        private UUID id;
        private String name;
        private Type type;
        private Status status;
        private String location;
        private LocalDateTime createdAt;
        private LocalDateTime lastSeen;

        public DeviceBuilder builder(){
            return new DeviceBuilder();
        }

        public DeviceBuilder id(UUID id) {
            this.id = id;
            return this;
        }

        public DeviceBuilder name(String name) {
            this.name = name;
            return this;
        }

        public DeviceBuilder type(Type type) {
            this.type = type;
            return this;
        }

        public DeviceBuilder status(Status status) {
            this.status = status;
            return this;
        }

        public DeviceBuilder location(String location) {
            this.location = location;
            return this;
        }

        public DeviceBuilder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public DeviceBuilder lastSeen(LocalDateTime lastSeen) {
            this.lastSeen = lastSeen;
            return this;
        }

        public Device build(){
            return new Device(this.id,
                    this.name,
                    this.type,
                    this.status,
                    this.location,
                    this.createdAt,
                    this.lastSeen
            );
        }
    }
}
