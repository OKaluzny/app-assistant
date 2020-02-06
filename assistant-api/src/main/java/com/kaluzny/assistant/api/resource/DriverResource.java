package com.kaluzny.assistant.api.resource;

import com.kaluzny.assistant.api.model.dto.DriverUpdateDto;
import com.kaluzny.assistant.api.model.dto.TruckDriverDto;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.constraints.NotNull;

/**
 * CRUD REST API service for microservice-assistant.
 *
 * @author Oleg Kaluzny
 */
@Api(value = "DriverResource", tags = "microservice-assistant-driver")
@SwaggerDefinition(tags = @Tag(name = "microservice-assistant", description = "Resource interface for microservice-assistant"))
public interface DriverResource {

    /**
     * REST endpoint to create info about newly driver.
     *
     * @param requestForSave {@link TruckDriverDto}
     * @return newly created info about a driver
     */
    @ApiOperation(value = "The endpoint to create a new driver for existing truck", response = TruckDriverDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Driver is created"),
            @ApiResponse(code = 201, message = " ")})
    TruckDriverDto addDriverForTruck(@ApiParam("Existing truck id.") @NotNull @PathVariable Long truckId,
                                     @ApiParam("Driver dto") @NotNull @RequestBody DriverUpdateDto requestForSave);

    /**
     * REST endpoint to get driver reference by id.
     *
     * @param id driver reference's id.
     * @return searched driver.
     */
    @ApiOperation(value = "Endpoint to get driver by id", response = TruckDriverDto.class)
    @ApiResponse(code = 200, message = "Success")
    TruckDriverDto getDriverById(
            @ApiParam("Unique identifier a Driver") @NotNull Long id);

    /**
     * REST endpoint to update driver by id.
     *
     * @param id               Driver's id.
     * @param requestForUpdate driver {@link TruckDriverDto}.
     * @return updated driver.
     */
    @ApiOperation(value = "Endpoint to update driver", response = TruckDriverDto.class)
    TruckDriverDto updateDriver(
            @ApiParam("driver id") @NotNull Long id,
            @ApiParam("driver") @NotNull DriverUpdateDto requestForUpdate);

    /**
     * REST endpoint to remove driver.
     *
     * @return deleted driver.
     */
    @ApiOperation(value = "Endpoint to delete driver by id", response = TruckDriverDto.class)
    void removeDriverById(
            @ApiParam("Driver id") @PathVariable @NotNull Long id);
}
