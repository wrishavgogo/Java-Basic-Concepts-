package JavaPlaylist_Concepts_And_Coding.Video_32_Locks_And_Condition.MonitorLocks;

public class Main {

    public static void main(String[] args) {

        SharedResource sharedResource = new SharedResource();
        Thread producerThread = new Thread(new ProducerTask(sharedResource));
        Thread consumerThread = new Thread(new ConsumerTask(sharedResource));
        producerThread.start();
        consumerThread.start();

        /**
         * The example could be perfect demonstrated , because we created only 1 instance
         * of shared resource and not multiple
         *
         * If the two instances where to be created then we would have lost the point of Monitor locks
         * because two threads are executing on completely different instances
         * **/




    }

}
