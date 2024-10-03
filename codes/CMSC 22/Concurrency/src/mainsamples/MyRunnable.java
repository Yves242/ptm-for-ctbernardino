package mainsamples;

public class MyRunnable implements Runnable {
	
	// there is run class in Runnable() class
    public void run() {
    	
    	// for sleeping
        int min = 500;
        int max = 2000;
        int time = 0;
        
        // perform actions
    	int value = (int) (Math.random() * (max - min + 1)) + min;
        for (int i = 1; i <= 5; i++) {
            try {
                Thread.sleep(value); // Sleep for 500 milliseconds
            	time += value;
            	System.out.println(Thread.currentThread().getName() + " did something [t=" + time/1000 + "." + (time-((time/1000)*1000)) + "].");
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        System.out.println(Thread.currentThread().getName() + " finished.");
    }
    
    public static void main(String[] args) {
    	
    	System.out.println("Test run for MyRunnable()");
        MyRunnable runnable = new MyRunnable();  
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        
        // Runnable() class needs to be started as a thread to work
        t1.start();
        t2.start();
    }
}
