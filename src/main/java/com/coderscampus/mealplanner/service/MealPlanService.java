package com.coderscampus.mealplanner.service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.coderscampus.mealplanner.dto.response.DayResponse;
import com.coderscampus.mealplanner.dto.response.WeekResponse;

@Service
public class MealPlanService {
	
	 private RestTemplate rt = new RestTemplate();
	 
	 @Value("${spoonacular.urls.base}")
	 private String baseUrl;
	 
	 @Value("${spoonacular.urls.mealplan}")
	 private String mealPlanEndpoint;

	 public DayResponse getDayMeals(String numCalories, String diet, String exclusions) {
    	URI uri = UriComponentsBuilder.fromHttpUrl(baseUrl + mealPlanEndpoint)
									  .queryParam("timeFrame", "day")
									  .queryParam("numCalories", numCalories)
									  .queryParam("diet", diet)
									  .queryParam("exclusions", exclusions)
									  .queryParam("apiKey", "14ae6605b0ab43658e9241902a17a7da")
									  .build()
									  .toUri();
    	
    	ResponseEntity<DayResponse> responseEntity = rt.getForEntity(uri, DayResponse.class);
    	DayResponse dayResponse = responseEntity.getBody();
    	return dayResponse;
	 }
  
	 public WeekResponse getWeekMeals(String numCalories, String diet, String exclusions) {
	    	URI uri = UriComponentsBuilder.fromHttpUrl(baseUrl + mealPlanEndpoint)
										  .queryParam("timeFrame", "week")
										  .queryParam("numCalories", numCalories)
										  .queryParam("diet", diet)
										  .queryParam("exclusions", exclusions)
										  .queryParam("apiKey", "14ae6605b0ab43658e9241902a17a7da")
										  .build()
										  .toUri();
	    	
	    	ResponseEntity<WeekResponse> responseEntity = rt.getForEntity(uri, WeekResponse.class);
	    	WeekResponse weekResponse = responseEntity.getBody();
	    	return weekResponse;
	}
	 
	 //This was the first way I got it to work, but I Think it is not common practice to structure it like this.
//	 public ResponseEntity<WeekResponse> getWeekMeals(String numCalories, String diet, String exclusions) {
//    	URI uri = UriComponentsBuilder.fromHttpUrl("https://api.spoonacular.com/mealplanner/generate")
//									  .queryParam("timeFrame", "week")
//									  .queryParam("numCalories", numCalories)
//									  .queryParam("diet", diet)
//									  .queryParam("exclusions", exclusions)
//									  .queryParam("apiKey", "14ae6605b0ab43658e9241902a17a7da")
//									  .build()
//									  .toUri();
//    	
//    	ResponseEntity<WeekResponse> response = rt.getForEntity(uri, WeekResponse.class);
//    	System.out.println(response.getBody());
//    	return response;
//	 }
    		

}
