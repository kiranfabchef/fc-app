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

import com.fc.app.model.RefChefSlot;
import com.fc.app.model.RefCuisine;
import com.fc.app.model.RefPackageTypes;
import com.fc.app.model.RefPaymentMethods;
import com.fc.app.model.RefCategoryTypes;
import com.fc.app.model.RefStaticData;
import com.fc.app.model.RefVenueDetails;
import com.fc.app.service.RefCuisineService;
import com.fc.app.service.RefPackageTypesService;
import com.fc.app.service.RefPaymentMethodsService;
import com.fc.app.service.RefCategoryTypesService;
import com.fc.app.service.RefChefSlotService;
import com.fc.app.service.RefStaticDataService;
import com.fc.app.service.RefVenueDetailsService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/referential")

public class ReferentialController {

	@Autowired
	private RefCuisineService cuisineService;

	@Autowired
	private RefCategoryTypesService categoryTypesService;
	
	@Autowired
	private RefStaticDataService staticDataService;
	
	@Autowired
	private RefChefSlotService chefSlotService;
	
	@Autowired
	private RefVenueDetailsService venueService;
	
	@Autowired
	private RefPackageTypesService packageTypesService;
	
	@Autowired
	private RefPaymentMethodsService paymentMethodsService;
	
	//Payment Methods
	@ApiOperation(value = "create a payment method", response = RefPaymentMethods.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully created a payment method"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@RequestMapping(path = "/payment-methods", method = RequestMethod.POST)
	public ResponseEntity<RefPaymentMethods> create(@RequestBody RefPaymentMethods paymentMethods) {
		ResponseEntity<RefPaymentMethods> response = null;
		RefPaymentMethods paymentMethodCreated = paymentMethodsService.save(paymentMethods);
		response = new ResponseEntity<>(paymentMethodCreated , HttpStatus.OK);
		return response;
	}

	@ApiOperation(value = "Update the payment method", response = RefPaymentMethods.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully updated the payment method"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@RequestMapping(path = "/payment-methods", method = RequestMethod.PUT)
	public ResponseEntity<RefPaymentMethods> update(@RequestBody RefPaymentMethods venue) {
		ResponseEntity<RefPaymentMethods> response = null;
		RefPaymentMethods paymentMethodsModified = paymentMethodsService.save(venue);
		response = new ResponseEntity<>(paymentMethodsModified, HttpStatus.OK);
		return response;
	}

	@ApiOperation(value = "Fetch the payment method by id", response = RefPaymentMethods.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully fetched the venue"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@RequestMapping(path = "/payment-methods/{id}", method = RequestMethod.GET)
	public ResponseEntity<RefPaymentMethods> getPaymentMethod(@PathVariable("id") Long id) {
		ResponseEntity<RefPaymentMethods> response = null;
		RefPaymentMethods packageType = null;
		Optional<RefPaymentMethods> venueOptional = paymentMethodsService.getPaymentMethodById(id);
		if (venueOptional.isPresent()) {
			packageType = venueOptional.get();
		}
		response = new ResponseEntity<>(packageType, HttpStatus.OK);
		return response;
	}

	@ApiOperation(value = "Fetch the list of payment methods", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })

	@RequestMapping(path = "/payment-methods/fetch-all", method = RequestMethod.GET)
	public ResponseEntity<List<RefPaymentMethods>> fetchAllPaymentMethods() {
		ResponseEntity<List<RefPaymentMethods>> response = null;
		List<RefPaymentMethods> paymentMethods = paymentMethodsService.getAllPaymentMethods();
		response = new ResponseEntity<>(paymentMethods, HttpStatus.OK);
		return response;
	}

	@ApiOperation(value = "Fetch the list of payment methods for the given criteria", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })

	@RequestMapping(path = "/payment-methods/search", method = RequestMethod.POST)
	public ResponseEntity<List<RefPaymentMethods>> fetchAllPaymentMethods(
			@RequestBody RefPaymentMethods paymentMethod) {
		ResponseEntity<List<RefPaymentMethods>> response = null;
		List<RefPaymentMethods> paymentMethods = paymentMethodsService.getAllPaymentMethodsByExample(paymentMethod);
		response = new ResponseEntity<>(paymentMethods, HttpStatus.OK);
		return response;
	}
	
	//Package types
		@ApiOperation(value = "create a package type", response = RefPackageTypes.class)
		@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully created a package type"),
				@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
				@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
				@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
		@RequestMapping(path = "/package-types", method = RequestMethod.POST)
		public ResponseEntity<RefPackageTypes> create(@RequestBody RefPackageTypes packageType) {
			ResponseEntity<RefPackageTypes> response = null;
			RefPackageTypes packageTypeCreated = packageTypesService.save(packageType);
			response = new ResponseEntity<>(packageTypeCreated , HttpStatus.OK);
			return response;
		}

		@ApiOperation(value = "Update the package type", response = RefPackageTypes.class)
		@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully updated the package type"),
				@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
				@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
				@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
		@RequestMapping(path = "/package-types", method = RequestMethod.PUT)
		public ResponseEntity<RefPackageTypes> update(@RequestBody RefPackageTypes venue) {
			ResponseEntity<RefPackageTypes> response = null;
			RefPackageTypes packageTypesModified = packageTypesService.save(venue);
			response = new ResponseEntity<>(packageTypesModified, HttpStatus.OK);
			return response;
		}

		@ApiOperation(value = "Fetch the package type by id", response = RefVenueDetails.class)
		@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully fetched the venue"),
				@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
				@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
				@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
		@RequestMapping(path = "/package-types/{id}", method = RequestMethod.GET)
		public ResponseEntity<RefPackageTypes> getPackageType(@PathVariable("id") Long id) {
			ResponseEntity<RefPackageTypes> response = null;
			RefPackageTypes packageType = null;
			Optional<RefPackageTypes> venueOptional = packageTypesService.getPackageTypesById(id);
			if (venueOptional.isPresent()) {
				packageType = venueOptional.get();
			}
			response = new ResponseEntity<>(packageType, HttpStatus.OK);
			return response;
		}

		@ApiOperation(value = "Fetch the list of package type", response = Iterable.class)
		@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
				@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
				@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
				@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })

		@RequestMapping(path = "/package-types/fetch-all", method = RequestMethod.GET)
		public ResponseEntity<List<RefPackageTypes>> fetchAllPackageTypes() {
			ResponseEntity<List<RefPackageTypes>> response = null;
			List<RefPackageTypes> packageTypes = packageTypesService.getAllPackageTypes();
			response = new ResponseEntity<>(packageTypes, HttpStatus.OK);
			return response;
		}

		@ApiOperation(value = "Fetch the list of package type for the given criteria", response = Iterable.class)
		@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
				@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
				@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
				@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })

		@RequestMapping(path = "/package-types/search", method = RequestMethod.POST)
		public ResponseEntity<List<RefPackageTypes>> fetchAllPackageTypes(
				@RequestBody RefPackageTypes venue) {
			ResponseEntity<List<RefPackageTypes>> response = null;
			List<RefPackageTypes> packageTypes = packageTypesService.getAllPackageTypesByExample(venue);
			response = new ResponseEntity<>(packageTypes, HttpStatus.OK);
			return response;
		}
	
	//Venue details
	@ApiOperation(value = "create a venue", response = RefVenueDetails.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully created a venue"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@RequestMapping(path = "/venue-details", method = RequestMethod.POST)
	public ResponseEntity<RefVenueDetails> create(@RequestBody RefVenueDetails venue) {
		ResponseEntity<RefVenueDetails> response = null;
		RefVenueDetails venueCreated = venueService.save(venue);
		response = new ResponseEntity<>(venueCreated , HttpStatus.OK);
		return response;
	}

	@ApiOperation(value = "Update the venue", response = RefVenueDetails.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully updated the venue"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@RequestMapping(path = "/venue-details", method = RequestMethod.PUT)
	public ResponseEntity<RefVenueDetails> update(@RequestBody RefVenueDetails venue) {
		ResponseEntity<RefVenueDetails> response = null;
		RefVenueDetails venueModified = venueService.save(venue);
		response = new ResponseEntity<>(venueModified, HttpStatus.OK);
		return response;
	}

	@ApiOperation(value = "Fetch the venue by id", response = RefVenueDetails.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully fetched the venue"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@RequestMapping(path = "/venue-details/{id}", method = RequestMethod.GET)
	public ResponseEntity<RefVenueDetails> getVenue(@PathVariable("id") Long id) {
		ResponseEntity<RefVenueDetails> response = null;
		RefVenueDetails venue = null;
		Optional<RefVenueDetails> venueOptional = venueService.getVenueDetailsById(id);
		if (venueOptional.isPresent()) {
			venue = venueOptional.get();
		}
		response = new ResponseEntity<>(venue, HttpStatus.OK);
		return response;
	}

	@ApiOperation(value = "Fetch the list of venues", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })

	@RequestMapping(path = "/venue-details/fetch-all", method = RequestMethod.GET)
	public ResponseEntity<List<RefVenueDetails>> fetchAllVenues() {
		ResponseEntity<List<RefVenueDetails>> response = null;
		List<RefVenueDetails> chefSlotList = venueService.getAllVenueDetails();
		response = new ResponseEntity<>(chefSlotList, HttpStatus.OK);
		return response;
	}

	@ApiOperation(value = "Fetch the list of chef slots for the given criteria", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })

	@RequestMapping(path = "/venue-details/search", method = RequestMethod.POST)
	public ResponseEntity<List<RefVenueDetails>> fetchAllVenues(
			@RequestBody RefVenueDetails venue) {
		ResponseEntity<List<RefVenueDetails>> response = null;
		List<RefVenueDetails> venues = venueService.getAllVenueDetailsByExample(venue);
		response = new ResponseEntity<>(venues, HttpStatus.OK);
		return response;
	}
	
	//Chef slots
	@ApiIgnore
	@ApiOperation(value = "create chef slot", response = RefChefSlot.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully created chef slot"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@RequestMapping(path = "/chef-slot", method = RequestMethod.POST)
	public ResponseEntity<RefChefSlot> create(@RequestBody RefChefSlot chefSlot) {
		ResponseEntity<RefChefSlot> response = null;
		RefChefSlot chefSlotCreated = chefSlotService.save(chefSlot);
		response = new ResponseEntity<>(chefSlotCreated, HttpStatus.OK);
		return response;
	}

	@ApiIgnore
	@ApiOperation(value = "Update the chef slot", response = RefChefSlot.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully updated the chef slot"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@RequestMapping(path = "/chef-slot", method = RequestMethod.PUT)
	public ResponseEntity<RefChefSlot> update(@RequestBody RefChefSlot chefSlot) {
		ResponseEntity<RefChefSlot> response = null;
		RefChefSlot chefSlotModified = chefSlotService.save(chefSlot);
		response = new ResponseEntity<>(chefSlotModified, HttpStatus.OK);
		return response;
	}

	@ApiOperation(value = "Fetch the chef slot by id", response = RefChefSlot.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully fetched the chef slot"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@RequestMapping(path = "/chef-slot/{id}", method = RequestMethod.GET)
	public ResponseEntity<RefChefSlot> getChefSlot(@PathVariable("id") Long id) {
		ResponseEntity<RefChefSlot> response = null;
		RefChefSlot chefSlot = null;
		Optional<RefChefSlot> chefSlotOptional = chefSlotService.getChefSlotById(id);
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
	public ResponseEntity<List<RefChefSlot>> fetchAllChefSlots() {
		ResponseEntity<List<RefChefSlot>> response = null;
		List<RefChefSlot> chefSlotList = chefSlotService.getChefSlots();
		response = new ResponseEntity<>(chefSlotList, HttpStatus.OK);
		return response;
	}

	@ApiOperation(value = "Fetch the list of chef slots for the given criteria", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })

	@RequestMapping(path = "/chef-slots/search", method = RequestMethod.POST)
	public ResponseEntity<List<RefChefSlot>> fetchAllChefSlots(
			@RequestBody RefChefSlot chefSlot) {
		ResponseEntity<List<RefChefSlot>> response = null;
		List<RefChefSlot> chefSlots = chefSlotService.getAllChefSlotsByExample(chefSlot);
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
	@ApiOperation(value = "create cuisine", response = RefCuisine.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully created cuisine"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@RequestMapping(path = "/cuisine", method = RequestMethod.POST)
	public ResponseEntity<RefCuisine> create(@RequestBody RefCuisine cuisine) {
		ResponseEntity<RefCuisine> response = null;
		RefCuisine cuisineCreated = cuisineService.save(cuisine);
		response = new ResponseEntity<>(cuisineCreated, HttpStatus.OK);
		return response;
	}

	@ApiOperation(value = "Update the cuisine", response = RefCuisine.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully updated the cuisine"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@RequestMapping(path = "/cuisine", method = RequestMethod.PUT)
	public ResponseEntity<RefCuisine> update(@RequestBody RefCuisine cuisine) {
		ResponseEntity<RefCuisine> response = null;
		RefCuisine cuisineModified = cuisineService.save(cuisine);
		response = new ResponseEntity<>(cuisineModified, HttpStatus.OK);
		return response;
	}
	

	@ApiOperation(value = "Fetch the cuisine by id", response = RefCuisine.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully fetched the cuisine"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@RequestMapping(path = "/cuisine/{id}", method = RequestMethod.GET)
	public ResponseEntity<RefCuisine> getCuisine(@PathVariable("id") Long id) {
		ResponseEntity<RefCuisine> response = null;
		RefCuisine cuisine = null;
		Optional<RefCuisine> cuisineOptional = cuisineService.getCuisineById(id);
		if (cuisineOptional.isPresent()) {
			cuisine = cuisineOptional.get();
		}
		response = new ResponseEntity<>(cuisine, HttpStatus.OK);
		return response;
	}

	@ApiOperation(value = "Fetch the list of cuisines", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })

	@RequestMapping(path = "/cuisine/fetch-all", method = RequestMethod.GET)
	public ResponseEntity<List<RefCuisine>> fetchAllCuisines() {
		ResponseEntity<List<RefCuisine>> response = null;
		List<RefCuisine> cuisinesList = null;
		cuisinesList = cuisineService.getAllCuisines();
		response = new ResponseEntity<>(cuisinesList, HttpStatus.OK);
		return response;
	}

	@ApiOperation(value = "Fetch the list of cuisines for the given criteria", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })

	@RequestMapping(path = "/cuisines/search", method = RequestMethod.POST)
	public ResponseEntity<List<RefCuisine>> fetchAllChefsByExample(@RequestBody RefCuisine cuisine) {
		ResponseEntity<List<RefCuisine>> response = null;
		List<RefCuisine> chefList = cuisineService.getAllCuisinesByExample(cuisine);
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
