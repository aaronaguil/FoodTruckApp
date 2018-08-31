package com.data;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import com.core.FoodTruck;
import com.util.FoodTruckJSONParser;

public class FoodTruckDAO {

	private static final String baseUrlStr = "https://data.sfgov.org/resource/bbb8-hzi6.json";
	FoodTruckJSONParser foodTruckJSONParser = new FoodTruckJSONParser();
	private List<FoodTruck> allOpenFoodTrucks;

	
	public void loadAllOpenFoodTrucks(String currentTimeAndDayQuery){
		allOpenFoodTrucks = getFoodTruckByQuery(currentTimeAndDayQuery);
	}
	
	public List<FoodTruck> getFoodTruckByQuery(String queryIn){
		List<FoodTruck> foodTrucks = null;
		StringBuilder queryResult = new StringBuilder();
		
		try {
			String urlQuery = baseUrlStr + queryIn;
			
			URL url = new URL(urlQuery);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			
			String line;
			while ((line = rd.readLine()) != null) {
				queryResult.append(line);
			}

			foodTrucks = foodTruckJSONParser.parseJSON(queryResult.toString());

			rd.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return foodTrucks;
	}
	
	public List<FoodTruck> getAllOpenFoodTrucks(){
		return allOpenFoodTrucks;
	}
	
	
	
	

	

}
