package Exercise5;

public class Exercise2 {
	public static void main(String[] args) throws InterruptedException{
		Thread t = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

		//Statments and starts
		System.out.println("After creation: " + t.getState());
		t.start();
		
		System.out.println("After start: " + t.getState());
		
		Thread.sleep(500);
		
		System.out.println("While sleeping: " + t.getState());
		
		t.join();
		
		System.out.println("After finished: " + t.getState());
		
	}

}
