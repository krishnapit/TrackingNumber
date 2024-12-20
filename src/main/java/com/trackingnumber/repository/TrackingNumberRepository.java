package com.trackingnumber.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trackingnumber.model.TrackingNumberEntity;

@Repository
public interface TrackingNumberRepository extends JpaRepository<TrackingNumberEntity, Long> {
	 boolean existsByTrackingNumber(String trackingNumber);
}
