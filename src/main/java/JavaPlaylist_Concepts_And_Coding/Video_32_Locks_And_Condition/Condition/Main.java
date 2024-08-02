package JavaPlaylist_Concepts_And_Coding.Video_32_Locks_And_Condition.Condition;

import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {

        /****
         *
         *  Q) What is producer Consumer problem ?
         *
         *  A) We have a queue of fixed size , lets say 5 , and you have multiple
         *      consumer threads and producer threads , you need to make sure
         *      that consumer thread does not consume when queue is empty
         *      and producer thread does not produce when queue is full , i.e size = 5
         *
         *  We will be implementing this problem , not with monitor locks this time but with
         *  Reenterant locks , basically the locks which are lock specific and not object specific
         *  but we wont be creating a new object
         *
         *  Since these locks are not monitor locks , hence there is a different way by which
         *  they make the threads communicate
         *  there is a Condition object ,
         *
         *  which has condition.await() ---> which is basically wait() in Monitor locks
         *  and condition.signal() --> which is notify()
         *  condition.signalAll() ---> notifyAll()
         */
        ReentrantLock reentrantLock = new ReentrantLock();
        SharedResource sharedResource = new SharedResource(5 , reentrantLock);

        for(int i = 0 ; i < 5 ; i ++ ) {
            Thread producerThread = new Thread(new ProducerTask(sharedResource));
            Thread consumerThread = new Thread(new ConsumerTask(sharedResource));
            producerThread.start();
            consumerThread.start();
        }



    }
}
