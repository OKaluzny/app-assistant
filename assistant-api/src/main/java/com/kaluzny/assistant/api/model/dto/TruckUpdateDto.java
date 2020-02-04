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
 * @author Oleg Kaluzny
 */
@Getter
@Setter
@ToString
@Accessors(chain = true)
public class TruckUpdateDto implements Diffable<TruckUpdateDto> {

    @ApiModelProperty(value = "Created date.", example = "2020-01-31T10:23:09.287Z")
    private Instant createDate;

    @ApiModelProperty(value = "Manufacturer of a Truck.", example = "Volvo")
    private String manufacturer;

    @ApiModelProperty(value = "Model of a Truck.", example = "FH-16")
    private String model;

    @ApiModelProperty(value = "List of a truck drivers.", required = true)
    private List<TruckDriverDto> truckDrivers = new ArrayList<>();

    @ApiModelProperty(value = "Owner", required = true)
    private TruckOwnerDto truckOwner;

    @Override
    public DiffResult diff(TruckUpdateDto obj) {
        return DiffBuilderUtils.createBuilder(this, obj);
    }
}
