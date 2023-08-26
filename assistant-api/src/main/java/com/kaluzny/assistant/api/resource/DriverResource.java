package com.kaluzny.assistant.api.resource;

import com.kaluzny.assistant.api.model.dto.DriverUpdateDto;
import com.kaluzny.assistant.api.model.dto.DriverDto;
import com.kaluzny.assistant.api.model.filter.DriverFilter;

import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collection;
import io.swagger.annotations.*;
import javax.validation.constraints.NotNull;

/**
 * CRUD REST API service for app-assistant.
 *
 * @author Oleg Kaluzny
 */
@Api(value = "DriverResource", tags = "app-assistant-driver")
@SwaggerDefinition(tags = @Tag(name = "app-assistant", description = "Resource interface for microservice-assistant"))
public interface DriverResource {

    /**
     * REST endpoint to create info about newly driver.
     *
     * @param requestForSave {@link DriverDto}
     * @return newly created info about a driver
     */
    @ApiOperation(value = "The endpoint to create a new driver for existing truck", response = DriverDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Driver is created"),
            @ApiResponse(code = 201, message = " ")})
    DriverDto addDriverForTruck(@ApiParam("Existing truck id.") @NotNull @PathVariable Long truckId,
                                @ApiParam("Driver dto") @NotNull @RequestBody DriverUpdateDto requestForSave);

    /**
     * REST endpoint to get driver reference by id.
     *
     * @param id driver reference's id.
     * @return searched driver.
     */
    @ApiOperation(value = "Endpoint to get driver by id", response = DriverDto.class)
    @ApiResponse(code = 200, message = "Success")
    DriverDto getDriverById(
            @ApiParam("Unique identifier a Driver") @NotNull Long id);

    /**
     * Pageable and filtered REST endpoint for drivers.
     *
     * @param pageable page details.
     * @param filter   filterable attributes.
     * @return searched drivers.
     */
    @ApiOperation(value = "Filterable and pageable endpoint for drivers", response = DriverDto.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", paramType = "query", value = "Results page you want to retrieve (1..N)."),
            @ApiImplicitParam(name = "count", paramType = "query", value = "Number of records per page."),
            @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query",
                    value = "Sorting criteria in the format: property (,asc|desc). Default sort order is ascending. "
                            + "Multiple sort criteria are supported.")
    })
    Collection<DriverDto> getPage(PageRequest pageable, DriverFilter filter);

    /**
     * REST endpoint to update driver by id.
     *
     * @param id               Driver's id.
     * @param requestForUpdate driver {@link DriverDto}.
     * @return updated driver.
     */
    @ApiOperation(value = "Endpoint to update driver", response = DriverDto.class)
    DriverDto updateDriver(
            @ApiParam("truck id") @NotNull Long truckId,
            @ApiParam("driver id") @NotNull Long id,
            @ApiParam("driver") @NotNull DriverUpdateDto requestForUpdate);

    /**
     * REST endpoint to remove driver.
     */
    @ApiOperation(value = "Endpoint to delete driver by id", response = DriverDto.class)
    void removeDriverById(
            @ApiParam("Driver id") @PathVariable @NotNull Long id);
}
