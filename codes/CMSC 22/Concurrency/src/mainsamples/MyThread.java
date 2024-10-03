package mainsamples;

public class MyThread extends Thread {
    
    // Override the run() method from Thread class
    @Override
    public void run() {
        
        // Sleep time range
        int min = 500;
        int max = 2000;
        int time = 0;

        // Generate random sleep time between 500 and 2000 milliseconds
        int value = (int) (Math.random() * (max - min + 1)) + min;

        // Perform actions in the thread
        for (int i = 1; i <= 5; i++) {
            try {
                Thread.sleep(value); // Sleep for a random time between 500ms and 2000ms
                time += value;
                System.out.println(Thread.currentThread().getName() + " did something [t=" + time / 1000 + "." + (time - ((time / 1000) * 1000)) + "].");
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        System.out.println(Thread.currentThread().getName() + " finished.");
    }
    
    public static void main(String[] args) {
    	System.out.println("Test run for MyThread()");
        MyThread t1 = new MyThread(); // Create an instance of MyThread
        MyThread t2 = new MyThread(); // Create another instance of MyThread
        
        // Start the threads
        t1.start();
        t2.start();
        
        try {
			t1.join();
			System.out.println("Okay it finished doing its thing.");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
}
