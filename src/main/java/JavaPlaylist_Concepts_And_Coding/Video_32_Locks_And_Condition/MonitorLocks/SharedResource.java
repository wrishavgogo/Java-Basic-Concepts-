package JavaPlaylist_Concepts_And_Coding.Video_32_Locks_And_Condition.MonitorLocks;

public class SharedResource {

    boolean itemAvailable = false;

    /**
     * Example of Monitor Locks ,
     * Monitor locks apply lock on the synchronised part of the object
     * When any thread has acquired the Monitor lock of the object ,
     * No other thread can access any of the synchronised part of that object
     * Be it in other method
     * ***/
    public synchronized void addItem() {

        System.out.println("add item invoked by  : " + Thread.currentThread().getName());

        try{
            Thread.sleep(4000); // make the producer thread sleep for 4 seconds
        } catch (Exception e) {
            // whenever using thread operations like this , you need to catch exceptions
        }

        itemAvailable = true;
        /***
         * Notify the all threads to comeback from the wait state to consumer again
         * */
        notifyAll();
        System.out.println("Item added by : " + Thread.currentThread().getName());
    }

    public synchronized void consumeItem() {
        System.out.println("consume Item invoked by : " + Thread.currentThread().getName());

        while(!itemAvailable) {

            try {
                System.out.println(Thread.currentThread().getName() + " : waiting for Monitor lock");
                wait(); // release the monitor lock acquired by any of the consumer thread
            } catch (Exception e) {

            }
        }

        itemAvailable = false;
        /***
         * Notify the all threads to comeback from the wait state to produce again
         * */
        notifyAll();
        System.out.println("item consumed by : " + Thread.currentThread().getName());
    }
}
