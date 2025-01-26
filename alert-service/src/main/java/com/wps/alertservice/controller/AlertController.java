package com.wps.alertservice.controller;

import com.wps.alertservice.dto.CreateAlertRequest;
import com.wps.alertservice.dto.CreateIncidentRequest;
import com.wps.alertservice.dto.CreateIncidentResponse;
import com.wps.alertservice.feign.AlertInterface;
import com.wps.alertservice.model.Alert;
import com.wps.alertservice.service.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/")
public class AlertController {

    @Autowired
    AlertService alertService;

    @Autowired
    AlertInterface alertInterface;

    @PostMapping("/createAlert")
    public ResponseEntity<Alert> createAlert(@RequestBody CreateAlertRequest createAlertRequest) {
        Alert alert = alertService.createAlert(createAlertRequest);
        CreateIncidentRequest createIncidentRequest = CreateIncidentRequest
                .builder()
                .lat(createAlertRequest.getLat())
                .lng(createAlertRequest.getLng())
                .build();
        CreateIncidentResponse createIncidentResponse = alertInterface.createIncident(createIncidentRequest).getBody();
        System.out.println("Incident Response " + createIncidentResponse);
        System.out.println("Alert Response " + alert);
        return new ResponseEntity<>(alert, HttpStatus.OK);
    }

    @GetMapping("/getAllAlerts")
    public ResponseEntity<List<Alert>> getAllAlerts() {
        List<Alert> allAlerts = alertService.getAllAlerts();
        return new ResponseEntity<>(allAlerts, HttpStatus.OK);
    }

    @GetMapping("/getAlert/{alertId}")
    public ResponseEntity<Alert> getAlert(@PathVariable Long alertId) {
        Optional<Alert> alert = alertService.getAlert(alertId);
        if (alert.isPresent()) {
            return new ResponseEntity<>(alert.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(new Alert(), HttpStatus.BAD_REQUEST);
    }
}
