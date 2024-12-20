package com.trackingnumber.model;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class TrackingNumberResponse {
    private String trackingNumber;
    private String createdAt;

    public TrackingNumberResponse(String trackingNumber, OffsetDateTime  createdAt) {
        this.trackingNumber = trackingNumber;
        this.createdAt = createdAt.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
    }

	public String getTrackingNumber() {
		return trackingNumber;
	}

	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

    
}
