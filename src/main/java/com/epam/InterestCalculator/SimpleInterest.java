package com.epam.InterestCalculator;

public class SimpleInterest extends InterestCalculator {
	public double simpleInterest;
	
	public SimpleInterest() {
		
	}
	
	public SimpleInterest(double principal, double rateOfInterest, double termOfTheLoanInYears) {
		this.principal = principal;
		this.rateOfInterest = rateOfInterest;
		this.termOfTheLoanInYears = termOfTheLoanInYears;
	}
	
	public void setInputValues(double principal, double rateOfInterest, double termOfTheLoanInYears) {
		this.principal = principal;
		this.rateOfInterest = rateOfInterest;
		this.termOfTheLoanInYears = termOfTheLoanInYears;
	}
	
	public double getSimpleInterest() {
		return ( (principal * termOfTheLoanInYears * rateOfInterest) / 100 );
	}
}
