package com.kaluzny.assistant.app.config;

import com.kaluzny.assistant.api.model.dto.TruckDto;
import com.kaluzny.assistant.app.domain.Truck;
import com.kaluzny.assistant.app.mappers.TruckMapper;
import ma.glasnost.orika.MapperFactory;
import net.rakugakibox.spring.boot.orika.OrikaMapperFactoryConfigurer;
import org.springframework.context.annotation.Configuration;

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
    }
}