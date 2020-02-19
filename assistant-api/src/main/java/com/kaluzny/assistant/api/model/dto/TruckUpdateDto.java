package com.kaluzny.assistant.api.model.dto;

import com.kaluzny.assistant.api.utils.DiffBuilderUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.builder.DiffResult;
import org.apache.commons.lang3.builder.Diffable;

/**
 * @author Oleg Kaluzny
 */
@Data
@Accessors(chain = true)
public class TruckUpdateDto implements Diffable<TruckUpdateDto> {

    @ApiModelProperty(value = "Created date.", example = "2020-01-31T10:47:08.3967422")
    private LocalDateTime createDate;

    @ApiModelProperty(value = "Manufacturer of a Truck.", example = "Volvo")
    private String manufacturer;

    @ApiModelProperty(value = "Model of a Truck.", example = "FH-16")
    private String model;

    @ApiModelProperty(value = "List of a truck drivers.", required = true)
    private List<TruckDriverDto> drivers = new ArrayList<>();

    @ApiModelProperty(value = "Owner", required = true)
    private OwnerDto truckOwner;

    @Override
    public DiffResult diff(TruckUpdateDto obj) {
        return DiffBuilderUtils.createBuilder(this, obj);
    }
}
