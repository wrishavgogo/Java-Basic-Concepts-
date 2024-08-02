package JavaPlaylist_Concepts_And_Coding.Video_32_Locks_And_Condition.ReenterantLock;

import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {

    boolean itemAvailable = false;
    ReentrantLock reentrantLock ;

    public SharedResource(ReentrantLock reentrantLock) {
        this.reentrantLock = reentrantLock;
    }

    /**
     * Example of Reenterant Locks ,
     * Reenterant locks apply lock on the critical part of the code ( irrespective of Object)
     * If critical section has a lock on it  ,
     * no matter we have a different instance of the object , that part will still be locked
     * until the lock is released
     * No other thread can access any of the critical part of that code
     * ***/
    public void getItem() {

        System.out.println(Thread.currentThread().getName() + " not in critical part " + this.getClass().getName() + this.hashCode());
        reentrantLock.lock();
        System.out.println(Thread.currentThread().getName() + " got the lock on " + this.getClass().getName() + this.hashCode() );
        try{
            Thread.sleep(4000); // make the producer thread sleep for 4 seconds
        } catch (Exception e) {
            // whenever using thread operations like this , you need to catch exceptions
        }
        finally {
            System.out.println(Thread.currentThread().getName() + " released lock" + this.getClass().getName() + this.hashCode());
            reentrantLock.unlock(); // releasing the lock in the finally block so that
            // no matter what happens lock should be released . In case of any exception or anything
            // this is kind of notifyAll()
        }

        /***
         * Notify the all threads to comeback from the wait state to consumer again
         * */

    }



}
