package parentandchild;

//ThreadTest.java
public class ThreadTest {
 public static void main(String[] args) {
     // Create an instance of ChildThread
     ChildThread childThread = new ChildThread();
     
     // Create and start the ParentThread
     ParentThread parentThread = new ParentThread(childThread);
     parentThread.start();
     
     // Wait for the parent thread to finish
     try {
         parentThread.join(); // Ensure the main thread waits for the parent to finish
     } catch (InterruptedException e) {
         e.printStackTrace();
     }

     System.out.println("Test completed.");
 }
}
