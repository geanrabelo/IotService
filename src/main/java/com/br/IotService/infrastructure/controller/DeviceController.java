package com.br.IotService.infrastructure.controller;

import com.br.IotService.infrastructure.dto.MessageDTO;
import com.br.IotService.infrastructure.dto.device.DeviceCreationDTO;
import com.br.IotService.infrastructure.dto.device.DeviceDetailsDTO;
import com.br.IotService.infrastructure.service.DeviceService;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/iot/device")
public class DeviceController {

    private final DeviceService deviceService;

    public DeviceController(DeviceService deviceService){
        this.deviceService = deviceService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<MessageDTO> createDevice(@RequestBody @Validated DeviceCreationDTO deviceCreationDTO){
        String message= deviceService.createDevice(deviceCreationDTO);
        return ResponseEntity.ok(new MessageDTO(message));
    }

    @GetMapping
    public ResponseEntity<List<DeviceDetailsDTO>> findAll(){
        return ResponseEntity.ok(deviceService.findAll());
    }

    @GetMapping("/id")
    public ResponseEntity<DeviceDetailsDTO> findById(@RequestParam(name = "id") String id){
        return ResponseEntity.ok(deviceService.findById(UUID.fromString(id)));
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity<Void> deleteById(@RequestParam(name = "id") String id){
        deviceService.deleteById(UUID.fromString(id));
        return ResponseEntity.noContent().build();
    }
}
