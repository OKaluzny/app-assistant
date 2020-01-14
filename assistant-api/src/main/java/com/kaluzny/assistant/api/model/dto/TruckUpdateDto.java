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
 * @author Oleg Kaluzny
 */
@Getter
@Setter
@ToString
@Accessors(chain = true)
public class TruckUpdateDto implements Diffable<TruckUpdateDto> {

    @Schema(description = "Manufacturer of a Truck.", example = "Volvo", required = true)
    @Size(max = 50)
    private String manufacturer;

    @Schema(description = "Model of a Truck.", example = "FH-16", required = true)
    @Size(max = 50)
    private String model;

    @Override
    public DiffResult diff(TruckUpdateDto obj) {
        return DiffBuilderUtils.createBuilder(this, obj);
    }
}
