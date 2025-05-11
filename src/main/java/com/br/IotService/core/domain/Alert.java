package com.br.IotService.core.domain;

import com.br.IotService.core.enums.Severity;

import java.time.LocalDateTime;
import java.util.UUID;

public class Alert {

    private UUID id;
    private Device device;
    private LocalDateTime timestamp;
    private Severity severity;
    private String description;

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

    public Severity getSeverity() {
        return severity;
    }

    public void setSeverity(Severity severity) {
        this.severity = severity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Alert(UUID id, Device device, LocalDateTime timestamp, Severity severity, String description) {
        this.id = id;
        this.device = device;
        this.timestamp = timestamp;
        this.severity = severity;
        this.description = description;
    }

    public static class AlertBuilder{
        private UUID id;
        private Device device;
        private LocalDateTime timestamp;
        private Severity severity;
        private String description;


        public AlertBuilder builder(){
            return new AlertBuilder();
        }

        public AlertBuilder id(UUID id) {
            this.id = id;
            return this;
        }

        public AlertBuilder device(Device device) {
            this.device = device;
            return this;
        }

        public AlertBuilder timestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public AlertBuilder severity(Severity severity) {
            this.severity = severity;
            return this;
        }

        public AlertBuilder description(String description) {
            this.description = description;
            return this;
        }

        public Alert build(){
            return new Alert(
                    this.id,
                    this.device,
                    this.timestamp,
                    this.severity,
                    this.description
            );
        }
    }
}
