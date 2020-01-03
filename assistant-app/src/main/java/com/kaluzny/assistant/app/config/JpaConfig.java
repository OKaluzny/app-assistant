package com.kaluzny.assistant.app.config;

import com.kaluzny.assistant.app.domain.Truck;
import com.kaluzny.assistant.app.repository.TruckRepository;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * JPA configuration.
 *
 * @author Oleg Kaluzny
 */
@Configuration
@EnableTransactionManagement
@EntityScan(basePackageClasses = Truck.class)
@EnableJpaRepositories(basePackageClasses = TruckRepository.class)
public class JpaConfig {
}
