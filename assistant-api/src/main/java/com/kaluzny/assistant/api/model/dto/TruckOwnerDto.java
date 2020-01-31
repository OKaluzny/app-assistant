package com.kaluzny.assistant.api.model.dto;

import com.kaluzny.assistant.api.utils.DiffBuilderUtils;

import io.swagger.annotations.ApiModelProperty;
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
public class TruckOwnerDto implements Diffable<TruckOwnerDto> {

    @ApiModelProperty(value = "Unique identifier a owner.", example = "1", hidden = true)
    private Long id;

    @ApiModelProperty(value = "First name of an owner.", example = "Steven")
    private String firstName;

    @ApiModelProperty(value = "Last name of an owner.", example = "Mueller")
    private String lastName;

    @Override
    public DiffResult diff(TruckOwnerDto obj) {
        return DiffBuilderUtils.createBuilder(this, obj);
    }
}
