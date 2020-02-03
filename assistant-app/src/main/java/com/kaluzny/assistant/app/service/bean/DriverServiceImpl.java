package com.kaluzny.assistant.app.service.bean;

import com.kaluzny.assistant.app.domain.TruckDriver;
import com.kaluzny.assistant.app.repository.DriverRepository;
import com.kaluzny.assistant.app.repository.TruckRepository;
import com.kaluzny.assistant.app.service.DriverService;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * TruckServiceImpl
 *
 * @author Oleg Kaluzny
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class DriverServiceImpl implements DriverService {

    private final DriverRepository driverRepository;
    private final TruckRepository truckRepository;
    //private final SpecificationBuilder specificationBuilder;

 /*   @Override
    public TruckDriver create(TruckDriver requestForSave) {
        log.debug("create() - start: requestForSave = {}", requestForSave);
        TruckDriver entity = driverRepository.save(requestForSave);
        log.info("create() - end: entity = {}", entity);
        return entity;
    }*/

  /*  @Override
    public Page<Truck> getPage(Pageable pageable, TruckFilter filter) {
        log.debug("getPage() - start: pageable = {}, filter = {}", pageable, filter);
        Specification<Truck> specification = specificationBuilder.buildFilterSpec(filter);
        Page<Truck> page = repository.findAll(specification, pageable);
        log.debug("getPage() - end: page = {}", page);
        return page;
    }*/

 /*   @Override
    public TruckDriver findById(Long id) {
        log.debug("findById() - start: id = {}", id);
        TruckDriver entity = driverRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity with id = Not found"));
        log.info("findById() - end: entity = {}", entity.getId());
        return entity;
    }*/

   /* @Override
    public TruckDriver update(TruckDriver driver) {
        log.debug("update() - start: driver = {}", driver);
        TruckDriver updatedEntity = driverRepository.findById(driver.getId())
                .map(entity -> {
                    entity.setFirstName(driver.getFirstName());
                    entity.setLastName(driver.getLastName());
                    return driverRepository.save(entity);
                })
                .orElseThrow(() -> new EntityNotFoundException("truck with id = Not found"));
        log.info("update() - end: entity = {}", updatedEntity.getId());
        return updatedEntity;
    }*/
    //=================

    public TruckDriver addDriver(@PathVariable Long truckId, TruckDriver driver) {
        log.debug("addDriver() - start: truckId = {}, driver = {}", truckId, driver);
        TruckDriver truckDriver = truckRepository.findById(truckId)
                .map(truck -> {
                    driver.setTruck(truck);
                    return driverRepository.save(driver);
                })
                .orElseThrow(() -> new EntityNotFoundException("truck not found with id " + truckId));
        log.info("addDriver() - end: truckDriver with id = {}", truckDriver.getId());
        return truckDriver;
    }

    //==========

   /* @Override
    public void deleteById(Long id) {
        log.debug("deleteById() - start: id = {}", id);
        driverRepository.deleteById(id);
        log.debug("deleteById() - end");
    }*/
}
