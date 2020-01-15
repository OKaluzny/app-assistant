package com.kaluzny.assistant.app.resource;

import com.kaluzny.assistant.api.model.dto.TruckDto;
import com.kaluzny.assistant.api.model.dto.TruckUpdateDto;
import com.kaluzny.assistant.api.model.filter.TruckFilter;
import com.kaluzny.assistant.api.resource.TruckResource;
import com.kaluzny.assistant.app.domain.Truck;
import com.kaluzny.assistant.app.service.TruckService;
import com.kaluzny.assistant.app.utils.converter.TruckConverter;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

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

    @GetMapping("/trucks")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public Collection<TruckDto> getPage(PageRequest pageable, TruckFilter filter) {
        log.debug("getPage() - start: pageable = {}, filter = {}", pageable, filter);
        Page<Truck> page = service.getPage(pageable, filter);
        List<TruckDto> pageContent = new ArrayList<>();
        for (Truck entity : page
                .getContent()) {
            TruckDto dto = converter.toDto(entity);
            pageContent.add(dto);
        }
        log.debug("getPage() - end: pageContent = {}", pageContent);
        return pageContent;
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

    @PutMapping("/trucks/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public TruckDto updateTruck(@PathVariable Long id, @RequestBody TruckUpdateDto requestForUpdate) {
        log.debug("updateTruck() - start: id = {}, requestForUpdate = {}", id, requestForUpdate);
        Truck entity = service.findById(id);
        converter.getMapperFacade().map(requestForUpdate, entity);
        TruckDto dto = converter.toDto(service.update(entity));
        log.debug("updateTruck() - end: dto = {}", dto.getId());
        return dto;
    }

    @DeleteMapping("/trucks/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Override
    public void deleteTruckById(@PathVariable("id") Long id) {
        log.debug("deleteTruckById() - start: id = {}", id);
        service.deleteById(id);
        log.debug("deleteTruckById() - end");
    }
}
