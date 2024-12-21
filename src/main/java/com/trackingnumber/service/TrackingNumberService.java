package com.trackingnumber.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trackingnumber.model.TrackingNumberEntity;
import com.trackingnumber.repository.TrackingNumberRepository;

import java.time.OffsetDateTime;
import java.util.UUID;

@Service
public class TrackingNumberService {

    private final TrackingNumberRepository trackingNumberRepository;

    @Autowired
    public TrackingNumberService(TrackingNumberRepository trackingNumberRepository) {
        this.trackingNumberRepository = trackingNumberRepository;
    }

    // Method to generate a unique tracking number
    @Transactional
    public String generateTrackingNumber(String originCountryId, String destinationCountryId, 
                                         String weight, String createdAt, String customerId, 
                                         String customerName, String customerSlug) {
        String trackingNumber = createTrackingNumber(originCountryId, destinationCountryId, weight, customerSlug);
System.out.println(trackingNumber);
        // Check if tracking number exists in database
        if (trackingNumberRepository.existsByTrackingNumber(trackingNumber)) {
            // If it exists, regenerate a new tracking number
            return generateTrackingNumber(originCountryId, destinationCountryId, weight, createdAt, customerId, customerName, customerSlug);
        }

        // Save the tracking number to the database
        TrackingNumberEntity entity = new TrackingNumberEntity();
        entity.setTrackingNumber(trackingNumber);
        entity.setCreatedAt(OffsetDateTime.now());
        entity.setCustomerId(customerId);
        trackingNumberRepository.save(entity);

        return trackingNumber;
    }

    // Helper method to create a tracking number using the input data
    private String createTrackingNumber(String originCountryId, String destinationCountryId, 
                                        String weight, String customerSlug) {
       // String base = originCountryId + destinationCountryId + customerSlug;
       // String uniquePart = UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        //return (base + uniquePart).substring(0, 16);  // Ensure the tracking number length is <= 16
    	return originCountryId + destinationCountryId + UUID.randomUUID().toString().replace("-", "").substring(0, 10).toUpperCase();
    }
}