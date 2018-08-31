package com.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.json.JSONArray;
import org.json.JSONObject;

import com.core.FoodTruck;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FoodTruckJSONParser {

	private static final Logger logger = Logger.getLogger(FoodTruckJSONParser.class.getName());

	public List<FoodTruck> parseJSON(String jsonIn) {
		List<FoodTruck> foodTrucks = new ArrayList<FoodTruck>();
		JSONArray foodTruckJSONArray = new JSONArray(jsonIn);

		for (Object object : foodTruckJSONArray) {
			JSONObject jsonFoodTruckObj = (JSONObject) object;
			ObjectMapper mapper = new ObjectMapper();
			FoodTruck foodTruck;
			try {
				foodTruck = mapper.readValue(jsonFoodTruckObj.toString(), FoodTruck.class);
				foodTrucks.add(foodTruck);
			} catch (JsonParseException e) {
				logger.info(e.getMessage());
				e.printStackTrace();
			} catch (JsonMappingException e) {
				logger.info(e.getMessage());
				e.printStackTrace();
			} catch (IOException e) {
				logger.info(e.getMessage());
				e.printStackTrace();
			}
		}
		
		return foodTrucks;
	}
}
