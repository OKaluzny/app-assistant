package com.kaluzny.assistant.app.service;

import com.kaluzny.assistant.app.domain.Driver;

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
    Driver addDriver(Long truckId, final Driver driver);

    /**
     * Get page of drivers.
     *
     * @param pageable page request details
     * @param filter   filters to apply
     * @return DTO representation of searched trucks.
     */
    /* Page<Truck> getPage(final Pageable pageable, final TruckFilter filter);*/

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
     * @param driver {@link Driver }.
     * @return representation for updated driver.
     */
    Driver update(final Driver driver);

    /**
     * Delete existing driver by id.
     *
     * @param id driver's id.
     */
    void deleteById(final Long id);
}
