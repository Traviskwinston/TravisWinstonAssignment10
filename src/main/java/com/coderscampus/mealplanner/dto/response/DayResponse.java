package com.coderscampus.mealplanner.dto.response;

import java.util.List;

import com.coderscampus.mealplanner.dto.Meals;
import com.coderscampus.mealplanner.dto.Nutrients;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DayResponse {
	
	@JsonProperty("meals")
	private List<Meals> meals;
	
	@JsonProperty("nutrients")
	private Nutrients nutrients;

	public List<Meals> getMeals() {
		return meals;
	}

	public void setMeals(List<Meals> meals) {
		this.meals = meals;
	}

	public Nutrients getNutrients() {
		return nutrients;
	}

	public void setNutrients(Nutrients nutrients) {
		this.nutrients = nutrients;
	}

}
