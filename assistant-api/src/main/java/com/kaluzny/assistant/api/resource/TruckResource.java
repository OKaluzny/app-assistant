package com.kaluzny.assistant.api.resource;

import com.kaluzny.assistant.api.model.dto.TruckDto;
import com.kaluzny.assistant.api.model.dto.TruckUpdateDto;

import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collection;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import javax.validation.constraints.NotNull;

/**
 * CRUD REST API service for microservice-assistant.
 *
 * @author Oleg Kaluzny
 */
@Tag(name = "microservice-assistant", description = "microservice-assistant API")
public interface TruckResource {

    /**
     * REST endpoint to create info about newly Truck.
     *
     * @param requestForSave info about a truck {@link TruckDto}
     * @return newly created info about a truck
     */
    @Operation(summary = "Endpoint to create a Truck", description = "creating an entity", tags = {"microservice-assistant"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Truck is created"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "409", description = "Truck already exists")})
    TruckDto createTruck(
            @Parameter(description = "Truck", required = true) @NotNull @RequestBody TruckUpdateDto requestForSave);

    /**
     * REST endpoint to get Truck reference by id.
     *
     * @param id Truck reference's id.
     * @return searched Truck.
     */
    @Operation(summary = "Endpoint to get Truck by id", description = "Returns a single entity", tags = {"microservice-assistant"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(schema = @Schema(implementation = TruckDto.class))),
            @ApiResponse(responseCode = "404", description = "Truck not found")})
    TruckDto getTruckById(
            @Parameter(description = "Unique identifier a Truck", required = true)
            @PathVariable @NotNull Long id);

    /**
     * Pageable REST endpoint for trucks.
     *
     * @param pageable page details.
     * @return searched documents.
     */
    @Operation(summary = "a pageable endpoint to get an existing Trucks", description = "need to fill", tags = {"microservice-assistant"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Truck get",
                    content = @Content(schema = @Schema(implementation = TruckDto.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input")})
    Collection<TruckDto> getPage(
            @Parameter(description = "pageable", required = true) PageRequest pageable);

    /**
     * REST endpoint to update Truck by id.
     *
     * @param id               Truck's id.
     * @param requestForUpdate truck {@link TruckUpdateDto}.
     * @return updated truck.
     */
    @Operation(summary = "Endpoint to update an existing a Truck", description = "need to fill", tags = {"microservice-assistant"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation"),
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
            @ApiResponse(responseCode = "404", description = "Automobile not found"),
            @ApiResponse(responseCode = "405", description = "Validation exception")})
    TruckDto updateTruck(
            @Parameter(description = "Id of a Truck to be update. Cannot be empty.", required = true)
            @NotNull @PathVariable Long id,
            @Parameter(description = "Truck to update.", required = true)
            @NotNull @RequestBody TruckUpdateDto requestForUpdate);

    /**
     * REST endpoint to delete Truck.
     *
     * @return deleted truck.
     */
    @Operation(summary = "Endpoint to delete a Truck by id", description = "need to fill", tags = {"microservice-assistant"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation"),
            @ApiResponse(responseCode = "404", description = "truck not found")})
    void deleteTruckById(
            @Parameter(description = "Id of a TRuck to be delete. Cannot be empty.", required = true)
            @NotNull @PathVariable Long id);
}
