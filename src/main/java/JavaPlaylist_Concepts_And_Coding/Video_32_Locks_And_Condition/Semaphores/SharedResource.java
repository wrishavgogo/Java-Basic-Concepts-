package JavaPlaylist_Concepts_And_Coding.Video_32_Locks_And_Condition.Semaphores;

import java.util.concurrent.Semaphore;

public class SharedResource {

    boolean itemAvailable = false;
    Semaphore semaphore ;

    public SharedResource(Semaphore semaphore ) {
        this.semaphore = semaphore;
    }

    /**
     * Example of Semaphores Locks ,
     *
     * ***/
    public void getItem() {

        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + " got the lock on " );
        try{
            Thread.sleep(4000); // make the producer thread sleep for 4 seconds
        } catch (Exception e) {
            // whenever using thread operations like this , you need to catch exceptions
        }
        finally {
            System.out.println(Thread.currentThread().getName() + " released lock" );
            semaphore.release(); // releasing the lock in the finally block so that
            // no matter what happens lock should be released . In case of any exception or anything
            // this is kind of notifyAll()
        }



    }



}
