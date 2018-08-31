package com.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.services.FoodTruckService;


public class FoodTruckFinder {

	private FoodTruckService foodTruckService;
	private Scanner scanner = new Scanner(System.in);
	private int currentFoodTruckIndex;
	
	public static void main(String[] args) {
		new FoodTruckFinder().run();
	}

	public void run() {
		foodTruckService = new FoodTruckService();
		currentFoodTruckIndex = 0;
		List<FoodTruck> foodTrucks;
		
		do {
			foodTrucks = getNextTenOpenFoodTrucks();
			displayFoodTruckInformation(foodTrucks);
		} while (!lessThanTenFoodTrucksOpen(foodTrucks) && continueToNextTenFoodTrucks());
		
		scanner.close();
	}

	public List<FoodTruck> getNextTenOpenFoodTrucks() {
		List<FoodTruck> allOpenFoodTrucks = foodTruckService.getAllOpenFoodTrucks();
		List<FoodTruck> nextTenFoodTrucks = new ArrayList<FoodTruck>();
		
		int endIndex = (currentFoodTruckIndex + 10) >= allOpenFoodTrucks.size() ? allOpenFoodTrucks.size() : currentFoodTruckIndex + 10  ;
		
		for (int index = currentFoodTruckIndex; index < endIndex; index++) {
			currentFoodTruckIndex++;
			nextTenFoodTrucks.add(allOpenFoodTrucks.get(index));
		}	
		
		return nextTenFoodTrucks;
	}

	private void displayFoodTruckInformation(List<FoodTruck> foodTrucks) {
		String applicantHeader = addSpacing("Applicant");
		String applicantLocationHeader = "Address";
		System.out.println(applicantHeader + applicantLocationHeader);
		System.out.println();
		
		for (FoodTruck foodTruck : foodTrucks) {
			String applicantName = addSpacing(foodTruck.getApplicant());
			String applicantLocation = foodTruck.getLocation();
			System.out.println(applicantName + "" + applicantLocation);
		}
	}

	public boolean continueToNextTenFoodTrucks() {
		String input;
		
		do {
			System.out.println("_________________________________________");
			System.out.println();
			System.out.println("Please type \"N\" to continue or \"Q\" to quit the program");
			input = scanner.next();
		} while (!input.equals("N") && !input.equals("Q"));
		
		return input.equals("N");
	}

	private boolean lessThanTenFoodTrucksOpen(List<FoodTruck> foodTrucks) {
		return foodTrucks.size() < 10;
	}

	/*
	 * Adds spaces to the 'applicant' name so the 'location' can be displayed inline
	 */

	private String addSpacing(String strIn) {
		int totalCharactersNeeded = 75;
		int acutalNumberOfCharacters = strIn.length();
		int differenceInCharacterLength = totalCharactersNeeded - acutalNumberOfCharacters;
		StringBuilder strWithAddedSpaces = new StringBuilder(strIn);

		for (int index = 0; index < differenceInCharacterLength; index++) {
			strWithAddedSpaces.append(" ");
		}
		return strWithAddedSpaces.toString();
	}


}

// to run:
// $ javac FoodTruckFinder.java && java FoodTruckFinder
