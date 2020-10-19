package com.meritamerica.assignment3;

import java.sql.Date;
import java.text.*;
//import java.util.*;

import com.meritamerica.assignment3.MeritBank;

public class BankAccount {

//VARIABLE
		private long accountNumber;
		private double balance;
		private double interestRate;
		double bankAccount;
		private java.util.Date accountOpenedOn;
		
		private double interestRate2;
		private double balance2;
		
		static SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

//CONSTRUCTOR BANK ACCOUNT
		  
	public BankAccount(double balance, double interestRate){
		this.balance = balance;
		this.interestRate = interestRate;
		this.accountNumber = MeritBank.getNextAccountNumber();
		this.accountOpenedOn = new Date(accountNumber);
		
	}
		
	public BankAccount(double balance, double interestRate, Date d){
		
		this.balance = balance;
		this.interestRate = interestRate;
		this.accountOpenedOn = d;
		this.accountNumber = MeritBank.getNextAccountNumber();
	}
		
		
	public BankAccount(long accountNumber, double balance, double interestRate, java.util.Date accountOpenedOn2) {
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.interestRate = interestRate;
		this.accountOpenedOn = accountOpenedOn2;
	
	}
		
// ACCOUNT NUMBER
	
	// METHOD ADDED TO MAKE CDACCOUNT LINE 26 WORK
	 public BankAccount(long nextAccountNumber, double balance2, double interestRate2) {
		 	this.balance2 = balance2;
			this.interestRate2 = interestRate2;
			java.util.Date d = null;
			this.accountOpenedOn = d;
			this.accountNumber = MeritBank.getNextAccountNumber();
	}

	public long getAccountNumber() {
		 return this.accountNumber;
	}
	 
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

// BALANACE
	 
	public double getBalance() {
		return this.balance;
	}

// INTEREST RATE
	
	public double getInterestRate() {
		return interestRate;
	}
	
// OPENING DATE
	
	public java.util.Date getOpenedOn() {
		return this.accountOpenedOn;
	}

// WITHDRAW
	
	public boolean Withdraw (double amount) {
		
		if (amount < 0) {
			System.out.println("WARNING - Can not withdraw a negative amount! Please Try again");
			return false;
		}
		else {
			if((this.getBalance() - amount) < 0) {
				System.out.println("WARNING - Not enough money in your account!");
				return false;
			}
			else {
				double newBalance = this.getBalance() - amount;
				this.balance = newBalance;
				return true;
			}
		}
	}

// DEPOSIT
	
	public boolean Deposit (double amount) {
		
		if(amount <= 0) {
			System.out.println("WARNING = Can not deposit a negative amount");
			return false;
		}
		else {
			this.balance = this.getBalance() + amount;
			return true;
		}
	}
	
// FUTURE VALUE
	
	public double futureValue(int years) {
		double FV = balance * Math.pow(1.0 + interestRate,years);
		return FV;
	}


// AMMENDMENTS


	static BankAccount readFromString(String accountData) throws ParseException {
		
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			String storage1[] = accountData.split(",");
			
			int formattedAccount = Integer.parseInt(storage1[0]);
			double formattedBalance = Double.parseDouble(storage1[1]);
			double formattedInterest = Double.parseDouble(storage1[2]);
			Date formattedDate = (Date) dateFormatter.parse(storage1[3]);
		
			//Date formattedDate = Date.valueOf(storage1[3]);
			
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