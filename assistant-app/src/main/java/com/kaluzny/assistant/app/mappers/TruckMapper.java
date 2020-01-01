package com.kaluzny.assistant.app.mappers;

import com.kaluzny.assistant.api.model.dto.TruckDto;
import com.kaluzny.assistant.app.domain.Truck;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;

/**
 * TruckMapper.
 *
 * @author Oleg Kaluzny
 */
public class TruckMapper extends CustomMapper<Truck, TruckDto> {

    @Override
    public void mapBtoA(TruckDto dto,
                        Truck entity,
                        MappingContext context) {
        super.mapBtoA(dto, entity, context);
    }
}
