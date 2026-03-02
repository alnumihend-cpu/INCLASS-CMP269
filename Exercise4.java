package Exercise5;

public class Exercise4 {
	public static void main(String[] args) throws InterruptedException {
        final long[] result = {0};

        Thread t = new Thread(() -> {
            long sum = 0;
            for(long i = 1; i <= 1_000_000_000L; i++) {
                sum +=i;
            }
            result[0]= sum;});

        t.start();
        t.join();

        System.out.println("Calculation Finished: " + result[0]);
    }
}


