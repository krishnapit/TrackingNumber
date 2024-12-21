package com.trackingnumber.controller;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trackingnumber.model.TrackingNumberResponse;
import com.trackingnumber.service.TrackingNumberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TrackingNumberController {

    private final TrackingNumberService trackingNumberService;

    @Autowired
    public TrackingNumberController(TrackingNumberService trackingNumberService) {
        this.trackingNumberService = trackingNumberService;
    }

    @GetMapping("/next-tracking-number")
    public Map<String, String> generateTrackingNumber(
            @RequestParam String origin_country_id,
            @RequestParam String destination_country_id,
            @RequestParam String weight,
            @RequestParam String created_at,
            @RequestParam String customer_id,
            @RequestParam String customer_name,
            @RequestParam String customer_slug) {

        String trackingNumber = trackingNumberService.generateTrackingNumber(
                origin_country_id, destination_country_id, weight, created_at,
                customer_id, customer_name, customer_slug);

        Map<String, String> response = new HashMap<>();
        response.put("tracking_number", trackingNumber);
        response.put("created_at", OffsetDateTime.now().toString());

        return response;
    }
}