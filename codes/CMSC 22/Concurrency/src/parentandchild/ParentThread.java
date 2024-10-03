package parentandchild;

// ParentThread.java
public class ParentThread extends Thread {
    private final ChildThread childThread;

    public ParentThread(ChildThread childThread) {
        this.childThread = childThread;
    }

    @Override
    public void run() {
        childThread.start(); // Start the child thread

        // Wait until the child has completed counting
        while (!childThread.isCompleted()) {
            try {
                Thread.sleep(500); // Check every 500 ms
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Parent thread detects child finished counting.");
    }

    public static void main(String[] args) {
        ChildThread childThread = new ChildThread();
        new ParentThread(childThread).start(); // Start the parent thread
    }
}
