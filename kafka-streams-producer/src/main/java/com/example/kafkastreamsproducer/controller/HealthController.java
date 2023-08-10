package com.example.kafkastreamsproducer.controller;

import com.example.commonlibrary.dto.Health;
import com.example.kafkastreamsproducer.service.HealthService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HealthController {
    private final HealthService healthService;

    public HealthController(HealthService healthService) {
        this.healthService = healthService;
    }

    @GetMapping
    public List<Health> produceHealthData() {
        return healthService.produceHealthData();
//        return "Health data sent successfully";
    }
}
