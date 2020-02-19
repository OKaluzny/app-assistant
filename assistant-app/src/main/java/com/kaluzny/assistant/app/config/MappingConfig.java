package com.kaluzny.assistant.app.config;

import com.kaluzny.assistant.api.model.dto.DriverDto;
import com.kaluzny.assistant.api.model.dto.TruckDto;
import com.kaluzny.assistant.app.domain.Truck;
import com.kaluzny.assistant.app.config.mapping.TruckMapper;
import com.kaluzny.assistant.app.domain.Driver;

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

        mapperFactory.classMap(Driver.class, DriverDto.class)
                .byDefault()
                .register();
    }
}
