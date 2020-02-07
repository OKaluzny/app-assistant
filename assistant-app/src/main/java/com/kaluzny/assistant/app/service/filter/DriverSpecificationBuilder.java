package com.kaluzny.assistant.app.service.filter;

import com.kaluzny.assistant.api.model.filter.DriverFilter;
import com.kaluzny.assistant.app.domain.Driver;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

import static com.kaluzny.assistant.app.utils.DriverSpecifications.isFirstName;
import static com.kaluzny.assistant.app.utils.DriverSpecifications.isLastName;

/**
 * SpecificationBuilder
 *
 * @author Oleg Kaluzny
 */
@Component
@RequiredArgsConstructor
public class DriverSpecificationBuilder {

    /**
     * Method return specification for {@link Driver}.
     *
     * @param filter filters to apply.
     * @return specification.
     */
    public Specification<Driver> buildFilterSpec(DriverFilter filter) {
        return Specification.<Driver>where(
                isFirstName(filter.getFirstName()))
                .and(isLastName(filter.getLastName()));
    }
}
