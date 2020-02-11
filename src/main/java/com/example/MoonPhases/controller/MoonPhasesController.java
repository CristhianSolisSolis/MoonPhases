package com.example.MoonPhases.controller;

import java.util.List;

import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.MoonPhases.dao.MoonPhasesResponse;
import com.example.MoonPhases.service.MoonPhasesService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(description = "Moon Phases API", name = "MoonPhasesController")
public class MoonPhasesController {
	
	@Autowired
	MoonPhasesService moonPhasesService;

	@GetMapping("NewMoons/{year}")
	@Produces(value = "application/json")
	@Operation(summary = "Find New Moon by year", tags = { "MoonPhasesController" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful Operation"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "500", description = "Internal Several Error")
            })	
	public List<String> newMoons(
			@Parameter(description="Year.Cannot be empty.", required=true) @PathVariable(value = "year") Long year){
		List<String> newMoons = moonPhasesService.newMoons(year);
		return newMoons;
	}
	
	@GetMapping("MoonPhases/{year}/{month}")
	@Produces(value = "application/json")
	@Operation(summary = "Find Moon Phases by year and month", tags = { "MoonPhasesController" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful Operation"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "500", description = "Internal Several Error")
            })	
	public MoonPhasesResponse moonPhases(
            @Parameter(description="Year.Cannot be empty.", required=true)@PathVariable(value = "year") Long year, 
            @Parameter(description="Month.Cannot be empty.", required=true)@PathVariable(value = "month") Long month){
		MoonPhasesResponse newMoons = moonPhasesService.moonPhases(year, month);
		return newMoons;
	}
	
}
