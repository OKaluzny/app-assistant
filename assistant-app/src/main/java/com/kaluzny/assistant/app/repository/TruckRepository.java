package com.kaluzny.assistant.app.repository;

import com.kaluzny.assistant.app.domain.Truck;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Repository for {@link Truck}.
 *
 * @author Oleg Kaluzny
 */
@Repository
public interface TruckRepository extends JpaRepository<Truck, Long>, JpaSpecificationExecutor<Truck> {
}
