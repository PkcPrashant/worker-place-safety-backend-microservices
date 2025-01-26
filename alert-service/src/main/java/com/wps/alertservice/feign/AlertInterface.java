package com.wps.alertservice.feign;

import com.wps.alertservice.dto.CreateIncidentRequest;
import com.wps.alertservice.dto.CreateIncidentResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("INCIDENT-SERVICE")
public interface AlertInterface {
    @PostMapping("api/createIncident")
    public ResponseEntity<CreateIncidentResponse> createIncident(@RequestBody CreateIncidentRequest createIncidentRequest);
}
