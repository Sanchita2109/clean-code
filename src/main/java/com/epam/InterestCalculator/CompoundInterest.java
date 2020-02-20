package com.epam.InterestCalculator;

public class CompoundInterest extends InterestCalculator{
	public double compoundInterest;
	
	public CompoundInterest() {
		
	}
	
	public CompoundInterest(double principal, double rateOfInterest, double termOfTheLoanInYears) {
		this.principal = principal;
		this.rateOfInterest = rateOfInterest;
		this.termOfTheLoanInYears = termOfTheLoanInYears;
	}
	
	public void setInputValues(double principal, double rateOfInterest, double termOfTheLoanInYears) {
		this.principal = principal;
		this.rateOfInterest = rateOfInterest;
		this.termOfTheLoanInYears = termOfTheLoanInYears;
	}
	
	public double getCompountInterest() {
		return (principal * Math.pow(1.0 + rateOfInterest / 100.0, termOfTheLoanInYears) - principal);
	}
	
}
