package com.kaluzny.assistant.app.service.bean;

import com.kaluzny.assistant.app.domain.Truck;
import com.kaluzny.assistant.app.repository.TruckRepository;
import com.kaluzny.assistant.app.service.TruckService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

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
        log.debug("create() - end: entity = {}", entity);
        return entity;
    }

    @Override
    public Truck findById(Long id) {
        log.debug("findById() - start: id = {}", id);
        Truck entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity with id = Not found"));
        log.info("findById() - end: entity = {}", entity.getId());
        return entity;
    }
}
