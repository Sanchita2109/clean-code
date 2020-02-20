package com.epam.ConstructionCost;

import java.util.HashMap;
import java.util.Map;

public class HouseConstructionCost extends Dimension {
	int costPerSquareFeet;
	Map<String,Integer> constructionPlans;
	public HouseConstructionCost() {
		constructionPlans = new HashMap<String,Integer>();
		constructionPlans.put("Standard", 1200);
		constructionPlans.put("Above Standard", 1500);
		constructionPlans.put("High Standard", 1800);
		constructionPlans.put("High Standard And Fully Automated", 2500);
	}
	
	public void setCostPerSquareFeet(String selectedPlan) {
		this.costPerSquareFeet = constructionPlans.get(selectedPlan);
	}
	
	public void setAreaOfTheHouse(int length, int breadth) {
		this.length = length;
		this.breadth = breadth;
	}
	
	// Can be Inherited and used if needed to change the plans.
	protected void changeConstructionPlans(Map<String, Integer> newConstructionPlans) {
		this.constructionPlans = newConstructionPlans;
	}
	
	public Map<String, Integer> getConstructionPlans() {
		return this.constructionPlans;
	}
	
	public int getEstimatedCost() {
		return (this.length * this.breadth * this.costPerSquareFeet);
	}
	
}
