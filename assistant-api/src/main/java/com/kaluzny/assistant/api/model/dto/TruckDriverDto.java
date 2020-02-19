package com.kaluzny.assistant.api.model.dto;

import com.kaluzny.assistant.api.utils.DiffBuilderUtils;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.builder.DiffResult;
import org.apache.commons.lang3.builder.Diffable;

/**
 * Model of Driver
 *
 * @author Oleg Kaluzny
 */
@Data
@Accessors(chain = true)
public class TruckDriverDto implements Diffable<TruckDriverDto> {

    @ApiModelProperty(value = "Unique identifier a driver.", example = "1", hidden = true)
    private Long id;

    @ApiModelProperty(value = "First name of a driver.", example = "Max")
    private String firstName;

    @ApiModelProperty(value = "Last name of a driver.", example = "Martens")
    private String lastName;

    @ApiModelProperty(value = "Model of truck.", example = "truck Martens")
    @JsonIgnore
    private TruckDto truck;

    @ApiModelProperty(value = "List of a addresses.", required = true)
    private List<AddressDto> addresses = new ArrayList<>();

    @Override
    public DiffResult diff(TruckDriverDto obj) {
        return DiffBuilderUtils.createBuilder(this, obj);
    }
}
