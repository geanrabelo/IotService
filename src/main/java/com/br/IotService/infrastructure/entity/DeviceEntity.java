package com.br.IotService.infrastructure.entity;

import com.br.IotService.core.enums.Status;
import com.br.IotService.core.enums.Type;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tb_device")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
public class DeviceEntity {

    private UUID id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Type type;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String location;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "last_seen")
    private LocalDateTime lastSeen;
}
