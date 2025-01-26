package com.wps.incidentservice.repository;

import com.wps.incidentservice.model.Incident;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncidentRepository extends JpaRepository<Incident, Long> {
}
