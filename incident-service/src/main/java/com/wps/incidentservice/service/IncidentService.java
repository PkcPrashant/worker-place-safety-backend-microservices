package com.wps.incidentservice.service;

import com.wps.incidentservice.dto.CreateIncidentRequest;
import com.wps.incidentservice.model.Incident;
import com.wps.incidentservice.repository.IncidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class IncidentService {

    @Autowired
    IncidentRepository incidentRepository;

    public Incident createIncident(CreateIncidentRequest createIncidentRequest) {
        Incident incident = Incident.builder()
                .lat(createIncidentRequest.getLat())
                .lng(createIncidentRequest.getLng())
                .createdAt(LocalDateTime.now())
                .build();
        return incidentRepository.save(incident);
    }

    public List<Incident> getAllIncidents() {
        return incidentRepository.findAll();
    }

    public Optional<Incident> getIncident(Long incidentId) {
        return incidentRepository.findById(incidentId);
    }
}
