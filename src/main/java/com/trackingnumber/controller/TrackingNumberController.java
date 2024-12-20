package com.trackingnumber.controller;

import java.math.BigDecimal;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trackingnumber.model.TrackingNumberResponse;
import com.trackingnumber.service.TrackingNumberService;

@RestController
@RequestMapping("/api")
public class TrackingNumberController {

    private final TrackingNumberService trackingNumberService;

    public TrackingNumberController(TrackingNumberService trackingNumberService) {
        this.trackingNumberService = trackingNumberService;
    }

   // @GetMapping("/next-tracking-number")
    @GetMapping(value = "/next-tracking-number", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TrackingNumberResponse> getNextTrackingNumber(
            @RequestParam String origin_country_id,
            @RequestParam String destination_country_id,
            @RequestParam BigDecimal weight,
            @RequestParam String created_at,
            @RequestParam String customer_id,
            @RequestParam String customer_name,
            @RequestParam String customer_slug) {
        
        TrackingNumberResponse response = trackingNumberService.generateTrackingNumber(
                origin_country_id, destination_country_id, weight, created_at, customer_id, customer_name, customer_slug);
        
        return ResponseEntity.ok(response);
    }
}
