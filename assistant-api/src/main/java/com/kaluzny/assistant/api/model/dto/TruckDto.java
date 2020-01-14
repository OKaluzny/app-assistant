package com.kaluzny.assistant.api.model.dto;

import com.kaluzny.assistant.api.utils.DiffBuilderUtils;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.builder.DiffResult;
import org.apache.commons.lang3.builder.Diffable;

/**
 * Model of Truck
 *
 * @author Oleg Kaluzny
 */
@Getter
@Setter
@ToString
@Accessors(chain = true)
@Schema(name = "Truck DTO", description = "Transfer data object for a truck", oneOf = TruckDto.class)
public class TruckDto implements Diffable<TruckDto> {

    @Schema(description = "Unique identifier a Truck.", example = "7", required = true)
    private Long id;

    @Schema(description = "Manufacturer of a Truck.", example = "Volvo", required = true)
    @Size(max = 50)
    private String manufacturer;

    @Schema(description = "Model of a Truck.", example = "FH-16", required = true)
    @Size(max = 50)
    private String model;

    @Override
    public DiffResult diff(TruckDto obj) {
        return DiffBuilderUtils.createBuilder(this, obj);
    }
}
