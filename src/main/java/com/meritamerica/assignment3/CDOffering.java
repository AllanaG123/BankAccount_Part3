package com.meritamerica.assignment3;
public class CDOffering {
	private int term;
	private double interestRate;
	//1. CDOferring (int term, double interestRate)
	// behulum and allana
	public CDOffering(int term, double interestRate) {
		this.term = term;
		this.interestRate = interestRate;
	}
	//2. int getTerm ()
	public int getTerm() {
		return this.term;
	}
	//3. double getInterestRate ()
	public double getInterestRate() {
		return this.interestRate;
	}
	public String writeToString(){
		return term+","+interestRate;
	}
	public static CDOffering readFromString(String cdOfferingInfo) {
		String[] cdInfo =  cdOfferingInfo.split(",");
		CDOffering cDOffering = new CDOffering(Integer.getInteger(cdInfo[0]), Double.valueOf(cdInfo[1]));
		return cDOffering;
	}
}





