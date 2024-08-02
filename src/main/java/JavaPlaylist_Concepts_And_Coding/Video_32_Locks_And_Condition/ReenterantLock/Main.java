package JavaPlaylist_Concepts_And_Coding.Video_32_Locks_And_Condition.ReenterantLock;

import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock();
        SharedResource sharedResource1 = new SharedResource(lock);
        SharedResource sharedResource2 = new SharedResource(lock);
        Thread producerThread = new Thread(new ProducerTask(sharedResource1));
        Thread consumerThread = new Thread(new ConsumerTask(sharedResource2));
        producerThread.start();
        consumerThread.start();

        /**
         * in the output you will see
         * thread1 does not get the lock before thread0 finishes
         * or vice-versa whichever gets the lock first
         **/

    }
}
