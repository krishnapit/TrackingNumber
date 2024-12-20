package com.trackingnumber.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trackingnumber.model.TrackingNumberEntity;
import com.trackingnumber.model.TrackingNumberResponse;
import com.trackingnumber.repository.TrackingNumberRepository;


@Service
public class TrackingNumberService {

    private final Set<String> generatedNumbers = ConcurrentHashMap.newKeySet();

    
    private final TrackingNumberRepository trackingNumberRepository;

    @Autowired
    public TrackingNumberService(TrackingNumberRepository trackingNumberRepository) {
        this.trackingNumberRepository = trackingNumberRepository;
    }

    
    public TrackingNumberResponse generateTrackingNumber(
            String originCountryId, String destinationCountryId, BigDecimal weight, String createdAt, 
            String customerId, String customerName, String customerSlug) {

        // Generate unique tracking number
        String trackingNumber = generateUniqueTrackingNumber(originCountryId, destinationCountryId, customerId);

        OffsetDateTime createdAt1 = OffsetDateTime.now();

        // Persist the tracking number
        saveTrackingNumber(trackingNumber, originCountryId, destinationCountryId, weight, createdAt1, customerId);

        // Return response with tracking number and createdAt timestamp
        return new TrackingNumberResponse(trackingNumber, createdAt1);
    }

    // Method to generate a unique tracking number based on origin, destination, and customerId
    private String generateUniqueTrackingNumber(String origin, String destination, String customerId) {
        String base = origin + destination + customerId + UUID.randomUUID();
        String trackingNumber = base.toUpperCase().substring(0, Math.min(base.length(), 16));

        // Check for uniqueness at the database level
        while (trackingNumberRepository.existsByTrackingNumber(trackingNumber)) {
            // If the number exists, regenerate a new one
            base = origin + destination + customerId + UUID.randomUUID();
            trackingNumber = base.toUpperCase().substring(0, Math.min(base.length(), 16));
        }

        return trackingNumber;
    }

    // Method to save generated tracking number in the database
    private void saveTrackingNumber(String trackingNumber, String originCountryId, String destinationCountryId, 
                                    BigDecimal weight, OffsetDateTime createdAt, String customerId) {
        TrackingNumberEntity entity = new TrackingNumberEntity();
        entity.setTrackingNumber(trackingNumber);
        //entity.setOriginCountryId(originCountryId);
       // entity.setDestinationCountryId(destinationCountryId);
        //entity.setWeight(weight);
        entity.setCreatedAt(createdAt);

        // Save entity to database
        trackingNumberRepository.save(entity);
    }
}
