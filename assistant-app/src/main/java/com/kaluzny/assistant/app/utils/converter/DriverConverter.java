package com.kaluzny.assistant.app.utils.converter;

import com.kaluzny.assistant.api.model.dto.TruckDriverDto;
import com.kaluzny.assistant.api.model.dto.TruckDto;
import com.kaluzny.assistant.app.domain.Truck;
import com.kaluzny.assistant.app.domain.TruckDriver;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ma.glasnost.orika.MapperFacade;

/**
 * TruckInfoConverter.
 *
 * @author Oleg Kaluzny
 */
@Component
@RequiredArgsConstructor
@Getter
public class DriverConverter {

    private final MapperFacade mapperFacade;

    public TruckDriverDto toDto(TruckDriver entity) {
        return mapperFacade.map(entity, TruckDriverDto.class);
    }
}
