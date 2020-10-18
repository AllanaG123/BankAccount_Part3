package com.meritamerica.assignment3;

import com.meritamerica.assignment3.BankAccount;

/* Week 3 Partner Pair Assignment #3
 * Bank Account Part 3
 * @date October 17, 2020
 * PART 3
 */
public class CheckingAccount extends BankAccount {
	
	private int accountNumber;
	private double balance;
	private static final double INTEREST_RATE = 0.0001; 
	private java.util.Date accountOpened;
	
    //CONSTRUCTOR OF OBJECTS CLASS CHECKING
	
	public CheckingAccount(double openingBalance) {
		super(openingBalance, INTEREST_RATE);
	}
	
	
	
}