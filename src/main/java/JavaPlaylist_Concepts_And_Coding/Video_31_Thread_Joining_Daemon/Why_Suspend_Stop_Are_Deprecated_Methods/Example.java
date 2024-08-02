package JavaPlaylist_Concepts_And_Coding.Video_31_Thread_Joining_Daemon.Why_Suspend_Stop_Are_Deprecated_Methods;

public class Example {

    public static void main(String[] args) {

        SharedResource sharedResource = new SharedResource();
        Thread th1 = new Thread(() -> {
            sharedResource.produce();
        });

        Thread th2 = new Thread(() -> {
            /**
             * This sleep of 3 seconds to make sure thread1 gets the lock first
             * */
            try {
                Thread.sleep(3000);
            }  catch (Exception e) {

            }
            sharedResource.produce();
        });

        th1.start();
        th2.start();

        try {
            Thread.sleep(2000);
        } catch (Exception e) {

        }

        th1.suspend();

        /**
         * Thread1 keeps holding the lock and does not release it
         * and thread2 cannot get the lock and deadlock situation gets created
         * **/


        System.out.println("main thread finished");



    }

}

class SharedResource {

    private boolean itemAvailable = false;

    public synchronized void produce() {

        System.out.println("lock acquired by : " + Thread.currentThread().getName());


        try {

            Thread.sleep(8000);
        } catch (Exception e) {

        }

        itemAvailable = true;

        System.out.println("lock released by : " + Thread.currentThread().getName());
    }
}
