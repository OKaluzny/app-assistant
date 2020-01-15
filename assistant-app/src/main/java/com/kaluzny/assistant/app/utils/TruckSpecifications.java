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
public class TruckSpecifications {

    private static final String MANUFACTURER = "manufacturer";
    private static final String MODEL = "model";

    public static <T> Specification<T> isManufacturer(String manufacturer) {

        return (root, query, criteriaBuilder) -> Optional.ofNullable(manufacturer)
                .map(value -> criteriaBuilder.equal(root.get(MANUFACTURER), value))
                .orElse(null);
    }

    public static <T> Specification<T> isModel(String model) {

        return (root, query, criteriaBuilder) -> Optional.ofNullable(model)
                .map(value -> criteriaBuilder.equal(root.get(MODEL), value))
                .orElse(null);
    }
}
