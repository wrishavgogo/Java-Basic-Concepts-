package JavaPlaylist_Concepts_And_Coding.Video_32_Locks_And_Condition.ProducerConsumerProblem;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class SharedResource {

    Queue<Object> buffer;
    int buffersize;

    public SharedResource(int buffersize) {
        this.buffersize = buffersize;
        buffer = new LinkedBlockingQueue<>();
    }

    /**
     * Example of Monitor Locks ,
     * Monitor locks apply lock on the synchronised part of the object
     * When any thread has acquired the Monitor lock of the object ,
     * No other thread can access any of the synchronised part of that object
     * Be it in other method
     * ***/
    public synchronized void addItem() {



        while(buffer.size() == buffersize ) {

            try {
                wait(); // release all the monitor locks and let consumer threads consume items
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
        notifyAll();
        System.out.println("Item added by : " + Thread.currentThread().getName());


    }

    public synchronized void consumeItem() {


        while(buffer.size() == 0) {

            try {
                wait(); // release the monitor lock so producer threads can produce items
            } catch (Exception e) {

            }
        }

        buffer.poll();
        /***
         * Notify the all threads to comeback from the wait state to produce again
         * */
        notifyAll();
        System.out.println("item consumed by : " + Thread.currentThread().getName());
    }
}
