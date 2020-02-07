package com.kaluzny.assistant.app.utils;

import org.springframework.data.jpa.domain.Specification;

import java.util.Optional;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

/**
 * TruckSpecifications
 *
 * @author Oleg Kaluzny
 */
@Slf4j
@UtilityClass
public class DriverSpecifications {

    private static final String FIRST_NAME = "firstName";
    private static final String LAST_NAME = "lastName";

    public static <T> Specification<T> isFirstName(String firstName) {

        return (root, query, criteriaBuilder) -> Optional.ofNullable(firstName)
                .map(value -> criteriaBuilder.equal(root.get(FIRST_NAME), value))
                .orElse(null);
    }

    public static <T> Specification<T> isLastName(String lastName) {

        return (root, query, criteriaBuilder) -> Optional.ofNullable(lastName)
                .map(value -> criteriaBuilder.equal(root.get(LAST_NAME), value))
                .orElse(null);
    }
}
