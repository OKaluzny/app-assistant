package com.kaluzny.assistant.api.model.dto;

import com.kaluzny.assistant.api.utils.DiffBuilderUtils;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.builder.DiffResult;
import org.apache.commons.lang3.builder.Diffable;

/**
 * Model of Address
 *
 * @author Oleg Kaluzny
 */
@Data
@Accessors(chain = true)
public class AddressUpdateDto implements Diffable<AddressUpdateDto> {

    @ApiModelProperty(value = "active address of an employee.", example = "true")
    private Boolean addressHasActive;

    @ApiModelProperty(value = "country of an employee.", example = "Ukraine")
    private String country;

    @ApiModelProperty(value = "city of an employee.", example = "Odessa")
    private String city;

    @ApiModelProperty(value = "street of an employee.", example = "French Boulevard")
    private String street;

    @Override
    public DiffResult diff(AddressUpdateDto obj) {
        return DiffBuilderUtils.createBuilder(this, obj);
    }
}
