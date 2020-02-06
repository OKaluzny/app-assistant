package com.kaluzny.assistant.api.model.dto;

import com.kaluzny.assistant.api.utils.DiffBuilderUtils;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.builder.DiffResult;
import org.apache.commons.lang3.builder.Diffable;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * Model of Truck
 *
 * @author Oleg Kaluzny
 */
@Getter
@Setter
@ToString
@Accessors(chain = true)
public class TruckDto implements Diffable<TruckDto> {

    @ApiModelProperty(value = "Unique identifier a Truck.", example = "1")
    private Long id;

    @ApiModelProperty(value = "Created date.", example = "2020-01-31T10:23:09.287Z")
    private Instant createDate;

    @ApiModelProperty(value = "Manufacturer of a Truck.", example = "Volvo")
    private String manufacturer;

    @ApiModelProperty(value = "Model of a Truck.", example = "FH-16")
    private String model;

    @ApiModelProperty(value = "List of a truck drivers.", required = true)
    private List<TruckDriverDto> drivers = new ArrayList<>();

    @Override
    public DiffResult diff(TruckDto obj) {
        return DiffBuilderUtils.createBuilder(this, obj);
    }
}
