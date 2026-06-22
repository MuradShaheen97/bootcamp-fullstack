package com.axsos.BanckAcc;

public class BanckTeast {

	public static void main(String[] args) {
	
		
		// TODO Auto-generated method stub
		
		
		//objects
		BanckAcc Murad = new BanckAcc();
		BanckAcc ramez = new BanckAcc();
		BanckAcc jalill = new BanckAcc();
		BanckAcc chaker = new BanckAcc();
		
		//deposite
		Murad.depositCheckingBalance(100.00);
		ramez.depositCheckingBalance(200.00);
		jalill.depositCheckingBalance(250.00);
		chaker.depositCheckingBalance(150.00);
		
		
		//saving
		Murad.depositSavingsBalance(500.00);
		ramez.depositSavingsBalance(50.00);
		jalill.depositSavingsBalance(300.00);
		chaker.depositSavingsBalance(150.00);
		
		//display
		System.out.println("murad Acc is ");
		Murad.displayTotalBalance();
		
		System.out.println("ramez Acc is ");
		ramez.displayTotalBalance();
		
		System.out.println("jalill Acc is ");
		jalill.displayTotalBalance();
		
		System.out.println("chaker Acc is ");
		chaker.displayTotalBalance();
		
		
		
		//withdrow
		Murad.withdrowCheckingBalance(100.00);
		Murad.withdrowSavingsBalance(200.00);
		
		ramez.withdrowCheckingBalance(200.00);
		ramez.withdrowSavingsBalance(400.00);

		jalill.withdrowCheckingBalance(100.00);
		jalill.withdrowSavingsBalance(300.00);
		
		chaker.withdrowCheckingBalance(400.00);
		chaker.withdrowSavingsBalance(200.00);
		
		
		//display
				System.out.println("murad Acc is ");
				Murad.displayTotalBalance();
				
				System.out.println("ramez Acc is ");
				ramez.displayTotalBalance();
				
				System.out.println("jalill Acc is ");
				jalill.displayTotalBalance();
				
				System.out.println("chaker Acc is ");
				chaker.displayTotalBalance();
		
		System.out.println(BanckAcc.getAccounts());
		System.out.println(BanckAcc.getTotalMoney());
		
		
	}
	
		
	
	
	

}
