package com.meritamerica.assignment3;
import java.sql.Date;
import java.text.ParseException;

public class CheckingAccount extends BankAccount {
	
		public CheckingAccount(double balance) {
			super(balance, balance);
		}	
		public CheckingAccount(long accountNumber, double balance, double interestRate, Date simpleDataFormat) {
			super(accountNumber, balance, interestRate, simpleDataFormat);
		}
	
	static CheckingAccount readFromString(String accountData) throws ParseException {
		String[]chd = accountData.split(",");
		
		long accountNumber = Long.parseLong(chd[0]);
		double balance = Double.parseDouble(chd[1]);
		double interestRate = Double.parseDouble(chd[2]);
		Date simpleDataFormat = Date.valueOf(chd[3]);
		CheckingAccount checkingAccountInfo = new CheckingAccount(accountNumber, balance,
				interestRate,simpleDataFormat);
		return checkingAccountInfo;
		


	}

}