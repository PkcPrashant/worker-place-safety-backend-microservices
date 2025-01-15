package com.wps.alertservice.service;

import com.wps.alertservice.dto.CreateAlertRequest;
import com.wps.alertservice.model.Alert;
import com.wps.alertservice.repository.AlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AlertService {

    @Autowired
    AlertRepository alertRepository;

    public Alert createAlert(CreateAlertRequest createAlertRequest) {
        Alert alert = Alert.builder()
                .type(createAlertRequest.getType())
                .createdAt(LocalDateTime.now())
                .build();
        return alertRepository.save(alert);
    }

    public List<Alert> getAllAlerts() {
        return alertRepository.findAll();
    }

    public Optional<Alert> getAlert(Long alertId) {
        return alertRepository.findById(alertId);
    }
}
