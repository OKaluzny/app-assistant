package com.kaluzny.assistant.app.service;

import com.kaluzny.assistant.api.model.dto.TruckDto;
import com.kaluzny.assistant.app.domain.Truck;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import lombok.NonNull;

/**
 * @author Oleg Kaluzny
 */
public interface TruckService {

    /**
     * Create new truck.
     *
     * @param requestForSave {@link TruckDto}.
     * @return DTO representation for created truck.
     */
    Truck create(@NonNull Truck requestForSave);

    /**
     * Get page of trucks.
     *
     * @param pageable page request details
     * @return DTO representation of searched trucks.
     */
    Page<Truck> getPage(Pageable pageable);

    /**
     * Get truck by ID.
     *
     * @param id truck's id.
     * @return DTO representation for searched truck.
     */
    Truck findById(final Long id);

    /**
     * Update existing Truck.
     *
     * @param truck {@link Truck }.
     * @return representation for updated truck.
     */
    Truck update(Truck truck);

    /**
     * Delete existing truck by id.
     *
     * @param id Truck's id.
     */
    void deleteById(final Long id);
}
