package JavaPlaylist_Concepts_And_Coding.Video_32_Locks_And_Condition.ReadWriteLock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SharedResource {

    boolean itemAvailable = false;
    ReentrantReadWriteLock readWriteLock ;

    public SharedResource(ReentrantReadWriteLock readWriteLock) {
        this.readWriteLock = readWriteLock;
    }

    /**
     * Example of Reenterant Locks ,
     * Reenterant locks apply lock on the critical part of the code ( irrespective of Object)
     * If critical section has a lock on it  ,
     * no matter we have a different instance of the object , that part will still be locked
     * until the lock is released
     * No other thread can access any of the critical part of that code
     * ***/

    /**
     * Since only read is happening so we have used read lock , which is a shared lock
     * */
    public void getItem() {

        readWriteLock.readLock().lock();
        System.out.println(Thread.currentThread().getName() + " got the lock on for read operation ");
        try{
            Thread.sleep(8000); // make the producer thread sleep for 8 seconds
        } catch (Exception e) {
            // whenever using thread operations like this , you need to catch exceptions
        }
        finally {
            System.out.println(Thread.currentThread().getName() + " released lock for read operation" );
            readWriteLock.readLock().unlock();
            // releasing the lock in the finally block so that
            // no matter what happens lock should be released . In case of any exception or anything
            // this is kind of notifyAll()
        }

        /***
         * Notify the all threads to comeback from the wait state to consumer again
         * */

    }


    /**
     * Method where writing is happening , so we have applied a write lock
     * it is an exclusive lock ,
     * and no other thread will be given access to this critical section once the thread is awakened
     * **/
    public void setItem() {

        readWriteLock.writeLock().lock();
        System.out.println(Thread.currentThread().getName() + " got the lock on write operation ");

        System.out.println(Thread.currentThread().getName() + " released lock on write operation " );
        readWriteLock.writeLock().unlock();
        // releasing the lock in the finally block so that
        // no matter what happens lock should be released . In case of any exception or anything
        // this is kind of notifyAll()

    }



}
