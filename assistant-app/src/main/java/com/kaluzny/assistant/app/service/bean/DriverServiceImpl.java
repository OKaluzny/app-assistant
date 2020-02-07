package com.kaluzny.assistant.app.service.bean;

import com.kaluzny.assistant.api.model.filter.DriverFilter;
import com.kaluzny.assistant.app.domain.Driver;
import com.kaluzny.assistant.app.repository.DriverRepository;
import com.kaluzny.assistant.app.repository.TruckRepository;
import com.kaluzny.assistant.app.service.DriverService;
import com.kaluzny.assistant.app.service.filter.DriverSpecificationBuilder;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

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
    private final DriverSpecificationBuilder driverSpecificationBuilder;

    @Override
    public Driver addDriver(Long truckId, Driver driver) {
        log.info("addDriver() - start: truckId = {}, driver = {}", truckId, driver);
        Driver truckDriver = truckRepository.findById(truckId)
                .map(truck -> {
                    driver.setTruck(truck);
                    return driverRepository.save(driver);
                })
                .orElseThrow(() -> new EntityNotFoundException("driver not found with id =" + driver.getId()));
        log.info("addDriver() - end: truckDriver with id = {}", truckDriver.getId());
        return truckDriver;
    }

    @Override
    public Page<Driver> getPage(Pageable pageable, DriverFilter filter) {
        log.debug("getPage() - start: pageable = {}, filter = {}", pageable, filter);
        Specification<Driver> specification = driverSpecificationBuilder.buildFilterSpec(filter);
        Page<Driver> page = driverRepository.findAll(specification, pageable);
        log.debug("getPage() - end: page = {}", page);
        return page;
    }

    @Override
    public Driver findById(Long id) {
        log.debug("findById() - start: id = {}", id);
        Driver driver = driverRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("driver not found with id = " + id));
        log.info("findById() - end: driver = {}", driver.getId());
        return driver;
    }

    @Override
    public Driver update(Long truckId, Driver driver) {
        log.debug("update() - start: truckId = {}, driver = {}", truckId, driver);
        Driver updatedDriver = truckRepository.findById(truckId)
                .map(truck -> {
                    driver.setTruck(truck);
                    driver.setFirstName(driver.getFirstName());
                    driver.setLastName(driver.getLastName());
                    return driverRepository.save(driver);
                })
                .orElseThrow(() -> new EntityNotFoundException("driver not found with id = " + driver.getId()));
        log.info("update() - end: entity = {}", updatedDriver.getId());
        return updatedDriver;
    }

    @Override
    public void deleteById(Long id) {
        log.debug("deleteById() - start: id = {}", id);
        driverRepository.deleteById(id);
        log.debug("deleteById() - end");
    }
}
