package com.axsos.javastack;

import java.util.ArrayList;
import java.util.Scanner;

public class CafeUtil {
	Scanner scanner = new Scanner(System.in);
	public int getStreakGoal() {
		int sum = 0 ;
				for (int i = 1 ; i <= 10 ; i++) {
					sum = sum + i;
					
					
				}
				return sum;
				
	}
	
	
	public double getOrderTotal(double[]prices) {
		
		double sum = 00.00;
		for (int i = 0 ; i < prices.length ; i++ ) { 
			sum += prices [i];
			
				
		}
		return sum ;
		
		
		
	}
	public void displayMenu(ArrayList<String>menuitems) {
		for(int i = 0 ; i < menuitems.size() ; i++) {
			System.out.println(i+ " " + menuitems.get(i));
			
		}
	}
	public void addCustomer(ArrayList<String> customer) {
		System.out.print("please enter your name: ");
		
		String name=scanner.nextLine();
		
		System.out.println("Hello, Mr "+name);
		System.out.println("there are "+ customer.size()+" people front of you");
		customer.add(name);
		for(int i=0;i<customer.size();i++) {
			System.out.print(customer.get(i));
		}
	}

	
	
	
	}
	



