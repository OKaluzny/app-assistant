package com.kaluzny.assistant.api.model.dto;

import com.kaluzny.assistant.api.utils.DiffBuilderUtils;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.builder.DiffResult;
import org.apache.commons.lang3.builder.Diffable;

/**
 * Model response
 *
 * @author Oleg Kaluzny
 */
@Data
@Accessors(chain = true)
public class TruckResponseDto implements Diffable<TruckResponseDto> {

    @ApiModelProperty(value = "Manufacturer of a Truck.", required = true)
    private String manufacturer;

    @ApiModelProperty(value = "Model of a Truck.", required = true)
    private String model;

    @Override
    public DiffResult diff(TruckResponseDto obj) {
        return DiffBuilderUtils.createBuilder(this, obj);
    }
}
