package com.kaluzny.assistant.app.service;

import com.kaluzny.assistant.api.model.dto.TruckDto;
import com.kaluzny.assistant.app.domain.Truck;
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
     * Get truck by ID.
     *
     * @param id truck's id.
     * @return DTO representation for searched truck.
     */
    Truck findById(final Long id);

    /**
     * Delete existing truck by id.
     *
     * @param id Truck's id.
     */
    void  deleteById(final Long id);
}
