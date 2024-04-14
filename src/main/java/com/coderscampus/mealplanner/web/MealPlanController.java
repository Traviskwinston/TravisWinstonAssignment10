package com.coderscampus.mealplanner.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderscampus.mealplanner.dto.response.DayResponse;
import com.coderscampus.mealplanner.dto.response.WeekResponse;
import com.coderscampus.mealplanner.service.MealPlanService;

@RestController
@RequestMapping("/mealplanner")
public class MealPlanController {
	
	@Autowired
	private MealPlanService mealPlanService;
	
	@GetMapping("/day")
	public ResponseEntity<DayResponse> getDayMeals(String numCalories, String diet, String exclusions) {
		DayResponse dayResponse = mealPlanService.getDayMeals(numCalories, diet, exclusions);
		return ResponseEntity.ok(dayResponse);
	}
	
	
	@GetMapping("/week")
	public ResponseEntity<WeekResponse> getWeekMeals(String numCalories, String diet, String exclusions) {
		WeekResponse weekResponse = mealPlanService.getWeekMeals(numCalories, diet, exclusions);
		return ResponseEntity.ok(weekResponse);
	}
	
	//This was first way I programmed it, but I don't think it's as common practice.
//	@GetMapping("/week")
//	public ResponseEntity<WeekResponse> getWeekMeals(String targetCalories, String diet, String exclude) {
//		return mealPlanService.getWeekMeals(targetCalories, diet, exclude);
//	}

}
