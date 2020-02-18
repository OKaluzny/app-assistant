package com.kaluzny.assistant.api.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kaluzny.assistant.api.utils.DiffBuilderUtils;

import java.util.ArrayList;
import java.util.List;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.builder.DiffResult;
import org.apache.commons.lang3.builder.Diffable;

/**
 * Model of Driver
 *
 * @author Oleg Kaluzny
 */
@Getter
@Setter
@ToString
@Accessors(chain = true)
public class DriverUpdateDto implements Diffable<DriverUpdateDto> {

    @ApiModelProperty(value = "First name of a driver.", example = "Jack")
    private String firstName;

    @ApiModelProperty(value = "Last name of a driver.", example = "Martens")
    private String lastName;

    @ApiModelProperty(value = "Model of truck.", example = "truck Martens")
    @JsonIgnore
    private TruckDto truck;

    @ApiModelProperty(value = "List of a addresses.", required = true)
    private List<AddressDto> addresses = new ArrayList<>();

    @Override
    public DiffResult diff(DriverUpdateDto obj) {
        return DiffBuilderUtils.createBuilder(this, obj);
    }
}
