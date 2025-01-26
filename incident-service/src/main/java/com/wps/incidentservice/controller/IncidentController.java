package com.wps.incidentservice.controller;

import com.wps.incidentservice.dto.CreateIncidentRequest;
import com.wps.incidentservice.model.Incident;
import com.wps.incidentservice.service.IncidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/")
public class IncidentController {

    @Autowired
    IncidentService incidentService;

    @PostMapping("/createIncident")
    public ResponseEntity<Incident> createIncident(@RequestBody CreateIncidentRequest createIncidentRequest) {
        Incident incident = incidentService.createIncident(createIncidentRequest);
        return new ResponseEntity<>(incident, HttpStatus.OK);
    }

    @GetMapping("/getAllIncidents")
    public ResponseEntity<List<Incident>> getAllIncidents() {
        List<Incident> allIncidents = incidentService.getAllIncidents();
        return new ResponseEntity<>(allIncidents, HttpStatus.OK);
    }

    @GetMapping("/getIncident/{incidentId}")
    public ResponseEntity<Incident> getIncident(@PathVariable Long incidentId) {
        Optional<Incident> incident = incidentService.getIncident(incidentId);
        if (incident.isPresent()) {
            return new ResponseEntity<>(incident.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(new Incident(), HttpStatus.BAD_REQUEST);
    }
}
