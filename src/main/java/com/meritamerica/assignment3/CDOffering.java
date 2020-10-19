package com.meritamerica.assignment3;

public class CDOffering {

	int term;
	double interestRate;
	

// CONSTRUCTOR

	public CDOffering (int term, double interestRate) {
		this.term = term;
		this.interestRate = interestRate;
	}
		
	
	public int getTerm() {
		return term;
	}
	
	public double getInterestRate() {
		return interestRate;
	}
	
	public String toString() {
		return "Your CD Offering Terms: " + this.getTerm() + " Your CD Offering Interest Rate: " + this.getInterestRate();
	}
		
// AMENDMENTS 
	
	static CDOffering readFromString(String cdOfferingDataString) {
		
		String storage1[] = cdOfferingDataString.split(",");
		int testTerm = Integer.parseInt(storage1[0]);
		double testInterest = Double.parseDouble(storage1[1]);
		
		CDOffering offeringA = new CDOffering(testTerm, testInterest);
		return offeringA;
	}
	
	
	public String writeToString() {
		return this.term + "," + this.interestRate;
	}
	
}




