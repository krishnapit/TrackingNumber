package com.trackingnumber.model;
import java.time.OffsetDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Parcel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tracking_number_id")
    private TrackingNumberEntity trackingNumber;  // This is the relationship with TrackingNumberEntity

    @Column(nullable = false)
    private String destinationCountry;

    @Column(nullable = false)
    private double weight;  // The weight of the parcel in kilograms

    @Column(nullable = false)
    private OffsetDateTime createdAt;  // Timestamp for when the parcel is created

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TrackingNumberEntity getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(TrackingNumberEntity trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public String getDestinationCountry() {
        return destinationCountry;
    }

    public void setDestinationCountry(String destinationCountry) {
        this.destinationCountry = destinationCountry;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
