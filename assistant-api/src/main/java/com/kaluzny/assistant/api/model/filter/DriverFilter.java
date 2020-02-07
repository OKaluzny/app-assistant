package com.kaluzny.assistant.api.model.filter;

import com.kaluzny.assistant.api.model.dto.TruckDriverDto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Describes filter model for {@link TruckDriverDto} page resource.
 *
 * @author Oleg Kaluzny
 */
@Data
@Accessors(chain = true)
public class DriverFilter {

    private String firstName;
    private String lastName;
}
