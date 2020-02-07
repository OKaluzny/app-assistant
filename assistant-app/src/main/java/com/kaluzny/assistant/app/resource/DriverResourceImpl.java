package com.kaluzny.assistant.app.resource;

import com.kaluzny.assistant.api.model.dto.DriverUpdateDto;
import com.kaluzny.assistant.api.model.dto.TruckDriverDto;
import com.kaluzny.assistant.api.model.filter.DriverFilter;
import com.kaluzny.assistant.api.resource.DriverResource;
import com.kaluzny.assistant.app.domain.Driver;
import com.kaluzny.assistant.app.service.DriverService;
import com.kaluzny.assistant.app.utils.converter.DriverConverter;

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
 * Implementing a REST service for working with info about a driver.
 *
 * @author Oleg Kaluzny
 */
@Slf4j
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class DriverResourceImpl implements DriverResource {

    private final DriverService service;
    private final DriverConverter converter;

    @PostMapping("/trucks/{id}/drivers")
    @ResponseStatus(HttpStatus.CREATED)
    @Override
    public TruckDriverDto addDriverForTruck(@PathVariable Long id, DriverUpdateDto requestForSave) {
        log.debug("addDriverForTruck() start: requestForSave={}", requestForSave);
        Driver entity = converter.getMapperFacade()
                .map(requestForSave, Driver.class);
        TruckDriverDto dto = converter.toDto(service.addDriver(id, entity));
        log.info("addDriverForTruck() - end: response dto = {}", dto);
        return dto;
    }

    @GetMapping("/drivers")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public Collection<TruckDriverDto> getPage(PageRequest pageable, DriverFilter filter) {
        log.debug("getPage() - start: pageable = {}, filter = {}", pageable, filter);
        Page<Driver> page = service.getPage(pageable, filter);
        List<TruckDriverDto> pageContent = new ArrayList<>();
        for (Driver entity : page
                .getContent()) {
            TruckDriverDto dto = converter.toDto(entity);
            pageContent.add(dto);
        }
        log.debug("getPage() - end: pageContent = {}", pageContent);
        return pageContent;
    }

    @GetMapping("/drivers/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public TruckDriverDto getDriverById(@PathVariable Long id) {
        log.debug("getDriverById() - start: id = {}", id);
        Driver entity = service.findById(id);
        TruckDriverDto dto = converter.toDto(entity);
        log.debug("getDriverById() - end: dto = {}", dto.getId());
        return dto;
    }

    @PutMapping("/trucks/{truckId}/drivers/{driverId}")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public TruckDriverDto updateDriver(
            @PathVariable Long truckId, @PathVariable Long driverId, @RequestBody DriverUpdateDto requestForUpdate) {
        log.debug("updateDriver() - start: truckId = {}, driverId = {}, requestForUpdate = {}", truckId, driverId, requestForUpdate);
        Driver entity = service.findById(driverId);
        converter.getMapperFacade().map(requestForUpdate, entity);
        TruckDriverDto dto = converter.toDto(service.update(truckId, entity));
        log.debug("updateTruck() - end: dto = {}", dto.getId());
        return dto;
    }

    @DeleteMapping("/drivers/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Override
    public void removeDriverById(@PathVariable Long id) {
        log.debug("removeDriverById() - start: id = {}", id);
        service.deleteById(id);
        log.debug("removeDriverById() - end");
    }
}
