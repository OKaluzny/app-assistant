package com.kaluzny.assistant.app.resource;

import com.kaluzny.assistant.api.model.dto.DriverUpdateDto;
import com.kaluzny.assistant.api.model.dto.TruckDriverDto;
import com.kaluzny.assistant.api.resource.DriverResource;
import com.kaluzny.assistant.app.domain.Driver;
import com.kaluzny.assistant.app.service.DriverService;
import com.kaluzny.assistant.app.utils.converter.DriverConverter;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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

  /*  @GetMapping("/trucks")
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
    }*/

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

    @PutMapping("/drivers/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public TruckDriverDto updateDriver(@PathVariable Long id, @RequestBody DriverUpdateDto requestForUpdate) {
        log.debug("updateDriver() - start: id = {}, requestForUpdate = {}", id, requestForUpdate);
        Driver entity = service.findById(id);
        converter.getMapperFacade().map(requestForUpdate, entity);
        TruckDriverDto dto = converter.toDto(service.update(entity));
        log.debug("updateTruck() - end: dto = {}", dto.getId());
        return dto;
    }

    @DeleteMapping("/drivers/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Override
    public void removeDriverById(@PathVariable("id") Long id) {
        log.debug("removeDriverById() - start: id = {}", id);
        service.deleteById(id);
        log.debug("removeDriverById() - end");
    }
}
