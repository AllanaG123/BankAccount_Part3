package com.meritamerica.assignment3;

import com.meritamerica.assignment3.BankAccount;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SavingsAccount extends BankAccount {

	// ***************** SAVING ACCOUNT CONSTRUCTOR *****************
	
	private static final double INTEREST_RATE = 0.01; 
	
	public SavingsAccount(double openingBalance) {	
		super(openingBalance, INTEREST_RATE);
		
	}

	public SavingsAccount(long accountNumber, double balance, double interestRate, Date accountOpenedOn) {
		super(accountNumber, balance, interestRate, accountOpenedOn);
	}

	public static SavingsAccount readFromString(String savingAccount) throws ParseException {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String[] savingAccountInfo = savingAccount.split(",");
		SavingsAccount savingsAccount = new SavingsAccount(Long.getLong(savingAccountInfo[0]),
				Double.valueOf(savingAccountInfo[1]), Double.valueOf(savingAccountInfo[2]),
				dateFormat.parse(savingAccountInfo[3]));
		
		return savingsAccount;
	}
}
