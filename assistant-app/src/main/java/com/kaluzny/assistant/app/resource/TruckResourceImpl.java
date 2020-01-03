package com.kaluzny.assistant.app.resource;

import com.kaluzny.assistant.api.model.dto.TruckDto;
import com.kaluzny.assistant.api.model.dto.TruckUpdateDto;
import com.kaluzny.assistant.api.resource.TruckResource;
import com.kaluzny.assistant.app.utils.converter.TruckConverter;
import com.kaluzny.assistant.app.domain.Truck;
import com.kaluzny.assistant.app.service.TruckService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Implementing a REST service for working with info about a truck.
 *
 * @author Oleg Kaluzny
 */
@Slf4j
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class TruckResourceImpl implements TruckResource {

    private final TruckService service;
    private final TruckConverter converter;

    @PostMapping("/trucks")
    @ResponseStatus(HttpStatus.CREATED)
    @Override
    public TruckDto createTruck(TruckUpdateDto requestForSave) {
        log.debug("createTruck() start: requestForSave={}", requestForSave);
        Truck entity = converter.getMapperFacade()
                .map(requestForSave, Truck.class);
        TruckDto dto = converter.toDto(service.create(entity));
        log.debug("createTruck() - end: response dto = {}", dto);
        return dto;
    }

    @GetMapping("/trucks/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public TruckDto getTruckById(@PathVariable("id") Long id) {
        log.debug("getTruckById() - start: id = {}", id);
        Truck entity = service.findById(id);
        TruckDto dto = converter.toDto(entity);
        log.debug("getTruckById() - end: dto = {}", dto.getId());
        return dto;
    }
}
