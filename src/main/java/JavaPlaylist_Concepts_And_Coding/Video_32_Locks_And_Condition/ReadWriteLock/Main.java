package JavaPlaylist_Concepts_And_Coding.Video_32_Locks_And_Condition.ReadWriteLock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main {


    /**
     * To understand read-write locks
     * lets first understand shared and exclusive locks
     *
     * lets say two threads are there t1 and t2
     * shared thread ( read-only thread) -> since its reading purpose , two threads both having
     * shared threads can access the critical block
     *
     * exclusive thread ( write - only thread) -> since its writing purpose , out of any of the two threads
     * if 1 of the threads has exclusive thread i.e write thread , then no other thread can access that critical
     * section at the same time . Because of inconsistent reads .
     * Even if shared thread gets access first , then exclusive thread will have to wait before
     * it can acquire the lock
     * t1 = shared thread
     *
     * **/

    public static void main(String[] args) {

        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        SharedResource sharedResource1 = new SharedResource(lock);
        SharedResource sharedResource2 = new SharedResource(lock);
        Thread writeThread = new Thread(new DatabaseWrite(sharedResource1));
        Thread readThread1 = new Thread(new DatabaseRead(sharedResource2));
        Thread readThread2 = new Thread(new DatabaseRead(sharedResource2));


        readThread1.start();
        readThread2.start();

        try {
            Thread.sleep(2000); // adding this 2 second delay purposely so that write thread starts late
        } catch (Exception e) {

        }

        writeThread.start();


        /**
         * The thing to observe in the output is that
         * read operation getItem() has a sleep of 8 seconds
         * since its read so a shared lock is applied there
         *
         * Now in the read operation setItem() , it has a write lock
         * exclusive lock since it's a write operation
         *
         * In the output
         * both the read threads will get the shared lock access but the write thread
         * will get access only when both the threads release the lock
         * only then the write thread will start operating
         * */

    }
}
