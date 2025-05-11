package com.br.IotService.infrastructure.entity;

import com.br.IotService.core.enums.Severity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tb_alert")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
public class AlertEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne
    private DeviceEntity deviceEntity;

    private LocalDateTime timestamp;

    @Enumerated(EnumType.STRING)
    private Severity severity;

    private String description;
}

