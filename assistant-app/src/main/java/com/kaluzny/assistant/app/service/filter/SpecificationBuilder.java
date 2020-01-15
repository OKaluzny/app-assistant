package com.kaluzny.assistant.app.service.filter;

import com.kaluzny.assistant.api.model.filter.TruckFilter;
import com.kaluzny.assistant.app.domain.Truck;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

import static com.kaluzny.assistant.app.utils.TruckSpecifications.isManufacturer;
import static com.kaluzny.assistant.app.utils.TruckSpecifications.isModel;

/**
 * SpecificationBuilder
 *
 * @author Oleg Kaluzny
 */
@Component
@RequiredArgsConstructor
public class SpecificationBuilder {

    /**
     * Method return specification for {@link Truck}.
     *
     * @param filter filters to apply.
     * @return specification.
     */
    public Specification<Truck> buildFilterSpec(TruckFilter filter) {
        return Specification.<Truck>where(
                isManufacturer(filter.getManufacturer()))
                .and(isModel(filter.getModel()));
    }
}
