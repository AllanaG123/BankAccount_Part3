package com.meritamerica.assignment3;
import java.io.*;
import java.util.*;

public class MeritBank {
	static AccountHolder myAccountHolder[] = new AccountHolder[0];
	static CDOffering myCDOffering[] = new CDOffering[0];
	static CDAccount myCDAccount[] = new CDAccount[0];
	private static long nextAccount = 0;

	public static void addAccountHolder(AccountHolder accountHolder) {
		AccountHolder[] myAccountHolder1 = new AccountHolder[myAccountHolder.length + 1];
		for (int i = 0; i < myAccountHolder.length; i++) {
			myAccountHolder1[i] = myAccountHolder[i];
		}
		myAccountHolder = myAccountHolder1;
		myAccountHolder[myAccountHolder.length - 1] = accountHolder;

	}

	public static AccountHolder[] getAccountHolders() {
		return myAccountHolder;

	}

	public static CDOffering[] getCDOfferings() {
		return myCDOffering;

	}

	public static CDOffering getBestCDOffering(double depositAmount) {
		double best = 00;
		CDOffering CDO = null;
		if (myCDOffering == null) {
			return null;
		}
		for (int i = 0; i < myCDOffering.length; i++) {
			if (futureValue(depositAmount, CDO.getInterestRate(), CDO.getTerm()) > best) {
				CDO = myCDOffering[i];
				best = futureValue(depositAmount, CDO.getInterestRate(), CDO.getTerm());
			}
		}
		return CDO;
	}

	public static CDOffering getSecondBestCDOffering(double depositAmount) {
		double secondbest = 00;
		CDOffering CDO = null;
		CDOffering CDB = null;
		if (myCDOffering == null) {
			return null;
		}
		for (int i = 0; i < myCDOffering.length; i++) {
			if (futureValue(depositAmount, CDO.getInterestRate(), CDO.getTerm()) > secondbest) {
				CDB = CDO;
				CDO = myCDOffering[i];
				secondbest = futureValue(depositAmount, CDO.getInterestRate(), CDO.getTerm());
			}
		}
		return CDB;

	}

	public static void clearCDOfferings() {
		myCDOffering = null;

	}

	public static void setCDOfferings(CDOffering[] offerings) {
		myCDOffering = offerings;
	}

	public static long getNextAccountNumber() {
		return nextAccount += 1;
	}

	public static double totalBalances() {
		double total = 0;
		for (int i = 0; i < myAccountHolder.length; i++) {
			total += myAccountHolder[i].getCombinedBalance();
		}
		return total;

	}

	public static double futureValue(double presentValue, double interestRate, int term) {
		double value = 0.00;
		double powered = Math.pow((1 + interestRate), term);
		value = presentValue * powered;
		return value;
	}

	static boolean readFromFile(String filename) throws Exception {
		CDOffering[] cdOffering;
		
		try {
			
			FileReader fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			
			nextAccount = Long.valueOf(br.readLine());
			
			int numberOfCDOfferings = Integer.parseInt(br.readLine());
			
			myCDOffering = new CDOffering[numberOfCDOfferings];
			for(int i =0; i < numberOfCDOfferings; i++) {
				cdOffering[i] = CDOffering.readFromString(br.readLine());
				
			}
			int numberOfAccountHolders = Integer.parseInt(br.readLine());
			AccountHolder[] accountHolders = new AccountHolder[numberOfAccountHolders];
			for(int i = 0; i < accountHolders.length; i++) {
				accountHolders[i] = AccountHolder.readFromString(br.readLine());
				
			int numberOfCheckingAccount = Integer.parseInt(br.readLine());
			for(int j =0; j < numberOfCheckingAccount; j++) {
				accountHolders[i].addCheckingAccount(CheckingAccount.readFromString(br.readLine()));
				
			}
			int numberOfSavingsAccounts = Integer.parseInt(br.readLine());
			for(int k =0; k < numberOfSavingsAccounts; k++) {
				accountHolders[i].addSavingsAccount(SavingsAccount.readFromString(br.readLine()));
			}
			int numberOfCDAccount = Integer.parseInt(br.readLine());
			for(int p =0; p < numberOfCDAccount; p++) {
				accountHolders[i].addCDAccount(CDAccount.readFromString(br.readLine()));
			}
			br.close();
			}
			return true;
					
		}
		catch(FileNotFoundException ex) {
			
			System.out.println("Oops Sorry Not Here");
			return false;
		}
	}

	static boolean writeToFile(String filename) {
		try {

			FileWriter fw = new FileWriter(filename);
			BufferedWriter bw = new BufferedWriter(fw);

			bw.write(String.valueOf(nextAccount));
			bw.newLine();
			bw.write(String.valueOf(myCDOffering.length));
			bw.newLine();
			for (int i = 0; i < myCDOffering.length; i++) {
				bw.write(myCDOffering[i].writeToString());
				bw.newLine();
			}
			bw.write(String.valueOf(myAccountHolder.length));
			bw.newLine();
			for (int i = 0; i < myAccountHolder.length; i++) {
				bw.write(myAccountHolder[i].writeToString());
				bw.newLine();
				bw.write(myAccountHolder[i].getNumberOfCheckingAccounts());
				for (int j = 0; j < myAccountHolder[i].getNumberOfCheckingAccounts(); j++) {
					bw.write(String.valueOf(myAccountHolder[i].getCheckingAccounts()[j].toString()));
				}
				for (int k = 0; k < myAccountHolder[i].getNumberOfSavingsAccounts(); k++) {
					bw.write(String.valueOf(myAccountHolder[i].getSavingsAccounts()[k].toString()));
				}
				for (int g = 0; g < myAccountHolder[i].getNumberOfCDAccounts(); g++) {
					bw.write(String.valueOf(myAccountHolder[i].getCDAccounts()[g].writeToString()));
				}
			}
			return true;
		} catch (IOException ex) {
			System.out.println("No you big dum");
			return false;
		}
	}

	static AccountHolder[] sortAccountHolders() {
		Arrays.sort(myAccountHolder);
		return myAccountHolder;
	}

	static void setNextAccountNumber(long nextAccountNumber) {

	}

}