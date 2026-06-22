package com.axsos.BanckAcc;

public class BanckAcc {
    // MEMBER VARIABLES
    private double checkingBalance;
    private double savingsBalance;
    private static int accounts;
    private static double totalMoney; // refers to the sum of all bank account checking and savings balances

	public BanckAcc() {
		// TODO Auto-generated constructor stub
		accounts +=2;
		checkingBalance=0;
		savingsBalance=0;
		
	}
//getter
	public double getCheckingBalance() {
		
		return this.checkingBalance;
		
		
	}
	
	public double getSavingsBalance() {
		
		return this.savingsBalance;
		
		
	}
	public static int getAccounts() {
		
		return accounts; 
		
		
	}
	
	public static double getTotalMoney() {
		
		return totalMoney; 
		
		
	}
	
	
	//deposet
	public void depositCheckingBalance(double amount ) {
		
		this.checkingBalance+=amount;
		totalMoney+=amount ;
		
	}
	
	public void depositSavingsBalance(double amount ) {
		
		this.savingsBalance+=amount;
		totalMoney+=amount ;
		
	}
	
	//withdrow
	
	public double withdrowCheckingBalance(double amount ) {
		if(amount>checkingBalance) {
			return 0;
		}
		
		this.checkingBalance-=amount;
		totalMoney-=amount ;
		return amount;
		
	}
	
	public double withdrowSavingsBalance(double amount ) {
		if(amount>savingsBalance) {
			return 0;
		}
		
		this.savingsBalance-=amount;
		totalMoney-=amount ;
		return amount;
		
	}
	
	//display
	public void displayTotalBalance() {
		System.out.println("Your Checking Account Balance is : "+ this.checkingBalance);
		System.out.println("Your Saving Account Balance is : "+ this.savingsBalance);
		System.out.println("Your total Accounts Balance is : "+ totalMoney);
	}
	
	
	
	
}









  

    // CONSTRUCTOR
    // Be sure to increment the number of accounts

    // GETTERS
    // for checking, savings, accounts, and totalMoney

    // METHODS
    // deposit
    // - users should be able to deposit money into their checking or savings account
    // withdraw 
    // - users should be able to withdraw money from their checking or savings account
    // - do not allow them to withdraw money if there are insufficient funds
    // - all deposits and withdrawals should affect totalMoney
    // getBalance
    // - display total balance for checking and savings of a particular bank account
