package com.meritamerica.assignment3;
/* Week 3 Partner Pair Assignment #3
 * Bank Account Part 3
 * @date October 17, 2020
 * PART 3
 */

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Formatter;

public class CDAccount extends BankAccount {

	CDOffering offering;
	private double balance;
	private Date date;

	public CDAccount(CDOffering offering, double balance) {
		super(MeritBank.getNextAccountNUmber(), balance, offering.getInterestRate());
		this.offering = offering;
		this.date = new Date();
	}
	public CDAccount(int accountNumber, double balance, double interestRate, java.util.Date accountOpenedOn, int term) {
		
		super(accountNumber, balance, interestRate, accountOpenedOn);
		this.term = term;
		
	}

	public double getBalance() {
		return super.getBalance();
	}

	public double getinterestRate() {
		return offering.getInterestRate();
	}

	public int getTerm() {
		return offering.getTerm();
	}

	public Date getStartDate() {
		return this.date;
	}

	public long getAccountNumber() {
		return super.getAccountNumber();
	}

	public double futureValue() {
		return (balance * Math.pow(1.0 + offering.getInterestRate(), offering.getTerm()));
	}
	//------------------------------------------------- ASSIGNMENT 3 AMENDMENTS -----------------------------------------------
	
	//Override the deposit and withdraw methods to return false. CD Accounts cannot deposit new funds or withdraw funds until the term is reached.
		
		public boolean withdraw(double amount) {
			return false;
		}
		
		public boolean deposit(double amount) {
			return false;
		}
		
		public static CDAccount readFromString(String accountData) throws ParseException{
			
			CDAccount newCdAccount;
			 
			try {
				ArrayList<String> TEST = new ArrayList<>(Arrays.asList(accountData.split(",")));
				
				int accountNumber = Integer.parseInt(TEST.get(0));
				double balance = Double.parseDouble(TEST.get(1));
				double interestRate = Double.parseDouble(TEST.get(2));
				Date accountOpenedOn = formatter.parse(TEST.get(3));
				int term = Integer.parseInt(TEST.get(4));
				newCdAccount = new CDAccount(accountNumber, balance, interestRate, accountOpenedOn, term);
				
			}
			catch (ParseException ex) {
				throw new java.lang.NumberFormatException();
				
			}
			return newCdAccount;
			
		}
		
		public String writeToString() {
			return this.getAccountNumber() + " , " + this.getBalance() + " , " + this.getinterestRate() + " , " + this.getTerm();
		}
	}
	
