package com.meritamerica.assignment3;

import com.meritamerica.assignment3.BankAccount;

public class SavingsAccount extends BankAccount {
	

	
	// ***************** SAVING ACCOUNT CONSTRUCTOR *****************
	
	private static final double INTEREST_RATE = 0.01; 
	
	public SavingsAccount(double openingBalance) {	
		super(openingBalance, INTEREST_RATE);
		
	}
	
}