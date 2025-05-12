package com.br.IotService.infrastructure.controller;

import com.br.IotService.infrastructure.dto.MessageDTO;
import com.br.IotService.infrastructure.dto.alert.AlertCreationDTO;
import com.br.IotService.infrastructure.dto.alert.AlertDetailsDTO;
import com.br.IotService.infrastructure.service.AlertService;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/iot/alert")
public class AlertController {

    private final AlertService alertService;

    public AlertController(AlertService alertService){
        this.alertService = alertService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<MessageDTO> createAlert(@RequestBody @Validated AlertCreationDTO alertCreationDTO){
        String message = alertService.createAlert(alertCreationDTO);
        return ResponseEntity.ok(new MessageDTO(message));
    }

    @GetMapping
    public ResponseEntity<List<AlertDetailsDTO>> findAll(){
        return ResponseEntity.ok(alertService.findAll());
    }

    @GetMapping("/id")
    public ResponseEntity<AlertDetailsDTO> findById(@RequestParam(name = "id") String id){
        return ResponseEntity.ok(alertService.findById(UUID.fromString(id)));
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity<Void> deleteById(@RequestParam(name = "id") String id){
        alertService.deleteById(UUID.fromString(id));
        return ResponseEntity.noContent().build();
    }
}
