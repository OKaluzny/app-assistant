package com.kaluzny.assistant.app.repository;

import com.kaluzny.assistant.app.domain.Truck;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Oleg Kaluzny
 */
@Repository
public interface TruckRepository extends JpaRepository<Truck, Long> {
}
