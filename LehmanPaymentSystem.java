package INCLASS;

import java.util.ArrayList;

public class LehmanPaymentSystem {
	public static void main(String[] args) {
		ArrayList<Payable> pending = new ArrayList<>();
		
		CreditCard card = new CreditCard("there's", 60.0, 100.0);
		MealPlan meal = new MealPlan("Yours", 40.0);
		
		pending.add(card);
		pending.add(meal);
		
		for(Payable p: pending) {
			p.processPayment(50.0);
			System.out.println(" Card Status: "  + p.getPaymentSituation());
			System.out.println("*************************");
			
			
		}
		System.out.println("Total Trans: " + PaymentMethod.totalTransactions );
		
	}
}
