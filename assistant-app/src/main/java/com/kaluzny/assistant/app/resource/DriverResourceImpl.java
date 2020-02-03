package com.kaluzny.assistant.app.resource;

import com.kaluzny.assistant.api.model.dto.DriverUpdateDto;
import com.kaluzny.assistant.api.model.dto.TruckDriverDto;
import com.kaluzny.assistant.api.resource.DriverResource;
import com.kaluzny.assistant.app.domain.TruckDriver;
import com.kaluzny.assistant.app.repository.DriverRepository;
import com.kaluzny.assistant.app.service.DriverService;
import com.kaluzny.assistant.app.utils.converter.DriverConverter;
import com.kaluzny.assistant.app.utils.converter.TruckConverter;

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
    public TruckDriverDto addDriverForTruck(@PathVariable Long id, TruckDriverDto requestForSave) {
        log.debug("addDriverForTruck() start: requestForSave={}", requestForSave);
        TruckDriver entity = converter.getMapperFacade()
                .map(requestForSave, TruckDriver.class);
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

 /*   @GetMapping("/trucks/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public TruckDto getTruckById(@PathVariable("id") Long id) {
        log.debug("getTruckById() - start: id = {}", id);
        Truck entity = service.findById(id);
        TruckDto dto = converter.toDto(entity);
        log.debug("getTruckById() - end: dto = {}", dto.getId());
        return dto;
    }*/

   /* @PutMapping("/trucks/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public TruckDto updateTruck(@PathVariable Long id, @RequestBody TruckUpdateDto requestForUpdate) {
        log.debug("updateTruck() - start: id = {}, requestForUpdate = {}", id, requestForUpdate);
        Truck entity = service.findById(id);
        converter.getMapperFacade().map(requestForUpdate, entity);
        TruckDto dto = converter.toDto(service.update(entity));
        log.debug("updateTruck() - end: dto = {}", dto.getId());
        return dto;
    }*/

   /* @DeleteMapping("/trucks/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Override
    public void deleteTruckById(@PathVariable("id") Long id) {
        log.debug("deleteTruckById() - start: id = {}", id);
        service.deleteById(id);
        log.debug("deleteTruckById() - end");
    }*/
}
