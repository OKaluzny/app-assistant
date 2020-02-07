package com.kaluzny.assistant.app.service;

import com.kaluzny.assistant.api.model.filter.DriverFilter;
import com.kaluzny.assistant.app.domain.Driver;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author Oleg Kaluzny
 */
public interface DriverService {

    /**
     * Create new driver.
     *
     * @param driver {@link Driver}.
     * @return DTO representation for created truck.
     */
    Driver addDriver(final Long truckId, final Driver driver);

    /**
     * Get page of drivers.
     *
     * @param pageable page request details
     * @param filter   filters to apply
     * @return DTO representation of searched drivers.
     */
    Page<Driver> getPage(final Pageable pageable, final DriverFilter filter);

    /**
     * Get driver by ID.
     *
     * @param id drivers id.
     * @return DTO representation for searched driver.
     */
    Driver findById(final Long id);

    /**
     * Update existing driver.
     *
     * @param truckId truck's id.
     * @param driver  {@link Driver}.
     * @return representation for updated driver.
     */
    Driver update(final Long truckId, final Driver driver);

    /**
     * Delete existing driver by id.
     *
     * @param id driver's id.
     */
    void deleteById(final Long id);
}
