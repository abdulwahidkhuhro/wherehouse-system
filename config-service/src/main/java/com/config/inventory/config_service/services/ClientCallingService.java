package com.config.inventory.config_service.services;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ClientCallingService {

    private final RestTemplate restTemplate;

    public ClientCallingService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }


    public ResponseEntity<String[]> actuatorRefreshService(){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Void> request = new HttpEntity<>(headers);

        return restTemplate.postForEntity("http://user-service/actuator/refresh",
                request,
                String[].class
        );

    }
}
