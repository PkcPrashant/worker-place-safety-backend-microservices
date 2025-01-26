package com.wps.alertservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateIncidentResponse {
    private Long id;
    private Double lat;
    private Double lng;
    private LocalDateTime createdAt;
}
