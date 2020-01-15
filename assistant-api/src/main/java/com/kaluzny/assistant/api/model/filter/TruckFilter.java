package com.kaluzny.assistant.api.model.filter;

import com.kaluzny.assistant.api.model.dto.TruckResponseDto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Describes filter model for {@link TruckResponseDto} page resource.
 *
 * @author Oleg Kaluzny
 */
@Data
@Accessors(chain = true)
public class TruckFilter {

    private String manufacturer;
    private String model;
}
