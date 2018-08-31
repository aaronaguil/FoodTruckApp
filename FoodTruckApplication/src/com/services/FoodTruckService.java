package com.services;

import java.util.List;

import com.core.FoodTruck;
import com.data.FoodTruckDAO;
import com.util.QueryBuilder;
import com.util.QueryBuilderFactory;
import com.util.QueryBuilderType;

public class FoodTruckService {

	FoodTruckDAO foodTruckDAO;
	private QueryBuilderFactory queryBuilderFactory;

	public FoodTruckService() {
		this.init();
	}

	public void init() {
		foodTruckDAO = new FoodTruckDAO();
	}

	public List<FoodTruck> getAllOpenFoodTrucks() {
		if (foodTruckDAO.getAllOpenFoodTrucks() == null) {
			loadAllOpenFoodTrucks();
		}
		return foodTruckDAO.getAllOpenFoodTrucks();
	}
	
	private void loadAllOpenFoodTrucks() {
		queryBuilderFactory = new QueryBuilderFactory();
		QueryBuilder queryBuilder = queryBuilderFactory.getQueryBuilder(QueryBuilderType.CurrentTimeAndDay);
		foodTruckDAO.loadAllOpenFoodTrucks(queryBuilder.buildQuery());
	}
	
	
	
	
}
