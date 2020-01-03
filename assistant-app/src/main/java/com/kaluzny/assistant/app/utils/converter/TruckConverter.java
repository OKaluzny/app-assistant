package com.kaluzny.assistant.app.utils.converter;

import com.kaluzny.assistant.api.model.dto.TruckDto;
import com.kaluzny.assistant.app.domain.Truck;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Component;

/**
 * TruckInfoConverter.
 *
 * @author Oleg Kaluzny
 */
@Component
@RequiredArgsConstructor
@Getter
public class TruckConverter {

    private final MapperFacade mapperFacade;

    public TruckDto toDto(Truck entity) {
        return mapperFacade.map(entity, TruckDto.class);
    }

    public Truck fromDto(TruckDto dto) {
        return mapperFacade.map(dto, Truck.class);
    }
}
