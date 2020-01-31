package com.kaluzny.assistant.app.config;

import com.kaluzny.assistant.api.model.dto.TruckDriverDto;
import com.kaluzny.assistant.api.model.dto.TruckDto;
import com.kaluzny.assistant.app.domain.Truck;
import com.kaluzny.assistant.app.config.mapping.TruckMapper;
import com.kaluzny.assistant.app.domain.TruckDriver;

import org.springframework.context.annotation.Configuration;

import ma.glasnost.orika.MapperFactory;
import net.rakugakibox.spring.boot.orika.OrikaMapperFactoryConfigurer;

/**
 * Orika mapping config.
 *
 * @author Oleg Kaluzny
 */
@Configuration
public class MappingConfig implements OrikaMapperFactoryConfigurer {

    @Override
    public void configure(MapperFactory mapperFactory) {

        mapperFactory.classMap(Truck.class, TruckDto.class)
                .customize(new TruckMapper())
                .byDefault()
                .register();

        mapperFactory.classMap(TruckDriver.class, TruckDriverDto.class)
                .byDefault()
                .register();
    }
}
