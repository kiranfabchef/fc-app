package com.fc.app.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fc.app.model.Chef;
import com.fc.app.model.ChefAvailability;
import com.fc.app.service.ChefAvailabilityService;
import com.fc.app.service.ChefCalendarService;
import com.fc.app.service.ChefService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/chef")
@Api(tags={ "chef" }, description="Operations pertaining to chef")
public class ChefController {
	
	@Autowired
	private ChefService chefService;
	
	@Autowired
	private ChefCalendarService calendarService;
	
	@Autowired
	private ChefAvailabilityService availabilityService;
	
	@ApiOperation(value = "Generate availability calendar of a chef", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully created calendar of a chef"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	@RequestMapping(path="/generate-calendar", method=RequestMethod.POST)
	public ResponseEntity<Boolean> generateChefAvailabilityCalendar(@RequestBody Long chefId) {
		ResponseEntity<Boolean> response = null;
		try {
		    calendarService.calculateAndPersistCalendar(chefId);
			response = new ResponseEntity<>(true, HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			response = new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);	
		}
		return response;
	}
	
	@ApiOperation(value = "Fetch the calendar of a chef", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully fetched chef availability calendar"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	@RequestMapping(path="/calendar/{chefId}", method=RequestMethod.POST)
	public ResponseEntity<List<ChefAvailability>> fetchChefAvailabilityCalendar(@PathVariable(name="chefId") Long chefId) {
		ResponseEntity<List<ChefAvailability>> response = null;
		List<ChefAvailability> chefAvailability = new ArrayList<>();
		try {
			chefAvailability = availabilityService.getAllAvailabilitiesForChef(chefId);
			response = new ResponseEntity<>(chefAvailability, HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			response = new ResponseEntity<>(chefAvailability, HttpStatus.INTERNAL_SERVER_ERROR);	
		}
		return response;
	}
	
	@ApiOperation(value = "Create a chef", response = Chef.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully created chef"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	@RequestMapping(path="/", method=RequestMethod.POST)
	public ResponseEntity<Chef> create(@RequestBody Chef chef) {
		ResponseEntity<Chef> response = null;
		try {
		    Chef chefModified = chefService.save(chef);
			response = new ResponseEntity<>(chefModified, HttpStatus.OK);
		}catch(Exception e) {
			response = new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);	
		}
		return response;
	}
	
	@ApiOperation(value = "Update the chef", response = Chef.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	@RequestMapping(path="/", method=RequestMethod.PUT)
	public ResponseEntity<Chef> update(@RequestBody Chef chef) {
		ResponseEntity<Chef> response = null;
		try {
		    Chef chefModified = chefService.save(chef);
			response = new ResponseEntity<>(chefModified, HttpStatus.OK);
		}catch(Exception e) {
			response = new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);	
		}
		return response;
	}
	
	@ApiOperation(value = "Fetch the chef by id", response = Chef.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	@RequestMapping(path="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Chef> getChef(@PathVariable("id") Long id) {
		ResponseEntity<Chef> response = null;
		Chef chef = null;
		try {
		    Optional<Chef> chefOptional = chefService.getChefById(id);
		    if(chefOptional.isPresent()) {
		    	chef = chefOptional.get();
		    }
			response = new ResponseEntity<>(chef, HttpStatus.OK);
		}catch(Exception e) {
			response = new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);	
		}
		return response;
	}
	
	@ApiOperation(value = "Fetch the list of chefs", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})

	@RequestMapping(path="/fetch-all", method=RequestMethod.GET)
	public ResponseEntity<List<Chef>> fetchAllChefs() {
		ResponseEntity<List<Chef>> response = null;
		List<Chef> chefList = null;
		
		try {
			chefList = chefService.getAllChefs();
			response = new ResponseEntity<>(chefList, HttpStatus.OK);
		}catch(Exception e) {
			response = new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}
	
	@ApiOperation(value = "Fetch the list of chefs for the given criteria", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})

	@RequestMapping(path="/search", method=RequestMethod.POST)
	public ResponseEntity<List<Chef>> fetchAllChefsByExample(@RequestBody Chef chef) {
		ResponseEntity<List<Chef>> response = null;
		List<Chef> chefList = chefService.getAllChefsByExample(chef);
		response = new ResponseEntity<>(chefList, HttpStatus.OK);
		return response;
	}
}
