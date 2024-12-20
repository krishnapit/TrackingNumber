package com.trackingnumber.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Entity
@Table(name = "tracking_numbers")
public class TrackingNumberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tracking_number", nullable = false, unique = true, length = 16)
    private String trackingNumber;

    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createdAt;

    // Constructors
    public TrackingNumberEntity() {
    }

    public TrackingNumberEntity(String trackingNumber, OffsetDateTime createdAt) {
        this.trackingNumber = trackingNumber;
        this.createdAt = createdAt;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "TrackingNumberEntity{" +
                "id=" + id +
                ", trackingNumber='" + trackingNumber + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
