package com.kaluzny.assistant.api.resource;

import com.kaluzny.assistant.api.model.dto.TruckDto;
import com.kaluzny.assistant.api.model.dto.TruckUpdateDto;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.constraints.NotNull;

/**
 * CRUD REST API service for microservice-assistant.
 *
 * @author Oleg Kaluzny
 */
@Api(value = "TruckResource", tags = "microservice-assistant")
@SwaggerDefinition(tags = @Tag(name = "microservice-assistant", description = "Resource interface for microservice-assistant"))
public interface TruckResource {

    /**
     * REST endpoint to create info about newly Truck.
     *
     * @param requestForSave info about a truck {@link TruckDto}
     * @return newly created info about a truck
     */
    @ApiOperation(value = "Endpoint to create Truck", response = TruckDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Truck is created"),
            @ApiResponse(code = 201, message = "Truck is created"),
            @ApiResponse(code = 201, message = " ")})
    TruckDto createTruck(
            @ApiParam("Truck") @NotNull @RequestBody TruckUpdateDto requestForSave);

    /**
     * REST endpoint to get Truck reference by id.
     *
     * @param id Truck reference's id.
     * @return searched Truck.
     */
    @ApiOperation(value = "Endpoint to get Truck by id", response = TruckDto.class)
    @ApiResponse(code = 200, message = "Truck received")
    TruckDto getTruckById(
            @ApiParam("Unique identifier a Truck") @PathVariable @NotNull Long id);

}
