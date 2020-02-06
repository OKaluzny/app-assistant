package com.kaluzny.assistant.app.service.bean;

import com.kaluzny.assistant.app.domain.Driver;
import com.kaluzny.assistant.app.repository.DriverRepository;
import com.kaluzny.assistant.app.repository.TruckRepository;
import com.kaluzny.assistant.app.service.DriverService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.EntityNotFoundException;

/**
 * DriverServiceImpl
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

    @Override
    public Driver findById(Long id) {
        log.debug("findById() - start: id = {}", id);
        Driver driver = driverRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("driver not found with id = " + id));
        log.info("findById() - end: driver = {}", driver.getId());
        return driver;
    }

    @Override
    public Driver update(Driver driver) {
        log.debug("update() - start: driver = {}", driver);

        Driver updatedEntity = driverRepository.findById(driver.getId())
                .map(entity -> {
                    entity.setFirstName(driver.getFirstName());
                    entity.setLastName(driver.getLastName());
                    return driverRepository.save(entity);
                })
                .orElseThrow(() -> new EntityNotFoundException("driver not found with id = " + driver.getId()));
        log.info("update() - end: entity = {}", updatedEntity.getId());
        return updatedEntity;
    }

    public Driver addDriver(@PathVariable Long truckId, Driver driver) {
        log.debug("addDriver() - start: truckId = {}, driver = {}", truckId, driver);
        Driver truckDriver = truckRepository.findById(truckId)
                .map(truck -> {
                    driver.setTruck(truck);
                    return driverRepository.save(driver);
                })
                .orElseThrow(() -> new EntityNotFoundException("driver not found with id = " + truckId));
        log.info("addDriver() - end: truckDriver with id = {}", truckDriver.getId());
        return truckDriver;
    }

    @Override
    public void deleteById(Long id) {
        log.debug("deleteById() - start: id = {}", id);
        driverRepository.deleteById(id);
        log.debug("deleteById() - end");
    }
}
