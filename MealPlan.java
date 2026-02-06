package INCLASS;

public class MealPlan extends PaymentMethod {
	
	private String creditSituation;
	
	public MealPlan(String accountHolder, double balance) {
		super(accountHolder, balance);
	}
	
	@Override
	public void validateAccount() {
		if(balance < 0) {
			System.out.println("invalid meal plane balance");
		}
		else {
			System.out.println("Meal pan account validated for " + accountHolder);
		}
		
	}
	
	@Override
	public void processPayment(double amount) {
		if(balance>= amount) {
			balance -= amount;
			PaymentMethod.totalTransactions++;
			creditSituation = "Successful";
			System.out.println("Mealpayment: $ " + amount);
			
		}
		else {
			creditSituation = "DECLINED";
			System.out.println("Meal plan payment declined");
		}
		
	}
	@Override
	public String getPaymentSituation() {
		return creditSituation;	
		
	}
}
