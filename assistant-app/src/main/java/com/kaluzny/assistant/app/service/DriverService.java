package com.kaluzny.assistant.app.service;

import com.kaluzny.assistant.api.model.filter.TruckFilter;
import com.kaluzny.assistant.app.domain.Truck;
import com.kaluzny.assistant.app.domain.TruckDriver;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.NonNull;

/**
 * @author Oleg Kaluzny
 */
public interface DriverService {

    /**
     * Create new driver.
     *
     * @param driver {@link TruckDriver}.
     * @return DTO representation for created truck.
     */
    TruckDriver addDriver(Long truckId, TruckDriver driver);
    //TruckDriver create(@NonNull TruckDriver requestForSave);

   /* *//**
     * Get page of drivers.
     *
     * @param pageable page request details
     * @param filter   filters to apply
     * @return DTO representation of searched trucks.
     *//*
    *//*Page<Truck> getPage(final Pageable pageable, final TruckFilter filter);*//*

    *//**
     * Get driver by ID.
     *
     * @param id drivers id.
     * @return DTO representation for searched driver.
     *//*
    TruckDriver findById(final Long id);

    *//**
     * Update existing driver.
     *
     * @param driver {@link TruckDriver }.
     * @return representation for updated driver.
     *//*
    TruckDriver update(final TruckDriver driver);

    *//**
     * Delete existing driver by id.
     *
     * @param id driver's id.
     *//*
    void deleteById(final Long id);*/
}
