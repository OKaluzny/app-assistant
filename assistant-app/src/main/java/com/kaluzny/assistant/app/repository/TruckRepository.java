package com.kaluzny.assistant.app.repository;

import com.kaluzny.assistant.app.domain.Truck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author Oleg Kaluzny
 */
@RepositoryRestResource
public interface TruckRepository extends JpaRepository<Truck, Long> {
}
