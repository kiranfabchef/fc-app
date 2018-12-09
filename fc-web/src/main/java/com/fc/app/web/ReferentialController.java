package com.fc.app.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fc.app.model.ChefSlot;
import com.fc.app.model.Cuisine;
import com.fc.app.model.RefCategoryTypes;
import com.fc.app.model.RefStaticData;
import com.fc.app.service.CuisineService;
import com.fc.app.service.RefCategoryTypesService;
import com.fc.app.service.RefChefSlotService;
import com.fc.app.service.RefStaticDataService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/referential")

public class ReferentialController {

	@Autowired
	private CuisineService cuisineService;

	@Autowired
	private RefCategoryTypesService categoryTypesService;
	
	@Autowired
	private RefStaticDataService staticDataService;
	
	@Autowired
	private RefChefSlotService chefSlotService;
	
	//Chef slots
	@ApiIgnore
	@ApiOperation(value = "create chef slot", response = ChefSlot.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully created chef slot"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@RequestMapping(path = "/chef-slot", method = RequestMethod.POST)
	public ResponseEntity<ChefSlot> create(@RequestBody ChefSlot chefSlot) {
		ResponseEntity<ChefSlot> response = null;
		ChefSlot chefSlotCreated = chefSlotService.save(chefSlot);
		response = new ResponseEntity<>(chefSlotCreated, HttpStatus.OK);
		return response;
	}

	@ApiIgnore
	@ApiOperation(value = "Update the chef slot", response = ChefSlot.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully updated the chef slot"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@RequestMapping(path = "/chef-slot", method = RequestMethod.PUT)
	public ResponseEntity<ChefSlot> update(@RequestBody ChefSlot chefSlot) {
		ResponseEntity<ChefSlot> response = null;
		ChefSlot chefSlotModified = chefSlotService.save(chefSlot);
		response = new ResponseEntity<>(chefSlotModified, HttpStatus.OK);
		return response;
	}

	@ApiOperation(value = "Fetch the chef slot by id", response = ChefSlot.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully fetched the chef slot"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@RequestMapping(path = "/chef-slot/{id}", method = RequestMethod.GET)
	public ResponseEntity<ChefSlot> getChefSlot(@PathVariable("id") Long id) {
		ResponseEntity<ChefSlot> response = null;
		ChefSlot chefSlot = null;
		Optional<ChefSlot> chefSlotOptional = chefSlotService.getChefSlotById(id);
		if (chefSlotOptional.isPresent()) {
			chefSlot = chefSlotOptional.get();
		}
		response = new ResponseEntity<>(chefSlot, HttpStatus.OK);
		return response;
	}

	@ApiOperation(value = "Fetch the list of chef slots", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })

	@RequestMapping(path = "/chef-slot/fetch-all", method = RequestMethod.GET)
	public ResponseEntity<List<ChefSlot>> fetchAllChefSlots() {
		ResponseEntity<List<ChefSlot>> response = null;
		List<ChefSlot> chefSlotList = chefSlotService.getChefSlots();
		response = new ResponseEntity<>(chefSlotList, HttpStatus.OK);
		return response;
	}

	@ApiOperation(value = "Fetch the list of chef slots for the given criteria", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })

	@RequestMapping(path = "/chef-slots/search", method = RequestMethod.POST)
	public ResponseEntity<List<ChefSlot>> fetchAllChefSlots(
			@RequestBody ChefSlot chefSlot) {
		ResponseEntity<List<ChefSlot>> response = null;
		List<ChefSlot> chefSlots = chefSlotService.getAllChefSlotsByExample(chefSlot);
		response = new ResponseEntity<>(chefSlots, HttpStatus.OK);
		return response;
	}
	
	//Category types
	@ApiOperation(value = "create category type", response = RefCategoryTypes.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully created cuisine"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@RequestMapping(path = "/category-types", method = RequestMethod.POST)
	public ResponseEntity<RefCategoryTypes> create(@RequestBody RefCategoryTypes refCategoryType) {
		ResponseEntity<RefCategoryTypes> response = null;
		RefCategoryTypes refCategoryTypeCreated = categoryTypesService.save(refCategoryType);
		response = new ResponseEntity<>(refCategoryTypeCreated, HttpStatus.OK);
		return response;
	}

	@ApiOperation(value = "Update the category type", response = RefCategoryTypes.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully updated the cuisine"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@RequestMapping(path = "/category-types", method = RequestMethod.PUT)
	public ResponseEntity<RefCategoryTypes> update(@RequestBody RefCategoryTypes refCategoryType) {
		ResponseEntity<RefCategoryTypes> response = null;
		RefCategoryTypes refCategoryTypeModified = categoryTypesService.save(refCategoryType);
		response = new ResponseEntity<>(refCategoryTypeModified, HttpStatus.OK);
		return response;
	}

	@ApiOperation(value = "Fetch the category type by id", response = RefCategoryTypes.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully fetched the cuisine"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@RequestMapping(path = "/category-types/{id}", method = RequestMethod.GET)
	public ResponseEntity<RefCategoryTypes> getCategoryType(@PathVariable("id") Long id) {
		ResponseEntity<RefCategoryTypes> response = null;
		RefCategoryTypes categoryType = null;
		Optional<RefCategoryTypes> categoryTypeOptional = categoryTypesService.getRefCategoryTypeById(id);
		if (categoryTypeOptional.isPresent()) {
			categoryType = categoryTypeOptional.get();
		}
		response = new ResponseEntity<>(categoryType, HttpStatus.OK);
		return response;
	}

	@ApiOperation(value = "Fetch the list of category types", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })

	@RequestMapping(path = "/category-types/fetch-all", method = RequestMethod.GET)
	public ResponseEntity<List<RefCategoryTypes>> fetchAllCategoryTypes() {
		ResponseEntity<List<RefCategoryTypes>> response = null;
		List<RefCategoryTypes> refCategoryTypesList = null;
		refCategoryTypesList = categoryTypesService.getAllCategoryTypes();
		response = new ResponseEntity<>(refCategoryTypesList, HttpStatus.OK);
		return response;
	}

	@ApiOperation(value = "Fetch the list of category types for the given criteria", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })

	@RequestMapping(path = "/category-types/search", method = RequestMethod.POST)
	public ResponseEntity<List<RefCategoryTypes>> fetchAllCategoryTypesByExample(
			@RequestBody RefCategoryTypes refCategoryType) {
		ResponseEntity<List<RefCategoryTypes>> response = null;
		List<RefCategoryTypes> refCategoryTypes = categoryTypesService.getAllRefCategoryTypesByExample(refCategoryType);
		response = new ResponseEntity<>(refCategoryTypes, HttpStatus.OK);
		return response;
	}

	// Cuisine
	@ApiIgnore
	@ApiOperation(value = "create cuisine", response = Cuisine.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully created cuisine"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@RequestMapping(path = "/cuisine", method = RequestMethod.POST)
	public ResponseEntity<Cuisine> create(@RequestBody Cuisine cuisine) {
		ResponseEntity<Cuisine> response = null;
		Cuisine cuisineCreated = cuisineService.save(cuisine);
		response = new ResponseEntity<>(cuisineCreated, HttpStatus.OK);
		return response;
	}

	@ApiIgnore
	@ApiOperation(value = "Update the cuisine", response = Cuisine.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully updated the cuisine"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@RequestMapping(path = "/cuisine", method = RequestMethod.PUT)
	public ResponseEntity<Cuisine> update(@RequestBody Cuisine cuisine) {
		ResponseEntity<Cuisine> response = null;
		Cuisine cuisineModified = cuisineService.save(cuisine);
		response = new ResponseEntity<>(cuisineModified, HttpStatus.OK);
		return response;
	}
	

	@ApiIgnore
	@ApiOperation(value = "Fetch the cuisine by id", response = Cuisine.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully fetched the cuisine"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@RequestMapping(path = "/cuisine/{id}", method = RequestMethod.GET)
	public ResponseEntity<Cuisine> getCuisine(@PathVariable("id") Long id) {
		ResponseEntity<Cuisine> response = null;
		Cuisine cuisine = null;
		Optional<Cuisine> cuisineOptional = cuisineService.getCuisineById(id);
		if (cuisineOptional.isPresent()) {
			cuisine = cuisineOptional.get();
		}
		response = new ResponseEntity<>(cuisine, HttpStatus.OK);
		return response;
	}

	@ApiIgnore
	@ApiOperation(value = "Fetch the list of cuisines", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })

	@RequestMapping(path = "/cuisine/fetch-all", method = RequestMethod.GET)
	public ResponseEntity<List<Cuisine>> fetchAllCuisines() {
		ResponseEntity<List<Cuisine>> response = null;
		List<Cuisine> cuisinesList = null;
		cuisinesList = cuisineService.getAllCuisines();
		response = new ResponseEntity<>(cuisinesList, HttpStatus.OK);
		return response;
	}

	@ApiIgnore
	@ApiOperation(value = "Fetch the list of cuisines for the given criteria", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })

	@RequestMapping(path = "/cuisines/search", method = RequestMethod.POST)
	public ResponseEntity<List<Cuisine>> fetchAllChefsByExample(@RequestBody Cuisine cuisine) {
		ResponseEntity<List<Cuisine>> response = null;
		List<Cuisine> chefList = cuisineService.getAllCuisinesByExample(cuisine);
		response = new ResponseEntity<>(chefList, HttpStatus.OK);
		return response;
	}
	
	//Static data
	@ApiOperation(value = "create Static data", response = RefStaticData.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully created Static data"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@RequestMapping(path = "/static-data", method = RequestMethod.POST, produces= {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<RefStaticData> create(@RequestBody RefStaticData refStaticData) {
		ResponseEntity<RefStaticData> response = null;
		RefStaticData refStaticDataCreated = staticDataService.save(refStaticData);
		response = new ResponseEntity<>(refStaticDataCreated, HttpStatus.OK);
		return response;
	}

	@ApiOperation(value = "Update the Static data", response = RefStaticData.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully updated the Static data"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@RequestMapping(path = "/static-data", method = RequestMethod.PUT, produces= {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<RefStaticData> update(@RequestBody RefStaticData refStaticData) {
		ResponseEntity<RefStaticData> response = null;
		RefStaticData refStaticDataModified = staticDataService.save(refStaticData);
		response = new ResponseEntity<>(refStaticDataModified, HttpStatus.OK);
		return response;
	}

	@ApiOperation(value = "Fetch the Static data by id", response = RefStaticData.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully fetched the Static data"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@RequestMapping(path = "/static-data/{id}", method = RequestMethod.GET, produces= {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<RefStaticData> getStaticData(@PathVariable("id") Long id) {
		ResponseEntity<RefStaticData> response = null;
		RefStaticData staticData = null;
		Optional<RefStaticData> staticDataOptional = staticDataService.getRefStaticDataById(id);
		if (staticDataOptional.isPresent()) {
			staticData = staticDataOptional.get();
		}
		response = new ResponseEntity<>(staticData, HttpStatus.OK);
		return response;
	}

	@ApiOperation(value = "Fetch the list of Static data", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })

	@RequestMapping(path = "/static-data/fetch-all", method = RequestMethod.GET, produces= {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<List<RefStaticData>> fetchAllStaticData() {
		ResponseEntity<List<RefStaticData>> response = null;
		List<RefStaticData> refStaticDataList = staticDataService.getAllStaticData();
		response = new ResponseEntity<>(refStaticDataList, HttpStatus.OK);
		return response;
	}

	@ApiOperation(value = "Fetch the list of category types for the given criteria", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })

	@RequestMapping(path = "/static-data/search", method = RequestMethod.POST, produces= {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<List<RefStaticData>> fetchAllStaticDataByExample(
			@RequestBody RefStaticData refStaticData) {
		ResponseEntity<List<RefStaticData>> response = null;
		List<RefStaticData> refStaticDataResult = staticDataService.getAllRefStaticDataListByExample(refStaticData);
		response = new ResponseEntity<>(refStaticDataResult, HttpStatus.OK);
		return response;
	}
}
