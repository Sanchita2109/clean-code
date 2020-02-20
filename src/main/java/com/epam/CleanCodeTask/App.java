package com.epam.CleanCodeTask;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.epam.ConstructionCost.HouseConstructionCost;
import com.epam.InterestCalculator.*;

public class App 
{
	static Scanner inputScanner = new Scanner(System.in);
	static PrintStream output = new PrintStream(new FileOutputStream(FileDescriptor.out));
	static double principal;
	static double rateOfInterest;
	static double termOfTheLoanInYears;
	
    public static void main( String[] args )
    {
    	try {
	    	do {
		        output.println("	Select Program	\n"
		        		+ "** Interest Calculator **\n"
		        		+ "1. Simple Interest\n"
		        		+ "2. Compound Interest\n\n"
		        		+ "** Estimating House Construction Cost **\n"
		        		+ "3. Select A Construction Plan : \n");
		        
		        int choice = inputScanner.nextInt();
		        switch(choice) {
		        case 1:
		        	getInterestInputValues();
		        	SimpleInterest simpleInterest = new SimpleInterest(principal, rateOfInterest, termOfTheLoanInYears);
		        	output.println("Simple Interest = " + simpleInterest.getSimpleInterest());
		        	break;
		        case 2:
		        	getInterestInputValues();
		        	CompoundInterest compoundInterest = new CompoundInterest(principal, rateOfInterest, termOfTheLoanInYears);
		        	output.println("Compound Interest = " + compoundInterest.getCompountInterest());
		        	break;
		        case 3:
		        	houseConstructionEstimation();
		        	break;
		        default:
		        	output.println("Invalid Option Selected");
		        }
		        output.println("\nWould You Like To Continue (y/n) : ");
	    	} while(inputScanner.next().charAt(0)  == 'y');
	    	
	    	output.println("Program Terminated Successfully\n");
	        inputScanner.close();
	        output.close();
    	}
    	catch(Exception e) {
    		output.println("\nError Occurred " + e);
    	}
    }
    
    public static void getInterestInputValues() {
    	output.println("Enter Principal, RateOfInterest, Time Period (in Years) :\n");
    	principal = inputScanner.nextDouble();
    	rateOfInterest = inputScanner.nextDouble();
    	termOfTheLoanInYears = inputScanner.nextDouble();
    }
    
    public static void houseConstructionEstimation() {
    	HouseConstructionCost houseConstructionObject = new HouseConstructionCost();
    	
        Set< Map.Entry< String,Integer> > constructionPlans = houseConstructionObject.getConstructionPlans().entrySet();
        int index = 1, length, breadth;
        String selectedPlan;
        ArrayList<String> options = new ArrayList<String>();
        output.println("List Of Construction Plans");
        for (Map.Entry< String,Integer> plan : constructionPlans) {
        	options.add(plan.getKey());
            output.println(index + ". " + plan.getKey() + " Material Costs " + plan.getValue() + " per square feet");
            index++;
        }
        index = inputScanner.nextInt();
        if(index > 0 && index < 5) {
        	selectedPlan = options.get(index-1);
        	houseConstructionObject.setCostPerSquareFeet(selectedPlan);
        }
        else {
        	output.println("Invalid Option\n");
        	return ;
        }
        output.println("Enter Area Of The House (Length x breadth) : \n");
        length = inputScanner.nextInt();
        breadth = inputScanner.nextInt();
        houseConstructionObject.setAreaOfTheHouse(length, breadth);
        output.println("Cost for construction = " + houseConstructionObject.getEstimatedCost() + " INR");
    }
}

