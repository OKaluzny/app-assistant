package com.kaluzny.assistant.app.service.bean;

import com.kaluzny.assistant.app.domain.Truck;
import com.kaluzny.assistant.app.repository.TruckRepository;
import com.kaluzny.assistant.app.service.TruckService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
public class TruckServiceImpl implements TruckService {

    private final TruckRepository repository;

    @Override
    public Truck create(Truck requestForSave) {
        log.debug("create() - start: requestForSave = {}", requestForSave);
        Truck entity = repository.save(requestForSave);
        log.info("create() - end: entity = {}", entity);
        return entity;
    }

    @Override
    public Page<Truck> getPage(Pageable pageable) {
        log.debug("getPage() - start: pageable = {}", pageable);
        Page<Truck> page = repository.findAll(pageable);
        log.debug("getPage() - end: page = {}", page);
        return page;
    }

    @Override
    public Truck findById(Long id) {
        log.debug("findById() - start: id = {}", id);
        Truck entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity with id = Not found"));
        log.info("findById() - end: entity = {}", entity.getId());
        return entity;
    }

    @Override
    public Truck update(Truck truck) {
        log.debug("update() - start: truck = {}", truck);
        Truck updatedEntity = repository.findById(truck.getId())
                .map(entity -> {
                    entity.setManufacturer(truck.getManufacturer());
                    entity.setModel(truck.getModel());
                    return repository.save(entity);
                })
                .orElseThrow(() -> new EntityNotFoundException("truck with id = Not found"));
        log.info("update() - end: entity = {}", updatedEntity.getId());
        return updatedEntity;
    }

    @Override
    public void deleteById(Long id) {
        log.debug("deleteById() - start: id = {}", id);
        repository.deleteById(id);
        log.debug("deleteById() - end");
    }
}
