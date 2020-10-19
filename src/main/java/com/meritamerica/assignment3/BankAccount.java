package com.meritamerica.assignment3;

/* Week 4 Partner Pair Assignment #3
* Bank Account Part 3  
* @date October 16, 2020
* PART 3
*/
	 
import com.meritamerica.assignment3.MeritBank;
import java.text.*;
import java.util.*;
public class BankAccount {

	
	// instance variable
		private long accountNumber;
		private double balance;
		private double interestRate;
		double bankAccount;
		private java.util.Date accountOpenedOn;
		static SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		
	//Constructs a Bank Account 
		  
	public BankAccount(double balance, double interestRate){
		this.balance = balance;
		this.interestRate = interestRate;
		this.accountNumber = MeritBank.getNextAccountNUmber();
		this.accountOpenedOn = new java.util.Date();
	}
	
	public BankAccount(double balance, double interestRate,Date accountOpenedOn) {
		this.balance = balance;
		this.interestRate = interestRate;
		this.accountOpenedOn = accountOpenedOn;
		this.accountNumber = MeritBank.getNextAccountNUmber();

		
	}   
	
	public BankAccount(long accountNumber, double balance, double interestRate, Date accountOpenedOn){
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.interestRate = interestRate;
		this.accountOpenedOn = accountOpenedOn;
		
	}
	//Date Account Opened on
	public java.util.Date getOpenedOn() {
		return this.accountOpenedOn;
		
		
	}

	//Account Number
	 public long getAccountNumber() {
		 return this.accountNumber;
		 
	 }
	 public void setAccountNumber(long accountNumber) {
			this.accountNumber = accountNumber;
		
		
	}

	 //Balance
	public double getBalance() {
		return this.balance;
		
	}

	//Interest Rate
	public double getInterestRate() {
		return interestRate;
		
	}


	//Withdraw
	public boolean Withdraw (double amount) {

	    if (amount < balance && amount > 0) {
	       balance -= amount;
	       return true;
	    }else {
	    	System.out.println ("not enough money in your account!");
	    	return false;
	    }
	}

	// Deposit
	public boolean Deposit (double amount) {
		if (amount > 0) {
			balance += amount;
			return true;
		}else {
			System.out.println("Cannot deposit a negative amount");
			return false;
		}
		
	}
	//Future Value
	public double futureValue(int years) {
		double FV = balance * Math.pow(1.0 + interestRate,years);
		return FV;

	}

public static BankAccount readFromString(String accountData) throws ParseException {

		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");

		try {
			String storage1[] = accountData.split(",");

			int formattedAccount = Integer.parseInt(storage1[0]);
			double formattedBalance = Double.parseDouble(storage1[1]);
			double formattedInterest = Double.parseDouble(storage1[2]);
			Date formattedDate = dateFormatter.parse(storage1[3]);

			BankAccount formattedBank = new BankAccount(formattedAccount, formattedBalance, formattedInterest, formattedDate);

			return formattedBank;
		}
		catch (ParseException e) {
			return null;
		}
}

		public String writeToSpring() {

	 		SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy");
	 		
	 		return this.accountNumber + "," + this.balance + "," + this.interestRate + "," + dateFormatter.format(this.accountOpenedOn); 	
 		}
	
}
	
	