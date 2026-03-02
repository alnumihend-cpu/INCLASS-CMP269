package Exercise5;

class BankAccount {
	private int balance = 1000;
	
	public synchronized void withdraw(int amount) {

	    if(balance>= amount) {
	        System.out.println(Thread.currentThread().getName() + " withdrawing...");

	        balance= balance - amount;

	        System.out.println("Balance: "+ balance);
	    }
	}

}

public class Exercise3{
	public static void main(String[] args) {
		BankAccount account = new BankAccount();
		
		Thread husband = new Thread(() -> account.withdraw(700), "Husband");
		Thread wife = new Thread(() -> account.withdraw(700), "Wife");
		
		husband.start();
		wife.start();
	}
}

