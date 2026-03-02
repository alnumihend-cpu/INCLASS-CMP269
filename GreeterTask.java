package Exercise5;
public class GreeterTask implements Runnable{
	@Override
	public void run() {
		for(int i =1; i <=5; i++) {
			System.out.println("Hello from " +Thread.currentThread().getName());
			try {
				Thread.sleep(500);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class Exercise1{
	public static void main(String[] args) {
		GreeterTask task = new GreeterTask();
		
		Thread t1 = new Thread(task, "Lehman-Thread-1");
		Thread t2 = new Thread(task, "Lehman-Thread-2");
		
		t1.start();
		t2.start();
		
	}
}