package INCLASS;

public class CreditCard extends PaymentMethod {
	private double creditLimit;
	private String creditSituation;
	

	public CreditCard(String accountHolder, double balance, double creditLimit) {
		super(accountHolder, balance);
		this.creditLimit = creditLimit;
		this.creditSituation = "Pending";
	}
	
	@Override
	public void validateAccount() {
		System.out.println("CREDIT CART AMOUNT " + accountHolder);
		
	}
	
	@Override 
	public void processPayment(double amount) {
		if(amount > balance +creditLimit) {
			creditSituation ="Transaction Declined." ;
			System.out.println("Transaction Declined.");
			
		}
		else {
			balance -= amount;
			PaymentMethod.totalTransactions++;
			creditSituation = "Successful";
			System.out.println("Successful");
			
		}
	//	Ifel
	}
	@Override
	public String getPaymentSituation() {
		return creditSituation;
	}
	
	

}
