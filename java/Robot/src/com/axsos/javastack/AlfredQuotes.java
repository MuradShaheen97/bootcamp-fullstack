package com.axsos.javastack;
import java.util.Date;
public class AlfredQuotes {


		
		public String basicGreeting() {
			// You do not need to code here, this is an example method
			return "Hello, lovely to see you. How are you?";
		}
	 
		public String guestGreeting(String name) {
			// YOUR CODE HERE
			return "Welcome MR."+ name +" Nice to meet you ";
		}
	 
		public String dateAnnouncement() {
			// YOUR CODE HERE
			Date today= new Date();
	 
			return "today is "+ today;
		}
	 
		public String respondBeforeAlexis(String conversation) {
			// YOUR CODE HERE
			return "sorry i did not understand your: "+ conversation;
		}
	 
		// NINJA BONUS
		// See the specs to overload the guestGreeting method
		// SENSEI BONUS
		// Write your own AlfredQuote method using any of the String methods you have
		// learned!
	}
	 
	 

