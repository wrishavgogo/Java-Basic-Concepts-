package JavaPlaylist_Concepts_And_Coding.Video_30_Thread_Creation_Thread_Lifecycle_Inter_Thread_Communication.Runnable_Interface_Implementation;


/**
 * @FunctionalInterface
 * public interface Runnable {
 *
 *      public abstract void run();
 *
}*

This functional interface is in turn implemented by the Thread class as well
**/


public class Example {

    public static void main(String[] args) {

        MultiThreadingLearning multiThreadingLearning = new MultiThreadingLearning();
        Thread t1 = new Thread(multiThreadingLearning); // --> thread created here
        /**
         * If you see inside the Thread Constructor it accepts a
         *
         * public Thread(Runnable target) {
         *         this(null, target, "Thread-" + nextThreadNum(), 0);
         *     }
         *
         *
         *     private Runnable target; --> attribute in Thread class
         * **/
        t1.start();
    }

    /**
     * Using this Runnable Interface we get a lot of capability of
     * Since a class can implement multiple interfaces ,
     * So we can  use a class implementing multiple interfaces
     * and make it behave as a thread
     * **/

}

class MultiThreadingLearning implements Runnable {

    @Override
    public void run() {
        System.out.println("implementing the Runnable Interface");
    }
}
