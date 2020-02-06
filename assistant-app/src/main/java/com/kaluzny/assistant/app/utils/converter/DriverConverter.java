package com.kaluzny.assistant.app.utils.converter;

import com.kaluzny.assistant.api.model.dto.TruckDriverDto;
import com.kaluzny.assistant.app.domain.Driver;

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

    public TruckDriverDto toDto(Driver entity) {
        return mapperFacade.map(entity, TruckDriverDto.class);
    }
}
