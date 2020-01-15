package com.kaluzny.assistant.api.resource;

import com.kaluzny.assistant.api.model.dto.TruckDto;
import com.kaluzny.assistant.api.model.dto.TruckUpdateDto;
import com.kaluzny.assistant.api.model.filter.TruckFilter;
import io.swagger.annotations.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.constraints.NotNull;
import java.util.Collection;

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
    @ApiResponse(code = 200, message = "Success")
    TruckDto getTruckById(
            @ApiParam("Unique identifier a Truck") @PathVariable @NotNull Long id);

    /**
     * Pageable and filtered REST endpoint for trucks.
     *
     * @param pageable page details.
     * @param filter   filterable attributes.
     * @return searched trucks.
     */
    @ApiOperation(value = "Filterable and pageable endpoint for trucks", response = TruckDto.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", paramType = "query", value = "Results page you want to retrieve (1..N)."),
            @ApiImplicitParam(name = "count", paramType = "query", value = "Number of records per page."),
            @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query",
                    value = "Sorting criteria in the format: property (,asc|desc). Default sort order is ascending. "
                            + "Multiple sort criteria are supported.")
    })
    Collection<TruckDto> getPage(PageRequest pageable, TruckFilter filter);

    /**
     * REST endpoint to update Truck by id.
     *
     * @param id               Truck's id.
     * @param requestForUpdate truck {@link TruckDto}.
     * @return updated truck.
     */
    @ApiOperation(value = "Endpoint to update Truck", response = TruckDto.class)
    TruckDto updateTruck(
            @ApiParam("Truck id") @NotNull Long id,
            @ApiParam("Truck") @NotNull TruckUpdateDto requestForUpdate);

    /**
     * REST endpoint to delete Truck.
     *
     * @return deleted truck.
     */
    @ApiOperation(value = "Endpoint to delete Truck by id", response = TruckDto.class)
    void deleteTruckById(
            @ApiParam("Truck id") @PathVariable @NotNull Long id);

}
