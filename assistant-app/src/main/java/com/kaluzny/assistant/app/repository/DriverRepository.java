package com.kaluzny.assistant.app.repository;

import com.kaluzny.assistant.app.domain.Driver;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Repository for {@link Driver}.
 *
 * @author Oleg Kaluzny
 */
@Repository
public interface DriverRepository extends JpaRepository<Driver, Long>, JpaSpecificationExecutor<Driver> {
}
