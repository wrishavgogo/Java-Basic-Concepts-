package JavaPlaylist_Concepts_And_Coding.Video_32_Locks_And_Condition.Condition;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {

    Queue<Object> buffer;
    int buffersize;
    ReentrantLock reentrantLock;
    Condition condition;

    public SharedResource(int buffersize , ReentrantLock reentrantLock) {
        this.buffersize = buffersize;
        buffer = new LinkedBlockingQueue<>();
        this.reentrantLock = reentrantLock;
        condition = reentrantLock.newCondition();
    }

    /**
     * Example of Monitor Locks ,
     * Monitor locks apply lock on the synchronised part of the object
     * When any thread has acquired the Monitor lock of the object ,
     * No other thread can access any of the synchronised part of that object
     * Be it in other method
     * ***/
    public void addItem() {

        reentrantLock.lock();

        while(buffer.size() == buffersize ) {
            // queue is full now , no thread should be producing
            try {
                condition.await(); // release all the monitor locks and let consumer threads consume items
            } catch (Exception e) {

            }
        }

        try {
            Thread.sleep(1000);
        } catch (Exception e) {

        }
        buffer.add("item");
        /***
         * Notify the all threads to comeback from the wait state to consume again
         * */
        condition.signalAll(); // signal rest of the threads that lock is released and continue their operation
        System.out.println("Item added by : " + Thread.currentThread().getName());

        reentrantLock.unlock();


    }

    public void consumeItem() {


        reentrantLock.lock();

        while(buffer.size() == 0) {

            try {
                condition.await(); // release the monitor lock so producer threads can produce items
            } catch (Exception e) {

            }
        }

        buffer.poll();
        /***
         * Since we are adding a wait specifically hence a notify/ signal method is required
         * else all the threads will be in stuck state forever
         * */
        condition.signalAll(); // let the threads know that lock has been released
        System.out.println("item consumed by : " + Thread.currentThread().getName());

        reentrantLock.unlock();
    }
}
