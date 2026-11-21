package com.config.inventory.config_service.controllers;

import com.config.inventory.config_service.services.ClientCallingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class ClientCallingController {

    private final ClientCallingService clientCallingService;

    public ClientCallingController(ClientCallingService clientCallingService){
        this.clientCallingService = clientCallingService;
    }
    @PostMapping("actuator/refresh")
    public ResponseEntity<String[]> actuatorRefreshController(){
        return clientCallingService.actuatorRefreshService();
    }
}
