package com.kaluzny.assistant.api.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @author Oleg Kaluzny
 */
@Getter
@Setter
@ToString
@Accessors(chain = true)
public class TruckUpdateDto {

    @ApiModelProperty(value = "Manufacturer of a Truck.", position = 2)
    private String manufacturer;

    @ApiModelProperty(value = "Model of a Truck.", required = true)
    private String model;
}
