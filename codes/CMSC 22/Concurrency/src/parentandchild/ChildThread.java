package parentandchild;

// ChildThread.java
public class ChildThread extends Thread {
    private volatile boolean isCompleted; // Declare a volatile variable for completion status

    public ChildThread() {
        this.isCompleted = false;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
            try {
                Thread.sleep(1000); // Simulate time taken for each count
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isCompleted = true; // Set completion status to true
        System.out.println("Child [" + Thread.currentThread().getName() + "]: I completed counting.");
    }
}
