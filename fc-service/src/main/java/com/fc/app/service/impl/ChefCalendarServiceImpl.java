package com.fc.app.service.impl;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fc.app.ChefNotFoundException;
import com.fc.app.FcServicesValidationFailureException;
import com.fc.app.model.Chef;
import com.fc.app.model.ChefAvailability;
import com.fc.app.model.RefChefSlot;
import com.fc.app.service.ChefAvailabilityService;
import com.fc.app.service.ChefCalendarService;
import com.fc.app.service.ChefService;
import com.fc.app.service.RefChefSlotService;

@Service
public class ChefCalendarServiceImpl implements ChefCalendarService {
	
	@Autowired
	private ChefService chefService;
	
	@Autowired
	private ChefAvailabilityService chefAvailabilityService;
	
	@Autowired
	private RefChefSlotService slotsService;
	
	private Map<Long, RefChefSlot> slotsMap = new HashMap<>();
	
	@Transactional
	@Override
	public void calculateAndPersistCalendar(Long chefId) {
		List<ChefAvailability> chefCalendarList = getChefCalendar(chefId);
		chefAvailabilityService.persistAvailabilities(chefCalendarList);
	}
	
	private List<ChefAvailability> getChefCalendar(Long chefId) {
		Optional<Chef> chefOptional = chefService.getChefById(chefId);
		if(!chefOptional.isPresent()){
			throw new ChefNotFoundException("Chef not found with id:"+chefId);
		}
		Chef chef = chefOptional.get();
		
		String availableDays = chef.getChefAvailabilityDays();
		String availableSlots = chef.getChefAvailabilitySlots();
		
		if(null==availableDays || null==availableSlots){
			throw new FcServicesValidationFailureException("Chef available days and available slots must not empty for the chef:"+chefId);
		}
		
		String[] availableDaysArray = availableDays.split(",");
		String[] availableSlotsArray = availableSlots.split(",");
		
		List<Integer> chefAvailableDaysOrdinals = new ArrayList<>();
		chefAvailableDaysOrdinals = chefAvailableDays(availableDaysArray);
		List<LocalDate> calendarList = getChefAvailabilityCalendar(chefAvailableDaysOrdinals);
		List<ChefAvailability> chefCalendarList =new ArrayList<>();
		if(!calendarList.isEmpty()){
			initializeSlotsMap();
		}
		for(LocalDate localDate: calendarList){
			for(String slot: availableSlotsArray){
				ChefAvailability chefAvailability = new ChefAvailability();
				chefAvailability.setActiveFlag('Y');
				chefAvailability.setChefId(chefId);
				chefAvailability.setCreatedBy("fabchef_admin");
				chefAvailability.setUpdatedBy("fabchef_admin");
				chefAvailability.setSlot(getSlot(slot));
				chefAvailability.setDate(Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
//				System.out.println("Date:"+date.toString()+"::slot="+slot);
				chefCalendarList.add(chefAvailability);
			}
		}
		return chefCalendarList;
	}

	private RefChefSlot getSlot(String slot) {
		return slotsMap.get(Long.valueOf(slot));
	}
	
	private void initializeSlotsMap() {
		List<RefChefSlot> slots = slotsService.getChefSlots();
		
		for(RefChefSlot elem: slots){
			slotsMap.put(elem.getSlotId(), elem);
		}
	}

	private List<LocalDate> getChefAvailabilityCalendar(List<Integer> chefAvailableDaysOrdinals) {
		List<LocalDate> calendarList = new ArrayList<>();
		LocalDate lt = LocalDate.now().plusYears(1).plusWeeks(1);
		LocalDate timeNow = LocalDate.now();

		while (timeNow.isBefore(lt)) {
			if (chefAvailableDaysOrdinals.contains(timeNow.getDayOfWeek().getValue())) {
				calendarList.add(timeNow);
			}
			timeNow = timeNow.plusDays(1);
		}
		return calendarList;
	}
	private static List<Integer> chefAvailableDays(String[] daysArray) {
		List<Integer> ordinals = new ArrayList<>();
		Map<String, Integer> map = dayValuesMap();
		for (String day : daysArray) {
			ordinals.add(map.get(day));
		}
		return ordinals;
	}

	private static Map<String, Integer> dayValuesMap() {
		Map<String, Integer> map = new HashMap<>();
		map.put("MON", DayOfWeek.MONDAY.getValue());
		map.put("TUE", DayOfWeek.TUESDAY.getValue());
		map.put("WED", DayOfWeek.WEDNESDAY.getValue());
		map.put("THU", DayOfWeek.THURSDAY.getValue());
		map.put("FRI", DayOfWeek.FRIDAY.getValue());
		map.put("SAT", DayOfWeek.SATURDAY.getValue());
		map.put("SUN", DayOfWeek.SUNDAY.getValue());
		return map;
	}

}
