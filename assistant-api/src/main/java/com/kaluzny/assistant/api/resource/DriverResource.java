package com.kaluzny.assistant.api.resource;

import com.kaluzny.assistant.api.model.dto.TruckDriverDto;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.annotations.*;
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
     * REST endpoint to create info about newly Truck.
     *
     * @param requestForSave {@link TruckDriverDto}
     * @return newly created info about a truck
     */
    @ApiOperation(value = "The endpoint to create a new driver for existing truck", response = TruckDriverDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Driver is created"),
            @ApiResponse(code = 201, message = " ")})
    TruckDriverDto addDriverForTruck(@ApiParam("Existing truck id.") @NotNull @PathVariable Long truckId,
                            @ApiParam("Driver dto") @NotNull @RequestBody TruckDriverDto requestForSave);
}
