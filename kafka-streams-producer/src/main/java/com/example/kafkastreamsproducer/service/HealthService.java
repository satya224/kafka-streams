package com.example.kafkastreamsproducer.service;

import com.example.commonlibrary.dto.*;
import com.example.kafkastreamsproducer.kafka.HealthDataProducer;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
public class HealthService {

    private final HealthDataProducer healthDataProducer;

    public HealthService(HealthDataProducer healthDataProducer) {
        this.healthDataProducer = healthDataProducer;
    }

    public List<Health> produceHealthData() {
        List<String> fileNames = List.of("data/HealthAuth-20220909.txt", "data/HealthAuth-20220912.txt", "data/HealthAuth-20220915.txt");
        List<Health> healthList = new ArrayList<>();
        Health health = new Health();
        for (String fileName : fileNames) {
            ClassPathResource classPathResource = new ClassPathResource(fileName);
            try {
                File file = classPathResource.getFile();
                BufferedReader reader = new BufferedReader(new FileReader(file));
                while (reader.ready()) {
                    String line = reader.readLine();
                    String prefix = line.substring(0, 3);
                    switch (prefix) {
                        case "SUB" -> health.setSubscriber(addSubscriber(line));
                        case "PAT" -> health.setPatient(addPatient(line));
                        case "CAS" -> health.set_case(addCase(line));
                        case "SVC" -> {
                            health.setService(addService(line));
                            healthDataProducer.sendMessage(health);
                            healthList.add(health);
                            health = new Health();
                        }
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return healthList;
    }

    private Service addService(String line) {
        return new Service(line.substring(3, 19).strip(),
                line.substring(19, 35).strip(),
                line.substring(35, 51).strip(),
                line.substring(51, 67).strip(),
                line.substring(67, 83).strip(),
                line.substring(83, 99).strip(),
                line.substring(99, 115).strip(),
                line.substring(115).strip());
    }

    private Case addCase(String line) {
        return new Case(line.substring(3, 19).strip(),
                line.substring(19, 35).strip(),
                line.substring(35, 51).strip(),
                line.substring(51, 67).strip(),
                line.substring(67, 83).strip(),
                line.substring(83, 99).strip(),
                line.substring(99).strip());
    }

    private Patient addPatient(String line) {
        return new Patient(line.substring(3, 19).strip(),
                line.substring(19, 35).strip(),
                line.substring(35, 51).strip(),
                line.substring(51, 67).strip(),
                line.substring(67, 83).strip(),
                line.substring(83, 99).strip(),
                line.substring(99, 115).strip(),
                line.substring(115, 131).strip(),
                line.substring(131).strip());
    }

    private Subscriber addSubscriber(String line) {
        return new Subscriber(line.substring(3, 19).strip(),
                line.substring(19, 35).strip(),
                line.substring(35, 51).strip(),
                line.substring(51, 67).strip(),
                line.substring(67, 83).strip(),
                line.substring(83, 99).strip(),
                line.substring(99, 115).strip(),
                line.substring(115, 131).strip(),
                line.substring(131).strip());
    }
}
