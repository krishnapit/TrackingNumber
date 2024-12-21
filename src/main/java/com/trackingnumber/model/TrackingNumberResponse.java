package com.trackingnumber.model;

import java.time.OffsetDateTime;

public class TrackingNumberResponse {

    private String trackingNumber;
    private OffsetDateTime createdAt;

    // Constructor, Getters, and Setters
    public TrackingNumberResponse(String trackingNumber, OffsetDateTime createdAt) {
        this.trackingNumber = trackingNumber;
        this.createdAt = createdAt;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
